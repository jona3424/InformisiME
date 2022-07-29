/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.informisime.Entities;

import java.io.Serializable;



public class Info implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String adresa;

    private String imedirektora;

    private String brojtelefona;

    private String brojfaxa;

    private String mail;

    public Info() {
    }

    public Info(Integer id) {
        this.id = id;
    }

    public Info(Integer id, String adresa, String imedirektora, String brojtelefona, String brojfaxa, String mail) {
        this.id = id;
        this.adresa = adresa;
        this.imedirektora = imedirektora;
        this.brojtelefona = brojtelefona;
        this.brojfaxa = brojfaxa;
        this.mail = mail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getImedirektora() {
        return imedirektora;
    }

    public void setImedirektora(String imedirektora) {
        this.imedirektora = imedirektora;
    }

    public String getBrojtelefona() {
        return brojtelefona;
    }

    public void setBrojtelefona(String brojtelefona) {
        this.brojtelefona = brojtelefona;
    }

    public String getBrojfaxa() {
        return brojfaxa;
    }

    public void setBrojfaxa(String brojfaxa) {
        this.brojfaxa = brojfaxa;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
        if (!(object instanceof Info)) {
            return false;
        }
        Info other = (Info) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.Info[ id=" + id + " ]";
    }
    
}
