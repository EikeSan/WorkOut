/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Eike
 */
import Util.DataConnect;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDAO {

    public static boolean validate(String email, String senha) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = (Connection) DataConnect.getConnection();
            ps = (PreparedStatement) con.prepareStatement("Select email, senha from personal where email = ? and senha = ?");
            ps.setString(1, email);
            ps.setString(2, senha);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                //result found, means valid inputs
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
        }
        return false;
    }
    
    public static int retornaID(String email){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = (Connection) DataConnect.getConnection();
            ps = (PreparedStatement) con.prepareStatement("Select id from personal where email= ?");
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                //result found, means valid inputs
                return rs.getInt(1); 
            }
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
        } finally {
            DataConnect.close(con);
        }
        return 0;
    }
}
