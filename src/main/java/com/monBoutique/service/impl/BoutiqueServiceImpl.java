/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monBoutique.service.impl;

import com.monBoutique.domain.Boutique;
import com.monBoutique.service.BoutiqueService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.monBoutique.dao.BoutiqueDao;

@Service
public class BoutiqueServiceImpl implements BoutiqueService {

    @Autowired
    private BoutiqueDao boutiqueDao;

    @Override
    @Transactional(readOnly = true)
    public List<Boutique> getBoutique(boolean activos) {
        var lista = boutiqueDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Boutique getBoutique(Boutique categoria) {
        return boutiqueDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Boutique categoria) {
        boutiqueDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Boutique categoria) {
        boutiqueDao.delete(categoria);
    }
}

