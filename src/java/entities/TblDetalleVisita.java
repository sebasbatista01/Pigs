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
@Table(name = "tbl_detalle_visita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDetalleVisita.findAll", query = "SELECT t FROM TblDetalleVisita t")
    , @NamedQuery(name = "TblDetalleVisita.findByCodVisita", query = "SELECT t FROM TblDetalleVisita t WHERE t.codVisita = :codVisita")
    , @NamedQuery(name = "TblDetalleVisita.findByNombre", query = "SELECT t FROM TblDetalleVisita t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TblDetalleVisita.findByFecha", query = "SELECT t FROM TblDetalleVisita t WHERE t.fecha = :fecha")
    , @NamedQuery(name = "TblDetalleVisita.findByCorreo", query = "SELECT t FROM TblDetalleVisita t WHERE t.correo = :correo")
    , @NamedQuery(name = "TblDetalleVisita.findByRespuesta", query = "SELECT t FROM TblDetalleVisita t WHERE t.respuesta = :respuesta")})
public class TblDetalleVisita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_visita")
    private Integer codVisita;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "respuesta")
    private String respuesta;
    @JoinColumn(name = "cod_visita", referencedColumnName = "cod_visita", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TblVisita tblVisita;

    public TblDetalleVisita() {
    }

    public TblDetalleVisita(Integer codVisita) {
        this.codVisita = codVisita;
    }

    public TblDetalleVisita(Integer codVisita, String nombre, Date fecha, String correo, String respuesta) {
        this.codVisita = codVisita;
        this.nombre = nombre;
        this.fecha = fecha;
        this.correo = correo;
        this.respuesta = respuesta;
    }

    public Integer getCodVisita() {
        return codVisita;
    }

    public void setCodVisita(Integer codVisita) {
        this.codVisita = codVisita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public TblVisita getTblVisita() {
        return tblVisita;
    }

    public void setTblVisita(TblVisita tblVisita) {
        this.tblVisita = tblVisita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codVisita != null ? codVisita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleVisita)) {
            return false;
        }
        TblDetalleVisita other = (TblDetalleVisita) object;
        if ((this.codVisita == null && other.codVisita != null) || (this.codVisita != null && !this.codVisita.equals(other.codVisita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblDetalleVisita[ codVisita=" + codVisita + " ]";
    }
    
}
