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
  <h2 align="center">Migrated REST Web Services & Clients</h2>

  <p align="center">
    Source modules and Eclipse workspace runtimes migrated to Java 21, Jakarta EE 10, and Apache CXF 4.1.1.
    <br />
    <em>Part of the UNIVAQ Service-Oriented Software Engineering (SOSE) Midterm Exam</em>
    <br />
    <br />
    <a href="../README.md"><strong>« Back to Repository Root</strong></a>
    <br />
    <br />
    <a href="#projects-overview">Projects Overview</a>
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
      <a href="#about-the-projects">About The Projects</a>
      <ul>
        <li><a href="#projects-overview">Projects Overview</a></li>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#batch-build-all-projects">Batch Build All Projects</a></li>
      </ul>
    </li>
    <li><a href="#module-links">Module Links</a></li>
    <li><a href="#contributors">Contributors</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECTS -->
## About The Projects

This folder contains all the source code artifacts, web application archives (WAR), and standalone client programs developed and migrated for the **Service-Oriented Software Engineering (SOSE)** midterm test at the **University of L'Aquila (UNIVAQ)**.

All projects have been upgraded from the historical Java 8 / `javax.*` baseline into modern **Java 21 LTS**, **Jakarta EE 10**, **Apache CXF 4.1.1**, and configured for deployment onto **Apache Tomcat 10.1 / 11.0**.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Projects Overview

| Directory | Type | Artifact | Description |
| :--- | :--- | :--- | :--- |
| [`3_3-1/GreetingRESTServiceMaven`](./3_3-1/GreetingRESTServiceMaven) | Web Service (WAR) | `GreetingRESTServiceMaven.war` | Demonstrates `@PathParam` and multi-format content negotiation (`text/plain`, `text/html`, `text/xml`). |
| [`3_3-1/SumRESTServiceMaven`](./3_3-1/SumRESTServiceMaven) | Web Service (WAR) | `SumRESTServiceMaven.war` | Demonstrates query parameter (`@QueryParam`) and URI path template (`@PathParam`) arithmetic operations. |
| [`3_3-1/SumRESTClientMaven`](./3_3-1/SumRESTClientMaven) | Java Client (JAR) | `SumRESTClientMaven` | Standalone client utilizing CXF `WebClient` to invoke the `SumRESTServiceMaven` endpoints. |
| [`3_3-1 bis/AsyncGreetingsRESTServiceMaven`](./3_3-1%20bis/AsyncGreetingsRESTServiceMaven) | Web Service (WAR) | `AsyncGreetingsRESTServiceMaven.war` | Server-side asynchronous processing via `@Suspended AsyncResponse` running long operations in worker threads. |
| [`3_3-1 bis/AsyncGreetingsRESTClientMaven`](./3_3-1%20bis/AsyncGreetingsRESTClientMaven) | Java Client (JAR) | `AsyncGreetingsRESTClientMaven` | Demonstrates 4 invocation patterns: blocking future polling, non-blocking polling loop, callback handler, and synchronous call. |
| [`Servers/`](./Servers) | Configuration | Server Metadata | Eclipse Web Tools Platform (WTP) runtime configurations for Apache Tomcat 10.1 and Tomcat 11.0. |

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

* [![Java][Java-badge]][Java-url]
* [![Jakarta EE][Jakarta-badge]][Jakarta-url]
* [![Apache CXF][CXF-badge]][CXF-url]
* [![Apache Tomcat][Tomcat-badge]][Tomcat-url]
* [![Apache Maven][Maven-badge]][Maven-url]
* [![Eclipse IDE][Eclipse-badge]][Eclipse-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

* **JDK 21 LTS** (`java -version`)
* **Apache Maven 3.9+** (`mvn -version`)
* **Apache Tomcat 10.1.x / 11.0.x** (Jakarta EE 10+ compatible)
* **Eclipse IDE for Enterprise Java and Web Developers** (2024-03+)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Batch Build All Projects

To compile and package every module from PowerShell:

```powershell
Get-ChildItem -Recurse -Filter "pom.xml" | ForEach-Object {
    Write-Host "Building $($_.DirectoryName)..." -ForegroundColor Cyan
    Push-Location $_.DirectoryName
    mvn clean package -DskipTests
    Pop-Location
}
```

Or using Bash:
```sh
find . -name "pom.xml" -execdir mvn clean package -DskipTests \;
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MODULE LINKS -->
## Module Links

* [Slide 3_3-1: Developing Synchronous REST WS](./3_3-1/README.md)
  * [GreetingRESTServiceMaven](./3_3-1/GreetingRESTServiceMaven/README.md)
  * [SumRESTServiceMaven](./3_3-1/SumRESTServiceMaven/README.md)
  * [SumRESTClientMaven](./3_3-1/SumRESTClientMaven/README.md)
* [Slide 3_3-1 bis: Developing Asynchronous REST WS](./3_3-1%20bis/README.md)
  * [AsyncGreetingsRESTServiceMaven](./3_3-1%20bis/AsyncGreetingsRESTServiceMaven/README.md)
  * [AsyncGreetingsRESTClientMaven](./3_3-1%20bis/AsyncGreetingsRESTClientMaven/README.md)
* [Eclipse Server Configurations](./Servers/README.md)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTRIBUTORS -->
## Contributors

> [!NOTE]
> This repository is a completed university project for the Service-Oriented Software Engineering course at the University of L'Aquila. It is maintained as an academic showcase; external contributions and pull requests are not accepted.

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
* **University of L'Aquila (UNIVAQ)** &mdash; Department of Information Engineering, Computer Science and Mathematics (DISIM)
* [Apache CXF](https://cxf.apache.org/)
* [Jakarta EE](https://jakarta.ee/)
* [Apache Tomcat](https://tomcat.apache.org/)
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
