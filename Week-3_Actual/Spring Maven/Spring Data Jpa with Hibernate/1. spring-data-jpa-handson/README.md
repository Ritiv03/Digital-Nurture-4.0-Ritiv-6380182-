
---

## 📘 Orm-Learn: Spring Data JPA + Hibernate + MySQL with Docker

This project demonstrates the use of **Spring Data JPA** and **Hibernate** with a MySQL database, running inside a **Docker container**, to perform various CRUD operations on a `Country` entity.

> 🧑‍💻 Developed as part of hands-on learning activities covering Hibernate XML and Annotation-based configuration, Spring Data JPA, and ORM principles.

---

## 📌 Objectives Covered

* ✅ Understand and explain the need and benefits of ORM.
* ✅ Use Spring Data JPA for ORM in a simplified way.
* ✅ Explore Hibernate core objects and architecture.
* ✅ Implement DML operations via Spring Data JPA.
* ✅ Perform CRUD operations on a `country` table.
* ✅ Integrate Spring Boot with MySQL running in Docker.

---

## ⚙️ Tech Stack

* Java 21
* Spring Boot 3.5.3
* Spring Data JPA
* Hibernate
* MySQL 8 (via Docker)
* Maven
* Eclipse IDE

---

## 🐳 Docker Setup for MySQL

Start a MySQL container using the command below:

```bash
docker run --name my-mysql \
  -e MYSQL_ROOT_PASSWORD=root \
  -e MYSQL_DATABASE=ormlearn \
  -p 3306:3306 \
  -d mysql:8
```

---

## 📂 Project Structure

```
src
├── main
│   ├── java
│   │   └── com.cognizant.orm_learn
│   │       ├── model (Country entity)
│   │       ├── repository (CountryRepository)
│   │       └── service (CountryService)
│   └── resources
│       └── application.properties
└── test
    └── java (test cases, if any)
```

---

## 📄 application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ormlearn
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# Logging
logging.level.org.springframework=info
logging.level.com.cognizant=debug
logging.level.org.hibernate.SQL=trace
logging.level.org.hibernate.type.descriptor.sql=trace
```

---

## 🛠 Features Implemented

### 1. Retrieve All Countries

* Method: `getAllCountries()`
* Repository: `findAll()`

### 2. Find Country by Code

* Method: `findCountryByCode(String code)`
* Uses `Optional` from `JpaRepository.findById()`

### 3. Add New Country

* Method: `addCountry(Country country)`
* Uses `JpaRepository.save()`

### 4. Update Country

* Method: `updateCountry(String code, String newName)`
* Fetches and modifies entity, then saves.

### 5. Delete Country

* Method: `deleteCountry(String code)`
* Uses `JpaRepository.deleteById()`

### 6. Partial Name Match (if implemented)

* Custom query method like `findByNameContaining(String name)`

---

## 🧾 Database Setup

### 🛢 Table Schema

```sql
CREATE TABLE country (
  co_code VARCHAR(2) PRIMARY KEY,
  co_name VARCHAR(50)
);
```

> Columns are mapped in the entity as `code` → `co_code`, and `name` → `co_name`.

### 📥 Sample Data Insert

```sql
INSERT INTO country (co_code, co_name) VALUES ('IN', 'India');
INSERT INTO country (co_code, co_name) VALUES ('US', 'United States of America');
-- Add the full country dataset as needed
```

---

## 🔬 Hibernate Concepts Covered

* SessionFactory, Session, Transaction
* `@Entity`, `@Table`, `@Id`, `@Column`, `@GeneratedValue`
* Hibernate XML Config vs Annotation-based Config
* DDL Auto Modes: `create`, `update`, `validate`, `create-drop`

---

## 🧪 Testing

Tests are performed within the `OrmLearnApplication` class using static method calls:

```java
ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
countryService = context.getBean(CountryService.class);
testGetAllCountries();
testFindCountryByCode();
testAddCountry();
testUpdateCountry();
testDeleteCountry();
```

---

## 📊 Learning Outcomes

* 📌 Understood the difference between JPA, Hibernate, and Spring Data JPA.
* 💡 Used Docker to simulate real-world deployment with containerized databases.
* 🔁 Performed all CRUD operations using clean, declarative Spring Data JPA methods.
* 🧼 Learned to minimize boilerplate code using repository patterns.

---

## 🔗 References

* [Spring Data JPA with MySQL](https://www.mkyong.com/spring-boot/spring-boot-spring-data-jpa-mysql-example/)
* [Hibernate Annotations](https://www.tutorialspoint.com/hibernate/hibernate_annotations.htm)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.5.3/reference/using/devtools.html)
* [ORM Explained](https://en.wikipedia.org/wiki/Object-relational_mapping)

---


