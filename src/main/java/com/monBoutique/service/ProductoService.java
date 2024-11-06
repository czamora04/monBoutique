/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.monBoutique.service;

import com.monBoutique.domain.Producto;
import java.util.List;

public interface ProductoService {
    
    // Se obtiene un listado de Productos en un List
    public List<Producto> getProductos(boolean activos);
    
   // Se obtiene un Producto, a partir del id de un Producto
    public Producto getProducto(Producto Producto);
    
    // Se inserta un nuevo Producto si el id del Producto esta vacío
    // Se actualiza un Producto si el id del Producto NO esta vacío
    public void save(Producto Producto);
    
    // Se elimina el Producto que tiene el id pasado por parámetro
    public void delete(Producto Producto);
}


