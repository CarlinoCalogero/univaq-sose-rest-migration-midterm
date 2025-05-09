package it.univaq.odws.maven.rest.greeting.client;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.cxf.jaxrs.client.WebClient;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;

public class AsyncGreetingClient {
	
	private final static String DATE_TIME_FORMAT = "dd/mm/yyyy hh:mm:ss";
	private final static String WS_SERVICE_URL = "http://localhost:8080/AsyncGreetingsRESTServiceMaven/rest";
	private final static String RESOURCE = "greetings-rest-service-async/say-hello";

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		// Send a service request using a blocking method
		//callServiceWithBlockingPolling();
		
		// Send a service request using a non blocking method
		//callServiceWithNonBlockingPolling();
		
		// Send a service request using a non blocking method and a callback handler
		//callServiceWithNonBlockingPollingUsingCallback();
		
		// Send a service request using a blocking synchronous method
		callServiceWithNoPolling();

	}
	
	public static void callServiceWithBlockingPolling() throws InterruptedException, ExecutionException {
		
		Client client = ClientBuilder.newClient();
		
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))
							+ " - invoking the sayHello async rest operation");
		
		String myName = "Pippo";
		String endpoint = WS_SERVICE_URL + "/" + RESOURCE + "/" + myName;
		Future<Response> futureResponse = client.target(endpoint).request().async().get();
		
		// BLOCKING OPERATION
		// Wait until the server completes and sends the response
		Response response = futureResponse.get();
		
		//Add a time threshold to the response
		//Wait maximum 1 second
		//Response response = futureResponse.get(1L, TimeUnit.SECONDS);
		
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))
				+ " - control regained");
		
		String serverResult = response.readEntity(String.class);
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))
							+ " - service responded with: " + serverResult);
		
	}
	
	public static void callServiceWithNonBlockingPolling() throws InterruptedException, ExecutionException {
		
		Client client = ClientBuilder.newClient();
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))
							+ " - invoking the sayHello async rest operation");
		
		String myName = "Pippo";
		String endpoint = WS_SERVICE_URL + "/" + RESOURCE + "/" + myName;
		Future<Response> futureResponse = client.target(endpoint).request().async().get();
		
		while (!futureResponse.isDone()) {
			// Client can do some other work while waiting
			Thread.sleep(1000);
			System.out.println("Waiting for server response...");
		}
		
		// Client is not blocked here
		Response response = futureResponse.get();
		
		String serverResult = response.readEntity(String.class);
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))
							+ " - service responded with: " + serverResult);
		
	}
	
	public static void callServiceWithNonBlockingPollingUsingCallback() throws InterruptedException, ExecutionException {
		
		Client client = ClientBuilder.newClient();
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))
							+ " - invoking the sayHello async rest operation");
		
		String myName = "Pippo";
		String endpoint = WS_SERVICE_URL + "/" + RESOURCE + "/" + myName;
		MyCallback callback = new MyCallback();
		Future<Response> futureResponse = client.target(endpoint).request().async().get(callback);
		
		while (!futureResponse.isDone()) {
			// Client can do some other work while waiting
			Thread.sleep(1000);
			System.out.println("Waiting for server response...");
		}
		
		String serverResult = callback.getMessageFromServer();
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))
							+ " - service responded through callback: " + serverResult);
		
	}
	
	public static void callServiceWithNoPolling() {
		
		Client client = ClientBuilder.newClient();
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))
							+ " - invoking the sayHello async rest operation");
		
		String myName = "Pippo";
		String endpoint = WS_SERVICE_URL + "/" + RESOURCE + "/" + myName;
		
		// BLOCKING OPERATION
		Response response = client.target(endpoint).request().get();
		
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))
				+ " - control regained");
		
		String serverResult = response.readEntity(String.class);
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))
							+ " - service responded with: " + serverResult);
		
	}

}
