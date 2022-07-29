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
@Table(name = "nemodularizovani")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nemodularizovani.findAll", query = "SELECT n FROM Nemodularizovani n"),
    @NamedQuery(name = "Nemodularizovani.findById", query = "SELECT n FROM Nemodularizovani n WHERE n.id = :id"),
    @NamedQuery(name = "Nemodularizovani.findByNaziv", query = "SELECT n FROM Nemodularizovani n WHERE n.naziv = :naziv")})
public class Nemodularizovani implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkNemodularizovani")
    private List<OblastiNemod> oblastiNemodList;

    public Nemodularizovani() {
    }

    public Nemodularizovani(Integer id) {
        this.id = id;
    }

    public Nemodularizovani(Integer id, String naziv) {
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
        if (!(object instanceof Nemodularizovani)) {
            return false;
        }
        Nemodularizovani other = (Nemodularizovani) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.Nemodularizovani[ id=" + id + " ]";
    }
    
}
