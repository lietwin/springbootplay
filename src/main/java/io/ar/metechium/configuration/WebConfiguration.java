package io.ar.metechium.configuration;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;


@Configuration
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter {
    /**
     * An example of custom servlet filters and handler interceptors
     * Adding Tomcat 8 remote ip filter implementation
     * e.g. suppose the app is run behind a load balancer proxy,
     * translate the real request ip that is used by the users instead of the proxy IP
     */
    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        return new LocaleChangeInterceptor();
    }

    //declare additional views
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }
}
