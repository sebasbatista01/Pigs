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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "tbl_administrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAdministrador.findAll", query = "SELECT t FROM TblAdministrador t")
    , @NamedQuery(name = "TblAdministrador.findByIdUsuario", query = "SELECT t FROM TblAdministrador t WHERE t.idUsuario = :idUsuario")})
public class TblAdministrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TblUsuario tblUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<TblActividad> tblActividadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<TblPqr> tblPqrList;

    public TblAdministrador() {
    }

    public TblAdministrador(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TblUsuario getTblUsuario() {
        return tblUsuario;
    }

    public void setTblUsuario(TblUsuario tblUsuario) {
        this.tblUsuario = tblUsuario;
    }

    @XmlTransient
    public List<TblActividad> getTblActividadList() {
        return tblActividadList;
    }

    public void setTblActividadList(List<TblActividad> tblActividadList) {
        this.tblActividadList = tblActividadList;
    }

    @XmlTransient
    public List<TblPqr> getTblPqrList() {
        return tblPqrList;
    }

    public void setTblPqrList(List<TblPqr> tblPqrList) {
        this.tblPqrList = tblPqrList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAdministrador)) {
            return false;
        }
        TblAdministrador other = (TblAdministrador) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblAdministrador[ idUsuario=" + idUsuario + " ]";
    }
    
}
