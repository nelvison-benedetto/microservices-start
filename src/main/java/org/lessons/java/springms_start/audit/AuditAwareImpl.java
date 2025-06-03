package org.lessons.java.springms_start.audit;
import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component("auditAwareImpl")  //custom name of this bean, x link in MyProjectApplication.java add @EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String>{  //use interface x use method getCurrentAuditor(), <String> x il type of the return

    //RUNNED ONLY if a @Entity/@MappedSuperclass w @CreatedDate @CreatedBy @LastModifiedDate @LastModifiedBy is created/updated.
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("MYACCOUNT_MS");  //return the name of the auditor (e.g., user or service) (here is setted MYACCOUNT_MS invented)
          //w spring sec you could use SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
