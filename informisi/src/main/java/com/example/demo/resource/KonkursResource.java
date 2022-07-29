/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;

import com.example.demo.model.Konkurs;
import com.example.demo.repository.KonkursRepository;
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
@RequestMapping(value = "/informisime/konkurs")
public class KonkursResource {
        @Autowired
        KonkursRepository konkursRepository;
    @GetMapping(value = "/all")
    public List<Konkurs> getAll(){
        return konkursRepository.findAll();
}
    @PostMapping(value = "/load")
    public List<Konkurs> persist(@RequestBody final Konkurs konkurs){
        konkursRepository.save(konkurs);
        return konkursRepository.findAll();
    
}
    
}
