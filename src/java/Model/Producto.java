package Model;
// Generated 10/09/2021 12:27:32 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Producto generated by hbm2java
 */
public class Producto  implements java.io.Serializable {


     private Integer idproducto;
     private Provedor provedor;
     private String nombre;
     private String descripcion;
     private Double contenido;
     private String marca;
     private Date fechacaducidad;
     private Double precio;
     private Set<Venta> ventas = new HashSet<Venta>(0);

    public Producto() {
     
        provedor = new Provedor();
    }

    public Producto(Provedor provedor, String nombre, String descripcion, Double contenido, String marca, Date fechacaducidad, Double precio, Set<Venta> ventas) {
       this.provedor = provedor;
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.contenido = contenido;
       this.marca = marca;
       this.fechacaducidad = fechacaducidad;
       this.precio = precio;
       this.ventas = ventas;
    }
   
    public Integer getIdproducto() {
        return this.idproducto;
    }
    
    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }
    public Provedor getProvedor() {
        return this.provedor;
    }
    
    public void setProvedor(Provedor provedor) {
        this.provedor = provedor;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Double getContenido() {
        return this.contenido;
    }
    
    public void setContenido(Double contenido) {
        this.contenido = contenido;
    }
    public String getMarca() {
        return this.marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public Date getFechacaducidad() {
        return this.fechacaducidad;
    }
    
    public void setFechacaducidad(Date fechacaducidad) {
        this.fechacaducidad = fechacaducidad;
    }
    public Double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public Set<Venta> getVentas() {
        return this.ventas;
    }
    
    public void setVentas(Set<Venta> ventas) {
        this.ventas = ventas;
    }




}


