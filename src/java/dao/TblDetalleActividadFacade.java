/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.TblDetalleActividad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author USER
 */
@Stateless
public class TblDetalleActividadFacade extends AbstractFacade<TblDetalleActividad> {

    @PersistenceContext(unitName = "pigsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblDetalleActividadFacade() {
        super(TblDetalleActividad.class);
    }
    
}