/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author mis
 */
@Entity
@Table(name = "coop_pros_criteria_sub")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopProsCriteriaSub.findAll", query = "SELECT c FROM CoopProsCriteriaSub c"),
	@NamedQuery(name = "CoopProsCriteriaSub.findBySubCriteriaNo", query = "SELECT c FROM CoopProsCriteriaSub c WHERE c.subCriteriaNo = :subCriteriaNo"),
	@NamedQuery(name = "CoopProsCriteriaSub.findBySubCriteriaDtl", query = "SELECT c FROM CoopProsCriteriaSub c WHERE c.subCriteriaDtl = :subCriteriaDtl"),
	@NamedQuery(name = "CoopProsCriteriaSub.findBySubCriteriaNum", query = "SELECT c FROM CoopProsCriteriaSub c WHERE c.subCriteriaNum = :subCriteriaNum")})
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
    @Column(name = "sub_criteria_num")
	private Integer subCriteriaNum;
	@JoinColumn(name = "criteria_main_num", referencedColumnName = "criteria_main_num")
    @ManyToOne
	private CoopProsCriteriaMain criteriaMainNum;
	@OneToMany(mappedBy = "subCriteriaNum")
	private Collection<CoopProsRatingSub> coopProsRatingSubCollection;

	public CoopProsCriteriaSub() {
	}

	public CoopProsCriteriaSub(Integer subCriteriaNum) {
		this.subCriteriaNum = subCriteriaNum;
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

	public Integer getSubCriteriaNum() {
		return subCriteriaNum;
	}

	public void setSubCriteriaNum(Integer subCriteriaNum) {
		this.subCriteriaNum = subCriteriaNum;
	}

	public CoopProsCriteriaMain getCriteriaMainNum() {
		return criteriaMainNum;
	}

	public void setCriteriaMainNum(CoopProsCriteriaMain criteriaMainNum) {
		this.criteriaMainNum = criteriaMainNum;
	}

	@XmlTransient
	public Collection<CoopProsRatingSub> getCoopProsRatingSubCollection() {
		return coopProsRatingSubCollection;
	}

	public void setCoopProsRatingSubCollection(Collection<CoopProsRatingSub> coopProsRatingSubCollection) {
		this.coopProsRatingSubCollection = coopProsRatingSubCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (subCriteriaNum != null ? subCriteriaNum.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopProsCriteriaSub)) {
			return false;
		}
		CoopProsCriteriaSub other = (CoopProsCriteriaSub) object;
		if ((this.subCriteriaNum == null && other.subCriteriaNum != null) || (this.subCriteriaNum != null && !this.subCriteriaNum.equals(other.subCriteriaNum))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopProsCriteriaSub[ subCriteriaNum=" + subCriteriaNum + " ]";
	}
	
}
