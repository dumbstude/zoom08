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
@Table(name = "coop_pros_rating_sub")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopProsRatingSub.findAll", query = "SELECT c FROM CoopProsRatingSub c"),
	@NamedQuery(name = "CoopProsRatingSub.findByCriteriaRating", query = "SELECT c FROM CoopProsRatingSub c WHERE c.criteriaRating = :criteriaRating"),
	@NamedQuery(name = "CoopProsRatingSub.findByProsRatingSubNum", query = "SELECT c FROM CoopProsRatingSub c WHERE c.prosRatingSubNum = :prosRatingSubNum")})
public class CoopProsRatingSub implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "criteria_rating")
	private Integer criteriaRating;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pros_rating_sub_num")
	private Integer prosRatingSubNum;
	@JoinColumn(name = "pros_rep_num", referencedColumnName = "pros_rep_num")
    @ManyToOne
	private CoopProsReport prosRepNum;
	@JoinColumn(name = "sub_criteria_num", referencedColumnName = "sub_criteria_num")
    @ManyToOne
	private CoopProsCriteriaSub subCriteriaNum;

	public CoopProsRatingSub() {
	}

	public CoopProsRatingSub(Integer prosRatingSubNum) {
		this.prosRatingSubNum = prosRatingSubNum;
	}

	public Integer getCriteriaRating() {
		return criteriaRating;
	}

	public void setCriteriaRating(Integer criteriaRating) {
		this.criteriaRating = criteriaRating;
	}

	public Integer getProsRatingSubNum() {
		return prosRatingSubNum;
	}

	public void setProsRatingSubNum(Integer prosRatingSubNum) {
		this.prosRatingSubNum = prosRatingSubNum;
	}

	public CoopProsReport getProsRepNum() {
		return prosRepNum;
	}

	public void setProsRepNum(CoopProsReport prosRepNum) {
		this.prosRepNum = prosRepNum;
	}

	public CoopProsCriteriaSub getSubCriteriaNum() {
		return subCriteriaNum;
	}

	public void setSubCriteriaNum(CoopProsCriteriaSub subCriteriaNum) {
		this.subCriteriaNum = subCriteriaNum;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (prosRatingSubNum != null ? prosRatingSubNum.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopProsRatingSub)) {
			return false;
		}
		CoopProsRatingSub other = (CoopProsRatingSub) object;
		if ((this.prosRatingSubNum == null && other.prosRatingSubNum != null) || (this.prosRatingSubNum != null && !this.prosRatingSubNum.equals(other.prosRatingSubNum))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopProsRatingSub[ prosRatingSubNum=" + prosRatingSubNum + " ]";
	}
	
}
