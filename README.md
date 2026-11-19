<a id="readme-top"></a>

<!-- PROJECT SHIELDS -->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<!-- PROJECT HEADER (NO LOGO) -->
<br />
<div align="center">
  <h2 align="center">UNIVAQ SOSE &mdash; REST Web Services Migration & Modernization</h2>

  <p align="center">
    Comprehensive migration of legacy Apache CXF RESTful Web Services examples to <strong>Java 21</strong>, <strong>Jakarta EE 10</strong>, <strong>Apache CXF 4.1.1</strong>, and <strong>Apache Tomcat 10.1 / 11.0</strong>.
    <br />
    <em>Academic Midterm Project &mdash; Service-Oriented Software Engineering (SOSE) &bull; University of L'Aquila (UNIVAQ)</em>
    <br />
    <br />
    <a href="#about-the-project"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="#usage">View Examples</a>
    &middot;
    <a href="https://github.com/CarlinoCalogero/univaq-sose-rest-migration-midterm/issues">Report Issue</a>
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
        <li><a href="#migration-highlights">Migration Highlights</a></li>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li><a href="#repository-structure">Repository Structure</a></li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation--build">Installation & Build</a></li>
        <li><a href="#server-deployment">Server Deployment</a></li>
      </ul>
    </li>
    <li>
      <a href="#usage">Usage</a>
      <ul>
        <li><a href="#topic-3_3-1-synchronous-rest-services">Topic 3_3-1: Synchronous REST Services</a></li>
        <li><a href="#topic-3_3-1-bis-asynchronous-rest-services">Topic 3_3-1 bis: Asynchronous REST Services</a></li>
      </ul>
    </li>
    <li><a href="#contributors">Contributors</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project

This repository hosts the academic midterm project for the **Service-Oriented Software Engineering (SOSE)** course (M.Sc. in Computer Science &mdash; Advanced Software Engineering) at the **University of L'Aquila (UNIVAQ)**, taught by **Prof. Marco Autili** (Academic Year 2024/2025).

The assignment task (**Group 1: MIGRATION**) required modernizing the legacy lecture demonstrations and slide exercises from the historical Java SE 8 / `javax.*` / Tomcat 8.5&ndash;9.0 ecosystem up to modern enterprise standards: **Java 21 LTS**, **Jakarta EE 10** (`jakarta.*`), **Apache CXF 4.1.1**, **Jakarta Servlet 6.1.0 / JAX-RS 4.0**, and **Apache Tomcat 10.1 / 11.0**.

The repository encompasses two complete slide topics:
1. **Topic 3_3-1 &mdash; Developing REST WS with Apache CXF & Maven**:
   - Fundamental JAX-RS resource design using annotations (`@Path`, `@GET`, `@Produces`, `@PathParam`, `@QueryParam`).
   - Multiple MIME representation handling (`text/plain`, `text/html`, `text/xml`).
   - Client-side invocation using Apache CXF `WebClient`.
2. **Topic 3_3-1 bis &mdash; Developing Asynchronous REST WS with Apache CXF & Maven**:
   - Server-side asynchronous processing via `@Suspended AsyncResponse`, freeing container threads during long-running background tasks.
   - Comprehensive client-side invocation models:
     - Asynchronous invocation with blocking polling (`Future.get()`).
     - Asynchronous invocation with non-blocking status polling (`Future.isDone()`).
     - Asynchronous invocation with event callbacks (`InvocationCallback<Response>`).
     - Standard synchronous blocking invocation for behavioral contrast.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Migration Highlights

| Dimension | Legacy Slide Baseline | Migrated Modern Stack |
| :--- | :--- | :--- |
| **Java Platform** | Java SE 8 (`source 1.8`) | **Java SE 21 LTS** (`21.0.6`) |
| **Enterprise Standard** | Java EE 7 / 8 (`javax.ws.rs.*`, `javax.servlet.*`) | **Jakarta EE 10** (`jakarta.ws.rs.*`, `jakarta.servlet.*`) |
| **REST Framework** | Apache CXF 3.3.7 / 3.5.5 | **Apache CXF 4.1.1** (Jakarta-native) |
| **Servlet Specification** | Servlet 3.1 / 4.0 | **Jakarta Servlet API 6.1.0** / **JAX-RS API 4.0.0** |
| **Servlet Container** | Apache Tomcat 8.5.58 / 9.0.73 | **Apache Tomcat 10.1 / 11.0** (Jakarta EE 10 compliant) |
| **Deployment Descriptor** | `web-app_4_0.xsd` (jcp.org) | `web-app_5_0.xsd` / `web-app_6_0.xsd` (`jakarta.ee`) with `<async-supported>true</async-supported>` |
| **Build System** | Maven Compiler Plugin legacy | **Apache Maven 3.9+** & `maven-compiler-plugin 3.14.0` |

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

* [![Java][Java-badge]][Java-url]
* [![Jakarta EE][Jakarta-badge]][Jakarta-url]
* [![Apache CXF][CXF-badge]][CXF-url]
* [![Apache Tomcat][Tomcat-badge]][Tomcat-url]
* [![Apache Maven][Maven-badge]][Maven-url]
* [![Eclipse IDE][Eclipse-badge]][Eclipse-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- REPOSITORY STRUCTURE -->
## Repository Structure

```text
univaq-sose-rest-migration-midterm/
├── BLANK_README.md               # Upstream README template
├── README.md                     # Main repository documentation (this file)
├── site.json                     # Developer portfolio & biographical metadata
├── projects/                     # Source modules and Eclipse runtime configurations
│   ├── README.md                 # Projects overview documentation
│   ├── 3_3-1/                    # Slide 3_3-1: Synchronous REST Web Services
│   │   ├── README.md             # Overview for topic 3_3-1
│   │   ├── GreetingRESTServiceMaven/ # WAR service producing text, html, and xml
│   │   ├── SumRESTServiceMaven/      # WAR service computing sums with query & path params
│   │   ├── SumRESTClientMaven/       # Standalone Java client using CXF WebClient
│   │   └── Servers/              # Eclipse Tomcat 11.0 local server configuration
│   ├── 3_3-1 bis/                # Slide 3_3-1 bis: Asynchronous REST Web Services
│   │   ├── README.md             # Overview for topic 3_3-1 bis
│   │   ├── AsyncGreetingsRESTServiceMaven/ # WAR service with server-side @Suspended AsyncResponse
│   │   ├── AsyncGreetingsRESTClientMaven/  # Java client demonstrating 4 async/sync patterns
│   │   └── Servers/              # Eclipse Tomcat 11.0 local server configuration
│   └── Servers/                  # Root Eclipse WTP Tomcat 10.1 & 11.0 server configs
│       └── README.md             # Server configurations documentation
└── specification/                # University assignment slides and guidelines
    ├── README.md                 # Documentation of midterm requirements & slides
    ├── 3_3-1 - Developing REST WS with Apache CXF-Maven.pptx
    ├── 3_3-1 bis - Developing REST WS with Apache CXF-Maven and Asynch.pptx
    ├── COMPULSORY MIDTERM TEST.pdf
    └── MIDTERM 2025 GROUP-TOPIC-TIMESLOT.docx
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

Follow the instructions below to get a local copy built and deployed.

### Prerequisites

Ensure the following tools are installed on your operating system:
* **Java Development Kit (JDK) 21 LTS** or later:
  ```sh
  java -version
  # openjdk version "21.0.6" or similar
  ```
* **Apache Maven 3.9+**:
  ```sh
  mvn -version
  ```
* **Apache Tomcat 10.1.x** or **Tomcat 11.0.x** (Jakarta EE 10+ compatible; Tomcat 9 and older will fail due to the `javax` to `jakarta` package change):
  ```sh
  catalina version
  ```
* **Eclipse IDE for Enterprise Java and Web Developers** (2024-03 or newer recommended) or your preferred IDE.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Installation & Build

1. Clone the repository:
   ```sh
   git clone https://github.com/CarlinoCalogero/univaq-sose-rest-migration-midterm.git
   cd univaq-sose-rest-migration-midterm
   ```

2. Build all web services and clients using Maven:

   * **Greeting REST Service (3_3-1)**:
     ```sh
     cd "projects/3_3-1/GreetingRESTServiceMaven"
     mvn clean package
     cd ../../..
     ```

   * **Sum REST Service (3_3-1)**:
     ```sh
     cd "projects/3_3-1/SumRESTServiceMaven"
     mvn clean package
     cd ../../..
     ```

   * **Sum REST Client (3_3-1)**:
     ```sh
     cd "projects/3_3-1/SumRESTClientMaven"
     mvn clean package
     cd ../../..
     ```

   * **Async Greeting REST Service (3_3-1 bis)**:
     ```sh
     cd "projects/3_3-1 bis/AsyncGreetingsRESTServiceMaven"
     mvn clean package
     cd ../../..
     ```

   * **Async Greeting REST Client (3_3-1 bis)**:
     ```sh
     cd "projects/3_3-1 bis/AsyncGreetingsRESTClientMaven"
     mvn clean package
     cd ../../..
     ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Server Deployment

You can deploy the generated `.war` artifacts either through Eclipse WTP or directly into a standalone Tomcat instance:

#### Option A: Standalone Apache Tomcat 10.1 / 11.0
1. Copy the packaged WAR files from their respective `target/` directories into your Tomcat `webapps/` folder:
   * `projects/3_3-1/GreetingRESTServiceMaven/target/GreetingRESTServiceMaven.war`
   * `projects/3_3-1/SumRESTServiceMaven/target/SumRESTServiceMaven.war`
   * `projects/3_3-1 bis/AsyncGreetingsRESTServiceMaven/target/AsyncGreetingsRESTServiceMaven.war`
2. Start Tomcat:
   ```sh
   # Windows
   bin\startup.bat
   # Linux/macOS
   bin/startup.sh
   ```

#### Option B: Eclipse IDE for Enterprise Java Developers
1. Open Eclipse and set the workspace to `projects/3_3-1` or `projects/3_3-1 bis` (or import them as Existing Maven Projects).
2. Configure an Apache Tomcat v10.1 or v11.0 Server runtime in the **Servers** view.
3. Right-click the server &rarr; **Add and Remove...** &rarr; add the service projects &rarr; **Finish**.
4. Start the server.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- USAGE EXAMPLES -->
## Usage

### Topic 3_3-1: Synchronous REST Services

#### 1. Greeting REST Service
Deployed under context `/GreetingRESTServiceMaven/rest/greetingrestservice`:

* **Plain Text Representation**:
  ```sh
  curl -i -H "Accept: text/plain" http://localhost:8080/GreetingRESTServiceMaven/rest/greetingrestservice/greeting_text_plain/Calogero
  ```
  _Response:_ `<h1>hello Calogero</h1>` (Content-Type: `text/plain`)

* **HTML Representation**:
  ```sh
  curl -i -H "Accept: text/html" http://localhost:8080/GreetingRESTServiceMaven/rest/greetingrestservice/greeting_text_html/Calogero
  ```
  _Response:_ `<h1>hello Calogero</h1>` (Content-Type: `text/html`)

* **XML Representation**:
  ```sh
  curl -i -H "Accept: text/xml" http://localhost:8080/GreetingRESTServiceMaven/rest/greetingrestservice/greeting_text_xml/Calogero
  ```
  _Response:_ `<?xml version="1.0" encoding="UTF-8"?><greeting>hello Calogero</greeting>` (Content-Type: `text/xml`)

* **WADL Contract Description**:
  ```sh
  curl -i http://localhost:8080/GreetingRESTServiceMaven/rest/greetingrestservice?_wadl
  ```

#### 2. Sum REST Service
Deployed under context `/SumRESTServiceMaven/rest/sumrestservice`:

* **Using Query Parameters** (`/sum?a={a}&b={b}`):
  ```sh
  curl -i "http://localhost:8080/SumRESTServiceMaven/rest/sumrestservice/sum?a=5&b=7"
  ```
  _Response:_ `12`

* **Using Path Parameters** (`/sum2/{a}/{b}`):
  ```sh
  curl -i http://localhost:8080/SumRESTServiceMaven/rest/sumrestservice/sum2/10/25
  ```
  _Response:_ `35`

* **WADL Contract Description**:
  ```sh
  curl -i http://localhost:8080/SumRESTServiceMaven/rest/sumrestservice?_wadl
  ```

#### 3. Sum REST Client
Run the client with Maven:
```sh
cd "projects/3_3-1/SumRESTClientMaven"
mvn exec:java -Dexec.mainClass="it.univaq.odws.maven.rest.sum.client.SumRESTClient"
```
_Output:_
```text
The response is 10
```

---

### Topic 3_3-1 bis: Asynchronous REST Services

#### 1. Asynchronous Greeting Service
The service method suspends the incoming HTTP connection and processes the response inside a worker thread with a simulated 5-second computation delay:
```sh
curl -i http://localhost:8080/AsyncGreetingsRESTServiceMaven/rest/greetings-rest-service-async/say-hello/Calogero
```
_Response (after ~5s):_ `Hello Calogero !`

#### 2. Asynchronous Greeting Client
Run the multi-pattern asynchronous client:
```sh
cd "projects/3_3-1 bis/AsyncGreetingsRESTClientMaven"
mvn exec:java -Dexec.mainClass="it.univaq.odws.maven.rest.greeting.client.AsyncGreetingClient"
```

The client source code demonstrates four invocation mechanisms:
1. `callServiceWithBlockingPolling()` &mdash; Invocates asynchronously via `request().async().get()`, then blocks on `Future.get()`.
2. `callServiceWithNonBlockingPolling()` &mdash; Checks `!futureResponse.isDone()` in a loop, allowing the client to execute other tasks while awaiting the response.
3. `callServiceWithNonBlockingPollingUsingCallback()` &mdash; Registers an `InvocationCallback<Response>` instance to receive completion or failure events asynchronously.
4. `callServiceWithNoPolling()` &mdash; Traditional synchronous request via `request().get()`.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTRIBUTORS -->
## Contributors

> [!NOTE]
> This repository represents a completed university midterm examination project for the **Service-Oriented Software Engineering** course at the **University of L'Aquila**. It is preserved in an archived, read-only state for academic showcase and reference purposes. External pull requests, issues, and contributions are not accepted.

Special recognition to the project authors and group members who contributed to the migration:

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

* **Prof. Marco Autili** &mdash; Professor of Service-Oriented Software Engineering, University of L'Aquila
* **University of L'Aquila (UNIVAQ)** &mdash; Department of Information Engineering, Computer Science and Mathematics (DISIM)
* [Apache CXF](https://cxf.apache.org/) &mdash; Open source enterprise services framework
* [Jakarta EE](https://jakarta.ee/) &mdash; Cloud Native Java Standards
* [Apache Tomcat](https://tomcat.apache.org/) &mdash; Open source implementation of Jakarta Servlet specification
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
