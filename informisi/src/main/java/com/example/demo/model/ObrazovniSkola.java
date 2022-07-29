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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jona
 */
@Entity
@Table(name = "obrazovni_skola")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObrazovniSkola.findAll", query = "SELECT o FROM ObrazovniSkola o"),
    @NamedQuery(name = "ObrazovniSkola.findById", query = "SELECT o FROM ObrazovniSkola o WHERE o.id = :id")})
public class ObrazovniSkola implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "fk_skole", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Škole fkSkole;
    @JoinColumn(name = "fk_obrazovni", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ObrazovniProgrami fkObrazovni;

    public ObrazovniSkola() {
    }

    public ObrazovniSkola(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Škole getFkSkole() {
        return fkSkole;
    }

    public void setFkSkole(Škole fkSkole) {
        this.fkSkole = fkSkole;
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
        if (!(object instanceof ObrazovniSkola)) {
            return false;
        }
        ObrazovniSkola other = (ObrazovniSkola) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.ObrazovniSkola[ id=" + id + " ]";
    }
    
}
