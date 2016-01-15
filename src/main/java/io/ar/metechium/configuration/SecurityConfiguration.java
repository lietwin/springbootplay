package io.ar.metechium.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Add authentication
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
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

    /*
        This function overrides the basic mechanism that automatically generates a login form
        - declaring url paths that should be secure or not
        - Only the index are configured not to required any authentication
        - A custom login form is provided
        - error must be handled at login?error by default
        - logout must be handled at login?logout by default
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
}
