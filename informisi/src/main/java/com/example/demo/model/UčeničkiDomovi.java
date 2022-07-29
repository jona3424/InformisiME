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
@Table(name = "u\u010deni\u010dki_domovi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "U\u010deni\u010dkiDomovi.findAll", query = "SELECT u FROM U\u010deni\u010dkiDomovi u"),
    @NamedQuery(name = "U\u010deni\u010dkiDomovi.findById", query = "SELECT u FROM U\u010deni\u010dkiDomovi u WHERE u.id = :id"),
    @NamedQuery(name = "U\u010deni\u010dkiDomovi.findByNaziv", query = "SELECT u FROM U\u010deni\u010dkiDomovi u WHERE u.naziv = :naziv"),
    @NamedQuery(name = "U\u010deni\u010dkiDomovi.findByKoordinate", query = "SELECT u FROM U\u010deni\u010dkiDomovi u WHERE u.koordinate = :koordinate")})
public class UčeničkiDomovi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "koordinate")
    private String koordinate;

    public UčeničkiDomovi() {
    }

    public UčeničkiDomovi(Integer id) {
        this.id = id;
    }

    public UčeničkiDomovi(Integer id, String naziv, String koordinate) {
        this.id = id;
        this.naziv = naziv;
        this.koordinate = koordinate;
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

    public String getKoordinate() {
        return koordinate;
    }

    public void setKoordinate(String koordinate) {
        this.koordinate = koordinate;
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
        if (!(object instanceof UčeničkiDomovi)) {
            return false;
        }
        UčeničkiDomovi other = (UčeničkiDomovi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.U\u010deni\u010dkiDomovi[ id=" + id + " ]";
    }
    
}
