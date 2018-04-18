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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "tbl_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblVenta.findAll", query = "SELECT t FROM TblVenta t")
    , @NamedQuery(name = "TblVenta.findByCodVenta", query = "SELECT t FROM TblVenta t WHERE t.codVenta = :codVenta")})
public class TblVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_venta")
    private Integer codVenta;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tblVenta")
    private TblDetalleVenta tblDetalleVenta;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private TblCliente idUsuario;

    public TblVenta() {
    }

    public TblVenta(Integer codVenta) {
        this.codVenta = codVenta;
    }

    public Integer getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(Integer codVenta) {
        this.codVenta = codVenta;
    }

    public TblDetalleVenta getTblDetalleVenta() {
        return tblDetalleVenta;
    }

    public void setTblDetalleVenta(TblDetalleVenta tblDetalleVenta) {
        this.tblDetalleVenta = tblDetalleVenta;
    }

    public TblCliente getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(TblCliente idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codVenta != null ? codVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblVenta)) {
            return false;
        }
        TblVenta other = (TblVenta) object;
        if ((this.codVenta == null && other.codVenta != null) || (this.codVenta != null && !this.codVenta.equals(other.codVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblVenta[ codVenta=" + codVenta + " ]";
    }
    
}
