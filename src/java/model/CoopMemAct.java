/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roland
 */
@Entity
@Table(name = "coop_mem_act")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopMemAct.findAll", query = "SELECT c FROM CoopMemAct c"),
    @NamedQuery(name = "CoopMemAct.findByMemActRecno", query = "SELECT c FROM CoopMemAct c WHERE c.memActRecno = :memActRecno")})
public class CoopMemAct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "mem_act_recno")
    private String memActRecno;
    @JoinColumn(name = "mem_id_no", referencedColumnName = "mem_id_no")
    @ManyToOne
    private CoopMember memIdNo;
    @JoinColumn(name = "act_recno", referencedColumnName = "act_recno")
    @ManyToOne
    private CoopActivity actRecno;

    public CoopMemAct() {
    }

    public CoopMemAct(String memActRecno) {
        this.memActRecno = memActRecno;
    }

    public String getMemActRecno() {
        return memActRecno;
    }

    public void setMemActRecno(String memActRecno) {
        this.memActRecno = memActRecno;
    }

    public CoopMember getMemIdNo() {
        return memIdNo;
    }

    public void setMemIdNo(CoopMember memIdNo) {
        this.memIdNo = memIdNo;
    }

    public CoopActivity getActRecno() {
        return actRecno;
    }

    public void setActRecno(CoopActivity actRecno) {
        this.actRecno = actRecno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memActRecno != null ? memActRecno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopMemAct)) {
            return false;
        }
        CoopMemAct other = (CoopMemAct) object;
        if ((this.memActRecno == null && other.memActRecno != null) || (this.memActRecno != null && !this.memActRecno.equals(other.memActRecno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopMemAct[ memActRecno=" + memActRecno + " ]";
    }
    
}
