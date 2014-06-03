/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roland
 */
@Entity
@Table(name = "coop_org_plan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopOrgPlan.findAll", query = "SELECT c FROM CoopOrgPlan c"),
    @NamedQuery(name = "CoopOrgPlan.findByOuPlanNo", query = "SELECT c FROM CoopOrgPlan c WHERE c.ouPlanNo = :ouPlanNo"),
    @NamedQuery(name = "CoopOrgPlan.findByPlanStart", query = "SELECT c FROM CoopOrgPlan c WHERE c.planStart = :planStart"),
    @NamedQuery(name = "CoopOrgPlan.findByPlanEnd", query = "SELECT c FROM CoopOrgPlan c WHERE c.planEnd = :planEnd"),
    @NamedQuery(name = "CoopOrgPlan.findByPlanDtl", query = "SELECT c FROM CoopOrgPlan c WHERE c.planDtl = :planDtl")})
public class CoopOrgPlan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ou_plan_no")
    private String ouPlanNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plan_start")
    @Temporal(TemporalType.DATE)
    private Date planStart;
    @Column(name = "plan_end")
    @Temporal(TemporalType.DATE)
    private Date planEnd;
    @Size(max = 2147483647)
    @Column(name = "plan_dtl")
    private String planDtl;
    @JoinColumn(name = "ou_code", referencedColumnName = "ou_code")
    @ManyToOne
    private CoopOrgUnit ouCode;

    public CoopOrgPlan() {
    }

    public CoopOrgPlan(String ouPlanNo) {
        this.ouPlanNo = ouPlanNo;
    }

    public CoopOrgPlan(String ouPlanNo, Date planStart) {
        this.ouPlanNo = ouPlanNo;
        this.planStart = planStart;
    }

    public String getOuPlanNo() {
        return ouPlanNo;
    }

    public void setOuPlanNo(String ouPlanNo) {
        this.ouPlanNo = ouPlanNo;
    }

    public Date getPlanStart() {
        return planStart;
    }

    public void setPlanStart(Date planStart) {
        this.planStart = planStart;
    }

    public Date getPlanEnd() {
        return planEnd;
    }

    public void setPlanEnd(Date planEnd) {
        this.planEnd = planEnd;
    }

    public String getPlanDtl() {
        return planDtl;
    }

    public void setPlanDtl(String planDtl) {
        this.planDtl = planDtl;
    }

    public CoopOrgUnit getOuCode() {
        return ouCode;
    }

    public void setOuCode(CoopOrgUnit ouCode) {
        this.ouCode = ouCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ouPlanNo != null ? ouPlanNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopOrgPlan)) {
            return false;
        }
        CoopOrgPlan other = (CoopOrgPlan) object;
        if ((this.ouPlanNo == null && other.ouPlanNo != null) || (this.ouPlanNo != null && !this.ouPlanNo.equals(other.ouPlanNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopOrgPlan[ ouPlanNo=" + ouPlanNo + " ]";
    }
    
}
