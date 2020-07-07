package com.example.layout.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
 
import lombok.Data;
 
@Data
@Component
@ConfigurationProperties(prefix="footer")
public class FooterConfig {
  private String jp;
  private String eng;
}
