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
@Table(name = "tbl_empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEmpleado.findAll", query = "SELECT t FROM TblEmpleado t")
    , @NamedQuery(name = "TblEmpleado.findByIdUsuario", query = "SELECT t FROM TblEmpleado t WHERE t.idUsuario = :idUsuario")})
public class TblEmpleado implements Serializable {

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
    private List<TblInventario> tblInventarioList;

    public TblEmpleado() {
    }

    public TblEmpleado(Integer idUsuario) {
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
    public List<TblInventario> getTblInventarioList() {
        return tblInventarioList;
    }

    public void setTblInventarioList(List<TblInventario> tblInventarioList) {
        this.tblInventarioList = tblInventarioList;
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
        if (!(object instanceof TblEmpleado)) {
            return false;
        }
        TblEmpleado other = (TblEmpleado) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblEmpleado[ idUsuario=" + idUsuario + " ]";
    }
    
}
