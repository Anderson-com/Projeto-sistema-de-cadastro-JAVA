package CONTROLLER;

import MODEL.Vendas;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VendasUtil {  
    
    private static final Logger logger = Logger.getLogger(VendasUtil.class.getName());
    private static final SimpleDateFormat DATE_FORMAT_DB = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat DATE_FORMAT_DISPLAY = new SimpleDateFormat("dd/MM/yyyy");

    public boolean adicionar(Vendas venda) {
        String sql = "INSERT INTO vendas (data_venda, cpf_cliente, nome_cliente, produto, valor) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Converte a data de DD/MM/AAAA para AAAA-MM-DD
            java.util.Date data = DATE_FORMAT_DISPLAY.parse(venda.getData());
            stmt.setString(1, DATE_FORMAT_DB.format(data));
            
            stmt.setString(2, venda.getCpf());
            stmt.setString(3, venda.getNome());
            stmt.setString(4, venda.getProduto());
            stmt.setDouble(5, venda.getValor());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao registrar venda", e);
            JOptionPane.showMessageDialog(null, 
                "Erro ao registrar venda: " + e.getMessage(), 
                "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void listarVendas(JTable tabela) {
        String sql = "SELECT data_venda, cpf_cliente, nome_cliente, produto, valor FROM vendas";
        atualizarTabela(tabela, sql);
    }

    public void filtrarPorData(JTable tabela, String data) {
        String sql = "SELECT data_venda, cpf_cliente, nome_cliente, produto, valor FROM vendas WHERE data_venda = ?";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Converte a data de DD/MM/AAAA para AAAA-MM-DD
            java.util.Date dataConvertida = DATE_FORMAT_DISPLAY.parse(data);
            stmt.setString(1, DATE_FORMAT_DB.format(dataConvertida));
            
            atualizarTabela(tabela, stmt);
            
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao filtrar por data (SQL)", e);
            JOptionPane.showMessageDialog(null, "Erro ao filtrar vendas", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException e) {
            logger.log(Level.SEVERE, "Erro ao filtrar por data (formato inválido)", e);
            JOptionPane.showMessageDialog(null, "Formato de data inválido. Use DD/MM/AAAA", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarTabela(JTable tabela, String sql) {
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            atualizarTabela(tabela, rs);
            
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao atualizar tabela", e);
            JOptionPane.showMessageDialog(null, "Erro ao carregar dados", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarTabela(JTable tabela, PreparedStatement stmt) throws SQLException {
        try (ResultSet rs = stmt.executeQuery()) {
            atualizarTabela(tabela, rs);
        }
    }

    private void atualizarTabela(JTable tabela, ResultSet rs) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.setRowCount(0);
        
        while (rs.next()) {
            // Formata a data para exibição DD/MM/AAAA
            String dataBanco = rs.getString("data_venda");
            String dataExibicao;
            
            try {
                java.util.Date data = DATE_FORMAT_DB.parse(dataBanco);
                dataExibicao = DATE_FORMAT_DISPLAY.format(data);
            } catch (ParseException e) {
                dataExibicao = dataBanco; // Se não conseguir converter, mantém o original
            }
            
            model.addRow(new Object[]{
                dataExibicao, // Data formatada como DD/MM/AAAA
                formatarCPF(rs.getString("cpf_cliente")),
                rs.getString("nome_cliente"),
                rs.getString("produto"),
                String.format("R$ %.2f", rs.getDouble("valor"))
            });
        }
    }

    public static List<Vendas> buscarPorCpf(String cpf) {
        List<Vendas> vendas = new ArrayList<>();
        String sql = "SELECT data_venda, cpf_cliente, nome_cliente, produto, valor FROM vendas WHERE cpf_cliente LIKE ?";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, "%" + cpf + "%");
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // Formata a data para DD/MM/AAAA
                    String dataBanco = rs.getString("data_venda");
                    String dataExibicao;
                    
                    try {
                        java.util.Date data = DATE_FORMAT_DB.parse(dataBanco);
                        dataExibicao = DATE_FORMAT_DISPLAY.format(data);
                    } catch (ParseException e) {
                        dataExibicao = dataBanco;
                    }
                    
                    Vendas venda = new Vendas(
                        rs.getString("cpf_cliente"),
                        rs.getString("nome_cliente"),
                        "", 
                        "", 
                        rs.getString("produto"),
                        rs.getDouble("valor"),
                        dataExibicao // Data já formatada
                    );
                    vendas.add(venda);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao buscar vendas por CPF", e);
            throw new RuntimeException("Erro ao buscar vendas por CPF", e);
        }
        return vendas;
    }

    public void filtrarPorPeriodo(JTable tabela, String dataInicio, String dataFim) {
        String sql = "SELECT data_venda, cpf_cliente, nome_cliente, produto, valor FROM vendas WHERE data_venda BETWEEN ? AND ?";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Converte as datas para o formato do banco
            java.util.Date inicio = DATE_FORMAT_DISPLAY.parse(dataInicio);
            java.util.Date fim = DATE_FORMAT_DISPLAY.parse(dataFim);
            
            stmt.setString(1, DATE_FORMAT_DB.format(inicio));
            stmt.setString(2, DATE_FORMAT_DB.format(fim));
            
            atualizarTabela(tabela, stmt);
            
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao filtrar por período (SQL)", e);
            JOptionPane.showMessageDialog(null, "Erro ao filtrar vendas por período", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException e) {
            logger.log(Level.SEVERE, "Erro ao filtrar por período (formato inválido)", e);
            JOptionPane.showMessageDialog(null, "Formato de data inválido. Use DD/MM/AAAA", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private String formatarCPF(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return cpf;
        }
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + 
               cpf.substring(6, 9) + "-" + cpf.substring(9);
    }
}