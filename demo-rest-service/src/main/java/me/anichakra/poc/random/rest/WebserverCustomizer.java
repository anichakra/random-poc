package me.anichakra.poc.random.rest;

import java.util.Optional;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
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
		Optional.ofNullable(contextPath)
				.ifPresent(c -> container.setContextPath(c.substring(0, c.indexOf(".", c.indexOf(".") + 1)))); // major
		// and
		// minor
		// version
		// only
	}

}
