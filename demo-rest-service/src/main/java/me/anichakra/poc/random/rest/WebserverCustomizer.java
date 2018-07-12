package me.anichakra.poc.random.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "custom")
public class WebserverCustomizer implements EmbeddedServletContainerCustomizer {
	
	private String contextPath;

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		Optional.ofNullable(contextPath).ifPresent(c -> {
			container.setContextPath(extractVersion(c));
			System.setProperty("spring.application.name", extractVersion(c).replaceAll("/", "-"));
		});
	}

	private String extractVersion(String c) {
		// major and minor version only
		return c.substring(0, c.indexOf(".", c.indexOf(".") + 1));
	}

}
