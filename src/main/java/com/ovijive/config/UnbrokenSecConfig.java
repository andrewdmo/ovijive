package com.ovijive.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class UnbrokenSecConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
//                .antMatcher("/")
            .authorizeRequests()
            .antMatchers("/", "/index", "/scripts/**", "/infura**", "/web3j**").permitAll()

            .antMatchers("/usersecurespace", "/user/**").hasRole("USER");
//            .anyRequest().permitAll();

//.requestMatchers("/**.api")
        // unsecure!:
//            .anyRequest().authenticated();
        // re-activate:
//                .and()

//                .formLogin()
//                .loginPage("/login")
//                .failureUrl("/login?error")
//                .successForwardUrl("/usersecurespace")
//                .permitAll()
//                .and()
//                //not working:
//                .exceptionHandling().accessDeniedPage("/403")
////            .loginProcessingUrl();
//                .and()

//                .logout()
//                .logoutSuccessUrl("/login?logout")
//                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .withUser("test@test").password("test").roles("USER");
    }

}

