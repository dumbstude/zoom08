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
@Table(name = "coop_pros_criteria_sub")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopProsCriteriaSub.findAll", query = "SELECT c FROM CoopProsCriteriaSub c"),
    @NamedQuery(name = "CoopProsCriteriaSub.findBySubCriteriaNo", query = "SELECT c FROM CoopProsCriteriaSub c WHERE c.subCriteriaNo = :subCriteriaNo"),
    @NamedQuery(name = "CoopProsCriteriaSub.findBySubCriteriaDtl", query = "SELECT c FROM CoopProsCriteriaSub c WHERE c.subCriteriaDtl = :subCriteriaDtl"),
    @NamedQuery(name = "CoopProsCriteriaSub.findBySubCriteriaRecno", query = "SELECT c FROM CoopProsCriteriaSub c WHERE c.subCriteriaRecno = :subCriteriaRecno")})
public class CoopProsCriteriaSub implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "sub_criteria_no")
    private Integer subCriteriaNo;
    @Size(max = 2147483647)
    @Column(name = "sub_criteria_dtl")
    private String subCriteriaDtl;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sub_criteria_recno")
    private Integer subCriteriaRecno;
    @OneToMany(mappedBy = "subCriteriaRecno")
    private Collection<CoopProsRating> coopProsRatingCollection;
    @JoinColumn(name = "criteria_main_recno", referencedColumnName = "criteria_main_recno")
    @ManyToOne
    private CoopProsCriteriaMain criteriaMainRecno;

    public CoopProsCriteriaSub() {
    }

    public CoopProsCriteriaSub(Integer subCriteriaRecno) {
        this.subCriteriaRecno = subCriteriaRecno;
    }

    public Integer getSubCriteriaNo() {
        return subCriteriaNo;
    }

    public void setSubCriteriaNo(Integer subCriteriaNo) {
        this.subCriteriaNo = subCriteriaNo;
    }

    public String getSubCriteriaDtl() {
        return subCriteriaDtl;
    }

    public void setSubCriteriaDtl(String subCriteriaDtl) {
        this.subCriteriaDtl = subCriteriaDtl;
    }

    public Integer getSubCriteriaRecno() {
        return subCriteriaRecno;
    }

    public void setSubCriteriaRecno(Integer subCriteriaRecno) {
        this.subCriteriaRecno = subCriteriaRecno;
    }

    @XmlTransient
    public Collection<CoopProsRating> getCoopProsRatingCollection() {
        return coopProsRatingCollection;
    }

    public void setCoopProsRatingCollection(Collection<CoopProsRating> coopProsRatingCollection) {
        this.coopProsRatingCollection = coopProsRatingCollection;
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
        hash += (subCriteriaRecno != null ? subCriteriaRecno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopProsCriteriaSub)) {
            return false;
        }
        CoopProsCriteriaSub other = (CoopProsCriteriaSub) object;
        if ((this.subCriteriaRecno == null && other.subCriteriaRecno != null) || (this.subCriteriaRecno != null && !this.subCriteriaRecno.equals(other.subCriteriaRecno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopProsCriteriaSub[ subCriteriaRecno=" + subCriteriaRecno + " ]";
    }
    
}
