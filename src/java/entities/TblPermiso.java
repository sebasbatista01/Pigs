/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
 * @author USER
 */
@Entity
@Table(name = "tbl_permiso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPermiso.findAll", query = "SELECT t FROM TblPermiso t")
    , @NamedQuery(name = "TblPermiso.findByIdPermiso", query = "SELECT t FROM TblPermiso t WHERE t.idPermiso = :idPermiso")
    , @NamedQuery(name = "TblPermiso.findByDescripcion", query = "SELECT t FROM TblPermiso t WHERE t.descripcion = :descripcion")})
public class TblPermiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_permiso")
    private Integer idPermiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinTable(name = "tbl_rol_has_tbl_permiso", joinColumns = {
        @JoinColumn(name = "id_permiso", referencedColumnName = "id_permiso")}, inverseJoinColumns = {
        @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")})
    @ManyToMany
    private List<TblRol> tblRolList;
    @OneToMany(mappedBy = "tblPermisoId")
    private List<TblPermiso> tblPermisoList;
    @JoinColumn(name = "tbl_permiso_id", referencedColumnName = "id_permiso")
    @ManyToOne
    private TblPermiso tblPermisoId;

    public TblPermiso() {
    }

    public TblPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public TblPermiso(Integer idPermiso, String descripcion) {
        this.idPermiso = idPermiso;
        this.descripcion = descripcion;
    }

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<TblRol> getTblRolList() {
        return tblRolList;
    }

    public void setTblRolList(List<TblRol> tblRolList) {
        this.tblRolList = tblRolList;
    }

    @XmlTransient
    public List<TblPermiso> getTblPermisoList() {
        return tblPermisoList;
    }

    public void setTblPermisoList(List<TblPermiso> tblPermisoList) {
        this.tblPermisoList = tblPermisoList;
    }

    public TblPermiso getTblPermisoId() {
        return tblPermisoId;
    }

    public void setTblPermisoId(TblPermiso tblPermisoId) {
        this.tblPermisoId = tblPermisoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermiso != null ? idPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPermiso)) {
            return false;
        }
        TblPermiso other = (TblPermiso) object;
        if ((this.idPermiso == null && other.idPermiso != null) || (this.idPermiso != null && !this.idPermiso.equals(other.idPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblPermiso[ idPermiso=" + idPermiso + " ]";
    }
    
}
