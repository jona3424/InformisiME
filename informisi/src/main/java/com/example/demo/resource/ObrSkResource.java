/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;

import com.example.demo.model.ObrazovniSkola;
import com.example.demo.repository.ObrProgRepository;
import com.example.demo.repository.ObrSkRepository;
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
@RequestMapping(value = "/informisime/obrsk")
public class ObrSkResource {
    @Autowired
    ObrSkRepository obrSkRepository;
    @GetMapping(value = "/all")
    public List<ObrazovniSkola> getAll(){
        return obrSkRepository.findAll();
}
    @PostMapping(value = "/load")
    public List<ObrazovniSkola> persist(@RequestBody final ObrazovniSkola obrazovniSkola){
        obrSkRepository.save(obrazovniSkola);
        return obrSkRepository.findAll();
    
}
    
    @GetMapping(value = "/dajobrsk/{fkSkole}")
    public List<ObrazovniSkola> dajoblmodnaalb(@PathVariable int fkSkole){
           List<ObrazovniSkola> cuvaj=new ArrayList<>();
        List<ObrazovniSkola> obrsk = obrSkRepository.findAll();
        for(ObrazovniSkola os:obrsk ){
            if(os.getFkSkole().getId()==fkSkole ){
            cuvaj.add(os);
        }
        }        return  cuvaj;

    }
}
