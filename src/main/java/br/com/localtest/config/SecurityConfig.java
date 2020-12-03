package br.com.localtest.config;

import br.com.localtest.service.CustomDemoUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomDemoUserDetailService customDemoUserDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/*/protected/**").hasRole("USER")
                .antMatchers("/*/admin/**").hasRole("ADMIN")
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customDemoUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }
    //    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//                .withUser("bruno").password(encoder.encode("demospring")).roles("USER")
//                .and()
//                .withUser("admin").password(encoder.encode("demospring")).roles("USER","ADMIN");
//    }

}
