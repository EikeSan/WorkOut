/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AlunoDao;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import Model.Aluno;
 
/**
 *
 * @author andii
 */
@Named
@SessionScoped
public class AlunoController implements Serializable{
 
    private AlunoDao alunoDAO;
    private Aluno aluno = new Aluno();
    private DataModel<Aluno> alunos;
 
    public void novo(){
        aluno = new Aluno();
    }
 
    public String inserir(){
        String resultado = "falha";
        alunoDAO = new AlunoDao();
        boolean retorno = alunoDAO.inserir(aluno);
 
        if(retorno){
            resultado = "gerenciarAluno";
        }
 
        return resultado;
    }
 
    public void selecionar(){
        aluno = alunos.getRowData();
    }
 
    public String alterar(){
        String resultado = "falha";
        alunoDAO = new AlunoDao();
        boolean retorno = alunoDAO.alterar(aluno);
 
        if(retorno){
            resultado = "gerenciarAluno";
        }
 
        return resultado;
    }
 
    public String remover(){
        String resultado = "falha";
        alunoDAO = new AlunoDao();
        boolean retorno = alunoDAO.remover(aluno);
 
        if(retorno){
            resultado = "gerenciarAluno";
        }
 
        return resultado;
    }
 
    public Aluno getAluno() {
        return aluno;
    }
 
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
 
    public DataModel<Aluno> getAlunos() {
        alunoDAO = new AlunoDao();
        List<Aluno> alunoList = alunoDAO.listar();
        alunos = new ListDataModel<Aluno>(alunoList);
        return alunos;
    }
 
    public void setAlunos(DataModel<Aluno> alunos) {
        this.alunos = alunos;
    }
 
}
