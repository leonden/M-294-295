# Vote-App

A voting app in Java [Spring Boot](https://spring.io/) and [Angular](https://angular.io/).

---

## Content

- [Vote-App](#vote-app)
  - [Content](#content)
  - [Description](#description)
  - [Backend](#backend)
    - [Run](#run)
  - [Frontend](#frontend)
    - [Run](#run-1)
  - [GitHub](#github)

---

## Description

The system is capable of displaying results from multiple users in one election statistic. You can create several elections in which the users can make their entries. The elections, as well as the results, should refer to a database via a REST interface and be saved there.

Users can log in to the application via a login page. Elections and their results can be viewed without registration, but registration is mandatory in order to be able to take part in them.

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

### Run

From the root project directory, cd into `\frontend\vote-app\` and run `ng serve` for a dev server. Navigate to http://localhost:4200/. The application will automatically reload if you change any of the source files.

---

## GitHub

The application is saved in a [GitHub](https://github.com/leonden/vote-app) repository.

Feel free to fork the project to your local machine.

```shell
git clone https://github.com/leonden/vote-app.git
```

---
