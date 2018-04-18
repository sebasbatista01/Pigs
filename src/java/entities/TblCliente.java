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
@Table(name = "tbl_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCliente.findAll", query = "SELECT t FROM TblCliente t")
    , @NamedQuery(name = "TblCliente.findByIdUsuario", query = "SELECT t FROM TblCliente t WHERE t.idUsuario = :idUsuario")})
public class TblCliente implements Serializable {

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
    private List<TblVenta> tblVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<TblVisita> tblVisitaList;

    public TblCliente() {
    }

    public TblCliente(Integer idUsuario) {
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
    public List<TblVenta> getTblVentaList() {
        return tblVentaList;
    }

    public void setTblVentaList(List<TblVenta> tblVentaList) {
        this.tblVentaList = tblVentaList;
    }

    @XmlTransient
    public List<TblVisita> getTblVisitaList() {
        return tblVisitaList;
    }

    public void setTblVisitaList(List<TblVisita> tblVisitaList) {
        this.tblVisitaList = tblVisitaList;
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
        if (!(object instanceof TblCliente)) {
            return false;
        }
        TblCliente other = (TblCliente) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblCliente[ idUsuario=" + idUsuario + " ]";
    }
    
}
