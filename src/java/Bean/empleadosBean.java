/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.EmpleadosDao;
import DAO.EmpleadosDaoImplement;
import Model.Empleado;
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
public class empleadosBean {

      private Empleado empleado;
      private List<Empleado> empleados;

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Empleado> getEmpleados() {
        EmpleadosDao dao = new EmpleadosDaoImplement();
        empleados = dao.mostrarEmpleado();
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    
    public empleadosBean() {
        empleado = new Empleado();
    }
    
    
    public void addMessage(String summary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,summary,null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void insertar(){
        EmpleadosDao dao = new EmpleadosDaoImplement();
        dao.insertarEmpleados(empleado);
        empleado = new Empleado();
        addMessage("Empleado agregado");
    }
    
    public void ModificarEmpleado(){
        EmpleadosDao dao = new EmpleadosDaoImplement();
        dao.modificarEmpleados(empleado);
        empleado = new Empleado();
        addMessage("Empleado agregado");
    }
    public void EliminarEmpleado(){
        EmpleadosDao dao = new EmpleadosDaoImplement();
        dao.eliminarEmpleados(empleado);
        empleado = new Empleado();
        addMessage("Empleado Eliminado");
    }
    
    
}
