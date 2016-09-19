/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Agenda;
import Util.AgendaUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Eike
 */
public class AgendaDAO {

    public void save(Agenda agenda) {
        Session session = AgendaUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(agenda);
        t.commit();
    }

    public Agenda getAgenda(long id) {
        Session session = AgendaUtil.getSessionFactory().openSession();
        return (Agenda) session.load(Agenda.class, id);
    }

    public List<Agenda> list() {
        Session session = AgendaUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Agenda").list();
        t.commit();
        return lista;
    }


    public void remove(Agenda agenda) {
        Session session = AgendaUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(agenda);
        t.commit();
    }


    public void update(Agenda agenda) {
        Session session = AgendaUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(agenda);
        t.commit();
    }
    
}
