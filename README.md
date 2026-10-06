# Social Network for Parents & Kindergartens — Spring Boot backend

Integrated engineering project (PIDEV, ESPRIT, 2021). A **Spring Boot REST backend** for a social
platform connecting parents, kindergartens and their staff: children follow-up, meetings and
appointments, events, clubs, school bus paths, forum posts, chat, claims and satisfaction surveys.

## Tech stack

- Java 8, Spring Boot 2.4 (Web, Data JPA / Hibernate, Web Services, DevTools)
- MySQL
- Maven, JUnit 4

## Domain model (30+ JPA entities)

| Area | Entities |
|---|---|
| Users & roles | `User`, `Role`, `Parent`, `KindergartenOwner`, `Educator`, `Doctor`, `Staff`, `BusDriver` |
| Kindergarten life | `Kindergarten`, `Child`, `Course`, `Activity`, `Note`, `Club`, `Event` |
| Communication | `Meeting`, `Appointment`, `Notification`, `Chat`, `Forum`, `Post`, `Comment` |
| Services | `Path` (bus routes), `Claim`, `Satisfaction` |

## REST API (implemented modules)

| Method | Path | Description |
|---|---|---|
| GET | `/retrieve-all-meetings` | List meetings |
| GET | `/retrieve-meeting/{meeting-id}` | Get a meeting |
| POST | `/add-meeting` | Create a meeting |
| PUT | `/modify-meeting` | Update a meeting |
| DELETE | `/remove-meeting/{meeting-id}` | Delete a meeting |
| GET | `/retrieve-all-users` | List users |
| GET | `/retrieve-user/{user-id}` | Get a user |
| POST | `/add-user` | Create a user |
| PUT | `/modify-user` | Update a user |
| DELETE | `/remove-user/{user-id}` | Delete a user |

Layered architecture: `entities` → `repositories` (Spring Data JPA) → `services` → `controls` (REST controllers),
with JUnit tests for the user and meeting services.

## Run

```bash
cd SocialNetwork-ParentsKindergartens
# MySQL running on localhost:3306 — see src/main/resources/application.properties
./mvnw spring-boot:run
```

## Author

**Rached Chakchouk** — Full Stack Software Engineer (Java / Spring Boot / Angular)
[LinkedIn](https://www.linkedin.com/in/rached-chakchouk) · [Portfolio](https://rached-chakchouk.netlify.app)
