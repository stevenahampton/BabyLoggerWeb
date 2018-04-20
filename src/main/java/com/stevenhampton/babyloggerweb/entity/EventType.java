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
@Table(name = "EVENTTYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventType.findAll", query = "SELECT e FROM EventType e")
    , @NamedQuery(name = "EventType.findByName", query = "SELECT e FROM EventType e WHERE e.name = :name")
    , @NamedQuery(name = "EventType.findByDescription", query = "SELECT e FROM EventType e WHERE e.description = :description")
    , @NamedQuery(name = "EventType.findById", query = "SELECT e FROM EventType e WHERE e.id = :id")})
public class EventType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "NAME")
    private String name;
    @Size(max = 256)
    @Column(name = "DESCRIPTION")
    private String description;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @OneToMany(mappedBy = "eventtype")
    private Collection<Event> eventCollection;

    public EventType() {
    }

    public EventType(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof EventType)) {
            return false;
        }
        EventType other = (EventType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stevenhampton.babyloggerweb.rest.EventType[ id=" + id + " ]";
    }
    
}
