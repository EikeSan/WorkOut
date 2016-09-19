/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Diogo
 */
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
 
public class Conexao {
 
    private String driver = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://localhost/newworkout";
    private String USER = "root";
    private String SENHA = "";
    private Connection conn;
 
    public Conexao() {
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(URL, USER, SENHA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public Connection getConn() {
        return conn;
    }
 
    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}