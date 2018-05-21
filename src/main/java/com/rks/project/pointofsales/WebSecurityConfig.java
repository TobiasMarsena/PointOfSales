package com.rks.project.pointofsales;

import com.rks.project.pointofsales.users.Users;
import com.rks.project.pointofsales.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

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
                .authorizeRequests().antMatchers("/user").hasRole("User")
                .and()
                .authorizeRequests().antMatchers("/admin/**").hasRole("Admin")
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
        List<Users> usersList = usersRepository.findAll();
        for (Users user : usersList) {
            manager.createUser(User.withUsername(user.getUsername())
                    .password(encoder.encode(user.getPassword()))
                    .roles(user.getRole())
                    .build());
        }
        return manager;
    }
}
