/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.TblPorquinaza;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author USER
 */
@Stateless
public class TblPorquinazaFacade extends AbstractFacade<TblPorquinaza> {

    @PersistenceContext(unitName = "pigsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblPorquinazaFacade() {
        super(TblPorquinaza.class);
    }
    
}
