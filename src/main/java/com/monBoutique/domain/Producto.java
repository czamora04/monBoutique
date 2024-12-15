/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monBoutique.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
 
 
@Data
@Entity
@Table(name="producto")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Long idProducto;   
    private String nombre;
    private String detalle;
    private double precio;
    private int existencias;
    @Column(name="ruta_Imagen")
    private String ruta_Imagen;
    private boolean activo;
 
    @ManyToOne
    @JoinColumn(name="id_Categoria")
    Boutique categoria;
 
    public Producto() {        
    }
 
 
    public Producto(String nombre, String detalle, double precio, int existencias, String imagen, boolean activo) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.ruta_Imagen = imagen;
        this.activo = activo;
    }
}


