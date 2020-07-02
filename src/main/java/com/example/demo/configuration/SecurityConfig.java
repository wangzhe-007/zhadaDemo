package com.example.demo.configuration;

import com.example.demo.Service.UserService;
import com.example.demo.Service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;
import java.io.PrintWriter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    /**
     * 登录处理
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 开启登录配置
        http.authorizeRequests()
                .antMatchers("/check").permitAll()
                // 标识访问修改教师和学生的页面必须是管理员
                .antMatchers("/user").hasRole("admin")
                // 允许老师访问的课程
                .antMatchers( "/course").hasRole("teacher")
                //允许学生访问的订阅模块
                .antMatchers( "/take").hasRole("student");
        http.csrf().disable();
        http.formLogin().loginPage("/toLogin");
        http.logout().logoutSuccessUrl("/");
    }



    //配置密码加密
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles("admin")
                .and()
                .withUser("teacher").password(new BCryptPasswordEncoder().encode("111111")).roles("teacher")
                .and()
                .withUser("student").password(new BCryptPasswordEncoder().encode("111111")).roles("student");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/console/**");
    }
}