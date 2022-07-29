/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;

import com.example.demo.model.InfoSkola;
import com.example.demo.repository.InfSkRepository;
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
@RequestMapping(value = "/informisime/infsk")
public class InfSkResource {
     @Autowired
     InfSkRepository infSkRepository;
    @GetMapping(value = "/all")
    public List<InfoSkola> getAll(){
        return infSkRepository.findAll();
}
    @PostMapping(value = "/load")
    public List<InfoSkola> persist(@RequestBody final InfoSkola infoSkola){
        infSkRepository.save(infoSkola);
        return infSkRepository.findAll();
    
}
    @GetMapping(value = "/dajinfsk/{fkSkole}")
    public List<InfoSkola> dajoblmodnaalb(@PathVariable int fkSkole){
           List<InfoSkola> cuvaj=new ArrayList<>();
        List<InfoSkola> infsk = infSkRepository.findAll();
        for(InfoSkola is:infsk ){
            if(is.getFkSkole().getId()==fkSkole ){
            cuvaj.add(is);
        }
        }        return  cuvaj;

    }
}
