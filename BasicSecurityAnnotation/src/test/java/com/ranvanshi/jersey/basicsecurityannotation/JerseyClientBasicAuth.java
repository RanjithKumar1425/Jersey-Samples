package com.ranvanshi.jersey.basicsecurityannotation;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class JerseyClientBasicAuth {
	public static void main(String[] args) {
		HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder()
			    .nonPreemptive().credentials("tomcat", "tomcat").build();
//		
		Client client = ClientBuilder.newClient();
		client.register(feature);
		WebTarget webTarget = client.target("http://localhost:8080/BasicSecurityAnnotation/webapi/myresource");
		WebTarget resourceWebTarget = webTarget.path("secured");
		
		Invocation.Builder invocationBuilder =
				resourceWebTarget.request(MediaType.TEXT_PLAIN_TYPE);
		invocationBuilder.header("some-header", "true");
		
		Response response = resourceWebTarget.request().get();
		
		//Response response = invocationBuilder.get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
}
