package com.example.product_app.security;

import com.example.product_app.properties.SecureConfigProperties;
import com.example.product_app.utility.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    SecureConfigProperties secureConfigProperties;

    //authorization and privilege manager method
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        super.configure(httpSecurity);
        httpSecurity.csrf().disable();
    }

    //authentication(identity validation) method
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        try {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            authenticationManagerBuilder.inMemoryAuthentication()
                    .passwordEncoder(passwordEncoder)
                    .withUser(this.secureConfigProperties.getSecureKeyUserName())
                    .password(passwordEncoder.encode(this.secureConfigProperties.getSecureKeyPassword()))
                    .roles("USER");
        }catch (Exception exception){
            Util.showGeneralException(exception);
        }
    }
}
