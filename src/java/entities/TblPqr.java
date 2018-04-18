/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "tbl_pqr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPqr.findAll", query = "SELECT t FROM TblPqr t")
    , @NamedQuery(name = "TblPqr.findByCodPqr", query = "SELECT t FROM TblPqr t WHERE t.codPqr = :codPqr")})
public class TblPqr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_pqr")
    private Integer codPqr;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tblPqr")
    private TblDetallePqr tblDetallePqr;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private TblAdministrador idUsuario;

    public TblPqr() {
    }

    public TblPqr(Integer codPqr) {
        this.codPqr = codPqr;
    }

    public Integer getCodPqr() {
        return codPqr;
    }

    public void setCodPqr(Integer codPqr) {
        this.codPqr = codPqr;
    }

    public TblDetallePqr getTblDetallePqr() {
        return tblDetallePqr;
    }

    public void setTblDetallePqr(TblDetallePqr tblDetallePqr) {
        this.tblDetallePqr = tblDetallePqr;
    }

    public TblAdministrador getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(TblAdministrador idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPqr != null ? codPqr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPqr)) {
            return false;
        }
        TblPqr other = (TblPqr) object;
        if ((this.codPqr == null && other.codPqr != null) || (this.codPqr != null && !this.codPqr.equals(other.codPqr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblPqr[ codPqr=" + codPqr + " ]";
    }
    
}
