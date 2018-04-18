/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "tbl_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblRol.findAll", query = "SELECT t FROM TblRol t")
    , @NamedQuery(name = "TblRol.findByIdRol", query = "SELECT t FROM TblRol t WHERE t.idRol = :idRol")
    , @NamedQuery(name = "TblRol.findByNombre", query = "SELECT t FROM TblRol t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TblRol.findByDescripcion", query = "SELECT t FROM TblRol t WHERE t.descripcion = :descripcion")})
public class TblRol implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRol")
    private List<TblUsuario> tblUsuarioList1;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_rol")
    private Integer idRol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToMany(mappedBy = "tblRolList")
    private List<TblPermiso> tblPermisoList;
    @JoinTable(name = "tbl_rol_has_tbl_usuario", joinColumns = {
        @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")}, inverseJoinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToMany
    private List<TblUsuario> tblUsuarioList;

    public TblRol() {
    }

    public TblRol(Integer idRol) {
        this.idRol = idRol;
    }

    public TblRol(Integer idRol, String nombre, String descripcion) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
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

    @XmlTransient
    public List<TblPermiso> getTblPermisoList() {
        return tblPermisoList;
    }

    public void setTblPermisoList(List<TblPermiso> tblPermisoList) {
        this.tblPermisoList = tblPermisoList;
    }

    @XmlTransient
    public List<TblUsuario> getTblUsuarioList() {
        return tblUsuarioList;
    }

    public void setTblUsuarioList(List<TblUsuario> tblUsuarioList) {
        this.tblUsuarioList = tblUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblRol)) {
            return false;
        }
        TblRol other = (TblRol) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblRol[ idRol=" + idRol + " ]";
    }

    @XmlTransient
    public List<TblUsuario> getTblUsuarioList1() {
        return tblUsuarioList1;
    }

    public void setTblUsuarioList1(List<TblUsuario> tblUsuarioList1) {
        this.tblUsuarioList1 = tblUsuarioList1;
    }
    
}
