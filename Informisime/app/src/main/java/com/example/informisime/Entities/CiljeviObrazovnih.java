/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.informisime.Entities;

import java.io.Serializable;


public class CiljeviObrazovnih implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Ciljevi fkCiljevi;

    private ObrazovniProgrami fkObrazovni;

    public CiljeviObrazovnih() {
    }

    public CiljeviObrazovnih(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ciljevi getFkCiljevi() {
        return fkCiljevi;
    }

    public void setFkCiljevi(Ciljevi fkCiljevi) {
        this.fkCiljevi = fkCiljevi;
    }

    public ObrazovniProgrami getFkObrazovni() {
        return fkObrazovni;
    }

    public void setFkObrazovni(ObrazovniProgrami fkObrazovni) {
        this.fkObrazovni = fkObrazovni;
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
        if (!(object instanceof CiljeviObrazovnih)) {
            return false;
        }
        CiljeviObrazovnih other = (CiljeviObrazovnih) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.CiljeviObrazovnih[ id=" + id + " ]";
    }
    
}
