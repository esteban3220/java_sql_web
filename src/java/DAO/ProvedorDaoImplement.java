/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Provedor;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author tonny
 */
public class ProvedorDaoImplement implements ProvedorDao {

    @Override
    public void insertarProvedor(Provedor provedor) {
       Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(provedor);//funcion similar a elinsert into solo que es mas facil 
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session!=null){
                session.close();
            }    
        }
    }

    @Override
    public void modificarProvedor(Provedor provedor) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(provedor);//funcion similar a elinsert into solo que es mas facil 
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session!=null){
                session.close();
            }    
        }
    }

    @Override
    public void eliminarProvedor(Provedor provedor) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(provedor);//funcion similar a elinsert into solo que es mas facil 
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session!=null){
                session.close();
            }    
        }
    }

    
    @Override
    public List<Provedor> mostrarProvedor() {
       Session session = null;
        List<Provedor> lista = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            //Ingeniero hace referencia a la clase que está en el paquete model.
            Query query = session.createQuery("from Provedor ");
            lista = (List<Provedor>) query.list();
        } catch (HibernateException e) {
         System.out.println(e.getMessage());            
        }finally{
            if(session != null){
                session.close();
            }
        }
        return lista;
    }
    
}

