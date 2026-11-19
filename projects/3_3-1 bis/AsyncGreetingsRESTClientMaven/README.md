<a id="readme-top"></a>

<!-- PROJECT SHIELDS -->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<!-- HEADER (NO LOGO) -->
<br />
<div align="center">
  <h2 align="center">AsyncGreetingsRESTClientMaven</h2>

  <p align="center">
    Multi-Paradigm Asynchronous JAX-RS REST Client demonstrating Future Polling and InvocationCallback.
    <br />
    <em>Topic 3_3-1 bis &bull; Service-Oriented Software Engineering &bull; University of L'Aquila</em>
    <br />
    <br />
    <a href="../README.md"><strong>« Back to Topic 3_3-1 bis</strong></a>
    &middot;
    <a href="../../../README.md"><strong>Repository Root</strong></a>
    <br />
    <br />
    <a href="#about-the-project">About The Project</a>
    &middot;
    <a href="#invocation-patterns">Invocation Patterns</a>
    &middot;
    <a href="#usage">Usage</a>
    &middot;
    <a href="#contributors">Contributors</a>
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#invocation-patterns">Invocation Patterns</a></li>
        <li><a href="#callback-implementation">Callback Implementation</a></li>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#compilation">Compilation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contributors">Contributors</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project

`AsyncGreetingsRESTClientMaven` is a standalone Java application built on **Java 21** and **Apache CXF 4.1.1** that showcases client-side asynchronous invocation patterns defined by the **Jakarta REST (JAX-RS) Client API**.

It connects to the `AsyncGreetingsRESTServiceMaven` endpoint (`/greetings-rest-service-async/say-hello/{name}`) and demonstrates how a client can invoke an asynchronous service without freezing the client application thread.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Invocation Patterns

The client source code in `AsyncGreetingClient.java` illustrates four distinct interaction paradigms:

#### 1. Blocking Polling (`callServiceWithBlockingPolling`)
```java
Future<Response> futureResponse = client.target(endpoint).request().async().get();
// Control is regained immediately, then blocks until the server responds:
Response response = futureResponse.get();
```
* The request is dispatched asynchronously.
* Calling `futureResponse.get()` pauses the current thread until the response arrives or a timeout threshold is reached (`futureResponse.get(1L, TimeUnit.SECONDS)`).

#### 2. Non-Blocking Polling Loop (`callServiceWithNonBlockingPolling`)
```java
Future<Response> futureResponse = client.target(endpoint).request().async().get();
while (!futureResponse.isDone()) {
    // The client can perform local CPU work or UI updates while waiting
    Thread.sleep(1000);
    System.out.println("Waiting for server response...");
}
Response response = futureResponse.get();
```
* Uses `isDone()` to poll completion state non-blockingly, allowing other tasks to progress concurrently.

#### 3. Asynchronous Invocation with Callback (`callServiceWithNonBlockingPollingUsingCallback`)
```java
MyCallback callback = new MyCallback();
Future<Response> futureResponse = client.target(endpoint).request().async().get(callback);
```
* Leverages an event-driven model where the runtime notifies an `InvocationCallback<Response>` upon HTTP response arrival.

#### 4. Synchronous Invocation (`callServiceWithNoPolling`)
```java
Response response = client.target(endpoint).request().get();
```
* Standard blocking HTTP `GET` invocation used for performance and execution baseline comparison.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Callback Implementation

`MyCallback.java` implements `jakarta.ws.rs.client.InvocationCallback<Response>`:

```java
public class MyCallback implements InvocationCallback<Response> {
    private String messageFromServer;

    @Override
    public void completed(Response response) {
        if (response.getStatus() == HttpURLConnection.HTTP_OK) {
            this.messageFromServer = response.readEntity(String.class);
        } else {
            System.err.println("Request error: " + response.getStatus());
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
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

* [![Java][Java-badge]][Java-url]
* [![Jakarta EE][Jakarta-badge]][Jakarta-url]
* [![Apache CXF][CXF-badge]][CXF-url]
* [![Apache Maven][Maven-badge]][Maven-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

* **JDK 21 LTS**
* **Apache Maven 3.9+**
* An active deployment of **AsyncGreetingsRESTServiceMaven** at `http://localhost:8080/AsyncGreetingsRESTServiceMaven`.

### Compilation

```sh
mvn clean compile
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- USAGE -->
## Usage

Run the client application:

```sh
mvn exec:java -Dexec.mainClass="it.univaq.odws.maven.rest.greeting.client.AsyncGreetingClient"
```

### Switching Patterns
Open `AsyncGreetingClient.java` and comment/uncomment the desired method call in `main()`:

```java
public static void main(String[] args) throws InterruptedException, ExecutionException {
    // 1. Blocking future
    callServiceWithBlockingPolling();
    
    // 2. Non-blocking status polling
    // callServiceWithNonBlockingPolling();
    
    // 3. Callback handler
    // callServiceWithNonBlockingPollingUsingCallback();
    
    // 4. Synchronous baseline
    // callServiceWithNoPolling();
}
```

### Sample Output (Pattern 2: Non-Blocking Polling)
```text
22/05/2025 04:30:00 - invoking the sayHello async rest operation
Waiting for server response...
Waiting for server response...
Waiting for server response...
Waiting for server response...
Waiting for server response...
22/05/2025 04:30:05 - service responded with: Hello Pippo !
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTRIBUTORS -->
## Contributors

> [!NOTE]
> This client is an educational module developed for the Service-Oriented Software Engineering midterm exam at the University of L'Aquila. It is archived and not accepting external contributions.

<br />
<div align="center">
  <a href="https://github.com/CarlinoCalogero/univaq-sose-rest-migration-midterm/graphs/contributors">
    <img src="https://contrib.rocks/image?repo=CarlinoCalogero/univaq-sose-rest-migration-midterm" alt="Project Contributors" />
  </a>
</div>
<br />

* **Calogero Carlino** &mdash; [@CarlinoCalogero](https://github.com/CarlinoCalogero) &bull; [carlinocalogero.dev@gmail.com](mailto:carlinocalogero.dev@gmail.com) &bull; [Portfolio](https://carlinocalogero.github.io)
* **Luca Francesco Macera** &mdash; [@LucaFraMac](https://github.com/LucaFraMac) &bull; [lucamacera02@gmail.com](mailto:lucamacera02@gmail.com)
* **Daniele Borgna** &mdash; Group 1 Team Member

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTACT -->
## Contact

**Calogero Carlino**
* Portfolio: [https://carlinocalogero.github.io](https://carlinocalogero.github.io)
* LinkedIn: [https://www.linkedin.com/in/calogero-carlino-2a94a33b5/](https://www.linkedin.com/in/calogero-carlino-2a94a33b5/)
* Email: [carlinocalogero.dev@gmail.com](mailto:carlinocalogero.dev@gmail.com)
* GitHub: [@CarlinoCalogero](https://github.com/CarlinoCalogero)

Project Link: [https://github.com/CarlinoCalogero/univaq-sose-rest-migration-midterm](https://github.com/CarlinoCalogero/univaq-sose-rest-migration-midterm)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* **Prof. Marco Autili** &mdash; University of L'Aquila
* **University of L'Aquila (UNIVAQ)** &mdash; DISIM
* [Apache CXF](https://cxf.apache.org/)
* [Jakarta EE](https://jakarta.ee/)
* [Othneil Drew's Best-README-Template](https://github.com/othneildrew/Best-README-Template)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
[contributors-shield]: https://img.shields.io/github/contributors/CarlinoCalogero/univaq-sose-rest-migration-midterm.svg?style=for-the-badge
[contributors-url]: https://github.com/CarlinoCalogero/univaq-sose-rest-migration-midterm/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/CarlinoCalogero/univaq-sose-rest-migration-midterm.svg?style=for-the-badge
[forks-url]: https://github.com/CarlinoCalogero/univaq-sose-rest-migration-midterm/network/members
[stars-shield]: https://img.shields.io/github/stars/CarlinoCalogero/univaq-sose-rest-migration-midterm.svg?style=for-the-badge
[stars-url]: https://github.com/CarlinoCalogero/univaq-sose-rest-migration-midterm/stargazers
[issues-shield]: https://img.shields.io/github/issues/CarlinoCalogero/univaq-sose-rest-migration-midterm.svg?style=for-the-badge
[issues-url]: https://github.com/CarlinoCalogero/univaq-sose-rest-migration-midterm/issues
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/calogero-carlino-2a94a33b5/

<!-- Tech Badges -->
[Java-badge]: https://img.shields.io/badge/Java-21_LTS-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html
[Jakarta-badge]: https://img.shields.io/badge/Jakarta_EE-10-F05032?style=for-the-badge&logo=eclipse&logoColor=white
[Jakarta-url]: https://jakarta.ee/
[CXF-badge]: https://img.shields.io/badge/Apache_CXF-4.1.1-D22128?style=for-the-badge&logo=apache&logoColor=white
[CXF-url]: https://cxf.apache.org/
[Maven-badge]: https://img.shields.io/badge/Apache_Maven-3.9+-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white
[Maven-url]: https://maven.apache.org/
