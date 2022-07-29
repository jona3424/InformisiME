/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;

import com.example.demo.model.ObrazovniProgrami;
import com.example.demo.repository.ObrProgRepository;
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
@RequestMapping(value = "/informisime/obrprog")
public class ObrProgResource {
    
    @Autowired
    ObrProgRepository obrProgRepository;
    @GetMapping(value = "/all")
    public List<ObrazovniProgrami> getAll(){
        return obrProgRepository.findAll();
}
    @PostMapping(value = "/load")
    public List<ObrazovniProgrami> persist(@RequestBody final ObrazovniProgrami obrazovniProgrami){
        obrProgRepository.save(obrazovniProgrami);
        return obrProgRepository.findAll();
    
}
}
