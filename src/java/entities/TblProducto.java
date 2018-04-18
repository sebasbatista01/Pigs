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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "tbl_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProducto.findAll", query = "SELECT t FROM TblProducto t")
    , @NamedQuery(name = "TblProducto.findByCodProducto", query = "SELECT t FROM TblProducto t WHERE t.codProducto = :codProducto")})
public class TblProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "cod_producto")
    private String codProducto;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tblProducto")
    private TblDetalleProducto tblDetalleProducto;
    @JoinColumn(name = "cod_inventario", referencedColumnName = "cod_inventario")
    @ManyToOne(optional = false)
    private TblInventario codInventario;

    public TblProducto() {
    }

    public TblProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public TblDetalleProducto getTblDetalleProducto() {
        return tblDetalleProducto;
    }

    public void setTblDetalleProducto(TblDetalleProducto tblDetalleProducto) {
        this.tblDetalleProducto = tblDetalleProducto;
    }

    public TblInventario getCodInventario() {
        return codInventario;
    }

    public void setCodInventario(TblInventario codInventario) {
        this.codInventario = codInventario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProducto != null ? codProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProducto)) {
            return false;
        }
        TblProducto other = (TblProducto) object;
        if ((this.codProducto == null && other.codProducto != null) || (this.codProducto != null && !this.codProducto.equals(other.codProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblProducto[ codProducto=" + codProducto + " ]";
    }
    
}
