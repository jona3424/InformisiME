/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;

import com.example.demo.model.Škole;
import com.example.demo.repository.SkRepository;
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
@RequestMapping(value = "/informisime/skole")
public class SkResource {
    @Autowired
    SkRepository skRepository;
    @GetMapping(value = "/all")
    public List<Škole> getAll(){
        return skRepository.findAll();
}
    @PostMapping(value = "/load")
    public List<Škole> persist(@RequestBody final Škole skole){
        skRepository.save(skole);
        return skRepository.findAll();
    
}
}
