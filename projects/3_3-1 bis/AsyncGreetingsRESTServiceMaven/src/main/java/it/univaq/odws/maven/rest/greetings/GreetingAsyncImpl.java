package it.univaq.odws.maven.rest.greetings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.ws.rs.container.AsyncResponse;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class GreetingAsyncImpl implements GreetingAsync {
	
	private final static String DATE_TIME_FORMAT = "dd/mm/yyyy hh:mm:ss";
	private final static int WAIT_TIME = 5000; // 5 seconds
	
	@Override
	public void sayHello(final String name, final AsyncResponse asyncResponse) {

		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))
				+ " - executing public void sayHello(String name, AsyncResponse asyncResponse)");

		new Thread() {
			public void run() {
				try {
					Thread.sleep(WAIT_TIME);
					
					Response response = Response.ok(String.format("Hello %s !", name))
												.type(MediaType.TEXT_PLAIN)
												.build();
					
					System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))
							+ " - responding on background thread");

					asyncResponse.resume(response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		}.start();

	}
	
	/*
	 @Override
	public String sayHello(final String name) {

		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))
				+ " - executing public String sayHello(String name)");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Hello %s !".formatted(name);

	}
	*/
	

}
