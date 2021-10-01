/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.SucursalDao;
import DAO.SucursalDaoImplement;
import Model.Sucursal;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marco Antonio
 */
@ManagedBean
@ViewScoped
public class sucursalBean {
   
    private Sucursal sucursal;
    private List<Sucursal> sucursales;

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public List<Sucursal> getSucursales() {
      SucursalDao dao = new SucursalDaoImplement(); 
        sucursales = dao.mostrarSucursal();
        return sucursales;
    
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    
    }
    
    /**
     * Creates a new instance of sucursalBean
     */
    public sucursalBean() {
    
        sucursal = new Sucursal();
        
    }
    
    public void addMessage(String summary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,summary,null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void insertar(){
    SucursalDao dao = new SucursalDaoImplement();
    dao.insertarSucursal(sucursal);
    sucursal = new Sucursal();
    addMessage("Sucursal Agregada");
    }
    
    public void modificar(){
    SucursalDao dao = new SucursalDaoImplement();
    dao.modificarSucursal(sucursal);
    sucursal = new Sucursal();
    addMessage("Sucursal Modificada");
    
    }
    
    public void eliminar(){
    SucursalDao dao = new SucursalDaoImplement();
    dao.eliminarSucursal(sucursal);
    sucursal = new Sucursal();
    addMessage("Sucursal Eliminada");
 
    }

}
