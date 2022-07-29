/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;

import com.example.demo.model.Ciljevi;
import com.example.demo.repository.CiljeviRepository;
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
@RequestMapping(value = "/informisime/ciljevi")
public class CiljeviResource {
  
   
    @Autowired
    CiljeviRepository ciljeviRepository;
    @GetMapping(value = "/all")
    public List<Ciljevi> getAll(){
        return ciljeviRepository.findAll();
}
    @PostMapping(value = "/load")
    public List<Ciljevi> persist(@RequestBody final Ciljevi ciljevi){
        ciljeviRepository.save(ciljevi);
        return ciljeviRepository.findAll();
    
}
}
