/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monBoutique.Controller;

import com.monBoutique.domain.Boutique;
import com.monBoutique.service.BoutiqueService;
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
@RequestMapping("/categoria")
public class BoutiqueController {

    @Autowired
    private BoutiqueService BoutiqueService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = BoutiqueService.getBoutiques(false);
        model.addAttribute("categorias", lista);
        model.addAttribute("totalCategorias", lista.size());
        return "/categoria/listado";
    }
    
    @GetMapping("/quienessomos")
    public String quienesSomos(Model model) {
        var lista = BoutiqueService.getBoutiques(false);
        model.addAttribute("categorias", lista);
        model.addAttribute("totalCategorias", lista.size());
        return "/categoria/quienessomos";
    }
    
    @GetMapping("/contactenos")
    public String contactenos(Model model) {
        var lista = BoutiqueService.getBoutiques(false);
        model.addAttribute("categorias", lista);
        model.addAttribute("totalCategorias", lista.size());
        return "/categoria/contactenos";
    }

    @GetMapping("/nuevo")
    public String categoriaNuevo(Boutique categoria) {
        return "/categoria/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String categoriaGuardar(Boutique categoria,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            categoria.setRuta_imagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "categoria",
                            categoria.getIdCategoria()));
            BoutiqueService.save(categoria);
        }
        BoutiqueService.save(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/eliminar/{idCategoria}")
    public String categoriaEliminar(Boutique categoria) {
        BoutiqueService.delete(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/modificar/{idCategoria}")
    public String categoriaModificar(Boutique categoria, Model model) {
        categoria = BoutiqueService.getBoutique(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modifica";
    }
}
