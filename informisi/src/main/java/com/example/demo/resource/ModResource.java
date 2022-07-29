/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;

import com.example.demo.model.Modularizovani;
import com.example.demo.repository.ModRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jona
 */
@RestController
@RequestMapping(value = "/informisime/mod")
public class ModResource {
    @Autowired
    ModRepository modRepository;
    @GetMapping(value = "/all")
    public List<Modularizovani> getAll(){
        return modRepository.findAll();
}
    @PostMapping(value = "/load")
    public List<Modularizovani> persist(@RequestBody final Modularizovani modularizovani){
        modRepository.save(modularizovani);
        return modRepository.findAll();
    
}
}
