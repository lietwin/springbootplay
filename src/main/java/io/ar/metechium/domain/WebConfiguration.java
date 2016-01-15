package io.ar.metechium.domain;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * An example of custom servlet filters and handler interceptors
 * Adding Tomcat 8 remote ip filter implementation
 * e.g. suppose the app is run behind a load balancer proxy,
 * translate the real request ip that is used by the users instead of the proxy IP
 */
@Configuration
@EnableWebSecurity
public class WebConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        return new LocaleChangeInterceptor();
    }

    /*
    the following will
     - require auhentication to every URL in the application
     - generate a login form
     - allow the user with the sales user and sales password to authenticate
     - allow the user to logout
     */
    @Autowired
    public void defaultConfigure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("sales").password("sales").roles("USER");
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//    }
}
