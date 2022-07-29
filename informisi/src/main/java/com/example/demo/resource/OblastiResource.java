/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;

import com.example.demo.model.Oblasti;
import com.example.demo.repository.OblastiRepository;
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
@RequestMapping(value = "/informisime/oblasti")
public class OblastiResource {
    @Autowired
    OblastiRepository oblastiRepository;
    @GetMapping(value = "/all")
    public List<Oblasti> getAll(){
        return oblastiRepository.findAll();
}
    @PostMapping(value = "/load")
    public List<Oblasti> persist(@RequestBody final Oblasti oblasti){
        oblastiRepository.save(oblasti);
        return oblastiRepository.findAll();
    
}
}
