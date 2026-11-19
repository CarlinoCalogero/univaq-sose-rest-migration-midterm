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
  <h2 align="center">Eclipse Server Runtime Configurations</h2>

  <p align="center">
    Eclipse Web Tools Platform (WTP) runtime descriptors for Apache Tomcat 10.1 and 11.0.
    <br />
    <em>UNIVAQ &bull; Service-Oriented Software Engineering (SOSE) Midterm Exam</em>
    <br />
    <br />
    <a href="../README.md"><strong>« Back to Projects</strong></a>
    &middot;
    <a href="../../README.md"><strong>Repository Root</strong></a>
    <br />
    <br />
    <a href="#about-the-servers">About The Servers</a>
    &middot;
    <a href="#server-configurations">Server Configurations</a>
    &middot;
    <a href="#contributors">Contributors</a>
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-servers">About The Servers</a>
      <ul>
        <li><a href="#server-configurations">Server Configurations</a></li>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#importing-into-eclipse">Importing into Eclipse</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contributors">Contributors</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

<!-- ABOUT THE SERVERS -->
## About The Servers

This directory contains the **Eclipse Web Tools Platform (WTP)** server definitions and configuration files used to run, debug, and hot-deploy the migrated REST web services directly from the Eclipse IDE.

Because the project was migrated from legacy `javax.*` to modern `jakarta.*` (Jakarta EE 10), legacy application servers such as Apache Tomcat 8.5 or 9.0 are incompatible. This folder provides configurations for **Apache Tomcat 10.1** and **Apache Tomcat 11.0**.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Server Configurations

| Folder | Target Container | Jakarta EE Specification | HTTP Port | Notes |
| :--- | :--- | :--- | :--- | :--- |
| `Tomcat v10.1 Server at localhost-config/` | Apache Tomcat 10.1.x | Jakarta EE 10 (Servlet 6.0) | `8080` | Production-ready Jakarta EE 10 baseline |
| `Tomcat v11.0 Server at localhost-config/` | Apache Tomcat 11.0.x | Jakarta EE 11 (Servlet 6.1) | `8080` | Latest development and evaluation container |

Each configuration contains tailored versions of:
* `server.xml`: Configured HTTP/1.1 connector on port `8080` and AJP on `8009`.
* `context.xml`: Application context configuration.
* `web.xml`: Default container-level MIME types and servlet mappings.
* `catalina.properties` & `catalina.policy`: JVM security policies and classloader rules.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

* [![Apache Tomcat][Tomcat-badge]][Tomcat-url]
* [![Eclipse IDE][Eclipse-badge]][Eclipse-url]
* [![Jakarta EE][Jakarta-badge]][Jakarta-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

* **Eclipse IDE for Enterprise Java and Web Developers** (2024-03 or newer)
* A local installation of **Apache Tomcat 10.1.x** or **Tomcat 11.0.x**

### Importing into Eclipse

1. Launch Eclipse IDE.
2. Select **File &rarr; Open Projects from File System...**
3. Browse to `projects/Servers` (or the root workspace).
4. In Eclipse's **Servers** tab, ensure the Tomcat installation directory matches your local system paths.
5. Right-click the server &rarr; **Publish** to synchronize configuration files.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- USAGE -->
## Usage

1. Open the **Servers** tab in Eclipse.
2. Double-click the server instance to modify ports or timeout settings if needed.
3. Right-click the server &rarr; **Add and Remove...** to attach:
   * `GreetingRESTServiceMaven`
   * `SumRESTServiceMaven`
   * `AsyncGreetingsRESTServiceMaven`
4. Click **Start** (or **Debug**).

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTRIBUTORS -->
## Contributors

> [!NOTE]
> This folder is part of a university examination project for the University of L'Aquila. External contributions are not accepted.

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
* [Apache Tomcat](https://tomcat.apache.org/)
* [Eclipse Foundation](https://www.eclipse.org/)
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
[Jakarta-badge]: https://img.shields.io/badge/Jakarta_EE-10-F05032?style=for-the-badge&logo=eclipse&logoColor=white
[Jakarta-url]: https://jakarta.ee/
[Tomcat-badge]: https://img.shields.io/badge/Apache_Tomcat-10.1_%2F_11.0-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black
[Tomcat-url]: https://tomcat.apache.org/
[Eclipse-badge]: https://img.shields.io/badge/Eclipse_IDE-2024-2C2255?style=for-the-badge&logo=eclipseide&logoColor=white
[Eclipse-url]: https://www.eclipse.org/downloads/packages/
