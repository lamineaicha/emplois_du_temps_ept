/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author AMETH
 */
@Entity
@Table(name = "enseignant")
@PrimaryKeyJoinColumn(name ="PERSONNE_ID")
@DiscriminatorValue("enseignant")
@NamedQueries({
    @NamedQuery(name = "Enseignant.findAll", query = "SELECT e FROM Enseignant e"),
    })
public class Enseignant extends Personne{

    private static final long serialVersionUID = 1L;
    @NotNull
    @Column(name = "DATE_EMBAUCHE")
    @Temporal(TemporalType.DATE)
    private Date dateEmbauche;
    @OneToMany(mappedBy = "responsablePedagogiqueId")
    private List<Classe> classeList;

    public Enseignant() {
    }

    public Enseignant(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public List<Classe> getClasseList() {
        return classeList;
    }

    public void setClasseList(List<Classe> classeList) {
        this.classeList = classeList;
    }
  
    
    
    
     @Override
    public int hashCode() {
        int hash = 0;
        hash += (super.getId() != null ? super.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eleve)) {
            return false;
        }
        Eleve other = (Eleve) object;
        if ((super.getId() == null && other.getId()!= null) || (super.getId()!= null && !super.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Eleve[ id=" + super.getId()+ " ]";
    }
    
    
}
