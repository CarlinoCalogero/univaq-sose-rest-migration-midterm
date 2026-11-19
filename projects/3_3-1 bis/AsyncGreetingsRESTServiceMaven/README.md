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
  <h2 align="center">AsyncGreetingsRESTServiceMaven</h2>

  <p align="center">
    Server-Side Asynchronous REST Web Service using JAX-RS @Suspended AsyncResponse and Apache CXF 4.1.1 on Java 21.
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
    <a href="#how-it-works">How It Works</a>
    &middot;
    <a href="#getting-started">Getting Started</a>
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
        <li><a href="#how-it-works">How It Works</a></li>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#build-and-packaging">Build and Packaging</a></li>
        <li><a href="#deployment">Deployment</a></li>
      </ul>
    </li>
    <li>
      <a href="#usage">Usage</a>
      <ul>
        <li><a href="#endpoints">Endpoints</a></li>
        <li><a href="#curl-testing">cURL Testing</a></li>
      </ul>
    </li>
    <li><a href="#contributors">Contributors</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project

`AsyncGreetingsRESTServiceMaven` is a Maven-packaged Web Application Archive (WAR) implementing **server-side asynchronous request processing** with **Jakarta REST (JAX-RS)** and **Apache CXF 4.1.1** on **Java 21**.

In high-concurrency environments, long-running requests can rapidly deplete container worker threads. By leveraging `@Suspended AsyncResponse`, the servlet container thread is released immediately while the actual payload generation runs in an independent background thread.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### How It Works

1. **JAX-RS Resource Contract (`GreetingAsync.java`)**:
   ```java
   @Path("/greetings-rest-service-async")
   public interface GreetingAsync {
       @GET
       @Path("/say-hello/{name}")
       void sayHello(@PathParam("name") final String name, 
                     @Suspended final AsyncResponse asyncResponse);
   }
   ```
   * The method return type is `void`.
   * `@Suspended` instructs CXF to suspend the request and inject an active `AsyncResponse` context.

2. **Asynchronous Execution (`GreetingAsyncImpl.java`)**:
   ```java
   new Thread() {
       public void run() {
           try {
               Thread.sleep(5000); // simulate 5-second computation
               Response response = Response.ok(String.format("Hello %s !", name))
                                           .type(MediaType.TEXT_PLAIN)
                                           .build();
               asyncResponse.resume(response);
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
   }.start();
   ```

3. **Servlet Descriptor (`web.xml`)**:
   Enables asynchronous support on Tomcat:
   ```xml
   <servlet>
       <servlet-name>CXFNonSpringJaxrsServlet</servlet-name>
       <servlet-class>org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet</servlet-class>
       ...
       <async-supported>true</async-supported>
   </servlet>
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

* [![Java][Java-badge]][Java-url]
* [![Jakarta EE][Jakarta-badge]][Jakarta-url]
* [![Apache CXF][CXF-badge]][CXF-url]
* [![Apache Tomcat][Tomcat-badge]][Tomcat-url]
* [![Apache Maven][Maven-badge]][Maven-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

* **JDK 21 LTS**
* **Apache Maven 3.9+**
* **Apache Tomcat 10.1 or 11.0**

### Build and Packaging

```sh
mvn clean package
```

Produces `target/AsyncGreetingsRESTServiceMaven.war`.

### Deployment

1. Copy `target/AsyncGreetingsRESTServiceMaven.war` to `$CATALINA_HOME/webapps/`.
2. Start Tomcat (`bin/startup.bat` or `bin/startup.sh`).
3. Or deploy via Eclipse using the configured Tomcat runtime.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- USAGE -->
## Usage

Base URL: `http://localhost:8080/AsyncGreetingsRESTServiceMaven/rest/greetings-rest-service-async`

### Endpoints

| HTTP Method | URI Pattern | Asynchronous Mode | Description |
| :--- | :--- | :--- | :--- |
| `GET` | `/say-hello/{name}` | Server-Side Suspended Thread | Delays response by 5s on background thread before returning `Hello {name} !` |
| `GET` | `?_wadl` | Synchronous metadata | Auto-generated WADL contract |

### cURL Testing

```sh
curl -i http://localhost:8080/AsyncGreetingsRESTServiceMaven/rest/greetings-rest-service-async/say-hello/Alice
```

_Observed behavior:_
* The request connection opens and waits for approximately 5 seconds.
* During the wait, server logs indicate the initial thread returned control and the response is dispatched from the background worker thread.
* Output:
  ```http
  HTTP/1.1 200 OK
  Content-Type: text/plain
  
  Hello Alice !
  ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTRIBUTORS -->
## Contributors

> [!NOTE]
> This service is an educational module developed for the Service-Oriented Software Engineering midterm exam at the University of L'Aquila. It is archived and not accepting external contributions.

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
