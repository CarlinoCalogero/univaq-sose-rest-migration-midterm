package it.univaq.odws.maven.rest.greeting.client;

import java.net.HttpURLConnection;

import jakarta.ws.rs.client.InvocationCallback;
import jakarta.ws.rs.core.Response;


public class MyCallback implements InvocationCallback<Response>{
	
	private String messageFromServer;

	@Override
	public void completed(Response response) {
		if(response.getStatus() == HttpURLConnection.HTTP_OK) {
			this.messageFromServer = response.readEntity(String.class);
		} else {
			System.err.println("Request error: %s".formatted(response.getStatus()));
		}
		
	}

	@Override
	public void failed(Throwable throwable) {
		throwable.printStackTrace();
	}
	
	public String getMessageFromServer() {
		return messageFromServer;
	}

}
