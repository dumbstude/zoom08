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
@Table(name = "coop_report_circ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopReportCirc.findAll", query = "SELECT c FROM CoopReportCirc c"),
    @NamedQuery(name = "CoopReportCirc.findByReportCircRecno", query = "SELECT c FROM CoopReportCirc c WHERE c.reportCircRecno = :reportCircRecno")})
public class CoopReportCirc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "report_circ_recno")
    private String reportCircRecno;
    @JoinColumn(name = "report_num", referencedColumnName = "report_num")
    @ManyToOne
    private CoopReport reportNum;
    @JoinColumn(name = "to_ou_code", referencedColumnName = "ou_code")
    @ManyToOne
    private CoopOrgUnit toOuCode;

    public CoopReportCirc() {
    }

    public CoopReportCirc(String reportCircRecno) {
        this.reportCircRecno = reportCircRecno;
    }

    public String getReportCircRecno() {
        return reportCircRecno;
    }

    public void setReportCircRecno(String reportCircRecno) {
        this.reportCircRecno = reportCircRecno;
    }

    public CoopReport getReportNum() {
        return reportNum;
    }

    public void setReportNum(CoopReport reportNum) {
        this.reportNum = reportNum;
    }

    public CoopOrgUnit getToOuCode() {
        return toOuCode;
    }

    public void setToOuCode(CoopOrgUnit toOuCode) {
        this.toOuCode = toOuCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportCircRecno != null ? reportCircRecno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopReportCirc)) {
            return false;
        }
        CoopReportCirc other = (CoopReportCirc) object;
        if ((this.reportCircRecno == null && other.reportCircRecno != null) || (this.reportCircRecno != null && !this.reportCircRecno.equals(other.reportCircRecno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopReportCirc[ reportCircRecno=" + reportCircRecno + " ]";
    }
    
}
