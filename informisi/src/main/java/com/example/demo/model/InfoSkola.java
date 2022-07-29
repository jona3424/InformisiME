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
@Table(name = "info_skola")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfoSkola.findAll", query = "SELECT i FROM InfoSkola i"),
    @NamedQuery(name = "InfoSkola.findById", query = "SELECT i FROM InfoSkola i WHERE i.id = :id")})
public class InfoSkola implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "fk_info", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Info fkInfo;
    @JoinColumn(name = "fk_skole", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Škole fkSkole;

    public InfoSkola() {
    }

    public InfoSkola(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Info getFkInfo() {
        return fkInfo;
    }

    public void setFkInfo(Info fkInfo) {
        this.fkInfo = fkInfo;
    }

    public Škole getFkSkole() {
        return fkSkole;
    }

    public void setFkSkole(Škole fkSkole) {
        this.fkSkole = fkSkole;
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
        if (!(object instanceof InfoSkola)) {
            return false;
        }
        InfoSkola other = (InfoSkola) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.InfoSkola[ id=" + id + " ]";
    }
    
}
