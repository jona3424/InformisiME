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
@Table(name = "oblasti_mod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OblastiMod.findAll", query = "SELECT o FROM OblastiMod o"),
    @NamedQuery(name = "OblastiMod.findById", query = "SELECT o FROM OblastiMod o WHERE o.id = :id")})
public class OblastiMod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "fk_modularizovani", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Modularizovani fkModularizovani;
    @JoinColumn(name = "fk_oblasti", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Oblasti fkOblasti;

    public OblastiMod() {
    }

    public OblastiMod(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Modularizovani getFkModularizovani() {
        return fkModularizovani;
    }

    public void setFkModularizovani(Modularizovani fkModularizovani) {
        this.fkModularizovani = fkModularizovani;
    }

    public Oblasti getFkOblasti() {
        return fkOblasti;
    }

    public void setFkOblasti(Oblasti fkOblasti) {
        this.fkOblasti = fkOblasti;
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
        if (!(object instanceof OblastiMod)) {
            return false;
        }
        OblastiMod other = (OblastiMod) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.OblastiMod[ id=" + id + " ]";
    }
    
}
