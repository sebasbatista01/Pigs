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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "tbl_porquinaza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPorquinaza.findAll", query = "SELECT t FROM TblPorquinaza t")
    , @NamedQuery(name = "TblPorquinaza.findByCodPorquinaza", query = "SELECT t FROM TblPorquinaza t WHERE t.codPorquinaza = :codPorquinaza")
    , @NamedQuery(name = "TblPorquinaza.findByPesoPorquinaza", query = "SELECT t FROM TblPorquinaza t WHERE t.pesoPorquinaza = :pesoPorquinaza")
    , @NamedQuery(name = "TblPorquinaza.findByPesoTotal", query = "SELECT t FROM TblPorquinaza t WHERE t.pesoTotal = :pesoTotal")})
public class TblPorquinaza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "cod_porquinaza")
    private String codPorquinaza;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso_porquinaza")
    private long pesoPorquinaza;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso_total")
    private long pesoTotal;
    @JoinColumn(name = "cod_inventario", referencedColumnName = "cod_inventario")
    @ManyToOne(optional = false)
    private TblInventario codInventario;

    public TblPorquinaza() {
    }

    public TblPorquinaza(String codPorquinaza) {
        this.codPorquinaza = codPorquinaza;
    }

    public TblPorquinaza(String codPorquinaza, long pesoPorquinaza, long pesoTotal) {
        this.codPorquinaza = codPorquinaza;
        this.pesoPorquinaza = pesoPorquinaza;
        this.pesoTotal = pesoTotal;
    }

    public String getCodPorquinaza() {
        return codPorquinaza;
    }

    public void setCodPorquinaza(String codPorquinaza) {
        this.codPorquinaza = codPorquinaza;
    }

    public long getPesoPorquinaza() {
        return pesoPorquinaza;
    }

    public void setPesoPorquinaza(long pesoPorquinaza) {
        this.pesoPorquinaza = pesoPorquinaza;
    }

    public long getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(long pesoTotal) {
        this.pesoTotal = pesoTotal;
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
        hash += (codPorquinaza != null ? codPorquinaza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPorquinaza)) {
            return false;
        }
        TblPorquinaza other = (TblPorquinaza) object;
        if ((this.codPorquinaza == null && other.codPorquinaza != null) || (this.codPorquinaza != null && !this.codPorquinaza.equals(other.codPorquinaza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblPorquinaza[ codPorquinaza=" + codPorquinaza + " ]";
    }
    
}
