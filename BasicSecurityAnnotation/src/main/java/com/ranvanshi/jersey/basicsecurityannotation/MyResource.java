package com.ranvanshi.jersey.basicsecurityannotation;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	/**
	 * This method is allowed for all Roles
	 * 
	 * @return
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/unsecured")
	@PermitAll
	public String getsecured() {
		return " Message For all Roles!";
	}

	/**
	 * This method is allowed to only users with Role <b>secured</b>
	 * 
	 * @return
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/secured")
	@RolesAllowed("secured")
	public String getSecured() {
		return "Message for user with Role secured!";
	}

	/**
	 * This method is allowed to only users with Role <b>admin</b>
	 * 
	 * @return
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/securedadmin")
	@RolesAllowed("admin")
	public String getSecuredadmin() {
		return "Message for user with Role admin!";
	}
}
