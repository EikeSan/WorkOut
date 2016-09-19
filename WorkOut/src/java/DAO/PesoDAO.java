package DAO;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Peso;
import Util.DataConnect;
import java.sql.Connection;
 
/**
 *
 * @author Diogo
 */
public class PesoDAO {
 
    private Conexao conexao;
    private Statement stmt;
    private boolean sucesso = false;
 
    public PesoDAO() {
        conexao = new Conexao();
        try {
            stmt = (Statement) conexao.getConn().createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
 
    public boolean inserir(Peso peso) {
        try {
            stmt.execute("INSERT INTO peso (peso, email) VALUES ('" + peso.getPeso()+ "','" + peso.getEmail()+ "')");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return sucesso;
    }
 
    public boolean alterar(Peso peso) {
        try {
            stmt.execute("UPDATE peso SET peso = '" + peso.getPeso()+ "', email = '" + peso.getEmail()+ "' WHERE id_peso = '" + peso.getId_peso()+ "'");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return sucesso;
    }
 
    public boolean remover(Peso peso) {
        try {
            stmt.execute("DELETE FROM peso WHERE id_peso = '" + peso.getId_peso()+ "'");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return sucesso;
    }
 
    public List<Peso> listar() {
        List<Peso> pesos = new ArrayList<Peso>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM peso ORDER BY id_peso");
            while (rs.next()) {
                Peso peso = new Peso();
                peso.setPeso(rs.getInt("peso"));
                peso.setData(rs.getString("data"));
                peso.setEmail(rs.getString("email"));
                peso.setId_peso(rs.getInt("id_peso"));
 
                pesos.add(peso);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return pesos;
    } 
    public List<Peso> listarPorAluno(String email) {
        List<Peso> pesos = new ArrayList<Peso>();
        Connection con = null;
        com.mysql.jdbc.PreparedStatement ps = null;
        try {
            con = (Connection) DataConnect.getConnection();
            ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement("SELECT * FROM peso where email = ? ORDER BY id_peso");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Peso peso = new Peso();
                peso.setPeso(rs.getInt("peso"));
                peso.setData(rs.getString("data"));
                peso.setEmail(rs.getString("email"));
                peso.setId_peso(rs.getInt("id_peso"));
 
                pesos.add(peso);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return pesos;
    }
    
    public List<Peso> listaChart(String email) {
        List<Peso> pesos = new ArrayList<Peso>();
        Connection con = null;
        com.mysql.jdbc.PreparedStatement ps = null;
        try {
            con = (Connection) DataConnect.getConnection();
            ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(" SELECT * FROM peso WHERE email = ? order by data");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Peso peso = new Peso();
                peso.setPeso(rs.getInt("peso"));
                peso.setData(rs.getString("data"));
                peso.setEmail(rs.getString("email"));
                peso.setId_peso(rs.getInt("id_peso"));
 
                pesos.add(peso);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return pesos;
    }   
}