/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.monBoutique.service;

/**
 *
 * @author josep
 */
import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "monboutique-ea230.firebasestorage.app";

    //Esta es la ruta básica de este proyecto
    final String rutaSuperiorStorage = "monBoutique";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "monboutique-ea230-firebase-adminsdk-x5evu-802b6bcb6d.json";
}
