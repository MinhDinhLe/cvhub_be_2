package com.codeforworks.NTH_WorkFinder.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class AppConfig {

    @Value("http://localhost:5173")
    private String frontendUrl;
}