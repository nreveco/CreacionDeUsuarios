﻿# Creation of Users

spring-boot-gradle-starter
==========================

#What is it?

Spring boot (http://projects.spring.io/spring-boot) is an interesting projetc, Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".

We take an opinionated view of the Spring platform and third-party libraries so you can get started with minimum fuss. Most Spring Boot applications need minimal Spring configuration.

If you’re looking for information about a specific version, or instructions about how to upgrade from an earlier release, check out the project release notes section on our wiki..

It is based on official https://spring.io/guides/gs/spring-boot but extended and configured to include a set of tool, that you are likely to use (Gradle 7.5+ or Maven 3.5+, etc.).

# How to run it?

If you have gradle installed and under linux/mac:

    gradle runJar

If gradle is not installed, but still under linux/mac

    gradlew runJar

And for windows without gradle

    gradlew.bat runJar

After the server is running, go to

```
http://localhost:8080/Api/v1/users/register
http://localhost:8080/Api/v1/users/find/{uuid}
```

The backend is done with
- Spring Boot v3.2.0
- Hibernate ORM core version 6.3.1
- Spring, Spring Data JPA
- Spring Starter Web
- Spring Starter Web Test
- Spring Doc
- Io Json Web Token
- Lombok
- Spring devtools
- H2 databases
- Junit.

There is embedded tomcat and embedded, in-memory h2 inside.

Backend is done with Java 17.