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
@Table(name = "tbl_medicamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblMedicamento.findAll", query = "SELECT t FROM TblMedicamento t")
    , @NamedQuery(name = "TblMedicamento.findByCodMedicamento", query = "SELECT t FROM TblMedicamento t WHERE t.codMedicamento = :codMedicamento")
    , @NamedQuery(name = "TblMedicamento.findByNombre", query = "SELECT t FROM TblMedicamento t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TblMedicamento.findByPresentacion", query = "SELECT t FROM TblMedicamento t WHERE t.presentacion = :presentacion")
    , @NamedQuery(name = "TblMedicamento.findByRegistroSanitario", query = "SELECT t FROM TblMedicamento t WHERE t.registroSanitario = :registroSanitario")
    , @NamedQuery(name = "TblMedicamento.findByLaboratorio", query = "SELECT t FROM TblMedicamento t WHERE t.laboratorio = :laboratorio")
    , @NamedQuery(name = "TblMedicamento.findByFechaVencimiento", query = "SELECT t FROM TblMedicamento t WHERE t.fechaVencimiento = :fechaVencimiento")})
public class TblMedicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "cod_medicamento")
    private String codMedicamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "presentacion")
    private String presentacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "registro_sanitario")
    private String registroSanitario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "laboratorio")
    private String laboratorio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @JoinColumn(name = "cod_inventario", referencedColumnName = "cod_inventario")
    @ManyToOne(optional = false)
    private TblInventario codInventario;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private TblUsuario idUsuario;

    public TblMedicamento() {
    }

    public TblMedicamento(String codMedicamento) {
        this.codMedicamento = codMedicamento;
    }

    public TblMedicamento(String codMedicamento, String nombre, String presentacion, String registroSanitario, String laboratorio, Date fechaVencimiento) {
        this.codMedicamento = codMedicamento;
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.registroSanitario = registroSanitario;
        this.laboratorio = laboratorio;
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCodMedicamento() {
        return codMedicamento;
    }

    public void setCodMedicamento(String codMedicamento) {
        this.codMedicamento = codMedicamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getRegistroSanitario() {
        return registroSanitario;
    }

    public void setRegistroSanitario(String registroSanitario) {
        this.registroSanitario = registroSanitario;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
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

    public TblUsuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(TblUsuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMedicamento != null ? codMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMedicamento)) {
            return false;
        }
        TblMedicamento other = (TblMedicamento) object;
        if ((this.codMedicamento == null && other.codMedicamento != null) || (this.codMedicamento != null && !this.codMedicamento.equals(other.codMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblMedicamento[ codMedicamento=" + codMedicamento + " ]";
    }
    
}
