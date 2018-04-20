/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stevenhampton.babyloggerweb.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author sa_ha
 */
@Entity
@Table(name = "AMOUNTUNIT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmountUnit.findAll", query = "SELECT a FROM AmountUnit a")
    , @NamedQuery(name = "AmountUnit.findById", query = "SELECT a FROM AmountUnit a WHERE a.id = :id")
    , @NamedQuery(name = "AmountUnit.findByAbbrev", query = "SELECT a FROM AmountUnit a WHERE a.abbrev = :abbrev")
    , @NamedQuery(name = "AmountUnit.findByDescription", query = "SELECT a FROM AmountUnit a WHERE a.description = :description")})
public class AmountUnit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 10)
    @Column(name = "ABBREV")
    private String abbrev;
    @Size(max = 256)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(mappedBy = "amountunit")
    private Collection<Event> eventCollection;

    public AmountUnit() {
    }

    public AmountUnit(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
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
        if (!(object instanceof AmountUnit)) {
            return false;
        }
        AmountUnit other = (AmountUnit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stevenhampton.babyloggerweb.rest.AmountUnit[ id=" + id + " ]";
    }
    
}
