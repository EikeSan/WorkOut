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
import Model.Aluno;
import Controller.LoginController;

/**
 *
 * @author Diogo
 */
public class AlunoDao {

    private Conexao conexao;
    private Statement stmt;
    private boolean sucesso = false;

    public AlunoDao() {
        conexao = new Conexao();
        try {
            stmt = (Statement) conexao.getConn().createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean inserir(Aluno aluno) {
        try {
            stmt.execute("INSERT INTO aluno (email, id, nome) VALUES ('" + aluno.getEmail()+ "','" + aluno.getId()+ "','"+aluno.getNome()+"')");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return sucesso;
    }

    public boolean alterar(Aluno aluno) {
        try {
            stmt.execute("UPDATE aluno SET email = '" + aluno.getEmail()+ "', id = '" + aluno.getId()+ "', nome = '"+aluno.getNome()+"' WHERE email = '" + aluno.getEmail()+ "'");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return sucesso;
    }

    public boolean remover(Aluno aluno) {
        try {
            stmt.execute("DELETE FROM aluno WHERE email = '" + aluno.getEmail()+ "'");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return sucesso;
    }

    public List<Aluno> listar() {
        LoginController login= new LoginController();
        List<Aluno> alunos = new ArrayList<Aluno>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM aluno WHERE id = '"+login.getId()+"'");
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setEmail(rs.getString("email"));
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));

                alunos.add(aluno);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return alunos;
    }
}

