/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author roland
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return getRestResourceClasses();
    }

    /**
     * Do not modify this method. It is automatically generated by NetBeans REST support.
     */
    private Set<Class<?>> getRestResourceClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        resources.add(service.CoopActivityAttendeeFacadeREST.class);
        resources.add(service.CoopActivityFacadeREST.class);
        resources.add(service.CoopActivityTypeFacadeREST.class);
        resources.add(service.CoopApplicantFacadeREST.class);
        resources.add(service.CoopMemActFacadeREST.class);
        resources.add(service.CoopMemberFacadeREST.class);
        resources.add(service.CoopOrgPlanFacadeREST.class);
        resources.add(service.CoopOrgUnitFacadeREST.class);
        resources.add(service.CoopOuActFacadeREST.class);
        resources.add(service.CoopProsActFacadeREST.class);
        resources.add(service.CoopProsCriteriaFacadeREST.class);
        resources.add(service.CoopProsCriteriaMainFacadeREST.class);
        resources.add(service.CoopProsCriteriaSubFacadeREST.class);
        resources.add(service.CoopProsLogFacadeREST.class);
        resources.add(service.CoopProsRatingFacadeREST.class);
        resources.add(service.CoopProsReportFacadeREST.class);
        resources.add(service.CoopProsRepverFacadeREST.class);
        resources.add(service.CoopProspectFacadeREST.class);
        resources.add(service.CoopRepActFacadeREST.class);
        resources.add(service.CoopReportCircFacadeREST.class);
        resources.add(service.CoopReportFacadeREST.class);
        resources.add(service.CoopReportTypeFacadeREST.class);
        // following code can be used to customize Jersey 1.x JSON provider:
        // following code can be used to customize Jersey 1.x JSON provider:
		// following code can be used to customize Jersey 1.x JSON provider:
		// following code can be used to customize Jersey 1.x JSON provider:
		// following code can be used to customize Jersey 1.x JSON provider:
		// following code can be used to customize Jersey 1.x JSON provider:
		// following code can be used to customize Jersey 1.x JSON provider:
		// following code can be used to customize Jersey 1.x JSON provider:
		// following code can be used to customize Jersey 1.x JSON provider:
		// following code can be used to customize Jersey 1.x JSON provider:
		// following code can be used to customize Jersey 1.x JSON provider:
		// following code can be used to customize Jersey 1.x JSON provider:
		// following code can be used to customize Jersey 1.x JSON provider:
		// following code can be used to customize Jersey 1.x JSON provider:
		// following code can be used to customize Jersey 1.x JSON provider:
		// following code can be used to customize Jersey 1.x JSON provider:
		try {
            Class jacksonProvider = Class.forName("org.codehaus.jackson.jaxrs.JacksonJsonProvider");
            resources.add(jacksonProvider);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return resources;
    }
    
}
