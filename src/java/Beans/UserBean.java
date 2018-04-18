/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import dao.TblAdministradorFacade;
import dao.TblClienteFacade;
import dao.TblEmpleadoFacade;
import dao.TblRolFacade;
import dao.TblUsuarioFacade;
import entities.TblUsuario;
import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author APRENDIZ
 */
@Named(value = "usuarios")
@ConversationScoped
public class UserBean implements Serializable {

    @EJB
    private TblUsuarioFacade tblUsuarioFacade;

    @EJB
    private TblRolFacade tblRolFacade;

    @EJB
    private TblEmpleadoFacade tblEmpleadoFacade;

    @EJB
    private TblClienteFacade tblClienteFacade;

    @EJB
    private TblAdministradorFacade tblAdministradorFacade;

    private Integer idUsuario;
    private String nombre;
    private String apellido;
    private String genero;
    private int edad;
    private Date fechaNacimiento;
    private String contraseña;
    private String correo;
    TblUsuario u;

    /**
     * Creates a new instance of Usuarios
     */
    public UserBean() {
        u = new TblUsuario();
    }

    public List<TblUsuario> getUsersillos() {
        return tblUsuarioFacade.findAll();
    }

    public TblUsuario generar() {

        u.setIdUsuario(idUsuario);
        u.setNombre(nombre);
        u.setApellido(apellido);
        u.setGenero(genero);
        u.setEdad(0);
        u.setFechaNacimiento(fechaNacimiento);
        u.setContraseña(contraseña);
        u.setCorreo(correo);
        tblUsuarioFacade.create(u);
        return u;
    }

    public TblUsuario corregir() {
        u.setIdUsuario(idUsuario);
        u.setNombre(nombre);
        u.setApellido(apellido);
        u.setGenero(genero);
        u.setEdad(0);
        u.setFechaNacimiento(fechaNacimiento);
        u.setContraseña(contraseña);
        u.setCorreo(correo);
        tblUsuarioFacade.edit(u);
        return u;
    }

    public TblUsuario quitar() {
        u.setIdUsuario(idUsuario);
        u.setNombre(nombre);
        u.setApellido(apellido);
        u.setGenero(genero);
        u.setEdad(0);
        u.setFechaNacimiento(fechaNacimiento);
        u.setContraseña(contraseña);
        u.setCorreo(correo);
        tblUsuarioFacade.remove(u);
        return u;
    }

    public TblRolFacade getTblRolFacade() {
        return tblRolFacade;
    }

    public void setTblRolFacade(TblRolFacade tblRolFacade) {
        this.tblRolFacade = tblRolFacade;
    }

    public TblEmpleadoFacade getTblEmpleadoFacade() {
        return tblEmpleadoFacade;
    }

    public void setTblEmpleadoFacade(TblEmpleadoFacade tblEmpleadoFacade) {
        this.tblEmpleadoFacade = tblEmpleadoFacade;
    }

    public TblClienteFacade getTblClienteFacade() {
        return tblClienteFacade;
    }

    public void setTblClienteFacade(TblClienteFacade tblClienteFacade) {
        this.tblClienteFacade = tblClienteFacade;
    }

    public TblAdministradorFacade getTblAdministradorFacade() {
        return tblAdministradorFacade;
    }

    public void setTblAdministradorFacade(TblAdministradorFacade tblAdministradorFacade) {
        this.tblAdministradorFacade = tblAdministradorFacade;
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

    public TblUsuario getU() {
        return u;
    }

    public void setU(TblUsuario u) {
        this.u = u;
    }
    
    
}
