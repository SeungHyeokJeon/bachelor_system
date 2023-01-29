# Backend

### Requirements

- Spring Boot 2.5.3
- Gradle 7.5.1
- TemurinJDK 17
- Postgresql 15

### Used Libraries

- `spring-boot-starter-web`
- `spring-boot-devtools`
- `spring-boot-starter-data-jpa` -> Java ORM Implementation
- `mariadb` -> DBMS
- `lombok` -> getter/setter 쉽게 적용
- `mapstruct` -> entity <-> dto 변환 적용
- `querydsl`
  - QueryDSL 적용전 반드시 Intellij 기준 Gradle-Tasks-other-compileJava 실행하여 Q클래스 생성해야함

### Project Structure

```plain text
src
└─── main
     ├─── java.com.example
     │    ├─── DemoApplication.java
     │    ├─── doamain1
     │    │    ├─── controller
     │    │    ├─── dto
     │    │    ├─── mapper
     │    │    └─── repository
     │    │         └─── custom
     │    │              └─── implementation
     │    │    └─── service
     │    │         └─── implementation
     │    └─── entities
     └─── resource
          └─── application.yml
```

### Implement Function

- CRUD
- pagination
