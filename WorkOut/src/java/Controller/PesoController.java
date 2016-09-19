/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import DAO.PesoDAO;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import Model.Peso;
 
/**
 *
 * @author Diogo
 */
@Named
@SessionScoped
public class PesoController implements Serializable{
 
    private PesoDAO pesoDAO;
    private Peso peso = new Peso();
    private DataModel<Peso> pesos;
 
    public void novo(){
        peso = new Peso();
    }
 
    public String inserir(){
        String resultado = "falha";
        pesoDAO = new PesoDAO();
        boolean retorno = pesoDAO.inserir(peso);
 
        if(retorno){
            resultado = "gerenciarPesos";
        }
 
        return resultado;
    }
 
    public void selecionar(){
        peso = pesos.getRowData();
    }
 
    public String alterar(){
        String resultado = "falha";
        pesoDAO = new PesoDAO();
        boolean retorno = pesoDAO.alterar(peso);
 
        if(retorno){
            resultado = "gerenciarPesos";
        }
 
        return resultado;
    }
 
    public String remover(){
        String resultado = "falha";
        pesoDAO = new PesoDAO();
        boolean retorno = pesoDAO.remover(peso);
 
        if(retorno){
            resultado = "gerenciarPesos";
        }
 
        return resultado;
    }
 
    public Peso getPeso() {
        return peso;
    }
 
    public void setPeso(Peso peso) {
        this.peso = peso;
    }
 
    public DataModel<Peso> getPesos() {
        pesoDAO = new PesoDAO();
        List<Peso> pesoList = pesoDAO.listar();
        pesos = new ListDataModel<Peso>(pesoList);
        return pesos;
    }
    
    public DataModel<Peso> getTreinosAluno(String email) {
        pesoDAO = new PesoDAO();
        List<Peso> pesoList = pesoDAO.listarPorAluno(email);
        pesos = new ListDataModel<>(pesoList);
        return pesos;
    }
 
    public void setClientes(DataModel<Peso> pesos) {
        this.pesos = pesos;
    }
 
}
