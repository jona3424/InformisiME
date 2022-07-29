/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;

import com.example.demo.model.UčeničkiDomovi;
import com.example.demo.repository.UceDomRepository;
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
@RequestMapping(value = "/informisime/ucedom")
public class UceDomResource {
     @Autowired
     UceDomRepository uceDomRepository;
    @GetMapping(value = "/all")
    public List<UčeničkiDomovi> getAll(){
        return uceDomRepository.findAll();
}
    @PostMapping(value = "/load")
    public List<UčeničkiDomovi> persist(@RequestBody final UčeničkiDomovi učeničkiDomovi){
        uceDomRepository.save(učeničkiDomovi);
        return uceDomRepository.findAll();
    
}
}
