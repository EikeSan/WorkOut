/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Treino;
import Util.DataConnect;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedList;

/**
 *
 * @author Diogo
 */
public class TreinoDAO {

    private Conexao conexao;
    private Statement stmt;
    private boolean sucesso = false;

    public TreinoDAO() {
        conexao = new Conexao();
        try {
            stmt = (Statement) conexao.getConn().createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean inserir(Treino treino) {
        try {
            stmt.execute("INSERT INTO treino (email, tipo,exercicio) VALUES ('" + treino.getEmail() + "','" + treino.getTipo() + "','" + treino.getExercicio() + "')");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return sucesso;
    }

    public boolean alterar(Treino treino) {
        try {
            stmt.execute("UPDATE treino SET email = '" + treino.getEmail() + "', tipo = '" + treino.getTipo() + "', exercicio = '" + treino.getExercicio() + "' WHERE id_treino = '" + treino.getId_treino() + "'");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return sucesso;
    }

    public boolean remover(Treino treino) {
        try {
            stmt.execute("DELETE FROM treino WHERE id_treino = '" + treino.getId_treino() + "'");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return sucesso;
    }

    public List<Treino> listar() {
        List<Treino> clientes = new ArrayList<Treino>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM treino ORDER BY id_treino");
            while (rs.next()) {
                Treino treino = new Treino();
                treino.setEmail(rs.getString("email"));
                treino.setExercicio(rs.getString("exercicio"));
                treino.setTipo(rs.getString("tipo"));
                treino.setId_treino(rs.getInt("id_treino"));

                clientes.add(treino);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return clientes;
    }

    public List<Treino> listarPorAluno(String email) {
        List<Treino> clientes = new ArrayList<>();
        Connection con = null;
        com.mysql.jdbc.PreparedStatement ps = null;
        try {
            con = (Connection) DataConnect.getConnection();
            ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement("SELECT * FROM treino where email = ? ORDER BY id_treino");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Treino treino = new Treino();
                treino.setEmail(rs.getString("email"));
                treino.setExercicio(rs.getString("exercicio"));
                treino.setTipo(rs.getString("tipo"));
                treino.setId_treino(rs.getInt("id_treino"));

                clientes.add(treino);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return clientes;
    }
}
