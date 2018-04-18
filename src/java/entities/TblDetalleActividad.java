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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "tbl_detalle_actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDetalleActividad.findAll", query = "SELECT t FROM TblDetalleActividad t")
    , @NamedQuery(name = "TblDetalleActividad.findByCodActividad", query = "SELECT t FROM TblDetalleActividad t WHERE t.codActividad = :codActividad")
    , @NamedQuery(name = "TblDetalleActividad.findByNombre", query = "SELECT t FROM TblDetalleActividad t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TblDetalleActividad.findByFechaAsignada", query = "SELECT t FROM TblDetalleActividad t WHERE t.fechaAsignada = :fechaAsignada")
    , @NamedQuery(name = "TblDetalleActividad.findByCorreoEmpleado", query = "SELECT t FROM TblDetalleActividad t WHERE t.correoEmpleado = :correoEmpleado")
    , @NamedQuery(name = "TblDetalleActividad.findByEtapa", query = "SELECT t FROM TblDetalleActividad t WHERE t.etapa = :etapa")
    , @NamedQuery(name = "TblDetalleActividad.findByTarea", query = "SELECT t FROM TblDetalleActividad t WHERE t.tarea = :tarea")
    , @NamedQuery(name = "TblDetalleActividad.findByEspecificacion", query = "SELECT t FROM TblDetalleActividad t WHERE t.especificacion = :especificacion")})
public class TblDetalleActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_actividad")
    private Integer codActividad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_asignada")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correo_empleado")
    private String correoEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "etapa")
    private String etapa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tarea")
    private String tarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "especificacion")
    private String especificacion;
    @JoinColumn(name = "cod_actividad", referencedColumnName = "cod_actividad", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TblActividad tblActividad;

    public TblDetalleActividad() {
    }

    public TblDetalleActividad(Integer codActividad) {
        this.codActividad = codActividad;
    }

    public TblDetalleActividad(Integer codActividad, String nombre, Date fechaAsignada, String correoEmpleado, String etapa, String tarea, String especificacion) {
        this.codActividad = codActividad;
        this.nombre = nombre;
        this.fechaAsignada = fechaAsignada;
        this.correoEmpleado = correoEmpleado;
        this.etapa = etapa;
        this.tarea = tarea;
        this.especificacion = especificacion;
    }

    public Integer getCodActividad() {
        return codActividad;
    }

    public void setCodActividad(Integer codActividad) {
        this.codActividad = codActividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaAsignada() {
        return fechaAsignada;
    }

    public void setFechaAsignada(Date fechaAsignada) {
        this.fechaAsignada = fechaAsignada;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }

    public TblActividad getTblActividad() {
        return tblActividad;
    }

    public void setTblActividad(TblActividad tblActividad) {
        this.tblActividad = tblActividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codActividad != null ? codActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleActividad)) {
            return false;
        }
        TblDetalleActividad other = (TblDetalleActividad) object;
        if ((this.codActividad == null && other.codActividad != null) || (this.codActividad != null && !this.codActividad.equals(other.codActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblDetalleActividad[ codActividad=" + codActividad + " ]";
    }
    
}
