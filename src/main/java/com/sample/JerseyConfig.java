package com.sample;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig{
	public JerseyConfig() {
		register(ProtectedResource.class);
		register(CORSResponseFilter.class);
	}
}
