package com.example.layout.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 今日のひとこと設定ファイル
 */
@Data
@Component
@ConfigurationProperties
public class CatchCopyConfig {
	  private List<String> catchcopy;
}
