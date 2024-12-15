/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monBoutique.Controller;

import com.monBoutique.domain.Boutique;
import com.monBoutique.domain.Producto;
import com.monBoutique.service.BoutiqueService;
import com.monBoutique.service.ProductoService;
import com.monBoutique.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private BoutiqueService boutiqueService;

    @Autowired
    private ProductoService productoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = productoService.getProductos(false);

        var categorias = boutiqueService.getBoutiques(false);
        model.addAttribute("categorias", categorias);

        model.addAttribute("productos", lista);
        model.addAttribute("totalProductos", lista.size());
        return "/producto/listado";
    }
    
    @GetMapping("/listado/{idCategoria}")
    public String listado(Model model, Boutique categoria) {
        var productos = boutiqueService.getBoutique(categoria).getProductos();
        var categorias = boutiqueService.getBoutiques(false);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        model.addAttribute("categorias", categorias);
        return "/producto/listado";
    }

    @GetMapping("/nuevo")
    public String productoNuevo(Producto producto) {
        return "/producto/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String productoGuardar(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            productoService.save(producto);
            producto.setRuta_Imagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "producto",
                            producto.getIdProducto()));
        }
        productoService.save(producto);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/eliminar/{idProducto}")
    public String productoEliminar(Producto producto) {
        productoService.delete(producto);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/modificar/{idProducto}")
    public String productoModificar(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);

        var categorias = boutiqueService.getBoutiques(false);
        model.addAttribute("categorias", categorias);

        return "/producto/modifica";
    }
}
