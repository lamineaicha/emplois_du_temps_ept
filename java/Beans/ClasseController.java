/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import entities.Classe;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jpa.ClasseJpa;

/**
 *
 * @author AMETH
 */
@Named(value = "classeController")
@RequestScoped
public class ClasseController implements Serializable{

    @EJB
    private ClasseJpa classeJpa;
    private Classe classe=new Classe();
    /**
     * Creates a new instance of ClasseController
     */
    public ClasseController() {
    }
  public String create() {
     classeJpa.create(classe);
    return "Create";  
  }
 public List<Classe> findAll(){
     return classeJpa.findAll();
 }
    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
  
}
