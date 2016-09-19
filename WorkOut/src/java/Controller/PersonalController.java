/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.*;
import Model.Personal;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

public class PersonalController {
    private Personal personal;
    private DataModel listaPersonal;
    private Map personalItem=null;
    private Map personalNomeID;
    
    public DataModel getListarPersonal(){
        List<Personal> lista = new PersonalDAO().list();
        listaPersonal = new ListDataModel(lista);
        return listaPersonal;
    }
    
    public Personal getPersonal(){
        return this.personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
    
    public String prepararAdicionarPersonal(){
        personal = new Personal();
        return "gerenciarPersonal";
    }
    
    public String prepararAlterarPersonal(){
         personal = (Personal)(listaPersonal.getRowData());
        return "gerenciarPersonal";
    }
    
    public String excluirPersonal(){
        Personal personalTemp = (Personal)(listaPersonal.getRowData());
        PersonalDAO dao = new PersonalDAO();
        dao.remove(personalTemp);
        return "personal";
    }
    
    public String adicionarPersonal(){
        PersonalDAO dao = new PersonalDAO();
        dao.save(personal);
        return "personal";
    }
    
    public String alterarPersonal(){
        PersonalDAO dao = new  PersonalDAO();
        dao.update(personal);
        return "personal";
    }
    
    public Map getNomes(){
	PersonalDAO dao = new PersonalDAO();
	personalItem = new LinkedHashMap();
	for(Iterator iter =dao.list().iterator();iter.hasNext();){
	Personal p = (Personal) iter.next();
	 //armazenando os cargos encontrados no bd em um map
		personalItem.put(p.getNome(), p.getNome());
	}
	return personalItem;
    }
    
    public Map getIds(){
	PersonalDAO dao = new PersonalDAO();
	personalItem = new LinkedHashMap();
	for(Iterator iter =dao.list().iterator();iter.hasNext();){
	Personal p = (Personal) iter.next();
	 //armazenando os cargos encontrados no bd em um map
		personalItem.put(p.getId(), p.getId());
	}
	return personalItem;
    }
    
    public Map getPopulaMapa(){
	PersonalDAO dao = new PersonalDAO();
	personalNomeID = new LinkedHashMap();
	for(Iterator iter = dao.list().iterator();iter.hasNext();){
	Personal p = (Personal) iter.next();
	 //armazenando os cargos encontrados no bd em um map
		personalNomeID.put(p.getId(), p.getNome());
	}
	return personalNomeID;
    }
    
    
}
