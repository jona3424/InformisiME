/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.informisime.Entities;

import java.io.Serializable;
import java.util.List;



public class Links implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String link;

    private String naziv;
    private List<LinkoviSkola> linkoviSkolaList;

    public Links() {
    }

    public Links(Integer id) {
        this.id = id;
    }

    public Links(Integer id, String link, String naziv) {
        this.id = id;
        this.link = link;
        this.naziv = naziv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
        if (!(object instanceof Links)) {
            return false;
        }
        Links other = (Links) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.Links[ id=" + id + " ]";
    }
    
}
