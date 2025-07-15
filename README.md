# 📝 Digital Diary App

A simple console-based digital diary application built using **Java `17**, **Hibernate ORM 7**, and **Jakarta Persistence 3.2** with **PostgreSQL** as the backend database.

---

## 🚀 Features

- Add diary entries with title, content, mood, tags, and date
- View all entries
- Search entries by:
  - Date
  - Mood
  - Keyword
- Update existing entries
- Delete entries
- Built using layered architecture (Entity, DAO, Service, App)

---

## 🛠 Technologies Used

- Java 17  
- Hibernate ORM 7.0.1.Final  
- Jakarta Persistence 3.2.0  
- PostgreSQL 15+  
- Maven for dependency management

---

## 📁 Project Structure
```
src/
├── main/
│ ├── java/
│ │ └── diary/
│ │ ├── App.java
│ │ ├── dao/
│ │ │ └── DiaryEntryDAO.java
│ │ ├── service/
│ │ │ └── DiaryService.java
│ │ └── entity/
│ │ └── DiaryEntry.java
│ └── resources/
│ └── META-INF/
│   └── persistence.xml
```
---

## 🛠️ Configure PostgreSQL

- Create a PostgreSQL database :diarydb
- Update `persistence.xml` located at `src/main/resources/META-INF/persistence.xml`:

```xml
<property name="jakarta.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/diarydb"/>
<property name="jakarta.persistence.jdbc.user" value="postgres"/>
<property name="jakarta.persistence.jdbc.password" value="12345"/>
```
---
## 🧩 Hibernate
Hibernate 7 as JPA provider

Configured via persistence.xml

Auto table creation: hibernate.hbm2ddl.auto = update

Logging disabled for cleaner output

---
## ⚙️ Build and Run
```
mvn clean install
mvn exec:java -Dexec.mainClass="diary.App"

```
---
## 👩‍💻 Contact
**Name:** Prerana Anand Nalawade  
**Email:** prerananalawade5@gmail.com  
**GitHub:** https://github.com/PreranaNalawade  
