package com.keepzing.security.configuration;

import com.keepzing.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
            .loginPage("/login_page.html")  //配置首页地址
            .loginProcessingUrl("/my_login")
            .permitAll()    //配置页面不需要登录可以直接访问
            .and()
            .csrf().disable()   //禁用csrf验证
            .authorizeRequests()  //配置角色权限
//            .anyRequest().authenticated()   //所有请求都需要登录
        ;
    }

    @Bean //向IOC容器中加入PasswordEncoder实例
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
