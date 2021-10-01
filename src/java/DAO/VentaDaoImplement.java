/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Venta;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author tonny
 */
public class VentaDaoImplement implements VentaDao{

    @Override
    public void insertarVenta(Venta venta) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(venta);//funcion similar a elinsert into solo que es mas facil 
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
    public void modificarVenta(Venta venta) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(venta);//funcion similar a elinsert into solo que es mas facil 
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
    public void eliminarVenta(Venta venta) {
      Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(venta);//funcion similar a elinsert into solo que es mas facil 
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
    public List<Venta> mostrarVenta() {
       Session session = null;
        List<Venta> lista=null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from sucursal ");//el Query realiza una consulta
            lista=(List<Venta>) query.list();
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
    
