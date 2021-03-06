package co.com.system.invoice.infrastructure.configuration;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

    @Override
    public void configure(HttpSecurity http) throws Exception {

        String [] arrayGet = new String[]{"/category/**","/state/**","/product/**","/attribute/**"};
        String [] arrayPost = new String[]{"/category/**","/product/**"};
        String [] arrayDelete = new String[]{"/category/delete/**"};

        http.authorizeRequests()
            .antMatchers(HttpMethod.GET,arrayGet).permitAll()
            .antMatchers(HttpMethod.POST,arrayPost).permitAll()
            .antMatchers(HttpMethod.PUT,arrayPost).permitAll()
            .antMatchers(HttpMethod.DELETE,arrayDelete).permitAll()
            .anyRequest().authenticated()
            .and().cors().configurationSource(corsConfigurationSource());
    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","DELETE","PUT","OPTIONS"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("Content-type","Authorization"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter(){
        FilterRegistrationBean<CorsFilter> filterRegistrationBean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
        filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return filterRegistrationBean;
    }



}
