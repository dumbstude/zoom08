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
@Table(name = "coop_pros_act")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopProsAct.findAll", query = "SELECT c FROM CoopProsAct c"),
	@NamedQuery(name = "CoopProsAct.findByProsActNum", query = "SELECT c FROM CoopProsAct c WHERE c.prosActNum = :prosActNum")})
public class CoopProsAct implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pros_act_num")
	private Integer prosActNum;
	@JoinColumn(name = "prospect_no", referencedColumnName = "prospect_no")
    @ManyToOne
	private CoopProspect prospectNo;
	@JoinColumn(name = "act_num", referencedColumnName = "act_num")
    @ManyToOne
	private CoopActivity actNum;

	public CoopProsAct() {
	}

	public CoopProsAct(Integer prosActNum) {
		this.prosActNum = prosActNum;
	}

	public Integer getProsActNum() {
		return prosActNum;
	}

	public void setProsActNum(Integer prosActNum) {
		this.prosActNum = prosActNum;
	}

	public CoopProspect getProspectNo() {
		return prospectNo;
	}

	public void setProspectNo(CoopProspect prospectNo) {
		this.prospectNo = prospectNo;
	}

	public CoopActivity getActNum() {
		return actNum;
	}

	public void setActNum(CoopActivity actNum) {
		this.actNum = actNum;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (prosActNum != null ? prosActNum.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopProsAct)) {
			return false;
		}
		CoopProsAct other = (CoopProsAct) object;
		if ((this.prosActNum == null && other.prosActNum != null) || (this.prosActNum != null && !this.prosActNum.equals(other.prosActNum))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopProsAct[ prosActNum=" + prosActNum + " ]";
	}
	
}
