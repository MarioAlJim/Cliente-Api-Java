/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author SILVERWOLF
 */
public class Catalogo {
    
    int idcatalogo; 
    String nombre; 
    int idtipo; 
    int orden;

    public Catalogo (){}

    public Catalogo(int idcatalogo, String nombre, int idtipo, int orden) {
        this.idcatalogo = idcatalogo;
        this.nombre = nombre;
        this.idtipo = idtipo;
        this.orden = orden;
    }
    
    public int getIdcatalogo() {
        return idcatalogo;
    }

    public void setIdcatalogo(int idcatalogo) {
        this.idcatalogo = idcatalogo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }
    
    
    
}
