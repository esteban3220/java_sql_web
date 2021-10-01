/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Clientes;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author tonny
 */
  //hacemos herencia 
public class ClientesDaoImplement implements ClientesDao {

    @Override
    public void insertarClientes(Clientes clientes) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(clientes);//funcion similar a elinsert into solo que es mas facil 
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
    public void modificarClientes(Clientes clientes) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(clientes);//funcion similar a el update solo que es mas facil 
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
    public void eliminarClientes(Clientes clientes) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(clientes);//funcion similar a elinsert into solo que es mas facil 
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
    public List<Clientes> mostrarClientes() {
        Session session = null;
        List<Clientes> lista=null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Clientes ");//el Query realiza una consulta
            lista=(List<Clientes>) query.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }finally{
            if(session!=null){
                session.close();
            } 
        }
        return lista;
    }
}


