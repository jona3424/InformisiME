/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;

import com.example.demo.model.Nemodularizovani;
import com.example.demo.repository.NemodRepository;
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
@RequestMapping(value = "/informisime/nemod")
public class NemodResource {
        @Autowired
        NemodRepository nemodRepository;
    @GetMapping(value = "/all")
    public List<Nemodularizovani> getAll(){
        return nemodRepository.findAll();
}
    @PostMapping(value = "/load")
    public List<Nemodularizovani> persist(@RequestBody final Nemodularizovani nemodularizovani){
        nemodRepository.save(nemodularizovani);
        return nemodRepository.findAll();
    
}
}
