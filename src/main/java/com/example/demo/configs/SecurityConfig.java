package com.example.demo.configs;

import com.example.demo.beans.interfaces.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    ReaderRepository readerRepository;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(new UserDetailsService() {
                    @Override
                    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                        return readerRepository.findById(username).get();
                    }
                });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 要求登录者拥有 Reader的角色
        http.authorizeRequests().antMatchers("/").access("hasRole('READER')")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin()
                // 登录表单的路径
                .loginPage("/login")
                .failureUrl("/login?error=true");
    }
}
