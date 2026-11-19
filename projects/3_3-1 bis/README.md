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
  <h2 align="center">Slide 3_3-1 bis &mdash; Asynchronous REST WS with Apache CXF & Maven</h2>

  <p align="center">
    Server-side and Client-side Asynchronous RESTful Web Services migrated to Java 21, Jakarta EE 10, and Apache CXF 4.1.1.
    <br />
    <em>UNIVAQ &bull; Service-Oriented Software Engineering (SOSE) Midterm Exam</em>
    <br />
    <br />
    <a href="../../README.md"><strong>« Back to Repository Root</strong></a>
    &middot;
    <a href="../README.md"><strong>Projects Overview</strong></a>
    <br />
    <br />
    <a href="#about-the-module">About The Module</a>
    &middot;
    <a href="#asynchronous-architecture">Asynchronous Architecture</a>
    &middot;
    <a href="#usage">Usage</a>
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-module">About The Module</a>
      <ul>
        <li><a href="#server-side-asynchrony">Server-Side Asynchrony</a></li>
        <li><a href="#client-side-asynchrony">Client-Side Asynchrony</a></li>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li><a href="#asynchronous-architecture">Asynchronous Architecture</a></li>
    <li><a href="#projects-in-this-module">Projects In This Module</a></li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#build-instructions">Build Instructions</a></li>
        <li><a href="#deployment">Deployment</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contributors">Contributors</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

<!-- ABOUT THE MODULE -->
## About The Module

This directory contains the migrated implementation of the lecture topic **"3_3-1 bis - Developing REST WS with Apache CXF-Maven and Asynch"** for the **Service-Oriented Software Engineering (SOSE)** curriculum at the **University of L'Aquila**.

The objective of this module is to eliminate synchronous I/O bottlenecks in distributed web architectures by decoupling thread execution on both the server and client tiers.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Server-Side Asynchrony

In standard synchronous REST endpoints, the container assigns a dedicated worker thread from the thread pool to service the HTTP connection. If a service operation takes a long time (e.g., intensive calculation, external database querying, microservice coordination), the container thread remains blocked, severely reducing throughput.

Using **Jakarta REST (`jakarta.ws.rs.container.AsyncResponse`)** combined with `@Suspended`:
1. The incoming request is suspended immediately.
2. The servlet container I/O thread is released back to the pool to accept incoming connections.
3. Computation proceeds on an application background worker thread.
4. When finished, `asyncResponse.resume(response)` transmits the HTTP payload back to the client.
5. In `web.xml`, `<async-supported>true</async-supported>` is configured on `CXFNonSpringJaxrsServlet`.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Client-Side Asynchrony

On the consumer side, the client can invoke operations asynchronously using the JAX-RS `client.target(...).request().async()` fluent API, avoiding thread blocking while awaiting server responses:
* **Blocking Polling**: Invokes asynchronously and calls `Future.get()` to wait for results.
* **Non-Blocking Polling**: Periodically inspects `futureResponse.isDone()` in a loop while doing parallel work.
* **Callback Handler**: Registers an `InvocationCallback<Response>` instance whose `completed()` or `failed()` callback is notified upon completion.
* **Synchronous Invocation**: Direct blocking call to compare against asynchronous paradigms.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

* [![Java][Java-badge]][Java-url]
* [![Jakarta EE][Jakarta-badge]][Jakarta-url]
* [![Apache CXF][CXF-badge]][CXF-url]
* [![Apache Tomcat][Tomcat-badge]][Tomcat-url]
* [![Apache Maven][Maven-badge]][Maven-url]
* [![Eclipse IDE][Eclipse-badge]][Eclipse-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ASYNCHRONOUS ARCHITECTURE -->
## Asynchronous Architecture

```text
               CLIENT SIDE                                              SERVER SIDE
      +----------------------------+                     +---------------------------------------+
      |    AsyncGreetingClient     |                     |    AsyncGreetingsRESTServiceMaven     |
      |                            |                     |                                       |
      |  request().async().get()   | ---- HTTP GET ----> |  Servlet Container I/O Thread         |
      |                            |                     |  - Injects @Suspended AsyncResponse   |
      |  [Option A: Future.get()]  |                     |  - Suspends HTTP request              |
      |  [Option B: isDone() loop] |                     |  - Releases container thread to pool  |
      |  [Option C: Callback]      |                     |                                       |
      |                            |                     |  Background Worker Thread:            |
      |                            |                     |  - Simulates work (sleep 5s)          |
      |                            |                     |  - Calls asyncResponse.resume(resp)   |
      |  completed() / Future.get  | <--- HTTP 200 OK -- |                                       |
      +----------------------------+                     +---------------------------------------+
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- PROJECTS IN THIS MODULE -->
## Projects In This Module

| Project Folder | Type | Description |
| :--- | :--- | :--- |
| [`AsyncGreetingsRESTServiceMaven`](./AsyncGreetingsRESTServiceMaven) | Web Service (WAR) | Server-side asynchronous greeting service using `@Suspended AsyncResponse` with simulated delay. |
| [`AsyncGreetingsRESTClientMaven`](./AsyncGreetingsRESTClientMaven) | Java Client (JAR) | Multi-paradigm client demonstrating blocking future, non-blocking polling, callbacks, and sync calls. |
| `Servers/` | Eclipse Config | Eclipse WTP runtime environment for Apache Tomcat 11.0. |

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

* **JDK 21 LTS**
* **Apache Maven 3.9+**
* **Apache Tomcat 10.1 or 11.0**

### Build Instructions

```sh
cd AsyncGreetingsRESTServiceMaven && mvn clean package && cd ..
cd AsyncGreetingsRESTClientMaven && mvn clean package && cd ..
```

### Deployment

1. Copy `AsyncGreetingsRESTServiceMaven/target/AsyncGreetingsRESTServiceMaven.war` to `$CATALINA_HOME/webapps/`.
2. Start Tomcat (`bin/startup.bat` or `bin/startup.sh`).
3. Or deploy via Eclipse using the pre-configured Tomcat v11.0 Server.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- USAGE -->
## Usage

### 1. Test the Asynchronous Service via cURL
The service suspends the connection and responds after 5 seconds:
```sh
curl -i http://localhost:8080/AsyncGreetingsRESTServiceMaven/rest/greetings-rest-service-async/say-hello/Student
```
_Response:_
```http
HTTP/1.1 200 OK
Content-Type: text/plain
Date: Thu, 22 May 2025 ...

Hello Student !
```

### 2. Execute the Multi-Paradigm Client
```sh
cd AsyncGreetingsRESTClientMaven
mvn exec:java -Dexec.mainClass="it.univaq.odws.maven.rest.greeting.client.AsyncGreetingClient"
```

To test alternative invocation patterns, uncomment the desired method in `AsyncGreetingClient.java`:
* `callServiceWithBlockingPolling()`
* `callServiceWithNonBlockingPolling()`
* `callServiceWithNonBlockingPollingUsingCallback()`
* `callServiceWithNoPolling()`

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTRIBUTORS -->
## Contributors

> [!NOTE]
> This module was developed as a university midterm assignment for the Service-Oriented Software Engineering course at the University of L'Aquila. It is archived and closed to external contributions.

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
[Tomcat-badge]: https://img.shields.io/badge/Apache_Tomcat-10.1_%2F_11.0-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black
[Tomcat-url]: https://tomcat.apache.org/
[Maven-badge]: https://img.shields.io/badge/Apache_Maven-3.9+-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white
[Maven-url]: https://maven.apache.org/
[Eclipse-badge]: https://img.shields.io/badge/Eclipse_IDE-2024-2C2255?style=for-the-badge&logo=eclipseide&logoColor=white
[Eclipse-url]: https://www.eclipse.org/downloads/packages/
