package com.example.demos;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class confProp {
    private String username;
    private String password;

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public void setUsername(){
        this.username = System.getenv("SQLName");
        System.out.println(username);
    }

    public void setPassword(){
        this.password = System.getenv("SQLPass");
        System.out.println(password);
    }


}