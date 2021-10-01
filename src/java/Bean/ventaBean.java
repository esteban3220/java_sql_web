/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.VentaDao;
import DAO.VentaDaoImplement;
import Model.Venta;
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
public class ventaBean {

    private Venta venta;
    private List<Venta> ventas;

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<Venta> getVentas() {
        VentaDao dao = new VentaDaoImplement();
        ventas = dao.mostrarVenta();
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public ventaBean() {
        venta = new Venta();

    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void insertar() {
        VentaDao dao = new VentaDaoImplement();
        dao.insertarVenta(venta);
        venta = new Venta();
        addMessage("Venta Agregada");
    }
    
     public void modificar() {
        VentaDao dao = new VentaDaoImplement();
        dao.modificarVenta(venta);
        venta = new Venta();
        addMessage("Venta Agregada");
    }
     
      public void eliminar() {
        VentaDao dao = new VentaDaoImplement();
        dao.eliminarVenta(venta);
        venta = new Venta();
        addMessage("Venta Agregada");
    }    
}
