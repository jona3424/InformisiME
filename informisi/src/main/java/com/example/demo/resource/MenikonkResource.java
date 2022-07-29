/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;

import com.example.demo.model.Menikonkurs;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repository.MenikonkRepository;

/**
 *
 * @author Jona
 */
@RestController
@RequestMapping(value = "/informisime/menikonk")
public class MenikonkResource {
    @Autowired
    MenikonkRepository menikonkRepository;
    @GetMapping(value = "/all")
    public List<Menikonkurs> getAll(){
        return menikonkRepository.findAll();
}
    @PostMapping(value = "/load")
    public List<Menikonkurs> persist(@RequestBody final Menikonkurs menikonkurs){
        menikonkRepository.save(menikonkurs);
        return menikonkRepository.findAll();
    
}
}
