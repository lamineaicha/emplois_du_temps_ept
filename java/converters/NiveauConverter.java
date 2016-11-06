/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import entities.Niveau;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import jpa.NiveauJpa;

/**
 *
 * @author AMETH
 */
//@FacesConverter("niveauConverter")
@ManagedBean(name="niveauConverter")
public class NiveauConverter implements Converter {

    @EJB
    private NiveauJpa niveauJpa;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return niveauJpa.findById(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Niveau)value).getId().toString();
    }
    
}
