/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "tbl_detalle_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDetalleProducto.findAll", query = "SELECT t FROM TblDetalleProducto t")
    , @NamedQuery(name = "TblDetalleProducto.findByCodProducto", query = "SELECT t FROM TblDetalleProducto t WHERE t.codProducto = :codProducto")
    , @NamedQuery(name = "TblDetalleProducto.findByNombre", query = "SELECT t FROM TblDetalleProducto t WHERE t.nombre = :nombre")})
public class TblDetalleProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "cod_producto")
    private String codProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "cod_producto", referencedColumnName = "cod_producto", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TblProducto tblProducto;

    public TblDetalleProducto() {
    }

    public TblDetalleProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public TblDetalleProducto(String codProducto, String nombre) {
        this.codProducto = codProducto;
        this.nombre = nombre;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TblProducto getTblProducto() {
        return tblProducto;
    }

    public void setTblProducto(TblProducto tblProducto) {
        this.tblProducto = tblProducto;
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
        if (!(object instanceof TblDetalleProducto)) {
            return false;
        }
        TblDetalleProducto other = (TblDetalleProducto) object;
        if ((this.codProducto == null && other.codProducto != null) || (this.codProducto != null && !this.codProducto.equals(other.codProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblDetalleProducto[ codProducto=" + codProducto + " ]";
    }
    
}
