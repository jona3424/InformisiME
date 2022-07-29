/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;

import com.example.demo.model.Meniobrazovni;
import com.example.demo.repository.MeniobrazovniRepository;
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
@RequestMapping(value = "/informisime/meniobr")
public class MeniobrazovniResource {
    @Autowired
    MeniobrazovniRepository meniobrazovniRepository;
    @GetMapping(value = "/all")
    public List<Meniobrazovni> getAll(){
        return meniobrazovniRepository.findAll();
}
    @PostMapping(value = "/load")
    public List<Meniobrazovni> persist(@RequestBody final Meniobrazovni meniobrazovni){
        meniobrazovniRepository.save(meniobrazovni);
        return meniobrazovniRepository.findAll();
    
}
}
