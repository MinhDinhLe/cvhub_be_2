package com.codeforworks.NTH_WorkFinder.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class AppConfig {

    @Value("https://fecvhub.vercel.app/")
    private String frontendUrl;
}