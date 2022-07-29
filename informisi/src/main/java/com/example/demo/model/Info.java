/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jona
 */
@Entity
@Table(name = "info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Info.findAll", query = "SELECT i FROM Info i"),
    @NamedQuery(name = "Info.findById", query = "SELECT i FROM Info i WHERE i.id = :id"),
    @NamedQuery(name = "Info.findByAdresa", query = "SELECT i FROM Info i WHERE i.adresa = :adresa"),
    @NamedQuery(name = "Info.findByImedirektora", query = "SELECT i FROM Info i WHERE i.imedirektora = :imedirektora"),
    @NamedQuery(name = "Info.findByBrojtelefona", query = "SELECT i FROM Info i WHERE i.brojtelefona = :brojtelefona"),
    @NamedQuery(name = "Info.findByBrojfaxa", query = "SELECT i FROM Info i WHERE i.brojfaxa = :brojfaxa"),
    @NamedQuery(name = "Info.findByMail", query = "SELECT i FROM Info i WHERE i.mail = :mail")})
public class Info implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Adresa")
    private String adresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Ime_direktora")
    private String imedirektora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Broj_telefona")
    private String brojtelefona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Broj_faxa")
    private String brojfaxa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Mail")
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
