/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.ProductoDao;
import DAO.ProductoDaoImplement;
import Model.Producto;
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
public class productoBean {
    
    private Producto producto;
    private List<Producto> productos;        

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getProductos() {
        ProductoDao dao = new ProductoDaoImplement();
        productos = dao.mostrarProducto();
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    /**
     * Creates a new instance of productoBean
     */
    public productoBean() {
        
        producto = new Producto();
    }
    
    public void addMessage(String summary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,summary,null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void insertar(){
        ProductoDao dao = new ProductoDaoImplement();
        dao.insertarProducto(producto);
        producto = new Producto();
        addMessage("Producto Agregado");
    }
    
    
    public void Modificar(){
        ProductoDao dao = new ProductoDaoImplement();
        dao.modificarProducto(producto);
        producto = new Producto();
        addMessage("Producto Modificado");
    }
    
    
    public void Eliminar(){
        ProductoDao dao = new ProductoDaoImplement();
        dao.eliminarProducto(producto);
        producto = new Producto();
        addMessage("Producto Eliminado");
    }
    
}
