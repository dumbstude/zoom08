/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author roland
 */
@Entity
@Table(name = "coop_pros_criteria_main")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopProsCriteriaMain.findAll", query = "SELECT c FROM CoopProsCriteriaMain c"),
    @NamedQuery(name = "CoopProsCriteriaMain.findByCriteriaNo", query = "SELECT c FROM CoopProsCriteriaMain c WHERE c.criteriaNo = :criteriaNo"),
    @NamedQuery(name = "CoopProsCriteriaMain.findByCriteriaDtl", query = "SELECT c FROM CoopProsCriteriaMain c WHERE c.criteriaDtl = :criteriaDtl"),
    @NamedQuery(name = "CoopProsCriteriaMain.findByCriteriaMainRecno", query = "SELECT c FROM CoopProsCriteriaMain c WHERE c.criteriaMainRecno = :criteriaMainRecno"),
    @NamedQuery(name = "CoopProsCriteriaMain.findBySubCriteria", query = "SELECT c FROM CoopProsCriteriaMain c WHERE c.subCriteria = :subCriteria")})
public class CoopProsCriteriaMain implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "criteria_no")
    private Integer criteriaNo;
    @Size(max = 2147483647)
    @Column(name = "criteria_dtl")
    private String criteriaDtl;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "criteria_main_recno")
    private Integer criteriaMainRecno;
    @Column(name = "sub_criteria")
    private Boolean subCriteria;
    @JoinColumn(name = "criteria_set_no", referencedColumnName = "criteria_set_no")
    @ManyToOne(optional = false)
    private CoopProsCriteria criteriaSetNo;
    @OneToMany(mappedBy = "criteriaMainRecno")
    private Collection<CoopProsRating> coopProsRatingCollection;
    @OneToMany(mappedBy = "criteriaMainRecno")
    private Collection<CoopProsCriteriaSub> coopProsCriteriaSubCollection;

    public CoopProsCriteriaMain() {
    }

    public CoopProsCriteriaMain(Integer criteriaMainRecno) {
        this.criteriaMainRecno = criteriaMainRecno;
    }

    public Integer getCriteriaNo() {
        return criteriaNo;
    }

    public void setCriteriaNo(Integer criteriaNo) {
        this.criteriaNo = criteriaNo;
    }

    public String getCriteriaDtl() {
        return criteriaDtl;
    }

    public void setCriteriaDtl(String criteriaDtl) {
        this.criteriaDtl = criteriaDtl;
    }

    public Integer getCriteriaMainRecno() {
        return criteriaMainRecno;
    }

    public void setCriteriaMainRecno(Integer criteriaMainRecno) {
        this.criteriaMainRecno = criteriaMainRecno;
    }

    public Boolean getSubCriteria() {
        return subCriteria;
    }

    public void setSubCriteria(Boolean subCriteria) {
        this.subCriteria = subCriteria;
    }

    public CoopProsCriteria getCriteriaSetNo() {
        return criteriaSetNo;
    }

    public void setCriteriaSetNo(CoopProsCriteria criteriaSetNo) {
        this.criteriaSetNo = criteriaSetNo;
    }

    @XmlTransient
    public Collection<CoopProsRating> getCoopProsRatingCollection() {
        return coopProsRatingCollection;
    }

    public void setCoopProsRatingCollection(Collection<CoopProsRating> coopProsRatingCollection) {
        this.coopProsRatingCollection = coopProsRatingCollection;
    }

    @XmlTransient
    public Collection<CoopProsCriteriaSub> getCoopProsCriteriaSubCollection() {
        return coopProsCriteriaSubCollection;
    }

    public void setCoopProsCriteriaSubCollection(Collection<CoopProsCriteriaSub> coopProsCriteriaSubCollection) {
        this.coopProsCriteriaSubCollection = coopProsCriteriaSubCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (criteriaMainRecno != null ? criteriaMainRecno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopProsCriteriaMain)) {
            return false;
        }
        CoopProsCriteriaMain other = (CoopProsCriteriaMain) object;
        if ((this.criteriaMainRecno == null && other.criteriaMainRecno != null) || (this.criteriaMainRecno != null && !this.criteriaMainRecno.equals(other.criteriaMainRecno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopProsCriteriaMain[ criteriaMainRecno=" + criteriaMainRecno + " ]";
    }
    
}
