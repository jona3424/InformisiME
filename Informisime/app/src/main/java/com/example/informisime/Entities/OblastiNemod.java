/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.informisime.Entities;

import java.io.Serializable;



public class OblastiNemod implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Oblasti fkOblasti;

    private Nemodularizovani fkNemodularizovani;

    public OblastiNemod() {
    }

    public OblastiNemod(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Oblasti getFkOblasti() {
        return fkOblasti;
    }

    public void setFkOblasti(Oblasti fkOblasti) {
        this.fkOblasti = fkOblasti;
    }

    public Nemodularizovani getFkNemodularizovani() {
        return fkNemodularizovani;
    }

    public void setFkNemodularizovani(Nemodularizovani fkNemodularizovani) {
        this.fkNemodularizovani = fkNemodularizovani;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OblastiNemod)) {
            return false;
        }
        OblastiNemod other = (OblastiNemod) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.OblastiNemod[ id=" + id + " ]";
    }
    
}
