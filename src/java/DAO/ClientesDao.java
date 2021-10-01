/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Clientes;
import java.util.List;

/**
 *
 * @author tonny
 */
public interface ClientesDao {
    
    public void insertarClientes(Clientes clientes);
    public void modificarClientes(Clientes clientes);
    public void eliminarClientes(Clientes clientes);
    public List<Clientes> mostrarClientes();
    
}
