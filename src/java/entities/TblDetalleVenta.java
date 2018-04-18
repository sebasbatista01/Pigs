/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "tbl_detalle_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDetalleVenta.findAll", query = "SELECT t FROM TblDetalleVenta t")
    , @NamedQuery(name = "TblDetalleVenta.findByCodVenta", query = "SELECT t FROM TblDetalleVenta t WHERE t.codVenta = :codVenta")
    , @NamedQuery(name = "TblDetalleVenta.findByTipoVenta", query = "SELECT t FROM TblDetalleVenta t WHERE t.tipoVenta = :tipoVenta")
    , @NamedQuery(name = "TblDetalleVenta.findByFecha", query = "SELECT t FROM TblDetalleVenta t WHERE t.fecha = :fecha")
    , @NamedQuery(name = "TblDetalleVenta.findByDireccion", query = "SELECT t FROM TblDetalleVenta t WHERE t.direccion = :direccion")
    , @NamedQuery(name = "TblDetalleVenta.findByPedido", query = "SELECT t FROM TblDetalleVenta t WHERE t.pedido = :pedido")
    , @NamedQuery(name = "TblDetalleVenta.findByCantidad", query = "SELECT t FROM TblDetalleVenta t WHERE t.cantidad = :cantidad")
    , @NamedQuery(name = "TblDetalleVenta.findByPrecio", query = "SELECT t FROM TblDetalleVenta t WHERE t.precio = :precio")})
public class TblDetalleVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_venta")
    private Integer codVenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_venta")
    private String tipoVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pedido")
    private String pedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private long precio;
    @JoinColumn(name = "cod_venta", referencedColumnName = "cod_venta", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TblVenta tblVenta;

    public TblDetalleVenta() {
    }

    public TblDetalleVenta(Integer codVenta) {
        this.codVenta = codVenta;
    }

    public TblDetalleVenta(Integer codVenta, String tipoVenta, Date fecha, String direccion, String pedido, int cantidad, long precio) {
        this.codVenta = codVenta;
        this.tipoVenta = tipoVenta;
        this.fecha = fecha;
        this.direccion = direccion;
        this.pedido = pedido;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(Integer codVenta) {
        this.codVenta = codVenta;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public TblVenta getTblVenta() {
        return tblVenta;
    }

    public void setTblVenta(TblVenta tblVenta) {
        this.tblVenta = tblVenta;
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
        if (!(object instanceof TblDetalleVenta)) {
            return false;
        }
        TblDetalleVenta other = (TblDetalleVenta) object;
        if ((this.codVenta == null && other.codVenta != null) || (this.codVenta != null && !this.codVenta.equals(other.codVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblDetalleVenta[ codVenta=" + codVenta + " ]";
    }
    
}
