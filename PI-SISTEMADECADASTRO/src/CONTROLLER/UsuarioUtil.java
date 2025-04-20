package CONTROLLER;

import MODEL.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UsuarioUtil {
    private static final Logger logger = Logger.getLogger(UsuarioUtil.class.getName());

    public Usuario autenticar(String login, String senha) {
        String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = SHA2(?, 256)";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setLogin(rs.getString("login"));
                    usuario.setSenha(rs.getString("senha"));
                    usuario.setTipo(rs.getString("tipo"));
                    usuario.setCpf(rs.getString("cpf"));
                    return usuario;
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro na autenticação", e);
            JOptionPane.showMessageDialog(null, "Erro ao autenticar usuário", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public boolean cadastrar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (login, senha, tipo, cpf) VALUES (?, SHA2(?, 256), ?, ?)";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getTipo());
            stmt.setString(4, usuario.getCpf());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao cadastrar usuário", e);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void listarUsuarios(JTable tabela) {
        String sql = "SELECT login, tipo, cpf FROM usuarios";
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.setRowCount(0); // limpa a tabela
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("login"),
                    "******", // Não mostra a senha real
                    rs.getString("tipo"),
                    rs.getString("cpf")
                });
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao listar usuários", e);
            JOptionPane.showMessageDialog(null, "Erro ao listar usuários", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

     public boolean excluirUsuario(String login) {
        String sql = "DELETE FROM usuarios WHERE login = ?";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, login);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao excluir usuário", e);
            JOptionPane.showMessageDialog(null, "Erro ao excluir usuário", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}