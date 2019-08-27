package com.wishcart.wishcart.config;

import static com.wishcart.wishcart.config.Appconstants.SPRING_PROFILE_DEVELOPMENT;

import java.util.HashMap;
import java.util.Map;

import lombok.NoArgsConstructor;

import org.springframework.boot.SpringApplication;

@NoArgsConstructor
public final class DefaultProfileUtil {
	private static final String SPRING_PROFILE_DEFAULT = "spring.profiles.default";

	public static void addDefaultProfile(SpringApplication app) {
		Map<String, Object> defProperties = new HashMap<>();
		/*
		 * The default profile to use when no other profiles are defined This cannot be set in the
		 * <code>application.yml</code> file. See https://github.com/spring-projects/spring-boot/issues/1219
		 */
		defProperties.put(SPRING_PROFILE_DEFAULT, SPRING_PROFILE_DEVELOPMENT);
		app.setDefaultProperties(defProperties);
	}
}
