/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.sun.corba.se.impl.util.PackagePrefixChecker;
import dao.TblUsuarioFacade;
import entities.TblRol;
import entities.TblUsuario;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author USER
 */
@Named(value = "userControlador")
@ConversationScoped
public class sesionController implements Serializable {

    @Inject
    private Conversation conversation;
    @EJB
    private TblUsuarioFacade usuarioFacade;
    private List<TblUsuario> listUsers;
    private TblUsuario usseer;
    private TblRol rol;

    private int modalIngreso; 
    private String correo;
    private String clave;

    @PostConstruct
    public void inicilizar() {
        listUsers = usuarioFacade.findAll();
        usseer = new TblUsuario();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public TblUsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(TblUsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public List<TblUsuario> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<TblUsuario> listUsers) {
        this.listUsers = listUsers;
    }

    public TblUsuario getUsseer() {
        return usseer;
    }

    public void setUsseer(TblUsuario usseer) {
        this.usseer = usseer;
    }

   public TblRol getRol() {
        return rol;
    }

    public void setRol(TblRol rol) {
        this.rol = rol;
    }

    public int getModalIngreso() {
        return modalIngreso;
    }

    public void setModalIngreso(int modalIngreso) {
        this.modalIngreso = modalIngreso;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String autenticar() {
        String res = "/pigs/";
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        if (correo != null && correo.trim().length()>0 && clave != null && clave.trim().length()>0) {
             
        }else{
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Datos Incorrectos", "El correo o clave estan mal"));
        }
        return null;
        
    }

      public void cerrarSesion() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        try {
            facesContext.getExternalContext().redirect("/index.html");
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public void validarSesionAdmon() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        try {
            if (httpServletRequest.getSession().getAttribute("usseer") != null && usseer.getIdRol().getIdRol() == 1) {
            } else {
                facesContext.getExternalContext().redirect("/pigs/403.xhtml");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
         public void validarSesionCliente() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        try {
            if (httpServletRequest.getSession().getAttribute("usseer") != null && rol.getIdRol() == 2) {
            } else {
                facesContext.getExternalContext().redirect("/pigs/403.xhtml");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validarSesiónEmpleado() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        try {
            if (httpServletRequest.getSession().getAttribute("usseer") != null && rol.getIdRol() == 3) {
            } else {
                facesContext.getExternalContext().redirect("/pigs/403.xhtml");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
