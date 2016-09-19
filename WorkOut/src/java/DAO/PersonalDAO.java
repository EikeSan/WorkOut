/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Personal;
import Util.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Eike
 */
public class PersonalDAO {

    public void save(Personal personal) {
        Session session = PersonalUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(personal);
        t.commit();
    }

    public Personal getPersonal(long id) {
        Session session = PersonalUtil.getSessionFactory().openSession();
        return (Personal) session.load(Personal.class, id);
    }

    public List<Personal> list() {
        Session session = PersonalUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Personal").list();
        t.commit();
        return lista;
    }

    public void remove(Personal personal) {
        Session session = PersonalUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(personal);
        t.commit();
    }


    public void update(Personal personal) {
        Session session = PersonalUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(personal);
        t.commit();
    }
    
}
