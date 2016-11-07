/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *c'est la classe d'accés au données 
 */
package jpa;

import entities.Classe;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AMETH
 */
@Stateless
public class ClasseJpa {
    @PersistenceContext(unitName = "primairePU")
    private EntityManager em;
    public void create(Classe c){
        em.persist(c);
    }
   public Classe findById(Long id){
       return em.createNamedQuery("Classe.findById",Classe.class).setParameter("id", id).getSingleResult();
   }
   public List<Classe> findAll(){
       
      return em.createNamedQuery("Classe.findAll",Classe.class).getResultList();
   }
}
