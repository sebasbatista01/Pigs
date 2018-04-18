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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "tbl_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUsuario.findAll", query = "SELECT t FROM TblUsuario t")
    , @NamedQuery(name = "TblUsuario.findByIdUsuario", query = "SELECT t FROM TblUsuario t WHERE t.idUsuario = :idUsuario")
    , @NamedQuery(name = "TblUsuario.findByNombre", query = "SELECT t FROM TblUsuario t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TblUsuario.findByApellido", query = "SELECT t FROM TblUsuario t WHERE t.apellido = :apellido")
    , @NamedQuery(name = "TblUsuario.findByGenero", query = "SELECT t FROM TblUsuario t WHERE t.genero = :genero")
    , @NamedQuery(name = "TblUsuario.findByEdad", query = "SELECT t FROM TblUsuario t WHERE t.edad = :edad")
    , @NamedQuery(name = "TblUsuario.findByFechaNacimiento", query = "SELECT t FROM TblUsuario t WHERE t.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "TblUsuario.findByContrase\u00f1a", query = "SELECT t FROM TblUsuario t WHERE t.contrase\u00f1a = :contrase\u00f1a")
    , @NamedQuery(name = "TblUsuario.findByUser", query = "SELECT t FROM TblUsuario t WHERE t.correo = :correo AND t.contraseña = :contraseña")  
    , @NamedQuery(name = "TblUsuario.findByCorreo", query = "SELECT t FROM TblUsuario t WHERE t.correo = :correo")})
public class TblUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "contrase\u00f1a")
    private String contraseña;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correo")
    private String correo;
    @ManyToMany(mappedBy = "tblUsuarioList")
    private List<TblRol> tblRolList;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private TblRol idRol;

    public TblUsuario() {
    }

    public TblUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TblUsuario(Integer idUsuario, String nombre, String apellido, String genero, int edad, Date fechaNacimiento, String contraseña, String correo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.contraseña = contraseña;
        this.correo = correo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public List<TblRol> getTblRolList() {
        return tblRolList;
    }

    public void setTblRolList(List<TblRol> tblRolList) {
        this.tblRolList = tblRolList;
    }

    public TblRol getIdRol() {
        return idRol;
    }

    public void setIdRol(TblRol idRol) {
        this.idRol = idRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblUsuario)) {
            return false;
        }
        TblUsuario other = (TblUsuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblUsuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
