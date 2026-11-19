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
  <h2 align="center">GreetingRESTServiceMaven</h2>

  <p align="center">
    JAX-RS Synchronous Greeting Web Service producing Plain Text, HTML, and XML representations.
    <br />
    <em>Topic 3_3-1 &bull; Service-Oriented Software Engineering &bull; University of L'Aquila</em>
    <br />
    <br />
    <a href="../README.md"><strong>« Back to Topic 3_3-1</strong></a>
    &middot;
    <a href="../../../README.md"><strong>Repository Root</strong></a>
    <br />
    <br />
    <a href="#endpoints">Endpoints</a>
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
        <li><a href="#service-architecture">Service Architecture</a></li>
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
        <li><a href="#curl-examples">cURL Examples</a></li>
      </ul>
    </li>
    <li><a href="#contributors">Contributors</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project

`GreetingRESTServiceMaven` is a Maven-packaged Web Application Archive (WAR) demonstrating fundamental REST architectural concepts implemented with **Jakarta RESTful Web Services (JAX-RS)** and **Apache CXF 4.1.1** running on **Java 21**.

The service illustrates:
* Resource exposure through the `@Path` annotation.
* Dynamic URI path parameter extraction with `@PathParam("name")`.
* Declarative MIME type handling with `@Produces`:
  * `MediaType.TEXT_PLAIN` (`text/plain`)
  * `MediaType.TEXT_HTML` (`text/html`)
  * `MediaType.TEXT_XML` (`text/xml`)
* Deployment in Jakarta EE 10 servlet containers (Tomcat 10.1 / 11.0) using `CXFNonSpringJaxrsServlet`.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Service Architecture

The service consists of:
* **SEI (Service Endpoint Interface)**: `it.univaq.odws.maven.rest.greeting.Greeting` defining the HTTP methods and MIME contracts.
* **SIB (Service Implementation Bean)**: `it.univaq.odws.maven.rest.greeting.GreetingImpl` implementing the responses.
* **Deployment Descriptor**: `src/main/webapp/WEB-INF/web.xml` wiring `CXFNonSpringJaxrsServlet` at servlet path `/rest/*`.

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
* **Apache Tomcat 10.1 / 11.0**

### Build and Packaging

Run the following command in this directory:

```sh
mvn clean package
```

The build produces `target/GreetingRESTServiceMaven.war`.

### Deployment

Deploy `target/GreetingRESTServiceMaven.war` to Apache Tomcat:
1. Copy the WAR file to `$CATALINA_HOME/webapps/GreetingRESTServiceMaven.war`.
2. Start the Tomcat instance (`startup.bat` or `startup.sh`).
3. Or deploy via Eclipse using the **Tomcat v10.1 / v11.0 Server** runtime.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- USAGE -->
## Usage

Base URL: `http://localhost:8080/GreetingRESTServiceMaven/rest/greetingrestservice`

### Endpoints

| HTTP Method | Resource Sub-Path | Produced MIME Type | Description |
| :--- | :--- | :--- | :--- |
| `GET` | `/greeting_text_plain/{name}` | `text/plain` | Returns plain text representation |
| `GET` | `/greeting_text_html/{name}` | `text/html` | Returns HTML representation |
| `GET` | `/greeting_text_xml/{name}` | `text/xml` | Returns XML representation |
| `GET` | `?_wadl` | `application/vnd.sun.wadl+xml` | CXF auto-generated WADL description |

### cURL Examples

```sh
# Plain text
curl -i -H "Accept: text/plain" http://localhost:8080/GreetingRESTServiceMaven/rest/greetingrestservice/greeting_text_plain/Mario

# HTML format
curl -i -H "Accept: text/html" http://localhost:8080/GreetingRESTServiceMaven/rest/greetingrestservice/greeting_text_html/Mario

# XML format
curl -i -H "Accept: text/xml" http://localhost:8080/GreetingRESTServiceMaven/rest/greetingrestservice/greeting_text_xml/Mario

# Inspect WADL
curl -i http://localhost:8080/GreetingRESTServiceMaven/rest/greetingrestservice?_wadl
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
