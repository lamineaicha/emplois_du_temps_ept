/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Eleve;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AMETH
 */
@Stateless
public class EleveJpa {
     @PersistenceContext(unitName = "primairePU")
    private EntityManager em;
    public void create(Eleve e){
        em.persist(e);
    }
    
}
