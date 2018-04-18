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
@Table(name = "tbl_actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblActividad.findAll", query = "SELECT t FROM TblActividad t")
    , @NamedQuery(name = "TblActividad.findByCodActividad", query = "SELECT t FROM TblActividad t WHERE t.codActividad = :codActividad")})
public class TblActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_actividad")
    private Integer codActividad;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private TblAdministrador idUsuario;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tblActividad")
    private TblDetalleActividad tblDetalleActividad;

    public TblActividad() {
    }

    public TblActividad(Integer codActividad) {
        this.codActividad = codActividad;
    }

    public Integer getCodActividad() {
        return codActividad;
    }

    public void setCodActividad(Integer codActividad) {
        this.codActividad = codActividad;
    }

    public TblAdministrador getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(TblAdministrador idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TblDetalleActividad getTblDetalleActividad() {
        return tblDetalleActividad;
    }

    public void setTblDetalleActividad(TblDetalleActividad tblDetalleActividad) {
        this.tblDetalleActividad = tblDetalleActividad;
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
        if (!(object instanceof TblActividad)) {
            return false;
        }
        TblActividad other = (TblActividad) object;
        if ((this.codActividad == null && other.codActividad != null) || (this.codActividad != null && !this.codActividad.equals(other.codActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblActividad[ codActividad=" + codActividad + " ]";
    }
    
}
