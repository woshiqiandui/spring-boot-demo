package com.example.demo.configs;

import com.example.demo.beans.interfaces.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
                        System.out.println(username);
                        UserDetails userDetails =  readerRepository.findOneByUsername(username);
                        return readerRepository.findOneByUsername(username);
                        //return  new User(username,"123456", AuthorityUtils.commaSeparatedStringToAuthorityList("READER"));
                    }
                    // 5.0 版本之后需要增加crypt
                }).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 要求登录者拥有 Reader的角色
      /*  http.authorizeRequests().antMatchers("/").access("hasRole('READER')")
                .antMatchers("/**").permitAll()
                .and()
                // 表单登录
                .formLogin()
                // 登录表单的路径
                .loginPage("/login")
                // 自定义登录接口
                .loginProcessingUrl("/testThymeleaf")
                .failureUrl("/login?error=true");*/

        http.formLogin()                    //  定义当需要用户登录时候，转到的登录页面。
                .and()
                .authorizeRequests()// 定义哪些URL需要被保护、哪些不需要被保护
                .anyRequest()               // 任何请求,登录后可以访问
                .authenticated()
                .and()
                .formLogin();


    }

 /*   public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("123456"));
    }*/
}
