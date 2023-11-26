package co.com.system.invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Application initializer
 *
 * @author Carvajal
 * @version 1.0
 * @since 2020-04-13
 */

@SpringBootApplication(scanBasePackages = {
    /*"co.com.system.invoice.api.*",
    "co.com.system.invoice.persistence.*",
    "co.com.system.invoice.service.*",
    "co.com.system.invoice.handlers",*/
        "co.com.system.invoice.*"
})
@EnableJpaRepositories(basePackages = {
    //"co.com.system.invoice.persistence.*"
        "co.com.system.invoice.*"})
@EntityScan(basePackages =// "co.com.system.invoice.persistence.*"
        "co.com.system.invoice.*" )
public class MainApplication extends SpringBootServletInitializer {


  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(MainApplication.class);
  }


  public static void main(final String[] args) {
    SpringApplication.run(MainApplication.class, args);
  }




}
