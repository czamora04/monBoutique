/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monBoutique.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "categoría")
public class Boutique implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Categoria")
    private long idCategoria;

    private String nombre;
    @Column(name = "ruta_imagen")
    private String ruta_imagen;
    private boolean activo;

    @OneToMany
    @JoinColumn(name = "id_categoria")
    List<Producto> productos;
    
    public Boutique() {
    }

    public Boutique(String nombre, String ruta_imagen, boolean activo) {
        this.nombre = nombre;
        this.ruta_imagen = ruta_imagen;
        this.activo = activo;
    }
}
