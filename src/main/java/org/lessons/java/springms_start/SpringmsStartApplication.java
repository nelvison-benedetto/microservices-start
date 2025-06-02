package org.lessons.java.springms_start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")  //activate the auditing system x the entire app, here now spring uses AuditAwareImpl as AuditorAware<T>
public class SpringmsStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmsStartApplication.class, args);
	}

}
