/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Empleado;
import java.util.List;

/**
 *
 * @author tonny
 */
public interface EmpleadosDao {
    public void insertarEmpleados(Empleado empleados);
    public void modificarEmpleados(Empleado empleados);
    public void eliminarEmpleados(Empleado empleados);
    public List<Empleado> mostrarEmpleado();
}
