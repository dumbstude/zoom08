/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roland
 */
@Entity
@Table(name = "coop_pros_rating")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopProsRating.findAll", query = "SELECT c FROM CoopProsRating c"),
    @NamedQuery(name = "CoopProsRating.findByProsRatingRecno", query = "SELECT c FROM CoopProsRating c WHERE c.prosRatingRecno = :prosRatingRecno"),
    @NamedQuery(name = "CoopProsRating.findByCriteriaRating", query = "SELECT c FROM CoopProsRating c WHERE c.criteriaRating = :criteriaRating")})
public class CoopProsRating implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pros_rating_recno")
    private Integer prosRatingRecno;
    @Column(name = "criteria_rating")
    private Integer criteriaRating;
    @JoinColumn(name = "pros_rep_recno", referencedColumnName = "pros_rep_recno")
    @ManyToOne
    private CoopProsReport prosRepRecno;
    @JoinColumn(name = "sub_criteria_recno", referencedColumnName = "sub_criteria_recno")
    @ManyToOne
    private CoopProsCriteriaSub subCriteriaRecno;
    @JoinColumn(name = "criteria_main_recno", referencedColumnName = "criteria_main_recno")
    @ManyToOne
    private CoopProsCriteriaMain criteriaMainRecno;

    public CoopProsRating() {
    }

    public CoopProsRating(Integer prosRatingRecno) {
        this.prosRatingRecno = prosRatingRecno;
    }

    public Integer getProsRatingRecno() {
        return prosRatingRecno;
    }

    public void setProsRatingRecno(Integer prosRatingRecno) {
        this.prosRatingRecno = prosRatingRecno;
    }

    public Integer getCriteriaRating() {
        return criteriaRating;
    }

    public void setCriteriaRating(Integer criteriaRating) {
        this.criteriaRating = criteriaRating;
    }

    public CoopProsReport getProsRepRecno() {
        return prosRepRecno;
    }

    public void setProsRepRecno(CoopProsReport prosRepRecno) {
        this.prosRepRecno = prosRepRecno;
    }

    public CoopProsCriteriaSub getSubCriteriaRecno() {
        return subCriteriaRecno;
    }

    public void setSubCriteriaRecno(CoopProsCriteriaSub subCriteriaRecno) {
        this.subCriteriaRecno = subCriteriaRecno;
    }

    public CoopProsCriteriaMain getCriteriaMainRecno() {
        return criteriaMainRecno;
    }

    public void setCriteriaMainRecno(CoopProsCriteriaMain criteriaMainRecno) {
        this.criteriaMainRecno = criteriaMainRecno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prosRatingRecno != null ? prosRatingRecno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopProsRating)) {
            return false;
        }
        CoopProsRating other = (CoopProsRating) object;
        if ((this.prosRatingRecno == null && other.prosRatingRecno != null) || (this.prosRatingRecno != null && !this.prosRatingRecno.equals(other.prosRatingRecno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopProsRating[ prosRatingRecno=" + prosRatingRecno + " ]";
    }
    
}
