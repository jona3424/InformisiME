/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;

import com.example.demo.model.Meni;
import com.example.demo.repository.MeniRepository;
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
@RequestMapping(value = "/informisime/meni")
public class MeniResource {
     @Autowired
     MeniRepository meniRepository;
    @GetMapping(value = "/all" ,produces="application/json")
    public List<Meni> getAll(){
        return meniRepository.findAll();
}
    @PostMapping(value = "/load")
    public List<Meni> persist(@RequestBody final Meni main){
        meniRepository.save(main);
        return meniRepository.findAll();
    
}
}
