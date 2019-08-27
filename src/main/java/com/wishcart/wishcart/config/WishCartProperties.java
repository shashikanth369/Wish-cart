package com.wishcart.wishcart.config;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import com.zaxxer.hikari.HikariConfig;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("wishcart")
@Data
@Validated
public class WishCartProperties {
	@NotNull
	@Valid
	private Dbdetails dbdetails = new Dbdetails();

	@Data
	public static class ActiveMq {
		private String brokerUrl;
	}

	@Data
	@Configuration
	public static class Dbdetails extends HikariConfig {
		/*
		 * @NotEmpty private String driverClassName;
		 */
		@NotEmpty
		private String url;

		@NotEmpty
		private String username;

		@NotEmpty
		private String password;
	}

}
