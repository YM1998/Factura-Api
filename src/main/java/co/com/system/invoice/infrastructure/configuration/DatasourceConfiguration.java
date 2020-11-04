package co.com.system.invoice.infrastructure.configuration;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;

/**
 * Spring boot configuration for Datasource runtime
 *
 * @author carvajal
 * @version 1.0
 * @since 2020-04-21
 */

//@Configuration
public class DatasourceConfiguration {

  public static final String JPA_DATASOURCE = "datasource-ebusiness";

  //@Bean(name = JPA_DATASOURCE)
  //@ConfigurationProperties(prefix = "spring.datasource.db-ebusiness")
  public DataSource dataSourceEbusiness() {
    return DataSourceBuilder.create().build();
  }

}
