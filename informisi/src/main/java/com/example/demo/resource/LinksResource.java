/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;

import com.example.demo.model.Links;
import com.example.demo.repository.LinksRepository;
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
@RequestMapping(value = "/informisime/links")

public class LinksResource {
    
    @Autowired
    LinksRepository linksRepository;
    @GetMapping(value = "/all")
    public List<Links> getAll(){
        return linksRepository.findAll();
}
    @PostMapping(value = "/load")
    public List<Links> persist(@RequestBody final Links links){
        linksRepository.save(links);
        return linksRepository.findAll();
    
}
}
