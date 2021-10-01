/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.ClientesDao;
import DAO.ClientesDaoImplement;
import Model.Clientes;
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
public class clientesBean {
    //se importan del  model
    private Clientes cliente;
    private List<Clientes> clientes;

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public List<Clientes> getClientes() {
        //instancia ala interfaz 
        ClientesDao dao = new ClientesDaoImplement();
        clientes = dao.mostrarClientes();
        return clientes;
    }

    public void setClientes(List<Clientes> clientes) {
        this.clientes = clientes;
    }
    
    

    /**
     * Creates a new instance of clientesBean
     */
    public clientesBean() {
        cliente = new Clientes();
    }
    //Agrega un mensaje
    public void addMessage(String summary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,summary,null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void insertar(){
        ClientesDao dao = new ClientesDaoImplement();
        dao.insertarClientes(cliente);
        cliente = new Clientes();
        addMessage("Cliente agregado");
    }
    
    public void modificar(){
        ClientesDao dao = new ClientesDaoImplement();
        dao.modificarClientes(cliente);
        cliente = new Clientes();
        addMessage("Cliente modificado");
    }
    
    public void eliminar(){
        ClientesDao dao = new ClientesDaoImplement();
        dao.eliminarClientes(cliente);
        cliente = new Clientes();
        addMessage("Cliente eliminado");
    }
}

