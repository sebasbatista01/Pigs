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
@Table(name = "tbl_visita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblVisita.findAll", query = "SELECT t FROM TblVisita t")
    , @NamedQuery(name = "TblVisita.findByCodVisita", query = "SELECT t FROM TblVisita t WHERE t.codVisita = :codVisita")})
public class TblVisita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_visita")
    private Integer codVisita;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tblVisita")
    private TblDetalleVisita tblDetalleVisita;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private TblCliente idUsuario;

    public TblVisita() {
    }

    public TblVisita(Integer codVisita) {
        this.codVisita = codVisita;
    }

    public Integer getCodVisita() {
        return codVisita;
    }

    public void setCodVisita(Integer codVisita) {
        this.codVisita = codVisita;
    }

    public TblDetalleVisita getTblDetalleVisita() {
        return tblDetalleVisita;
    }

    public void setTblDetalleVisita(TblDetalleVisita tblDetalleVisita) {
        this.tblDetalleVisita = tblDetalleVisita;
    }

    public TblCliente getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(TblCliente idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof TblVisita)) {
            return false;
        }
        TblVisita other = (TblVisita) object;
        if ((this.codVisita == null && other.codVisita != null) || (this.codVisita != null && !this.codVisita.equals(other.codVisita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblVisita[ codVisita=" + codVisita + " ]";
    }
    
}
