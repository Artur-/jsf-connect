package org.vaadin.artur.jsfvaadinblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // require all requests to be authenticated except for the resources
    http.authorizeRequests().antMatchers("/javax.faces.resource/**")
        .permitAll()
        .antMatchers("/admin/**").authenticated()
        .antMatchers("/admin/blog-admin.xhtml").hasAnyRole("ADMIN")
        .anyRequest().permitAll();
    // login
    http.formLogin().loginPage("/admin/login.xhtml").permitAll()
        .failureUrl("/admin/login.xhtml?error=true");
        
    // logout
    http.logout().logoutSuccessUrl("/blogposts.xhtml");
    // not needed as JSF 2.2 is implicitly protected against CSRF
    http.csrf().disable();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth)
      throws Exception {
    auth.inMemoryAuthentication().withUser("user")
        .password("{noop}user").roles("USER").and()
        .withUser("admin").password("{noop}admin").roles("USER","ADMIN");
  }
}
