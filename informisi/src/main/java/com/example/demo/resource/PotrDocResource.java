/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;

import com.example.demo.model.PotrebnaDokumenta;
import com.example.demo.repository.PotrDocRepository;
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
@RequestMapping(value = "/informisime/potrdoc")
public class PotrDocResource {
    @Autowired
    PotrDocRepository potrDocRepository;
    @GetMapping(value = "/all")
    public List<PotrebnaDokumenta> getAll(){
        return potrDocRepository.findAll();
}
    @PostMapping(value = "/load")
    public List<PotrebnaDokumenta> persist(@RequestBody final PotrebnaDokumenta potrebnaDokumenta){
        potrDocRepository.save(potrebnaDokumenta);
        return potrDocRepository.findAll();
    
}
}
