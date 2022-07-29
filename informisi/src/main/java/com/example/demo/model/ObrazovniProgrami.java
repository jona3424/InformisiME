/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jona
 */
@Entity
@Table(name = "obrazovni_programi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObrazovniProgrami.findAll", query = "SELECT o FROM ObrazovniProgrami o"),
    @NamedQuery(name = "ObrazovniProgrami.findById", query = "SELECT o FROM ObrazovniProgrami o WHERE o.id = :id"),
    @NamedQuery(name = "ObrazovniProgrami.findByNaziv", query = "SELECT o FROM ObrazovniProgrami o WHERE o.naziv = :naziv")})
public class ObrazovniProgrami implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkObrazovni")
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
