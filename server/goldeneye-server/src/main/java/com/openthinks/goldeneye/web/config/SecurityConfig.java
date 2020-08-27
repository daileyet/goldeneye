package com.openthinks.goldeneye.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configurable
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  UserDetailsService userDetailsService;

  private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }


  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    LOGGER.info("Security config configuring.....");
    // @formatter:off
    http
    .authorizeRequests()
      .antMatchers("/css/**", "/img/**","/lib/**","/js/**","/fonts/**","../fonts/**","/favicon.ico").permitAll()
      //.antMatchers("/cfg/log","/cfg/log/**","/api/log/cfgs").hasRole("admin")
      .antMatchers("/api/**").permitAll()
      .antMatchers("/s/**").permitAll()
      .anyRequest().authenticated()
    .and()
      .formLogin()
        .loginPage("/login")
        .usernameParameter("userName")
        .passwordParameter("userPass")
        .permitAll()
    .and()
      .logout()
        .logoutUrl("/logout")
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
        .permitAll()
        .invalidateHttpSession(true)
     .and()
       .rememberMe()
       .key("goldeneye-rem-me-key")
       .rememberMeParameter("remember-me")
       .rememberMeCookieName("goldeneye-rem-me-ck")
       .tokenValiditySeconds(86400);
     ;
    // @formatter:on
  }


}
