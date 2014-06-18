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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mis
 */
@Entity
@Table(name = "coop_pros_report")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopProsReport.findAll", query = "SELECT c FROM CoopProsReport c"),
	@NamedQuery(name = "CoopProsReport.findByProsRepNum", query = "SELECT c FROM CoopProsReport c WHERE c.prosRepNum = :prosRepNum")})
public class CoopProsReport implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pros_rep_num")
	private Integer prosRepNum;
	@JoinColumn(name = "report_num", referencedColumnName = "report_num")
    @ManyToOne
	private CoopReport reportNum;
	@JoinColumn(name = "prospect_no", referencedColumnName = "prospect_no")
    @ManyToOne
	private CoopProspect prospectNo;
	@OneToMany(mappedBy = "prosRepNum")
	private Collection<CoopProsRatingMain> coopProsRatingMainCollection;
	@OneToMany(mappedBy = "prosRepNum")
	private Collection<CoopProsRepver> coopProsRepverCollection;
	@OneToMany(mappedBy = "prosRepNum")
	private Collection<CoopProsRatingSub> coopProsRatingSubCollection;

	public CoopProsReport() {
	}

	public CoopProsReport(Integer prosRepNum) {
		this.prosRepNum = prosRepNum;
	}

	public Integer getProsRepNum() {
		return prosRepNum;
	}

	public void setProsRepNum(Integer prosRepNum) {
		this.prosRepNum = prosRepNum;
	}

	public CoopReport getReportNum() {
		return reportNum;
	}

	public void setReportNum(CoopReport reportNum) {
		this.reportNum = reportNum;
	}

	public CoopProspect getProspectNo() {
		return prospectNo;
	}

	public void setProspectNo(CoopProspect prospectNo) {
		this.prospectNo = prospectNo;
	}

	@XmlTransient
	public Collection<CoopProsRatingMain> getCoopProsRatingMainCollection() {
		return coopProsRatingMainCollection;
	}

	public void setCoopProsRatingMainCollection(Collection<CoopProsRatingMain> coopProsRatingMainCollection) {
		this.coopProsRatingMainCollection = coopProsRatingMainCollection;
	}

	@XmlTransient
	public Collection<CoopProsRepver> getCoopProsRepverCollection() {
		return coopProsRepverCollection;
	}

	public void setCoopProsRepverCollection(Collection<CoopProsRepver> coopProsRepverCollection) {
		this.coopProsRepverCollection = coopProsRepverCollection;
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
		hash += (prosRepNum != null ? prosRepNum.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopProsReport)) {
			return false;
		}
		CoopProsReport other = (CoopProsReport) object;
		if ((this.prosRepNum == null && other.prosRepNum != null) || (this.prosRepNum != null && !this.prosRepNum.equals(other.prosRepNum))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopProsReport[ prosRepNum=" + prosRepNum + " ]";
	}
	
}
