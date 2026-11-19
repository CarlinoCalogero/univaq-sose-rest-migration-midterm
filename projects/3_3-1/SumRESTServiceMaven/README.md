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
  <h2 align="center">SumRESTServiceMaven</h2>

  <p align="center">
    JAX-RS Synchronous Calculator Web Service demonstrating Query Parameters and Path Parameters.
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

`SumRESTServiceMaven` is a Maven-packaged Web Application Archive (WAR) implementing a synchronous mathematical addition web service via **Jakarta RESTful Web Services (JAX-RS)** and **Apache CXF 4.1.1** on **Java 21**.

The service provides a direct comparison between two primary styles of parameter transmission in RESTful APIs:
* **Query Parameters (`@QueryParam`)**: Useful for optional or filtered inputs where order is irrelevant (e.g., `?a=7&b=10` or `?b=10&a=7`).
* **Path Parameters (`@PathParam`)**: Useful when parameters represent hierarchical resource identities or required path elements (e.g., `/sum2/7/10`).

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Service Architecture

* **Service Interface**: `it.univaq.odws.maven.rest.sum.Sum` defining endpoints and annotations.
* **Service Implementation**: `it.univaq.odws.maven.rest.sum.SumImpl` performing the calculation and returning integer values serialized as `text/plain`.
* **Deployment Descriptor**: `src/main/webapp/WEB-INF/web.xml` deploying `CXFNonSpringJaxrsServlet` mapped to `/*` with root REST address `/rest`.

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

Package the application as a WAR:

```sh
mvn clean package
```

The resulting artifact is created at `target/SumRESTServiceMaven.war`.

### Deployment

1. Copy `target/SumRESTServiceMaven.war` into your Tomcat installation's `webapps/` directory.
2. Start Apache Tomcat (`bin/startup.bat` or `bin/startup.sh`).
3. Alternatively, add the project to the Tomcat server inside Eclipse IDE and start the server.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- USAGE -->
## Usage

Base URL: `http://localhost:8080/SumRESTServiceMaven/rest/sumrestservice`

### Endpoints

| HTTP Method | URI Pattern | Parameter Mechanism | Description | Example Request |
| :--- | :--- | :--- | :--- | :--- |
| `GET` | `/sum` | `@QueryParam("a")`, `@QueryParam("b")` | Adds two integer query parameters | `/sum?a=12&b=8` &rarr; `20` |
| `GET` | `/sum2/{a}/{b}` | `@PathParam("a")`, `@PathParam("b")` | Adds two integers embedded in the URI path | `/sum2/15/25` &rarr; `40` |
| `GET` | `?_wadl` | Query parameter | Generates WADL XML schema | `?_wadl` |

### cURL Examples

```sh
# 1. Query parameters
curl -i "http://localhost:8080/SumRESTServiceMaven/rest/sumrestservice/sum?a=7&b=10"

# 2. Query parameters (reversed order)
curl -i "http://localhost:8080/SumRESTServiceMaven/rest/sumrestservice/sum?b=10&a=7"

# 3. Path template parameters
curl -i http://localhost:8080/SumRESTServiceMaven/rest/sumrestservice/sum2/100/50

# 4. View service WADL contract
curl -i http://localhost:8080/SumRESTServiceMaven/rest/sumrestservice?_wadl
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
