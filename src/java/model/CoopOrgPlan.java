/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author mis
 */
@Entity
@Table(name = "coop_org_plan")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopOrgPlan.findAll", query = "SELECT c FROM CoopOrgPlan c"),
	@NamedQuery(name = "CoopOrgPlan.findByOuPlanNo", query = "SELECT c FROM CoopOrgPlan c WHERE c.ouPlanNo = :ouPlanNo")})
public class CoopOrgPlan implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ou_plan_no")
	private Integer ouPlanNo;
	@JoinColumn(name = "report_num", referencedColumnName = "report_num")
    @ManyToOne
	private CoopReport reportNum;
	@JoinColumn(name = "ou_code", referencedColumnName = "ou_code")
    @ManyToOne
	private CoopOrgUnit ouCode;

	public CoopOrgPlan() {
	}

	public CoopOrgPlan(Integer ouPlanNo) {
		this.ouPlanNo = ouPlanNo;
	}

	public Integer getOuPlanNo() {
		return ouPlanNo;
	}

	public void setOuPlanNo(Integer ouPlanNo) {
		this.ouPlanNo = ouPlanNo;
	}

	public CoopReport getReportNum() {
		return reportNum;
	}

	public void setReportNum(CoopReport reportNum) {
		this.reportNum = reportNum;
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
