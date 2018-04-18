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
@Table(name = "tbl_detalle_pqr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDetallePqr.findAll", query = "SELECT t FROM TblDetallePqr t")
    , @NamedQuery(name = "TblDetallePqr.findByCodPqr", query = "SELECT t FROM TblDetallePqr t WHERE t.codPqr = :codPqr")
    , @NamedQuery(name = "TblDetallePqr.findByTipoPqr", query = "SELECT t FROM TblDetallePqr t WHERE t.tipoPqr = :tipoPqr")
    , @NamedQuery(name = "TblDetallePqr.findByFecha", query = "SELECT t FROM TblDetallePqr t WHERE t.fecha = :fecha")
    , @NamedQuery(name = "TblDetallePqr.findByDescripcion", query = "SELECT t FROM TblDetallePqr t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TblDetallePqr.findByRespuesta", query = "SELECT t FROM TblDetallePqr t WHERE t.respuesta = :respuesta")})
public class TblDetallePqr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_pqr")
    private Integer codPqr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_pqr")
    private String tipoPqr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "respuesta")
    private String respuesta;
    @JoinColumn(name = "cod_pqr", referencedColumnName = "cod_pqr", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TblPqr tblPqr;

    public TblDetallePqr() {
    }

    public TblDetallePqr(Integer codPqr) {
        this.codPqr = codPqr;
    }

    public TblDetallePqr(Integer codPqr, String tipoPqr, Date fecha, String descripcion, String respuesta) {
        this.codPqr = codPqr;
        this.tipoPqr = tipoPqr;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.respuesta = respuesta;
    }

    public Integer getCodPqr() {
        return codPqr;
    }

    public void setCodPqr(Integer codPqr) {
        this.codPqr = codPqr;
    }

    public String getTipoPqr() {
        return tipoPqr;
    }

    public void setTipoPqr(String tipoPqr) {
        this.tipoPqr = tipoPqr;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public TblPqr getTblPqr() {
        return tblPqr;
    }

    public void setTblPqr(TblPqr tblPqr) {
        this.tblPqr = tblPqr;
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
        if (!(object instanceof TblDetallePqr)) {
            return false;
        }
        TblDetallePqr other = (TblDetallePqr) object;
        if ((this.codPqr == null && other.codPqr != null) || (this.codPqr != null && !this.codPqr.equals(other.codPqr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblDetallePqr[ codPqr=" + codPqr + " ]";
    }
    
}
