/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecniRec.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author josseline
 */
@Entity
@Table(name = "vacantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacantes.findAll", query = "SELECT v FROM Vacantes v"),
    @NamedQuery(name = "Vacantes.findById", query = "SELECT v FROM Vacantes v WHERE v.id = :id"),
    @NamedQuery(name = "Vacantes.findByNombre", query = "SELECT v FROM Vacantes v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "Vacantes.findByFecha", query = "SELECT v FROM Vacantes v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "Vacantes.findBySalario", query = "SELECT v FROM Vacantes v WHERE v.salario = :salario"),
    @NamedQuery(name = "Vacantes.findByEstatus", query = "SELECT v FROM Vacantes v WHERE v.estatus = :estatus"),
    @NamedQuery(name = "Vacantes.findByDestacado", query = "SELECT v FROM Vacantes v WHERE v.destacado = :destacado"),
    @NamedQuery(name = "Vacantes.findByImagen", query = "SELECT v FROM Vacantes v WHERE v.imagen = :imagen")})
public class Vacantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salario")
    private Double salario;
    @Column(name = "estatus")
    private Integer estatus;
    @Column(name = "destacado")
    private Integer destacado;
    @Column(name = "imagen")
    private String imagen;
    @Lob
    @Column(name = "detalle")
    private String detalle;
    @JoinColumn(name = "idCategoria", referencedColumnName = "id")
    @ManyToOne
    private Categorias idCategoria;
    @OneToMany(mappedBy = "idVacante")
    private Collection<Solicitudes> solicitudesCollection;

    public Vacantes() {
    }

    public Vacantes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public Integer getDestacado() {
        return destacado;
    }

    public void setDestacado(Integer destacado) {
        this.destacado = destacado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Categorias getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categorias idCategoria) {
        this.idCategoria = idCategoria;
    }

    @XmlTransient
    public Collection<Solicitudes> getSolicitudesCollection() {
        return solicitudesCollection;
    }

    public void setSolicitudesCollection(Collection<Solicitudes> solicitudesCollection) {
        this.solicitudesCollection = solicitudesCollection;
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
        if (!(object instanceof Vacantes)) {
            return false;
        }
        Vacantes other = (Vacantes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tecniRec.model.Vacantes[ id=" + id + " ]";
    }
    
}
