/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author roland
 */
@Entity
@Table(name = "coop_applicant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopApplicant.findAll", query = "SELECT c FROM CoopApplicant c"),
    @NamedQuery(name = "CoopApplicant.findByApplicantNo", query = "SELECT c FROM CoopApplicant c WHERE c.applicantNo = :applicantNo"),
    @NamedQuery(name = "CoopApplicant.findByLastName", query = "SELECT c FROM CoopApplicant c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "CoopApplicant.findByFirstName", query = "SELECT c FROM CoopApplicant c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "CoopApplicant.findByMiddleName", query = "SELECT c FROM CoopApplicant c WHERE c.middleName = :middleName"),
    @NamedQuery(name = "CoopApplicant.findByGender", query = "SELECT c FROM CoopApplicant c WHERE c.gender = :gender"),
    @NamedQuery(name = "CoopApplicant.findByBirthdate", query = "SELECT c FROM CoopApplicant c WHERE c.birthdate = :birthdate"),
    @NamedQuery(name = "CoopApplicant.findByStreet", query = "SELECT c FROM CoopApplicant c WHERE c.street = :street"),
    @NamedQuery(name = "CoopApplicant.findByBarangay", query = "SELECT c FROM CoopApplicant c WHERE c.barangay = :barangay"),
    @NamedQuery(name = "CoopApplicant.findByCityMun", query = "SELECT c FROM CoopApplicant c WHERE c.cityMun = :cityMun"),
    @NamedQuery(name = "CoopApplicant.findByRegion", query = "SELECT c FROM CoopApplicant c WHERE c.region = :region"),
    @NamedQuery(name = "CoopApplicant.findByProvince", query = "SELECT c FROM CoopApplicant c WHERE c.province = :province"),
    @NamedQuery(name = "CoopApplicant.findByContactNumber", query = "SELECT c FROM CoopApplicant c WHERE c.contactNumber = :contactNumber"),
    @NamedQuery(name = "CoopApplicant.findByEmail", query = "SELECT c FROM CoopApplicant c WHERE c.email = :email"),
    @NamedQuery(name = "CoopApplicant.findByNationality", query = "SELECT c FROM CoopApplicant c WHERE c.nationality = :nationality"),
    @NamedQuery(name = "CoopApplicant.findByOccupation", query = "SELECT c FROM CoopApplicant c WHERE c.occupation = :occupation"),
    @NamedQuery(name = "CoopApplicant.findByApplicationDate", query = "SELECT c FROM CoopApplicant c WHERE c.applicationDate = :applicationDate"),
    @NamedQuery(name = "CoopApplicant.findByApplicationStat", query = "SELECT c FROM CoopApplicant c WHERE c.applicationStat = :applicationStat"),
    @NamedQuery(name = "CoopApplicant.findByBoardAction", query = "SELECT c FROM CoopApplicant c WHERE c.boardAction = :boardAction"),
    @NamedQuery(name = "CoopApplicant.findByBoardResoNo", query = "SELECT c FROM CoopApplicant c WHERE c.boardResoNo = :boardResoNo"),
    @NamedQuery(name = "CoopApplicant.findByActionDate", query = "SELECT c FROM CoopApplicant c WHERE c.actionDate = :actionDate"),
    @NamedQuery(name = "CoopApplicant.findByApplicantStatRem", query = "SELECT c FROM CoopApplicant c WHERE c.applicantStatRem = :applicantStatRem"),
    @NamedQuery(name = "CoopApplicant.findByResidentSince", query = "SELECT c FROM CoopApplicant c WHERE c.residentSince = :residentSince")})
public class CoopApplicant implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "application_stat")
    private String applicationStat;
    @Column(name = "civil_status")
    private Character civilStatus;
    @Size(max = 2147483647)
    @Column(name = "education")
    private String education;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "applicant_no")
    private String applicantNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 20)
    @Column(name = "middle_name")
    private String middleName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gender")
    private char gender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Size(max = 60)
    @Column(name = "street")
    private String street;
    @Size(max = 50)
    @Column(name = "barangay")
    private String barangay;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "city_mun")
    private String cityMun;
    @Size(max = 50)
    @Column(name = "region")
    private String region;
    @Size(max = 50)
    @Column(name = "province")
    private String province;
    @Size(max = 12)
    @Column(name = "contact_number")
    private String contactNumber;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "nationality")
    private String nationality;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "occupation")
    private String occupation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "application_date")
    @Temporal(TemporalType.DATE)
    private Date applicationDate;
    @Column(name = "board_action")
    private Boolean boardAction;
    @Size(max = 7)
    @Column(name = "board_reso_no")
    private String boardResoNo;
    @Column(name = "action_date")
    @Temporal(TemporalType.DATE)
    private Date actionDate;
    @Size(max = 2147483647)
    @Column(name = "applicant_stat_rem")
    private String applicantStatRem;
    @Column(name = "resident_since")
    @Temporal(TemporalType.DATE)
    private Date residentSince;
    @JoinColumn(name = "ou_code", referencedColumnName = "ou_code")
    @ManyToOne
    private CoopOrgUnit ouCode;
    @OneToMany(mappedBy = "applicantNo")
    private Collection<CoopMember> coopMemberCollection;

    public CoopApplicant() {
    }

    public CoopApplicant(String applicantNo) {
        this.applicantNo = applicantNo;
    }

    public CoopApplicant(String applicantNo, String lastName, String firstName, char gender, Date birthdate, String cityMun, String nationality, String occupation, Date applicationDate, String applicationStat) {
        this.applicantNo = applicantNo;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.birthdate = birthdate;
        this.cityMun = cityMun;
        this.nationality = nationality;
        this.occupation = occupation;
        this.applicationDate = applicationDate;
        this.applicationStat = applicationStat;
    }

    public String getApplicantNo() {
        return applicantNo;
    }

    public void setApplicantNo(String applicantNo) {
        this.applicantNo = applicantNo;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBarangay() {
        return barangay;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public String getCityMun() {
        return cityMun;
    }

    public void setCityMun(String cityMun) {
        this.cityMun = cityMun;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getApplicationStat() {
        return applicationStat;
    }

    public void setApplicationStat(String applicationStat) {
        this.applicationStat = applicationStat;
    }

    public Boolean getBoardAction() {
        return boardAction;
    }

    public void setBoardAction(Boolean boardAction) {
        this.boardAction = boardAction;
    }

    public String getBoardResoNo() {
        return boardResoNo;
    }

    public void setBoardResoNo(String boardResoNo) {
        this.boardResoNo = boardResoNo;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public String getApplicantStatRem() {
        return applicantStatRem;
    }

    public void setApplicantStatRem(String applicantStatRem) {
        this.applicantStatRem = applicantStatRem;
    }

    public Date getResidentSince() {
        return residentSince;
    }

    public void setResidentSince(Date residentSince) {
        this.residentSince = residentSince;
    }

    public CoopOrgUnit getOuCode() {
        return ouCode;
    }

    public void setOuCode(CoopOrgUnit ouCode) {
        this.ouCode = ouCode;
    }

    @XmlTransient
    public Collection<CoopMember> getCoopMemberCollection() {
        return coopMemberCollection;
    }

    public void setCoopMemberCollection(Collection<CoopMember> coopMemberCollection) {
        this.coopMemberCollection = coopMemberCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (applicantNo != null ? applicantNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopApplicant)) {
            return false;
        }
        CoopApplicant other = (CoopApplicant) object;
        if ((this.applicantNo == null && other.applicantNo != null) || (this.applicantNo != null && !this.applicantNo.equals(other.applicantNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopApplicant[ applicantNo=" + applicantNo + " ]";
    }

    public Character getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(Character civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
    
}
