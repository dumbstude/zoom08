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
@Table(name = "coop_pros_rating_main")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopProsRatingMain.findAll", query = "SELECT c FROM CoopProsRatingMain c"),
	@NamedQuery(name = "CoopProsRatingMain.findByCriteriaRating", query = "SELECT c FROM CoopProsRatingMain c WHERE c.criteriaRating = :criteriaRating"),
	@NamedQuery(name = "CoopProsRatingMain.findByProsRatingMainNum", query = "SELECT c FROM CoopProsRatingMain c WHERE c.prosRatingMainNum = :prosRatingMainNum")})
public class CoopProsRatingMain implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "criteria_rating")
	private Integer criteriaRating;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pros_rating_main_num")
	private Integer prosRatingMainNum;
	@JoinColumn(name = "pros_rep_num", referencedColumnName = "pros_rep_num")
    @ManyToOne
	private CoopProsReport prosRepNum;
	@JoinColumn(name = "criteria_main_num", referencedColumnName = "criteria_main_num")
    @ManyToOne
	private CoopProsCriteriaMain criteriaMainNum;

	public CoopProsRatingMain() {
	}

	public CoopProsRatingMain(Integer prosRatingMainNum) {
		this.prosRatingMainNum = prosRatingMainNum;
	}

	public Integer getCriteriaRating() {
		return criteriaRating;
	}

	public void setCriteriaRating(Integer criteriaRating) {
		this.criteriaRating = criteriaRating;
	}

	public Integer getProsRatingMainNum() {
		return prosRatingMainNum;
	}

	public void setProsRatingMainNum(Integer prosRatingMainNum) {
		this.prosRatingMainNum = prosRatingMainNum;
	}

	public CoopProsReport getProsRepNum() {
		return prosRepNum;
	}

	public void setProsRepNum(CoopProsReport prosRepNum) {
		this.prosRepNum = prosRepNum;
	}

	public CoopProsCriteriaMain getCriteriaMainNum() {
		return criteriaMainNum;
	}

	public void setCriteriaMainNum(CoopProsCriteriaMain criteriaMainNum) {
		this.criteriaMainNum = criteriaMainNum;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (prosRatingMainNum != null ? prosRatingMainNum.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopProsRatingMain)) {
			return false;
		}
		CoopProsRatingMain other = (CoopProsRatingMain) object;
		if ((this.prosRatingMainNum == null && other.prosRatingMainNum != null) || (this.prosRatingMainNum != null && !this.prosRatingMainNum.equals(other.prosRatingMainNum))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopProsRatingMain[ prosRatingMainNum=" + prosRatingMainNum + " ]";
	}
	
}
