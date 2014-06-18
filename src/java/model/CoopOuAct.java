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
@Table(name = "coop_ou_act")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopOuAct.findAll", query = "SELECT c FROM CoopOuAct c"),
	@NamedQuery(name = "CoopOuAct.findByOuActNum", query = "SELECT c FROM CoopOuAct c WHERE c.ouActNum = :ouActNum")})
public class CoopOuAct implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ou_act_num")
	private Integer ouActNum;
	@JoinColumn(name = "ou_code", referencedColumnName = "ou_code")
    @ManyToOne
	private CoopOrgUnit ouCode;
	@JoinColumn(name = "act_num", referencedColumnName = "act_num")
    @ManyToOne
	private CoopActivity actNum;

	public CoopOuAct() {
	}

	public CoopOuAct(Integer ouActNum) {
		this.ouActNum = ouActNum;
	}

	public Integer getOuActNum() {
		return ouActNum;
	}

	public void setOuActNum(Integer ouActNum) {
		this.ouActNum = ouActNum;
	}

	public CoopOrgUnit getOuCode() {
		return ouCode;
	}

	public void setOuCode(CoopOrgUnit ouCode) {
		this.ouCode = ouCode;
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
		hash += (ouActNum != null ? ouActNum.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopOuAct)) {
			return false;
		}
		CoopOuAct other = (CoopOuAct) object;
		if ((this.ouActNum == null && other.ouActNum != null) || (this.ouActNum != null && !this.ouActNum.equals(other.ouActNum))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopOuAct[ ouActNum=" + ouActNum + " ]";
	}
	
}
