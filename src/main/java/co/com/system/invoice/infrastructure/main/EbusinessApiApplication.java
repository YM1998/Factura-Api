package co.com.system.invoice.infrastructure.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Application initializer
 *
 * @author Carvajal
 * @version 1.0
 * @since 2020-04-13
 */

@SpringBootApplication(scanBasePackages = {
    "co.com.system.invoice.infrastructure",
    "co.com.system.invoice.api",
    "co.com.system.invoice.persistence.dataproviders",
    "co.com.system.invoice.service",
    "co.com.system.invoice.translators",
    "co.com.system.invoice.handlers",
    "co.com.system.invoice.persistence.repository"})
@EnableJpaRepositories(basePackages = {
    "co.com.system.invoice.persistence.repository"})
@EntityScan(basePackages = "co.com.system.invoice.persistence.entity")
public class EbusinessApiApplication {

  public static void main(final String[] args) {
    SpringApplication.run(EbusinessApiApplication.class, args);
  }




}
