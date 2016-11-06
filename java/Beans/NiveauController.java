/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import entities.Niveau;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jpa.NiveauJpa;

/**
 *
 * @author AMETH
 */
@Named(value = "niveauController")
@RequestScoped
public class NiveauController implements Serializable{

    @EJB
    private NiveauJpa niveauJpa;
    

    /**
     * Creates a new instance of NvieauController
     */
    public NiveauController() {
    }
  public List<Niveau>findAll(){
      return niveauJpa.findAll();
      
  }  
}
