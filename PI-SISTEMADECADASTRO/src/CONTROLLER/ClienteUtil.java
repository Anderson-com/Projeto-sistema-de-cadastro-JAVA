package CONTROLLER;

import MODEL.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteUtil {
    private static final Logger logger = Logger.getLogger(ClienteUtil.class.getName());

    public boolean clienteExiste(String cpf) {
        String sql = "SELECT 1 FROM clientes WHERE cpf = ?";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
            
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao verificar cliente", e);
            JOptionPane.showMessageDialog(null, "Erro ao verificar cliente", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean adicionar(Cliente cliente) {
        String sql = "INSERT INTO clientes (cpf, nome, email, telefone) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao cadastrar cliente", e);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean atualizar(Cliente cliente) {
        String sql = "UPDATE clientes SET nome = ?, email = ?, telefone = ? WHERE cpf = ?";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getCpf());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao atualizar cliente", e);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

   public Cliente buscarPorCpf(String cpf) {
        String sql = "SELECT nome, email, telefone FROM clientes WHERE cpf = ?";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(                        
                        rs.getString("nome"),                        
                        rs.getString("telefone"),
                            cpf,
                        rs.getString("email")
                            
                    );
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao buscar cliente por CPF", e);
        }
        return null;
    }
}