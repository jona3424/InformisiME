/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;

import com.example.demo.model.Centri;
import com.example.demo.repository.CentriRepository;
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
@RequestMapping(value = "/informisime/centri")
public class CentriResource {
   
    @Autowired
    CentriRepository centriRepository;
    @GetMapping(value = "/all")
    public List<Centri> getAll(){
        return centriRepository.findAll();
}
    @PostMapping(value = "/load")
    public List<Centri> persist(@RequestBody final Centri centri){
        centriRepository.save(centri);
        return centriRepository.findAll();
    
}}
