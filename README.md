<img src="./public/votez_logo.png" width="50px" style="float: left; margin-right: 15px"/>

# votez

A voting app in Java [Spring Boot](https://spring.io/) and [Angular](https://angular.io/).

This project is related to the module [294](https://www.modulbaukasten.ch/module/294/1/de-DE?title=Frontend-einer-interaktiven-Webapplikation-realisieren) and [295](https://www.modulbaukasten.ch/module/295/1/de-DE?title=Backend-f%C3%BCr-Applikationen-realisieren) from the Swiss Education Ordinance in information technologies.

---

## Content

- [votez](#votez)
  - [Content](#content)
  - [Description](#description)
  - [GitHub](#github)
  - [Backend](#backend)
    - [Run](#run)
  - [Frontend](#frontend)
    - [Run](#run-1)
  - [Data](#data)
  - [Security](#security)
    - [Authentication](#authentication)
  - [Licensing](#licensing)

---

## Description

The system is capable of displaying results from multiple users in one election statistic. You can create several elections in which the users can make their entries. The elections, as well as the results, should refer to a database via a REST interface and be saved there.

Users can log in to the application via a login page. Elections and their results can be viewed without registration, but registration is mandatory in order to be able to take part in them.

---

## GitHub

The application is saved in a [GitHub](https://github.com/leonden/vote-app) repository.

Feel free to fork the project to your local machine.

```shell
git clone https://github.com/leonden/vote-app.git
```

---

## Backend

The backend is implemented in [Java](https://java.com) as a [Spring Boot](https://spring.io/) application.

### Run

Make sure you have Java 17 installed.

After cloning the repository to your local machine, you can cd into it. Then head to `\backend\vote-app` and run

```shell
mvn spring-boot:run
```

After running this command, you can head to http://localhost:8080 to see the API documentation in the local [Swagger](https://swagger.io/tools/swagger-ui/) UI.

---

## Frontend

The frontend is implemented in [TypeScript](https://typescriptlang.org/) as an [Angular](https://angular.io/) application.

For efficient development purposes, the app uses the [Angular Material](https://material.angular.io) component library from Google.

### Run

From the root project directory, cd into `\frontend\vote-app\` and run `ng serve` for a dev server. Navigate to http://localhost:4200/. The application will automatically reload if you change any of the source files.

---

## Data

Data is stored in a [PostgreSQL](https://www.postgresql.org/) database. For an easy usage and database integration, the app uses [Java JPA](https://www.ibm.com/docs/de/was-liberty/base?topic=overview-java-persistence-api-jpa).

---

## Security

### Authentication

The authentication process is made possible with [OAuth2](https://oauth.net/2/) and [Keycloak](https://www.keycloak.org/). Users are organized inside of the local Keycloak environment.

---

## Licensing

The entire project is [MIT](https://www.mit.edu/) licensed, which means, that anyone can use this project and its source code for personal purposes.
