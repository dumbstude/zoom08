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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mis
 */
@Entity
@Table(name = "coop_pros_criteria_main")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopProsCriteriaMain.findAll", query = "SELECT c FROM CoopProsCriteriaMain c"),
	@NamedQuery(name = "CoopProsCriteriaMain.findByCriteriaNo", query = "SELECT c FROM CoopProsCriteriaMain c WHERE c.criteriaNo = :criteriaNo"),
	@NamedQuery(name = "CoopProsCriteriaMain.findByCriteriaDtl", query = "SELECT c FROM CoopProsCriteriaMain c WHERE c.criteriaDtl = :criteriaDtl"),
	@NamedQuery(name = "CoopProsCriteriaMain.findByCriteriaMainNum", query = "SELECT c FROM CoopProsCriteriaMain c WHERE c.criteriaMainNum = :criteriaMainNum"),
	@NamedQuery(name = "CoopProsCriteriaMain.findBySubCriteria", query = "SELECT c FROM CoopProsCriteriaMain c WHERE c.subCriteria = :subCriteria")})
public class CoopProsCriteriaMain implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Column(name = "criteria_no")
	private int criteriaNo;
	@Size(max = 2147483647)
    @Column(name = "criteria_dtl")
	private String criteriaDtl;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "criteria_main_num")
	private Integer criteriaMainNum;
	@Column(name = "sub_criteria")
	private Boolean subCriteria;
	@JoinColumn(name = "criteria_set_no", referencedColumnName = "criteria_set_no")
    @ManyToOne(optional = false)
	private CoopProsCriteria criteriaSetNo;
	@OneToMany(mappedBy = "criteriaMainNum")
	private Collection<CoopProsRatingMain> coopProsRatingMainCollection;
	@OneToMany(mappedBy = "criteriaMainNum")
	private Collection<CoopProsCriteriaSub> coopProsCriteriaSubCollection;

	public CoopProsCriteriaMain() {
	}

	public CoopProsCriteriaMain(Integer criteriaMainNum) {
		this.criteriaMainNum = criteriaMainNum;
	}

	public CoopProsCriteriaMain(Integer criteriaMainNum, int criteriaNo) {
		this.criteriaMainNum = criteriaMainNum;
		this.criteriaNo = criteriaNo;
	}

	public int getCriteriaNo() {
		return criteriaNo;
	}

	public void setCriteriaNo(int criteriaNo) {
		this.criteriaNo = criteriaNo;
	}

	public String getCriteriaDtl() {
		return criteriaDtl;
	}

	public void setCriteriaDtl(String criteriaDtl) {
		this.criteriaDtl = criteriaDtl;
	}

	public Integer getCriteriaMainNum() {
		return criteriaMainNum;
	}

	public void setCriteriaMainNum(Integer criteriaMainNum) {
		this.criteriaMainNum = criteriaMainNum;
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
	public Collection<CoopProsRatingMain> getCoopProsRatingMainCollection() {
		return coopProsRatingMainCollection;
	}

	public void setCoopProsRatingMainCollection(Collection<CoopProsRatingMain> coopProsRatingMainCollection) {
		this.coopProsRatingMainCollection = coopProsRatingMainCollection;
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
		hash += (criteriaMainNum != null ? criteriaMainNum.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopProsCriteriaMain)) {
			return false;
		}
		CoopProsCriteriaMain other = (CoopProsCriteriaMain) object;
		if ((this.criteriaMainNum == null && other.criteriaMainNum != null) || (this.criteriaMainNum != null && !this.criteriaMainNum.equals(other.criteriaMainNum))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopProsCriteriaMain[ criteriaMainNum=" + criteriaMainNum + " ]";
	}
	
}
