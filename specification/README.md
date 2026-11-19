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
  <h2 align="center">Course Specifications & Lecture Slides</h2>

  <p align="center">
    Official University Exam Guidelines, Topic Allocations, and Presentation Slides.
    <br />
    <em>UNIVAQ &bull; Service-Oriented Software Engineering (SOSE) Midterm Exam</em>
    <br />
    <br />
    <a href="../README.md"><strong>« Back to Repository Root</strong></a>
    &middot;
    <a href="../projects/README.md"><strong>Explore Projects</strong></a>
    <br />
    <br />
    <a href="#about-the-specifications">About The Specifications</a>
    &middot;
    <a href="#group-allocation--assignment">Group Assignment</a>
    &middot;
    <a href="#contributors">Contributors</a>
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-specifications">About The Specifications</a>
      <ul>
        <li><a href="#academic-context">Academic Context</a></li>
        <li><a href="#materials-inventory">Materials Inventory</a></li>
      </ul>
    </li>
    <li><a href="#group-allocation--assignment">Group Allocation & Assignment</a></li>
    <li><a href="#migration-criteria">Migration Criteria</a></li>
    <li><a href="#contributors">Contributors</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

<!-- ABOUT THE SPECIFICATIONS -->
## About The Specifications

This directory holds the official course documents, evaluation guidelines, and lecture slide decks provided by **Prof. Marco Autili** for the **Service-Oriented Software Engineering (SOSE)** midterm examination at the **University of L'Aquila (UNIVAQ)**.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Academic Context

* **Institution**: University of L'Aquila (UNIVAQ) &mdash; Department of Information Engineering, Computer Science and Mathematics (DISIM)
* **Degree Program**: Master's Degree in Computer Science (Ingegneria del Software Avanzata)
* **Course**: Service-Oriented Software Engineering (SOSE)
* **Instructor**: Prof. Marco Autili
* **Session**: Midterm Exam &mdash; May 2025

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Materials Inventory

| File | Type | Description |
| :--- | :--- | :--- |
| `COMPULSORY MIDTERM TEST.pdf` | Document (PDF) | Official midterm exam rules, evaluation criteria, and presentation schedule. |
| `MIDTERM 2025 GROUP-TOPIC-TIMESLOT.docx` | Document (DOCX) | Group assignments, topics, room schedules, and slide distribution. |
| `3_3-1 - Developing REST WS with Apache CXF-Maven.pptx` | Slides (PPTX) | Lecture deck covering synchronous REST web service creation, JAX-RS annotations, and CXF WebClient. |
| `3_3-1 bis - Developing REST WS with Apache CXF-Maven and Asynch.pptx` | Slides (PPTX) | Lecture deck covering server-side asynchronous request processing and client-side async patterns. |

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GROUP ALLOCATION & ASSIGNMENT -->
## Group Allocation & Assignment

According to `MIDTERM 2025 GROUP-TOPIC-TIMESLOT.docx`:

* **Team**: **Group 1**
* **Presentation Timeslot**: Thursday, May 22nd, 2025 &mdash; 16:30&ndash;16:55 (Room Aula A1.3, DISIM)
* **Team Members**:
  * **Calogero Carlino**
  * **Luca Francesco Macera**
  * **Daniele Borgna**
* **Assigned Topic**: `MIGRATION`
* **Assigned Material**:
  * Slide Topic `3_3-1`: *Developing REST WS with Apache CXF-Maven*
  * Slide Topic `3_3-1 bis`: *Developing REST WS with Apache CXF-Maven and Asynch*

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MIGRATION CRITERIA -->
## Migration Criteria

The objective of the homework assignment was defined as:
> *"Migrating all the assigned slides and related examples to Java 21 / Jakarta 10 and the latest versions of all the frameworks used, e.g., swagger, apache cxf, jackson, maven plugin, etc."*

Key modernization objectives completed:
1. Transition all source code and dependencies from historical `javax.*` packages to standard **`jakarta.*`** (Jakarta EE 10).
2. Upgrade target bytecode and language level to **Java 21 LTS** (`21.0.6`).
3. Migrate Apache CXF to **CXF 4.1.1** with Jakarta EE 10 support.
4. Upgrade Apache Tomcat runtime to **Tomcat 10.1 / 11.0**.
5. Update all `pom.xml` descriptors with modern Maven plugins (`maven-compiler-plugin 3.14.0`).
6. Validate all four client-side asynchronous invocation patterns against the server-side `@Suspended` implementation.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTRIBUTORS -->
## Contributors

> [!NOTE]
> This folder documents academic coursework completed for the University of L'Aquila. The repository is archived and is not accepting contributions.

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

* **Prof. Marco Autili** &mdash; Course Lecturer, University of L'Aquila
* **University of L'Aquila (UNIVAQ)** &mdash; DISIM
* [Apache Software Foundation](https://www.apache.org/)
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
