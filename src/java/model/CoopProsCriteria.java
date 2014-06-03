/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author roland
 */
@Entity
@Table(name = "coop_pros_criteria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopProsCriteria.findAll", query = "SELECT c FROM CoopProsCriteria c"),
    @NamedQuery(name = "CoopProsCriteria.findByCriteriaSetNo", query = "SELECT c FROM CoopProsCriteria c WHERE c.criteriaSetNo = :criteriaSetNo"),
    @NamedQuery(name = "CoopProsCriteria.findByCriteriaSetDate", query = "SELECT c FROM CoopProsCriteria c WHERE c.criteriaSetDate = :criteriaSetDate")})
public class CoopProsCriteria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "criteria_set_no")
    private Integer criteriaSetNo;
    @Column(name = "criteria_set_date")
    @Temporal(TemporalType.DATE)
    private Date criteriaSetDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "criteriaSetNo")
    private Collection<CoopProsCriteriaMain> coopProsCriteriaMainCollection;

    public CoopProsCriteria() {
    }

    public CoopProsCriteria(Integer criteriaSetNo) {
        this.criteriaSetNo = criteriaSetNo;
    }

    public Integer getCriteriaSetNo() {
        return criteriaSetNo;
    }

    public void setCriteriaSetNo(Integer criteriaSetNo) {
        this.criteriaSetNo = criteriaSetNo;
    }

    public Date getCriteriaSetDate() {
        return criteriaSetDate;
    }

    public void setCriteriaSetDate(Date criteriaSetDate) {
        this.criteriaSetDate = criteriaSetDate;
    }

    @XmlTransient
    public Collection<CoopProsCriteriaMain> getCoopProsCriteriaMainCollection() {
        return coopProsCriteriaMainCollection;
    }

    public void setCoopProsCriteriaMainCollection(Collection<CoopProsCriteriaMain> coopProsCriteriaMainCollection) {
        this.coopProsCriteriaMainCollection = coopProsCriteriaMainCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (criteriaSetNo != null ? criteriaSetNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopProsCriteria)) {
            return false;
        }
        CoopProsCriteria other = (CoopProsCriteria) object;
        if ((this.criteriaSetNo == null && other.criteriaSetNo != null) || (this.criteriaSetNo != null && !this.criteriaSetNo.equals(other.criteriaSetNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopProsCriteria[ criteriaSetNo=" + criteriaSetNo + " ]";
    }
    
}
