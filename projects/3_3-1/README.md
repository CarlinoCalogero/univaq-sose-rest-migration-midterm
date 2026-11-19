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
  <h2 align="center">Slide 3_3-1 &mdash; Developing REST WS with Apache CXF & Maven</h2>

  <p align="center">
    Synchronous RESTful Web Services and Client examples migrated to Java 21, Jakarta EE 10, and Apache CXF 4.1.1.
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
    <a href="#services--clients-breakdown">Services Breakdown</a>
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
        <li><a href="#migration-notes">Migration Notes</a></li>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li><a href="#services--clients-breakdown">Services & Clients Breakdown</a></li>
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

This folder contains the complete migrated projects corresponding to lecture slide **"3_3-1 - Developing REST WS with Apache CXF-Maven"** of the **Service-Oriented Software Engineering (SOSE)** curriculum at the **University of L'Aquila**.

The goal of this topic is to learn how to design, configure, and consume synchronous RESTful web services in Java using the JAX-RS standard:
* **Resource Modeling**: Resource URI mapping via `@Path`.
* **Parameter Extraction**: Utilizing `@PathParam` for URI template variables and `@QueryParam` for URL query strings.
* **Content Negotiation & Multiple Representations**: Using `@Produces` with standard MIME types (`text/plain`, `text/html`, `text/xml`).
* **Contract Discovery**: Automatic WADL (Web Application Description Language) generation enabled via Apache CXF's `cxf-rt-rs-service-description`.
* **Programmatic Consumption**: Building lightweight Java client applications with Apache CXF's `WebClient`.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Migration Notes

In this module, the following modernizations were implemented:
* **Java 21 LTS** target compilation via `maven-compiler-plugin 3.14.0`.
* **Jakarta EE 10**: Replaced deprecated `javax.ws.rs.*` with `jakarta.ws.rs.*` and `javax.servlet.*` with `jakarta.servlet.*` (`6.1.0`).
* **Apache CXF 4.1.1**: Adopted Jakarta-compatible artifacts (`cxf-rt-frontend-jaxrs`, `cxf-rt-transports-http`, `cxf-rt-rs-service-description`, and `cxf-rt-rs-client`).
* **Servlet Engine**: Configured `CXFNonSpringJaxrsServlet` inside `web.xml` compatible with Apache Tomcat 10.1 and 11.0.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

* [![Java][Java-badge]][Java-url]
* [![Jakarta EE][Jakarta-badge]][Jakarta-url]
* [![Apache CXF][CXF-badge]][CXF-url]
* [![Apache Tomcat][Tomcat-badge]][Tomcat-url]
* [![Apache Maven][Maven-badge]][Maven-url]
* [![Eclipse IDE][Eclipse-badge]][Eclipse-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- SERVICES & CLIENTS BREAKDOWN -->
## Services & Clients Breakdown

| Project Folder | Role | Package | Description |
| :--- | :--- | :--- | :--- |
| [`GreetingRESTServiceMaven`](./GreetingRESTServiceMaven) | Web Service (WAR) | `it.univaq.odws.maven.rest.greeting` | Exposes greeting endpoints returning plain text, HTML, and XML representations based on a path parameter `{name}`. |
| [`SumRESTServiceMaven`](./SumRESTServiceMaven) | Web Service (WAR) | `it.univaq.odws.maven.rest.sum` | Exposes addition operations demonstrating both query parameters (`?a=...&b=...`) and path template parameters (`/{a}/{b}`). |
| [`SumRESTClientMaven`](./SumRESTClientMaven) | Java Client (JAR) | `it.univaq.odws.maven.rest.sum.client` | Standalone client application using Apache CXF `WebClient` to invoke `SumRESTServiceMaven`. |
| `Servers/` | Eclipse Config | &mdash; | Pre-configured Eclipse WTP server environment for Tomcat 11.0. |

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

* **JDK 21 LTS**
* **Apache Maven 3.9+**
* **Apache Tomcat 10.1 or 11.0**

### Build Instructions

Build all three projects from the command line:

```sh
cd GreetingRESTServiceMaven && mvn clean package && cd ..
cd SumRESTServiceMaven && mvn clean package && cd ..
cd SumRESTClientMaven && mvn clean package && cd ..
```

### Deployment

1. Copy the resulting WAR files (`GreetingRESTServiceMaven.war` and `SumRESTServiceMaven.war`) to `$CATALINA_BASE/webapps/`.
2. Start Tomcat (`bin/startup.bat` or `bin/startup.sh`).
3. Or deploy directly using the configured Eclipse Tomcat runtime.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- USAGE -->
## Usage

### 1. GreetingRESTServiceMaven Endpoints
Base URL: `http://localhost:8080/GreetingRESTServiceMaven/rest/greetingrestservice`

* **Plain text greeting**:
  ```sh
  curl -i http://localhost:8080/GreetingRESTServiceMaven/rest/greetingrestservice/greeting_text_plain/Student
  ```
* **HTML greeting**:
  ```sh
  curl -i http://localhost:8080/GreetingRESTServiceMaven/rest/greetingrestservice/greeting_text_html/Student
  ```
* **XML greeting**:
  ```sh
  curl -i http://localhost:8080/GreetingRESTServiceMaven/rest/greetingrestservice/greeting_text_xml/Student
  ```
* **WADL Inspection**:
  ```sh
  curl -i http://localhost:8080/GreetingRESTServiceMaven/rest/greetingrestservice?_wadl
  ```

### 2. SumRESTServiceMaven Endpoints
Base URL: `http://localhost:8080/SumRESTServiceMaven/rest/sumrestservice`

* **Query Parameter Addition**:
  ```sh
  curl -i "http://localhost:8080/SumRESTServiceMaven/rest/sumrestservice/sum?a=15&b=25"
  ```
  _Result:_ `40`

* **Path Parameter Addition**:
  ```sh
  curl -i http://localhost:8080/SumRESTServiceMaven/rest/sumrestservice/sum2/100/50
  ```
  _Result:_ `150`

### 3. SumRESTClientMaven Execution
Execute the standalone client:
```sh
cd SumRESTClientMaven
mvn exec:java -Dexec.mainClass="it.univaq.odws.maven.rest.sum.client.SumRESTClient"
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTRIBUTORS -->
## Contributors

> [!NOTE]
> This module is part of an academic examination assignment for the University of L'Aquila and is not open for external contributions or pull requests.

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
