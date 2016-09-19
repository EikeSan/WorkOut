/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import DAO.TreinoDAO;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import Model.Treino;
import Model.Aluno;
/**
 *
 * @author andii
 */
@Named
@SessionScoped
public class TreinoController implements Serializable{
 
    private TreinoDAO treinoDAO;
    private Aluno aluno;
    private Treino treino = new Treino();
    private DataModel<Treino> treinos;
 
    public void novo(){
        treino = new Treino();
    }
 
    public String inserir(){
        String resultado = "falha";
        treinoDAO = new TreinoDAO();
        boolean retorno = treinoDAO.inserir(treino);
 
        if(retorno){
            resultado = "gerenciarTreino";
        }
 
        return resultado;
    }
 
    public void selecionar(){
        treino = treinos.getRowData();
    }
    
 
    public String alterar(){
        String resultado = "falha";
        treinoDAO = new TreinoDAO();
        boolean retorno = treinoDAO.alterar(treino);
 
        if(retorno){
            resultado = "gerenciarTreino";
        }
 
        return resultado;
    }
 
    public String remover(){
        String resultado = "falha";
        treinoDAO = new TreinoDAO();
        boolean retorno = treinoDAO.remover(treino);
 
        if(retorno){
            resultado = "gerenciarTreino";
        }
 
        return resultado;
    }
 
    public Treino getTreino() {
        return treino;
    }
 
    public void setTreino(Treino treino) {
        this.treino = treino;
    }
 
    public DataModel<Treino> getTreinos() {
        treinoDAO = new TreinoDAO();
        List<Treino> treinoList = treinoDAO.listar();
        treinos = new ListDataModel<>(treinoList);
        return treinos;
    }
    
    public DataModel<Treino> getTreinosAluno(String email) {
        treinoDAO = new TreinoDAO();
        List<Treino> treinoList = treinoDAO.listarPorAluno(email);
        treinos = new ListDataModel<>(treinoList);
        return treinos;
    }
 
    public void setTreinos(DataModel<Treino> treinos) {
        this.treinos = treinos;
    }
 
}
