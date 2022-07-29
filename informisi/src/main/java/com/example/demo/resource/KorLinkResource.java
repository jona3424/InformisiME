/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;
import com.example.demo.model.KorisniLinkovi;
import com.example.demo.repository.KorLinkRepository;
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
@RequestMapping(value = "/informisime/korlink")
public class KorLinkResource {
    @Autowired
    KorLinkRepository korLinkRepository;
    @GetMapping(value = "/all")
    public List<KorisniLinkovi> getAll(){
        return korLinkRepository.findAll();
}
    @PostMapping(value = "/load")
    public List<KorisniLinkovi> persist(@RequestBody final KorisniLinkovi korisniLinkovi){
        korLinkRepository.save(korisniLinkovi);
        return korLinkRepository.findAll();
    
}
}
