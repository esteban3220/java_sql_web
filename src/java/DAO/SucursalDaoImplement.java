/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Sucursal;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author tonny
 */
public class SucursalDaoImplement implements SucursalDao{

    @Override
    public void insertarSucursal(Sucursal sucursal) {
       Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(sucursal);//funcion similar a elinsert into solo que es mas facil 
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
    public void modificarSucursal(Sucursal sucursal) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(sucursal);//funcion similar a elinsert into solo que es mas facil 
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
    public void eliminarSucursal(Sucursal sucursal) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(sucursal);//funcion similar a elinsert into solo que es mas facil 
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
    public List<Sucursal> mostrarSucursal() {
     Session session = null;
        List<Sucursal> lista=null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Sucursal ");//el Query realiza una consulta
            lista=(List<Sucursal>) query.list();
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
