/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;

import com.example.demo.model.OblastiNemod;
import com.example.demo.repository.OblNemodRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jona
 */
@RestController
@RequestMapping(value = "/informisime/oblnemod")
public class OblNemodResource {
    @Autowired
    OblNemodRepository oblNemodRepository;
    @GetMapping(value = "/all")
    public List<OblastiNemod> getAll(){
        return oblNemodRepository.findAll();
}
    @PostMapping(value = "/load")
    public List<OblastiNemod> persist(@RequestBody final OblastiNemod oblastiNemod){
        oblNemodRepository.save(oblastiNemod);
        return oblNemodRepository.findAll();
    
}
    
         @GetMapping(value = "/dajoblnemod/{fkOblasti}")
    public List<OblastiNemod> dajoblnemod(@PathVariable int fkOblasti){
           List<OblastiNemod> cuvaj=new ArrayList<>();
        List<OblastiNemod> oblastinemod = oblNemodRepository.findAll();
        for(OblastiNemod on: oblastinemod){
            if(on.getFkOblasti().getId()==fkOblasti ){
            cuvaj.add(on);
        }
        }        return  cuvaj;

    }
}
