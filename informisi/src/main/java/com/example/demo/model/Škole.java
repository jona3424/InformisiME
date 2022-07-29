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
import javax.persistence.Lob;
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
@Table(name = "\u0161kole")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "\u0160kole.findAll", query = "SELECT \u0161 FROM \u0160kole \u0161"),
    @NamedQuery(name = "\u0160kole.findById", query = "SELECT \u0161 FROM \u0160kole \u0161 WHERE \u0161.id = :id"),
    @NamedQuery(name = "\u0160kole.findByNaziv", query = "SELECT \u0161 FROM \u0160kole \u0161 WHERE \u0161.naziv = :naziv")})
public class Škole implements Serializable {

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
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "maps")
    private String maps;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkSkole")
    private List<InfoSkola> infoSkolaList;

    public Škole() {
    }

    public Škole(Integer id) {
        this.id = id;
    }

    public Škole(Integer id, String naziv, String maps) {
        this.id = id;
        this.naziv = naziv;
        this.maps = maps;
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

    public String getMaps() {
        return maps;
    }

    public void setMaps(String maps) {
        this.maps = maps;
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
        if (!(object instanceof Škole)) {
            return false;
        }
        Škole other = (Škole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.\u0160kole[ id=" + id + " ]";
    }
    
}
