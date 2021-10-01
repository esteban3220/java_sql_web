/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.ProvedorDao;
import DAO.ProvedorDaoImplement;
import Model.Provedor;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;



/**
 *
 * @author tonny
 */
@ManagedBean
@ViewScoped
public class provedorBean {

     private Provedor provedor;
     private List<Provedor> provedores;        

    public Provedor getProvedor() {
        return provedor;
    }

    public void setProvedor(Provedor provedor) {
        this.provedor = provedor;
    }

    public List<Provedor> getProvedores() {
        ProvedorDao dao = new ProvedorDaoImplement();
        provedores = dao.mostrarProvedor();
        return provedores;
    }

    public void setProvedores(List<Provedor> provedores) {
        this.provedores = provedores;
    }
    
    public provedorBean() {
      
        provedor = new Provedor();
    }
     
    public void addMessage(String summary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,summary,null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
      
    public void insertar(){
       ProvedorDao dao = new ProvedorDaoImplement(); 
       dao.insertarProvedor(provedor);
       provedor = new Provedor();
      addMessage("Provedor Agregado");
       
    }
    
    public void modificarProvedor(){
       ProvedorDao dao = new ProvedorDaoImplement(); 
       dao.modificarProvedor(provedor);
       provedor = new Provedor();
        addMessage("Provedor Modificado");
    }
    
    public void eliminarProvedor(){
       ProvedorDao dao = new ProvedorDaoImplement(); 
       dao.eliminarProvedor(provedor);
       provedor = new Provedor();
        addMessage("Provedor Eliminado");
       
    }           
}

