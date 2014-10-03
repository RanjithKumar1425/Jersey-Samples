package com.ranvanshi.jersey.basicsecurityannotation;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

@ApplicationPath("/")
public class ApplicationResourceConfig extends ResourceConfig{
	 public ApplicationResourceConfig() {
	        super(MyResource.class);
	        register(RolesAllowedDynamicFeature.class);
	    }
}
