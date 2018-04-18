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
@Table(name = "tbl_cerdo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCerdo.findAll", query = "SELECT t FROM TblCerdo t")
    , @NamedQuery(name = "TblCerdo.findByCodCerdo", query = "SELECT t FROM TblCerdo t WHERE t.codCerdo = :codCerdo")
    , @NamedQuery(name = "TblCerdo.findByFechaNacimiento", query = "SELECT t FROM TblCerdo t WHERE t.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "TblCerdo.findByRaza", query = "SELECT t FROM TblCerdo t WHERE t.raza = :raza")
    , @NamedQuery(name = "TblCerdo.findByNCamada", query = "SELECT t FROM TblCerdo t WHERE t.nCamada = :nCamada")
    , @NamedQuery(name = "TblCerdo.findByPesoNacimiento", query = "SELECT t FROM TblCerdo t WHERE t.pesoNacimiento = :pesoNacimiento")
    , @NamedQuery(name = "TblCerdo.findByNChapeta", query = "SELECT t FROM TblCerdo t WHERE t.nChapeta = :nChapeta")})
public class TblCerdo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "cod_cerdo")
    private String codCerdo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "raza")
    private String raza;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_camada")
    private int nCamada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso_nacimiento")
    private long pesoNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_chapeta")
    private int nChapeta;
    @JoinColumn(name = "cod_inventario", referencedColumnName = "cod_inventario")
    @ManyToOne(optional = false)
    private TblInventario codInventario;

    public TblCerdo() {
    }

    public TblCerdo(String codCerdo) {
        this.codCerdo = codCerdo;
    }

    public TblCerdo(String codCerdo, Date fechaNacimiento, String raza, int nCamada, long pesoNacimiento, int nChapeta) {
        this.codCerdo = codCerdo;
        this.fechaNacimiento = fechaNacimiento;
        this.raza = raza;
        this.nCamada = nCamada;
        this.pesoNacimiento = pesoNacimiento;
        this.nChapeta = nChapeta;
    }

    public String getCodCerdo() {
        return codCerdo;
    }

    public void setCodCerdo(String codCerdo) {
        this.codCerdo = codCerdo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getNCamada() {
        return nCamada;
    }

    public void setNCamada(int nCamada) {
        this.nCamada = nCamada;
    }

    public long getPesoNacimiento() {
        return pesoNacimiento;
    }

    public void setPesoNacimiento(long pesoNacimiento) {
        this.pesoNacimiento = pesoNacimiento;
    }

    public int getNChapeta() {
        return nChapeta;
    }

    public void setNChapeta(int nChapeta) {
        this.nChapeta = nChapeta;
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
        hash += (codCerdo != null ? codCerdo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCerdo)) {
            return false;
        }
        TblCerdo other = (TblCerdo) object;
        if ((this.codCerdo == null && other.codCerdo != null) || (this.codCerdo != null && !this.codCerdo.equals(other.codCerdo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblCerdo[ codCerdo=" + codCerdo + " ]";
    }
    
}
