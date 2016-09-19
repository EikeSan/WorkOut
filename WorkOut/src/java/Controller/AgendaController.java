/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AgendaDAO;
import Model.Agenda;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Eike
 */
@ManagedBean
@SessionScoped

public class AgendaController {
    private Agenda agenda;
    private DataModel listaAgenda;
    
    public DataModel getListarAgenda(){
        List<Agenda> lista = new AgendaDAO().list();
        listaAgenda = new ListDataModel(lista);
        return listaAgenda;
    }
    
    public Agenda getAgenda(){
        return this.agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
    
    public String prepararAdicionarAgenda(){
        agenda = new Agenda();
        return "gerenciarAgenda";
    }
    
    public String prepararAlterarAgenda(){
         agenda = (Agenda)(listaAgenda.getRowData());
        return "gerenciarAgenda";
    }
    
    public String excluirAgenda(){
        Agenda agendaTemp = (Agenda)(listaAgenda.getRowData());
        AgendaDAO dao = new AgendaDAO();
        dao.remove(agendaTemp);
        return "agenda";
    }
    
    public String adicionarAgenda(){
        AgendaDAO dao = new AgendaDAO();
        dao.save(agenda);
        return "agenda";
    }
    
    public String alterarAgenda(){
        AgendaDAO dao = new AgendaDAO();
        dao.update(agenda);
        return "agenda";
    }
}
