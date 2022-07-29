/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;

import com.example.demo.model.OblastiMod;
import com.example.demo.repository.OblModRepository;
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
@RequestMapping(value = "/informisime/oblmod")
public class OblModResource {
    
    @Autowired
    OblModRepository oblModRepository;
    @GetMapping(value = "/all")
    public List<OblastiMod> getAll(){
        return oblModRepository.findAll();
}
    @PostMapping(value = "/load")
    public List<OblastiMod> persist(@RequestBody final OblastiMod oblastiMod){
        oblModRepository.save(oblastiMod);
        return oblModRepository.findAll();
    
}
    
        
          @GetMapping(value = "/dajoblmod/{fkOblasti}")
    public List<OblastiMod> dajoblmod(@PathVariable int fkOblasti){
           List<OblastiMod> cuvaj=new ArrayList<>();
        List<OblastiMod> oblastim = oblModRepository.findAll();
        for(OblastiMod om:oblastim ){
            if(om.getFkOblasti().getId()==fkOblasti ){
            cuvaj.add(om);
        }
        }        return  cuvaj;

    }
}
