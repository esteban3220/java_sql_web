/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Venta;
import java.util.List;

/**
 *
 * @author tonny
 */
public interface VentaDao {
   public void insertarVenta(Venta venta);
    public void modificarVenta(Venta venta);
    public void eliminarVenta(Venta venta);
    public List<Venta> mostrarVenta(); 
}