package com.liuning.pojo;

import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Data
@ConfigurationProperties("spring.datasource")
public class Jdbclianjie {

    private String username;

    private String password;

    private String url;

    private String driverClassName;
}
