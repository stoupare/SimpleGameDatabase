package com.stoups.core;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by astouparenko on 4/11/2017.
 */

@ComponentScan(basePackages =
        {"com.stoups"})
@SpringBootApplication
@EnableAutoConfiguration
public class VGDataClient {
    public static void main(String[] args) {
        new SpringApplicationBuilder(VGDataClient.class).web(true).run(args);
    }
}
