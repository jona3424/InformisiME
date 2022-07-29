/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;


import com.example.demo.model.Info;
import com.example.demo.repository.InfoRepository;
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
@RequestMapping(value = "/informisime/info")
public class InfoResource {
    @Autowired
    InfoRepository infoRepository;
    @GetMapping(value = "/all")
    public List<Info> getAll(){
        return infoRepository.findAll();
}
    @PostMapping(value = "/load")
    public List<Info> persist(@RequestBody final Info info){
        infoRepository.save(info);
        return infoRepository.findAll();
    
}
}
