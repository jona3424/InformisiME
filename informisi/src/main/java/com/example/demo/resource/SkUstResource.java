/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;

import com.example.demo.model.ŠkoleUstanova;
import com.example.demo.repository.SkUstRepository;
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
@RequestMapping(value = "/informisime/skust")
public class SkUstResource {
    @Autowired
    SkUstRepository skUstRepository;
    @GetMapping(value = "/all")
    public List<ŠkoleUstanova> getAll(){
        return skUstRepository.findAll();
}
    @PostMapping(value = "/load")
    public List<ŠkoleUstanova> persist(@RequestBody final ŠkoleUstanova skoleUstanova){
        skUstRepository.save(skoleUstanova);
        return skUstRepository.findAll();
    
}
       @GetMapping(value = "/dajskust/{fkUstanove}")
    public List<ŠkoleUstanova> dajoblmodnaalb(@PathVariable int fkUstanove){
           List<ŠkoleUstanova> cuvaj=new ArrayList<>();
        List<ŠkoleUstanova> skustanova = skUstRepository.findAll();
        for(ŠkoleUstanova skust:skustanova ){
            if(skust.getFkUstanove().getId()==fkUstanove ){
            cuvaj.add(skust);
        }
        }        return  cuvaj;

    }
}
