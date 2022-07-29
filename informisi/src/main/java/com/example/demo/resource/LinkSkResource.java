/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;
import com.example.demo.model.LinkoviSkola;
import com.example.demo.repository.LinkSkRepository;
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
@RequestMapping(value = "/informisime/linksk")
public class LinkSkResource {
    @Autowired
    LinkSkRepository linkSkRepository;
    @GetMapping(value = "/all")
    public List<LinkoviSkola> getAll(){
        return linkSkRepository.findAll();
}
    @PostMapping(value = "/load")
    public List<LinkoviSkola> persist(@RequestBody final LinkoviSkola linkoviSkola){
        linkSkRepository.save(linkoviSkola);
        return linkSkRepository.findAll();
    
}
    
    @GetMapping(value = "/dajlinks/{fkSkole}")
    public List<LinkoviSkola> dajoblmodnaalb(@PathVariable int fkSkole){
           List<LinkoviSkola> cuvaj=new ArrayList<>();
        List<LinkoviSkola> linkssk = linkSkRepository.findAll();
        for(LinkoviSkola ls:linkssk ){
            if(ls.getFkSkole().getId()==fkSkole ){
            cuvaj.add(ls);
        }
        }        return  cuvaj;

    }
}
