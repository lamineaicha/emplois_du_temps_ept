/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Niveau;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *couche d'accés aux données pour la classe niveau
 * @author AMETH
 */
@Stateless

public class NiveauJpa {
    
   @PersistenceContext(unitName = "primairePU")
   private EntityManager em;
   public List<Niveau> findAll(){
        return em.createNamedQuery("Niveau.findAll",Niveau.class).getResultList();
    }
   public Niveau findById(Long id){
       return em.createNamedQuery("Niveau.findById",Niveau.class).setParameter("id", id).getSingleResult();
   }
}
