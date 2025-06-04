package org.lessons.java.springms_start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.ExternalDocumentation;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")  //activate the auditing system x the entire app, here now spring uses AuditAwareImpl as AuditorAware<T>
@OpenAPIDefinition(
	info = @Info(
		title = "Microservices Spring Start",
		version = "1.0",
		description = "Microservices Spring Start",
		contact = @Contact(
			name = "Nelvison",
			email = "nelvison24@gmail.com",
			url = "https://www.nelvison24.com"
		),
		license = @License(
			name = "Apache 2.0",
			url = "https://www.apache.org/licenses/LICENSE-2.0"
		)
	),
	externalDocs = @ExternalDocumentation(
		description = "Find out more",
		url = "https://www.nelvison24.com"
	)
)
public class SpringmsStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmsStartApplication.class, args);
	}

}
