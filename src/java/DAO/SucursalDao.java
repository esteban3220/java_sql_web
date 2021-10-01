/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Sucursal;
import java.util.List;

/**
 *
 * @author tonny
 */
public interface SucursalDao {
    public void insertarSucursal(Sucursal sucursal);
    public void modificarSucursal(Sucursal sucursal);
    public void eliminarSucursal(Sucursal sucursal);
    public List<Sucursal> mostrarSucursal(); 
}
