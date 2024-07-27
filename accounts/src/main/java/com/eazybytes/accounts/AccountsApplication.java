package com.eazybytes.accounts;

import com.eazybytes.accounts.DTO.AccountsContactInfoDTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {AccountsContactInfoDTO.class})
@EnableFeignClients
@OpenAPIDefinition(
        info = @Info(
                title = "EasyBank Accounts Microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Xuyang",
                        email = "lxylbznb@gmail.com",
                        url = "https://github.com/Nisieko"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "www.nisieko.com"
                )
        ),

        externalDocs = @ExternalDocumentation(
                description = "EasyBank Accounts microservice REST API Documentation",
                url = "https://github.com/Nisieko/Bank-Web-Application-Microservices-Spring"
        )
)
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}
