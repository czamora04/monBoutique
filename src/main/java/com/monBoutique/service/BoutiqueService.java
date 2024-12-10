/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.monBoutique.service;

import com.monBoutique.domain.Boutique;
import java.util.List;

public interface BoutiqueService {
    
    // Se obtiene un listado de categorias en un List
    public List<Boutique> getBoutiques(boolean activos);
    
   // Se obtiene un Categoria, a partir del id de un categoria
    public Boutique getBoutique(Boutique categoria);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Boutique categoria);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Boutique categoria);
}
