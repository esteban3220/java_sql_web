/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Empleado;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author tonny
 */
public class EmpleadosDaoImplement implements EmpleadosDao{

    @Override
    public void insertarEmpleados(Empleado empleados) {
       Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(empleados);//funcion similar a elinsert into solo que es mas facil 
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
    public void modificarEmpleados(Empleado empleados) {
       Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(empleados);//funcion similar a elinsert into solo que es mas facil 
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
    public void eliminarEmpleados(Empleado empleados) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(empleados);//funcion similar a elinsert into solo que es mas facil 
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
    public List<Empleado> mostrarEmpleado() {
       Session session = null;
        List<Empleado> lista=null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Empleado ");//el Query realiza una consulta
            lista=(List<Empleado>) query.list();
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
    



