/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author AMETH
 */
@Entity
@Table(name = "classe")
@NamedQueries({
    @NamedQuery(name = "Classe.findAll", query = "SELECT c FROM Classe c"),
    @NamedQuery(name = "Classe.findById", query = "SELECT c FROM Classe c WHERE c.id = :id"),
    @NamedQuery(name = "Classe.findByNom", query = "SELECT c FROM Classe c WHERE c.nom = :nom"),
    @NamedQuery(name = "Classe.findByAnnee", query = "SELECT c FROM Classe c WHERE c.annee = :annee")})
public class Classe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANNEE")
    private int annee;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classeId")
    private List<Eleve> eleveList;
    @JoinColumn(name = "NIVEAU_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Niveau niveauId;
    @JoinColumn(name = "RESPONSABLE_ID", referencedColumnName = "PERSONNE_ID")
    @ManyToOne
    private Eleve responsableId;
    @JoinColumn(name = "RESPONSABLE_PEDAGOGIQUE_ID", referencedColumnName = "PERSONNE_ID")
    @ManyToOne
    private Enseignant responsablePedagogiqueId;

    public Classe() {
    }

    public Classe(Long id) {
        this.id = id;
    }
    
    public Classe(Long id, String nom, int annee) {
        this.id = id;
        this.nom = nom;
        this.annee = annee;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public List<Eleve> getEleveList() {
        return eleveList;
    }

    public void setEleveList(List<Eleve> eleveList) {
        this.eleveList = eleveList;
    }

    public Niveau getNiveauId() {
        return niveauId;
    }

    public void setNiveauId(Niveau niveauId) {
        this.niveauId = niveauId;
    }

    public Eleve getResponsableId() {
        return responsableId;
    }

    public void setResponsableId(Eleve responsableId) {
        this.responsableId = responsableId;
    }

    public Enseignant getResponsablePedagogiqueId() {
        return responsablePedagogiqueId;
    }

    public void setResponsablePedagogiqueId(Enseignant responsablePedagogiqueId) {
        this.responsablePedagogiqueId = responsablePedagogiqueId;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classe)) {
            return false;
        }
        Classe other = (Classe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Classe[ id=" + id + " ]";
    }
    
}
