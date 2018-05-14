package com.rks.project.pointofsales;

import com.rks.project.pointofsales.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Created by ASUS on 14/05/2018.
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UsersRepository usersRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").hasAnyRole("Admin", "User")
                .and()
                .authorizeRequests().antMatchers("/admin**").hasRole("Admin")
                .and()
                .authorizeRequests().antMatchers("/user**").hasRole("User")
                .and()
                .formLogin().loginPage("/login")
                .and()
                .logout().logoutUrl("/logout").permitAll()
                .and()
                .csrf().disable();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername(usersRepository.findByUsername("Rosa").get().getUsername())
                .password(encoder.encode(usersRepository.findByUsername("Rosa").get().getPassword()))
                .roles(usersRepository.findByUsername("Rosa").get().getRole())
                .build());
        manager.createUser(User.withUsername(usersRepository.findByUsername("Tobias").get().getUsername())
                .password(encoder.encode(usersRepository.findByUsername("Tobias").get().getPassword()))
                .roles(usersRepository.findByUsername("Tobias").get().getRole())
                .build());
        manager.createUser(User.withUsername(usersRepository.findByUsername("William").get().getUsername())
                .password(encoder.encode(usersRepository.findByUsername("William").get().getPassword()))
                .roles(usersRepository.findByUsername("William").get().getRole())
                .build());
        return manager;
    }
}
