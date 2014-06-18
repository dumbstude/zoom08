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
@Table(name = "coop_mem_act")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopMemAct.findAll", query = "SELECT c FROM CoopMemAct c"),
	@NamedQuery(name = "CoopMemAct.findByMemActNum", query = "SELECT c FROM CoopMemAct c WHERE c.memActNum = :memActNum")})
public class CoopMemAct implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mem_act_num")
	private Integer memActNum;
	@JoinColumn(name = "mem_no", referencedColumnName = "mem_no")
    @ManyToOne
	private CoopMember memNo;
	@JoinColumn(name = "act_num", referencedColumnName = "act_num")
    @ManyToOne
	private CoopActivity actNum;

	public CoopMemAct() {
	}

	public CoopMemAct(Integer memActNum) {
		this.memActNum = memActNum;
	}

	public Integer getMemActNum() {
		return memActNum;
	}

	public void setMemActNum(Integer memActNum) {
		this.memActNum = memActNum;
	}

	public CoopMember getMemNo() {
		return memNo;
	}

	public void setMemNo(CoopMember memNo) {
		this.memNo = memNo;
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
		hash += (memActNum != null ? memActNum.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopMemAct)) {
			return false;
		}
		CoopMemAct other = (CoopMemAct) object;
		if ((this.memActNum == null && other.memActNum != null) || (this.memActNum != null && !this.memActNum.equals(other.memActNum))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopMemAct[ memActNum=" + memActNum + " ]";
	}
	
}
