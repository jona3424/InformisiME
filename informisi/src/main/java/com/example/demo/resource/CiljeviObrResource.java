/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;

import com.example.demo.model.CiljeviObrazovnih;
import com.example.demo.repository.CiljObrRepository;
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
@RequestMapping(value = "/informisime/ciljeviobr")
public class CiljeviObrResource {
    
    @Autowired
    CiljObrRepository ciljObrRepository;
    @GetMapping(value = "/all")
    public List<CiljeviObrazovnih> getAll(){
        return ciljObrRepository.findAll();
}
    @PostMapping(value = "/load")
    public List<CiljeviObrazovnih> persist(@RequestBody final CiljeviObrazovnih ciljeviObrazovnih){
        ciljObrRepository.save(ciljeviObrazovnih);
        return ciljObrRepository.findAll();
    
}
    
    
           @GetMapping(value = "/dajciljobr/{fkObrazovni}")
    public List<CiljeviObrazovnih> dajoblmodnaalb(@PathVariable int fkObrazovni){
           List<CiljeviObrazovnih> cuvaj=new ArrayList<>();
        List<CiljeviObrazovnih> ciljobraz = ciljObrRepository.findAll();
        for(CiljeviObrazovnih co:ciljobraz ){
            if(co.getFkObrazovni().getId()==fkObrazovni ){
            cuvaj.add(co);
        }
        }        return  cuvaj;

    }
}
