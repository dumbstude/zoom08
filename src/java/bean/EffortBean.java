/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.CoopActivity;
import model.CoopActivityAttendee;
import model.CoopActivityType;
import model.CoopApplicant;
import model.CoopMemAct;
import model.CoopMember;
import model.CoopOrgPlan;
import model.CoopOrgUnit;
import model.CoopOuAct;
import model.CoopProsAct;
import model.CoopProsCriteria;
import model.CoopProsCriteriaMain;
import model.CoopProsCriteriaSub;
import model.CoopProsLog;
import model.CoopProspect;
import model.CoopProsRating;
import model.CoopProsReport;
import model.CoopProsRepver;
import model.CoopRepAct;
import model.CoopReport;
import model.CoopReportCirc;
import model.CoopReportType;
import org.primefaces.event.SelectEvent;
import service.CoopActivityFacadeREST;
import service.CoopActivityAttendeeFacadeREST;
import service.CoopApplicantFacadeREST;
import service.CoopMemActFacadeREST;
import service.CoopMemberFacadeREST;
import service.CoopOrgPlanFacadeREST;
import service.CoopOrgUnitFacadeREST;
import service.CoopActivityTypeFacadeREST;
import service.CoopOuActFacadeREST;
import service.CoopProsActFacadeREST;
import service.CoopProsCriteriaFacadeREST;
import service.CoopProsCriteriaMainFacadeREST;
import service.CoopProsCriteriaSubFacadeREST;
import service.CoopProsLogFacadeREST;
import service.CoopProspectFacadeREST;
import service.CoopProsRatingFacadeREST;
import service.CoopProsReportFacadeREST;
import service.CoopProsRepverFacadeREST;
import service.CoopRepActFacadeREST;
import service.CoopReportFacadeREST;
import service.CoopReportCircFacadeREST;
import service.CoopReportTypeFacadeREST;

/**
 *
 * @author roland
 */
@ManagedBean(name = "effortBean")
@SessionScoped
public class EffortBean implements Serializable {

    @EJB
    private CoopActivityFacadeREST coopActivityFacadeREST;
    private CoopActivity activity;
    private CoopActivityAttendeeFacadeREST coopActivityAttendeeFacadeREST;
    private CoopActivityAttendee activityAttendee;
    private CoopActivityTypeFacadeREST coopActivityTypeFacadeREST;
    private CoopActivityType activityType;
    private CoopApplicantFacadeREST coopApplicantFacadeREST;
    private CoopApplicant applicant;
    private CoopMemActFacadeREST coopMemActFacadeREST;
    private CoopMemAct memAct;
    private CoopMemberFacadeREST coopMemberFacadeREST;
    private CoopMember member;
    private CoopOrgPlanFacadeREST coopOrgPlanFacadeREST;
    private CoopOrgPlan orgPlan;
    private CoopOrgUnitFacadeREST coopOrgUnitFacadeREST;
    private CoopOrgUnit orgUnit;
    private CoopOuActFacadeREST coopOuActFacadeREST;
    private CoopOuAct ouAct;
    private CoopProsActFacadeREST coopProsActFacadeREST;
    private CoopProsAct prosAct;
    private CoopProsCriteriaFacadeREST coopProsCriteriaFacadeREST;
    private CoopProsCriteria prosCriteria;
    private CoopProsCriteriaMainFacadeREST coopProsCriteriaMainFacadeREST;
    private CoopProsCriteriaMain prosCriteriaMain;
    private CoopProsCriteriaSubFacadeREST coopProsCriteriaSubFacadeREST;
    private CoopProsCriteriaSub prosCriteriaSub;
    private CoopProsLogFacadeREST coopProsLogFacadeREST;
    private CoopProsLog prosLog;
    private CoopProspectFacadeREST coopProspectFacadeREST;
    private CoopProspect prospect;
    private List<CoopProspect> prospectList;
    private CoopProspect selectedProspect;
    private DataModel<CoopProspect> prospectModel;
    private CoopProsRatingFacadeREST coopProsRatingFacadeREST;
    private CoopProsRating prosRating;
    private CoopProsReportFacadeREST coopProsReportFacadeREST;
    private CoopProsReport prosReport;
    private CoopRepActFacadeREST coopRepActFacadeREST;
    private CoopRepAct repAct;
    private CoopReportFacadeREST coopReportFacadeREST;
    private CoopReport report;
    private CoopReportCircFacadeREST coopReportCircFacadeREST;
    private CoopReportCirc reportCirc;
    private CoopReportTypeFacadeREST coopReportTypeFacadeREST;
    private CoopReportType reportType;
    private CoopProsRepverFacadeREST coopProsRepverFacadeREST;
    private CoopProsRepver prosRepver;

    public void init() {
        activity = new CoopActivity();
        activityAttendee = new CoopActivityAttendee();
        activityType = new CoopActivityType();
        applicant = new CoopApplicant();
        memAct = new CoopMemAct();
        member = new CoopMember();
        orgPlan = new CoopOrgPlan();
        orgUnit = new CoopOrgUnit();
        ouAct = new CoopOuAct();
        prosAct = new CoopProsAct();
        prosCriteria = new CoopProsCriteria();
        prosCriteriaMain = new CoopProsCriteriaMain();
        prosCriteriaSub = new CoopProsCriteriaSub();
        prosLog = new CoopProsLog();
        prospect = new CoopProspect();
        prospectList = coopProspectFacadeREST.findAll();
        prospectModel = new ListDataModel<CoopProspect>(prospectList);
        prosRating = new CoopProsRating();
        prosReport = new CoopProsReport();
        prosRepver = new CoopProsRepver();
        repAct = new CoopRepAct();
        report = new CoopReport();
        reportCirc = new CoopReportCirc();
        reportType = new CoopReportType();
    }

    public CoopActivityType getActivityType() {
        return activityType;
    }

    public CoopApplicant getApplicant() {
        return applicant;
    }

    public CoopMember getMember() {
        return member;
    }

    public CoopOrgPlan getOrgPlan() {
        return orgPlan;
    }

    public CoopOrgUnit getOrgUnit() {
        return orgUnit;
    }

    public CoopReportType getReportType() {
        return reportType;
    }

    public CoopActivityAttendee getActivityAttendee() {
        return activityAttendee;
    }

    public void setActivityAttendee(CoopActivityAttendee activityAttendee) {
        this.activityAttendee = activityAttendee;
    }

    public CoopMemAct getMemAct() {
        return memAct;
    }

    public void setMemAct(CoopMemAct memAct) {
        this.memAct = memAct;
    }

    public CoopOuAct getOuAct() {
        return ouAct;
    }

    public void setOuAct(CoopOuAct ouAct) {
        this.ouAct = ouAct;
    }

    public CoopProsLog getProsLog() {
        return prosLog;
    }

    public void setProsLog(CoopProsLog prosLog) {
        this.prosLog = prosLog;
    }

    public CoopProsReport getProsReport() {
        return prosReport;
    }

    public void setProsReport(CoopProsReport prosReport) {
        this.prosReport = prosReport;
    }

    public CoopRepAct getRepAct() {
        return repAct;
    }

    public void setRepAct(CoopRepAct repAct) {
        this.repAct = repAct;
    }

    public CoopReportCirc getReportCirc() {
        return reportCirc;
    }

    public void setReportCirc(CoopReportCirc reportCirc) {
        this.reportCirc = reportCirc;
    }

    public CoopProsRepver getProsRepver() {
        return prosRepver;
    }

    public void setProsRepver(CoopProsRepver prosRepver) {
        this.prosRepver = prosRepver;
    }

    public void effortBeanClear() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("effortBean", null);
    }

    public EffortBean() {
    }

    public DataModel<CoopProspect> getProspectModel() {
        if (prospectModel == null) {
            prospectModel = new ListDataModel<>(prospectList);
        }
        return prospectModel;
    }

    public CoopProspect getProspect() {
        return prospect;
    }

    public void saveDtl() {
        report.setReportDtl("effReport");
    }

    public List<CoopProspect> getProspectList() {
        prospectList = coopProspectFacadeREST.findAll();
        return prospectList;
    }

    public void setProspectList(List<CoopProspect> prospectList) {
        this.prospectList = prospectList;
    }

    public void setSelectedProspect(CoopProspect selectedProspect) {
        this.selectedProspect = selectedProspect;
    }

    public CoopProspect getSelectedProspect() {
        if (selectedProspect == null) {
            selectedProspect = new CoopProspect();
        }
        return selectedProspect;
    }

    public void onRowSelect(SelectEvent event) {
    }

    public CoopActivity getActivity() {
        if (activity == null) {
            activity = new CoopActivity();
        }
        return activity;
    }

    public void setActivity(CoopActivity activity) {
        this.activity = activity;
    }

    public CoopReport getReport() {
        if (report == null) {
            report = new CoopReport();
        }
        return report;
    }

    public void setReport(CoopReport report) {
        this.report = report;
    }

    public CoopProsRating getProsRating() {
        if (prosRating == null) {
            prosRating = new CoopProsRating();
        }
        return prosRating;
    }

    public void setProsRating(CoopProsRating prosRating) {
        this.prosRating = prosRating;
    }

    public CoopProsAct getProsAct() {
        if (prosAct == null) {
            prosAct = new CoopProsAct();
        }
        return prosAct;
    }

    public void setProsAct(CoopProsAct prosAct) {
        this.prosAct = prosAct;
    }

    public CoopProsCriteria getProsCriteria() {
        return prosCriteria;
    }

    public CoopProsCriteriaMain getProsCriteriaMain() {
        return prosCriteriaMain;
    }

    public void handleDateSelect(SelectEvent event) {
        Date date = (Date) event.getObject();
    }

    public CoopProsCriteriaSub getProsCriteriaSub() {
        return prosCriteriaSub;
    }

    public String saveEffort() {
        coopActivityFacadeREST.edit(activity);
        activity = new CoopActivity();
        coopActivityAttendeeFacadeREST.edit(activityAttendee);
        activityAttendee = new CoopActivityAttendee();
        coopMemActFacadeREST.edit(memAct);
        memAct = new CoopMemAct();
        coopOuActFacadeREST.edit(ouAct);
        ouAct = new CoopOuAct();
        coopProsActFacadeREST.edit(prosAct);
        prosAct = new CoopProsAct();
        coopProsLogFacadeREST.edit(prosLog);
        prosLog = new CoopProsLog();
        coopProsRatingFacadeREST.edit(prosRating);
        prosRating = new CoopProsRating();
        coopRepActFacadeREST.edit(repAct);
        repAct = new CoopRepAct();
        coopProsReportFacadeREST.edit(prosReport);
        prosReport = new CoopProsReport();
        coopProsRepverFacadeREST.edit(prosRepver);
        prosRepver = new CoopProsRepver();
        coopReportFacadeREST.edit(report);
        report = new CoopReport();
        coopReportCircFacadeREST.edit(reportCirc);
        reportCirc = new CoopReportCirc();
        coopReportTypeFacadeREST.edit(reportType);
        reportType = new CoopReportType();
        return "mainEffort";
    }
}
