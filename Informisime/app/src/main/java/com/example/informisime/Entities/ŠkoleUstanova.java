/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.informisime.Entities;

import java.io.Serializable;



public class ŠkoleUstanova implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Škole fkŠkole;

    private Ustanove fkUstanove;

    public ŠkoleUstanova() {
    }

    public ŠkoleUstanova(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Škole getFkŠkole() {
        return fkŠkole;
    }

    public void setFkŠkole(Škole fkŠkole) {
        this.fkŠkole = fkŠkole;
    }

    public Ustanove getFkUstanove() {
        return fkUstanove;
    }

    public void setFkUstanove(Ustanove fkUstanove) {
        this.fkUstanove = fkUstanove;
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
        if (!(object instanceof ŠkoleUstanova)) {
            return false;
        }
        ŠkoleUstanova other = (ŠkoleUstanova) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.\u0160koleUstanova[ id=" + id + " ]";
    }
    
}
