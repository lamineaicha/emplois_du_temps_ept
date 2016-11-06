/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import entities.Eleve;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jpa.EleveJpa;

/**
 *
 * @author AMETH
 */
@Named(value = "eleveController")
@RequestScoped
public class EleveController {

    @EJB
    private EleveJpa eleveJpa;
    private Eleve e=new Eleve();

    /**
     * Creates a new instance of EleveController
     */
    public EleveController() {
    }
    public String create(){
        eleveJpa.create(e);
        return "Create";
    }
    public Eleve getE() {
        return e;
    }

    public void setE(Eleve e) {
        this.e = e;
    }
    
}
