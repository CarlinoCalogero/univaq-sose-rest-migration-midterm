package it.univaq.odws.maven.rest.greetings;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.container.AsyncResponse;
import jakarta.ws.rs.container.Suspended;

@Path("/greetings-rest-service-async")
public interface GreetingAsync {
	
	
	@GET
	@Path("/say-hello/{name}")
	void sayHello(@PathParam("name") final String name, @Suspended final AsyncResponse asyncResponse);
	
	
	/*
	 Without using the @Suspended annotation, the AsyncResponse instance is not injected into the method.
	 Nevertheless, we do not need to modify the client side. All of the 4 types of invocations will continue to work properly.
	 */
	/*
	@GET
   	@Path("/say-hello/{name}")
	String sayHello(@PathParam("name") final String name);
	*/

}
