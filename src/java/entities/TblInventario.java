/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "tbl_inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblInventario.findAll", query = "SELECT t FROM TblInventario t")
    , @NamedQuery(name = "TblInventario.findByCodInventario", query = "SELECT t FROM TblInventario t WHERE t.codInventario = :codInventario")
    , @NamedQuery(name = "TblInventario.findByFechaIngreso", query = "SELECT t FROM TblInventario t WHERE t.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "TblInventario.findByCantidad", query = "SELECT t FROM TblInventario t WHERE t.cantidad = :cantidad")
    , @NamedQuery(name = "TblInventario.findByEstado", query = "SELECT t FROM TblInventario t WHERE t.estado = :estado")})
public class TblInventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_inventario")
    private Integer codInventario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codInventario")
    private List<TblMedicamento> tblMedicamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codInventario")
    private List<TblPorquinaza> tblPorquinazaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codInventario")
    private List<TblConcentrado> tblConcentradoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codInventario")
    private List<TblCerdo> tblCerdoList;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private TblEmpleado idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codInventario")
    private List<TblProducto> tblProductoList;

    public TblInventario() {
    }

    public TblInventario(Integer codInventario) {
        this.codInventario = codInventario;
    }

    public TblInventario(Integer codInventario, Date fechaIngreso, int cantidad, String estado) {
        this.codInventario = codInventario;
        this.fechaIngreso = fechaIngreso;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public Integer getCodInventario() {
        return codInventario;
    }

    public void setCodInventario(Integer codInventario) {
        this.codInventario = codInventario;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<TblMedicamento> getTblMedicamentoList() {
        return tblMedicamentoList;
    }

    public void setTblMedicamentoList(List<TblMedicamento> tblMedicamentoList) {
        this.tblMedicamentoList = tblMedicamentoList;
    }

    @XmlTransient
    public List<TblPorquinaza> getTblPorquinazaList() {
        return tblPorquinazaList;
    }

    public void setTblPorquinazaList(List<TblPorquinaza> tblPorquinazaList) {
        this.tblPorquinazaList = tblPorquinazaList;
    }

    @XmlTransient
    public List<TblConcentrado> getTblConcentradoList() {
        return tblConcentradoList;
    }

    public void setTblConcentradoList(List<TblConcentrado> tblConcentradoList) {
        this.tblConcentradoList = tblConcentradoList;
    }

    @XmlTransient
    public List<TblCerdo> getTblCerdoList() {
        return tblCerdoList;
    }

    public void setTblCerdoList(List<TblCerdo> tblCerdoList) {
        this.tblCerdoList = tblCerdoList;
    }

    public TblEmpleado getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(TblEmpleado idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<TblProducto> getTblProductoList() {
        return tblProductoList;
    }

    public void setTblProductoList(List<TblProducto> tblProductoList) {
        this.tblProductoList = tblProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codInventario != null ? codInventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblInventario)) {
            return false;
        }
        TblInventario other = (TblInventario) object;
        if ((this.codInventario == null && other.codInventario != null) || (this.codInventario != null && !this.codInventario.equals(other.codInventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblInventario[ codInventario=" + codInventario + " ]";
    }
    
}
