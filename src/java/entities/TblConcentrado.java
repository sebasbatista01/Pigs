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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "tbl_concentrado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblConcentrado.findAll", query = "SELECT t FROM TblConcentrado t")
    , @NamedQuery(name = "TblConcentrado.findByCodConcentrado", query = "SELECT t FROM TblConcentrado t WHERE t.codConcentrado = :codConcentrado")
    , @NamedQuery(name = "TblConcentrado.findByTipoConcentrado", query = "SELECT t FROM TblConcentrado t WHERE t.tipoConcentrado = :tipoConcentrado")
    , @NamedQuery(name = "TblConcentrado.findByEtapa", query = "SELECT t FROM TblConcentrado t WHERE t.etapa = :etapa")
    , @NamedQuery(name = "TblConcentrado.findByPesoConcentrado", query = "SELECT t FROM TblConcentrado t WHERE t.pesoConcentrado = :pesoConcentrado")
    , @NamedQuery(name = "TblConcentrado.findByFechaVencimiento", query = "SELECT t FROM TblConcentrado t WHERE t.fechaVencimiento = :fechaVencimiento")})
public class TblConcentrado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "cod_concentrado")
    private String codConcentrado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_concentrado")
    private String tipoConcentrado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "etapa")
    private String etapa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso_concentrado")
    private long pesoConcentrado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @JoinColumn(name = "cod_inventario", referencedColumnName = "cod_inventario")
    @ManyToOne(optional = false)
    private TblInventario codInventario;

    public TblConcentrado() {
    }

    public TblConcentrado(String codConcentrado) {
        this.codConcentrado = codConcentrado;
    }

    public TblConcentrado(String codConcentrado, String tipoConcentrado, String etapa, long pesoConcentrado, Date fechaVencimiento) {
        this.codConcentrado = codConcentrado;
        this.tipoConcentrado = tipoConcentrado;
        this.etapa = etapa;
        this.pesoConcentrado = pesoConcentrado;
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCodConcentrado() {
        return codConcentrado;
    }

    public void setCodConcentrado(String codConcentrado) {
        this.codConcentrado = codConcentrado;
    }

    public String getTipoConcentrado() {
        return tipoConcentrado;
    }

    public void setTipoConcentrado(String tipoConcentrado) {
        this.tipoConcentrado = tipoConcentrado;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public long getPesoConcentrado() {
        return pesoConcentrado;
    }

    public void setPesoConcentrado(long pesoConcentrado) {
        this.pesoConcentrado = pesoConcentrado;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
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
        hash += (codConcentrado != null ? codConcentrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblConcentrado)) {
            return false;
        }
        TblConcentrado other = (TblConcentrado) object;
        if ((this.codConcentrado == null && other.codConcentrado != null) || (this.codConcentrado != null && !this.codConcentrado.equals(other.codConcentrado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblConcentrado[ codConcentrado=" + codConcentrado + " ]";
    }
    
}
