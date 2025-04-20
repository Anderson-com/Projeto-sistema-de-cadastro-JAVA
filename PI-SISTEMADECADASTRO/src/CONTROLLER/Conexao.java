package CONTROLLER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_vendas";
    private static final String USUARIO = "root"; 
    private static final String SENHA = "anderson";
    private static Connection conexao;

    public static Connection getConnection() {
        try {
            if (conexao == null || conexao.isClosed()) {
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            }
            return conexao;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, "Erro ao conectar ao banco de dados", ex);
            throw new RuntimeException("Erro ao conectar ao banco de dados", ex);
        }
    }

    public static void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, "Erro ao fechar conexão", ex);
        }
    }
}