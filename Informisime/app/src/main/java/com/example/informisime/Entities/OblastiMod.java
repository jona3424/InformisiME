/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.informisime.Entities;

import java.io.Serializable;


public class OblastiMod implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Modularizovani fkModularizovani;

    private Oblasti fkOblasti;

    public OblastiMod() {
    }

    public OblastiMod(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Modularizovani getFkModularizovani() {
        return fkModularizovani;
    }

    public void setFkModularizovani(Modularizovani fkModularizovani) {
        this.fkModularizovani = fkModularizovani;
    }

    public Oblasti getFkOblasti() {
        return fkOblasti;
    }

    public void setFkOblasti(Oblasti fkOblasti) {
        this.fkOblasti = fkOblasti;
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
        if (!(object instanceof OblastiMod)) {
            return false;
        }
        OblastiMod other = (OblastiMod) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.OblastiMod[ id=" + id + " ]";
    }
    
}
