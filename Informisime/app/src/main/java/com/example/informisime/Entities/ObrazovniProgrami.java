/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.informisime.Entities;

import java.io.Serializable;
import java.util.List;



public class ObrazovniProgrami implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String naziv;
    private List<ObrazovniSkola> obrazovniSkolaList;

    public ObrazovniProgrami() {
    }

    public ObrazovniProgrami(Integer id) {
        this.id = id;
    }

    public ObrazovniProgrami(Integer id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
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
        if (!(object instanceof ObrazovniProgrami)) {
            return false;
        }
        ObrazovniProgrami other = (ObrazovniProgrami) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.ObrazovniProgrami[ id=" + id + " ]";
    }
    
}
