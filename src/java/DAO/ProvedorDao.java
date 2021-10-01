/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Provedor;
import java.util.List;

/**
 *
 * @author tonny
 */
public interface ProvedorDao {
    
    public void insertarProvedor(Provedor provedor);
    public void modificarProvedor(Provedor provedor);
    public void eliminarProvedor(Provedor provedor);
    public List<Provedor> mostrarProvedor();
    
}
