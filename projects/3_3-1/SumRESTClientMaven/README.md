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
  <h2 align="center">SumRESTClientMaven</h2>

  <p align="center">
    Standalone Java REST Client consuming SumRESTServiceMaven using Apache CXF WebClient.
    <br />
    <em>Topic 3_3-1 &bull; Service-Oriented Software Engineering &bull; University of L'Aquila</em>
    <br />
    <br />
    <a href="../README.md"><strong>« Back to Topic 3_3-1</strong></a>
    &middot;
    <a href="../../../README.md"><strong>Repository Root</strong></a>
    <br />
    <br />
    <a href="#about-the-project">About The Project</a>
    &middot;
    <a href="#getting-started">Getting Started</a>
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
        <li><a href="#client-implementation">Client Implementation</a></li>
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

`SumRESTClientMaven` is a lightweight standalone Java client application demonstrating programmatic invocation of RESTful services in **Java 21** using **Apache CXF 4.1.1**'s `WebClient` API.

The client sends an HTTP `GET` request to `SumRESTServiceMaven`, negotiating a `text/plain` media type, reading the serialized integer response entity, and displaying the calculation in the console.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Client Implementation

The core logic located in `it.univaq.odws.maven.rest.sum.client.SumRESTClient`:

```java
public class SumRESTClient {
    private static final String endpoint = "http://localhost:8080/SumRESTServiceMaven/rest/";

    public static void main(String[] args) {
        WebClient client = WebClient.create(endpoint + "sumrestservice/sum?a=5&b=5");
        Response response = client.accept(MediaType.TEXT_PLAIN).get();

        String value = response.readEntity(String.class);
        System.out.println("The response is " + value);
    }
}
```

Key features:
* **Fluent API**: Builder-style invocation via `WebClient.create(...)`.
* **Header Negotiation**: Explicit request for `text/plain` using `.accept(MediaType.TEXT_PLAIN)`.
* **Entity Extraction**: Type-safe entity extraction via `response.readEntity(String.class)`.

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
* A running instance of **SumRESTServiceMaven** deployed on Tomcat at `http://localhost:8080/SumRESTServiceMaven`.

### Compilation

Compile the client:

```sh
mvn clean compile
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- USAGE -->
## Usage

Ensure the `SumRESTServiceMaven` web service is up and running on port 8080. Then execute the client class:

### Using Maven Exec Plugin
```sh
mvn exec:java -Dexec.mainClass="it.univaq.odws.maven.rest.sum.client.SumRESTClient"
```

### Expected Output
```text
The response is 10
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
