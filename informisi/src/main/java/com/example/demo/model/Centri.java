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
@Table(name = "centri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Centri.findAll", query = "SELECT c FROM Centri c"),
    @NamedQuery(name = "Centri.findById", query = "SELECT c FROM Centri c WHERE c.id = :id"),
    @NamedQuery(name = "Centri.findByNaziv", query = "SELECT c FROM Centri c WHERE c.naziv = :naziv"),
    @NamedQuery(name = "Centri.findByKoordinate", query = "SELECT c FROM Centri c WHERE c.koordinate = :koordinate")})
public class Centri implements Serializable {

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

    public Centri() {
    }

    public Centri(Integer id) {
        this.id = id;
    }

    public Centri(Integer id, String naziv, String koordinate) {
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
        if (!(object instanceof Centri)) {
            return false;
        }
        Centri other = (Centri) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.Centri[ id=" + id + " ]";
    }
    
}
