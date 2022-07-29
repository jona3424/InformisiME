/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resource;

import com.example.demo.model.DatabaseFile;
import com.example.demo.repository.FilesRepository;
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
@RequestMapping(value = "/informisime/files")
public class DatabseFileRersource {
    @Autowired
    FilesRepository databaseFileRepository;
     @GetMapping(value = "/dajoblmodalb/{fileid}")
    public String dajimefile(@PathVariable int fileid){
        String ime="";
        List<DatabaseFile> files = databaseFileRepository.findAll();
        for(DatabaseFile f:files ){
            if(Integer.parseInt(f.getId())==fileid ){
            ime=f.getFileName();
        }
        }        return  ime;

    }
    }

