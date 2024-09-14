package cdi.beans;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import cdi.annotations.Web;
import cdi.scopes.ApplicationScope;
import cdi.scopes.DependentScope;
import cdi.scopes.RequestScope;
import cdi.scopes.SessionScope;
import cdi.sessionbeans.AuditedService;

@Web
public class ScopesBean implements Serializable {

    //Field injection point
    @Inject
    private RequestScope requestScope;
    @Inject
    private ApplicationScope applicationScope;

    @Inject
    private AuditedService auditedService;
    
    //Producer object
    @Inject
    private Logger logger;

    private SessionScope sessionScope;

    private DependentScope dependentScope;

    //Lifecyle callback
    @PostConstruct
    private void init() {
        auditedService.auditedMethod();
        logger.log(Level.INFO, "*******************************************");
        logger.log(Level.INFO, "Scopes bean called");
        logger.log(Level.INFO, "********************************************");

    }

    @PreDestroy
    private void kill() {
        logger.log(Level.INFO, "*******************************************");
        logger.log(Level.INFO, "Scopes bean gonna be killed :-( ");
        logger.log(Level.INFO, "********************************************");
    }

    //Constructor injection point
    @Inject
    private ScopesBean(DependentScope dependentScope) {
        this.dependentScope = dependentScope;
    }

    //Method injection point
    @Inject
    private void setSessionScope(SessionScope sessionScope) {
        this.sessionScope = sessionScope;
    }

    public String requestScopeHashCode() {
        return requestScope.getHashCode();
    }

    public String applicatioinScopeHashCode() {
        return applicationScope.getHashCode();
    }

    public String sessionScopeHashCode() {
        return sessionScope.getHashCode();
    }

    public String dependentScopeHashCode() {
        return dependentScope.getHashCode();
    }

}
