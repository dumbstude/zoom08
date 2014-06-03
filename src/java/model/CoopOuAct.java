/*
 * To change this template, choose Tools | Templates
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
 * @author roland
 */
@Entity
@Table(name = "coop_ou_act")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopOuAct.findAll", query = "SELECT c FROM CoopOuAct c"),
    @NamedQuery(name = "CoopOuAct.findByOuActRecno", query = "SELECT c FROM CoopOuAct c WHERE c.ouActRecno = :ouActRecno")})
public class CoopOuAct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ou_act_recno")
    private Integer ouActRecno;
    @JoinColumn(name = "ou_code", referencedColumnName = "ou_code")
    @ManyToOne
    private CoopOrgUnit ouCode;
    @JoinColumn(name = "act_recno", referencedColumnName = "act_recno")
    @ManyToOne
    private CoopActivity actRecno;

    public CoopOuAct() {
    }

    public CoopOuAct(Integer ouActRecno) {
        this.ouActRecno = ouActRecno;
    }

    public Integer getOuActRecno() {
        return ouActRecno;
    }

    public void setOuActRecno(Integer ouActRecno) {
        this.ouActRecno = ouActRecno;
    }

    public CoopOrgUnit getOuCode() {
        return ouCode;
    }

    public void setOuCode(CoopOrgUnit ouCode) {
        this.ouCode = ouCode;
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
        hash += (ouActRecno != null ? ouActRecno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopOuAct)) {
            return false;
        }
        CoopOuAct other = (CoopOuAct) object;
        if ((this.ouActRecno == null && other.ouActRecno != null) || (this.ouActRecno != null && !this.ouActRecno.equals(other.ouActRecno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopOuAct[ ouActRecno=" + ouActRecno + " ]";
    }
    
}
