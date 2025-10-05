//Raphael Cordeiro Lopes 4°Semestre Uniplan
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca_escolar";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    
    public static Connection  getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver não encontrado");
        }
    }
    
    public static boolean testarConexao() {
        try {
            Connection conn = getConnection();
            conn.close();
            System.out.println("Conexão com o banco OK!");
            return true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }
}
