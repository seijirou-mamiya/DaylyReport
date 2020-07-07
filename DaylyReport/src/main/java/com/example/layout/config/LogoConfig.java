package com.example.layout.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * ロゴ設定ファイル
 */
@Data
@Component
@ConfigurationProperties
public class LogoConfig {
	  private List<String> logo;
}
