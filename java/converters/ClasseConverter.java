/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import entities.Classe;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import jpa.ClasseJpa;

/**
 *
 * @author AMETH
 */
@ManagedBean(name="classeConverter")
public class ClasseConverter implements Converter{

    @EJB
    private ClasseJpa classeJpa;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
      return classeJpa.findById(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      return ((Classe)value).getId().toString();
    }
    
}
