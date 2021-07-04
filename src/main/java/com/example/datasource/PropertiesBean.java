package com.example.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class PropertiesBean {

    private String url;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "PropertiesBean{" + "url='" + url + '\'' + ", username='" + username + '\'' + ", password='" + password
                + '\'' + '}';
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
