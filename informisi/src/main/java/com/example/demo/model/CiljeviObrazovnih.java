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
@Table(name = "ciljevi_obrazovnih")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CiljeviObrazovnih.findAll", query = "SELECT c FROM CiljeviObrazovnih c"),
    @NamedQuery(name = "CiljeviObrazovnih.findById", query = "SELECT c FROM CiljeviObrazovnih c WHERE c.id = :id")})
public class CiljeviObrazovnih implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "fk_ciljevi", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Ciljevi fkCiljevi;
    @JoinColumn(name = "fk_obrazovni", referencedColumnName = "ID")
    @ManyToOne(optional = false)
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
