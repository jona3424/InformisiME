/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.CiljeviObrazovnih;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jona
 */
public interface CiljObrRepository extends JpaRepository<CiljeviObrazovnih, Integer>{
    
}
