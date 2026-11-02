# Data model

[Français](DATA-MODEL.md) · **English**

Back to the [README](../README.en.md).

The `se.pidev.entities` package holds **24 JPA entities** and **10 enums**. Hibernate creates the tables at
startup (`spring.jpa.hibernate.ddl-auto=update`) in the `KinderGartenPIdevDataBase` MySQL database. The table
names below are the ones in the DDL generated during CI.

## Common rules

- **No JPA relationship** (`@OneToMany`, `@ManyToOne`…): every entity is a standalone table, with no foreign
  key.
- **Identifier**: a `Long` attribute generated with `GenerationType.IDENTITY` (`bigint auto_increment` column).
- **Types**: an attribute with no type given below is a `String` (`varchar(255)`); `Date` attributes
  (`java.util.Date`, no `@Temporal`) become `datetime` columns.
- **Enums**: stored by name (`@Enumerated(EnumType.STRING)`), in a `varchar(255)` column.
- **Column names**: Spring Boot's naming strategy lowercases names and inserts `_` at case changes
  (`Kindergarden_Matricule_Fiscale` → `kindergarden_matricule_fiscale`, table `T_BusDrivers` →
  `t_bus_drivers`). Three identifiers are renamed with `@Column`: `Appoinment_Id` → `appointment_id`,
  `Note_Id` → `notes_id`, `Post_Id` → `posts_id`.
- **Engine**: the `MySQL5Dialect` dialect creates MyISAM tables.
- **Exposure**: only `User` and `Meeting` have a Spring Data repository, a service and a REST controller. The
  API's JSON keys follow the accessors (`getUser_Email()` → `user_Email`, `getMeeting_Date()` → `meeting_Date`).

## Users and profiles

| Entity | Table | Attributes |
|---|---|---|
| `User` | `t_users` | `User_Id` (id), `User_Email`, `User_Password` |
| `Parent` | `t_parents` | `Parent_Id` (id), `Parent_First_name`, `Parent_Last_name`, `Parent_Adresse`, `Parent_Telephone`, `Parent_Cin`, `Parent_Date` |
| `Staff` | `t_staff` | `Staff_Id` (id), `Staff_First_name`, `Staff_Last_name`, `Staff_Adresse`, `Staff_Telephone`, `Staff_Cin`, `Staff_Date`, `role` (`Role`) |
| `KindergartenOwner` | `t_kindergarten_owners` | `KindergardenOwner_Id` (id) only |
| `Educator` | `t_educators` | `Educator_Id` (id) only |
| `Doctor` | `t_doctors` | `Doctor_Id` (id) only |
| `BusDriver` | `t_bus_drivers` | `BusDriver_Id` (id) only |

`Parent_Date` and `Staff_Date` are `String` values, not dates.

## Kindergarten life

| Entity | Table | Attributes |
|---|---|---|
| `Kindergarten` | `t_kindergartens` | `Kindergarden_Id` (id), `Kindergarden_name`, `kindergarden_adresse`, `Kindergarden_phone` (`Long`), `Kindergarden_Matricule_Fiscale`, `Kindergarden_Date` (`Date`), `Kindergarden_Email` |
| `Child` | `t_child` | `Child_ID` (id), `Child_F_name`, `Child_L_name`, `Child_Birth_Date` (`Date`), `Child_Adresse` |
| `Course` | `t_courses` | `Courses_ID` (id), `Courses_name`, `Courses_Details` |
| `Activity` | `t_activities` | `Activity_Id` (id), `Activity_Name`, `Activity_Type`, `Activity_Date_Begin` (`Date`), `Activity_Date_Finish` (`Date`), `Activity_Description`, `Activity_Image` |
| `Note` | `t_notes` | `Note_Id` (id), `Note_Creation_Date` (`Date`), `Note_Description`, `note_subject` (`Note_Subject`), `note_type` (`Note_Type`) |
| `Club` | `t_clubs` | `Club_Id` (id), `Club_Description`, `club_type` (`Club_Type`) |
| `Event` | `t_events` | `Event_Id` (id), `Event_Date_Begin` (`Date`), `Event_Date_Finish` (`Date`), `Event_Description`, `event_place` (`Event_Place`), `event_type` (`Event_Type`) |

## Communication

| Entity | Table | Attributes |
|---|---|---|
| `Meeting` | `t_meetings` | `Meeting_Id` (id), `Meeting_Topic`, `Meeting_Duration` (`Long`), `Meeting_Location`, `Meeting_Details`, `Meeting_Date` (`Date`) |
| `Appointment` | `t_appointments` | `Appoinment_Id` (id), `Appoinment_Date` (`Date`), `Appoinment_Subject`, `appoitnment_place` (`Appointment_Place`), `appoitnment_type` (`Appoitnment_Type`) |
| `Notification` | `t_notifications` | `Notification_Id` (id), `Notification_Date` (`Date`), `Notification_Text`, `Notification_Type` |
| `Chat` | `t_chat` | `Chat_Id` (id), `Chat_Text`, `Chat_Date` (`Date`) |
| `Forum` | `t_forums` | `Forum_Id` (id), `Forum_Subject`, `Forum_Date_Creation` (`Date`) |
| `Post` | `t_posts` | `Post_Id` (id), `Post_Date` (`Date`), `Post_Description`, `post_Title` |
| `Comment` | `t_comments` | `Comment_Id` (id), `Comment_Date` (`Date`), `Comment_text` |

## Services

| Entity | Table | Attributes |
|---|---|---|
| `Path` (school bus route) | `t_paths` | `Itinarary_Id` (id), `Itinarary_Bus_Ref`, `Itinarary_Place_Number` (`int`), `path_from` (`Path_From`), `path_to` (`Path_To`) |
| `Claim` (complaint) | `t_claims` | `Claims_Id` (id), `Claims_Description`, `Claims_Date` (`Date`), `Claims_image`, `Claims_Type` |
| `Satisfaction` (satisfaction feedback) | `t_satisfactions` | `Satisfaction_Id` (id), `Satisfaction_Date` (`Date`), `Satisfaction_Text` |

## Enums

Values are reproduced exactly as they are spelled in the code.

| Enum | Values | Used by |
|---|---|---|
| `Role` | `DOCTOR`, `EDUCATOR`, `BUSDRIVER`, `KINDERGARDEN_OWNER` | `Staff.role` |
| `Appointment_Place` | `DOCTOR_OFFICE`, `ADMINISTRATION_OFFICE`, `DEAN_OFFICE`, `EDUCATOR_OFFICE`, `OTHER` | `Appointment.appoitnment_place` |
| `Appoitnment_Type` | `MEDICAL`, `EDUCATIF`, `ADMINISTRATIF`, `SPORTIF`, `FINANCIAL`, `OTHER` | `Appointment.appoitnment_type` |
| `Club_Type` | `COMEDY`, `EDUCATIF`, `MUSICAL`, `SPORTS`, `TECHNOLOGIE`, `OTHER` | `Club.club_type` |
| `Event_Place` | `KINDERGARDEN`, `OTHER` | `Event.event_place` |
| `Event_Type` | `PARTY`, `COMMEDY`, `EDUCATIF`, `MUSICAL`, `SPORTIF`, `COMETITION`, `TECHNOLOGIE`, `OTHER` | `Event.event_type` |
| `Note_Subject` | `PSYCHOLOGY`, `CRONICAL_ILNESS`, `ORTHOPEDIST`, `PEDIATRIE`, `OTHER` | `Note.note_subject` |
| `Note_Type` | same values as `Note_Subject` | `Note.note_type` |
| `Path_From` | `ADRESSE_CHILD`, `KINDERGARDEN`, `OTHER` | `Path.path_from` |
| `Path_To` | `ADRESSE_CHILD`, `KINDERGARDEN`, `OTHER` | `Path.path_to` |

## Migrations and data

No migration tool (Flyway, Liquibase): the schema follows the entities at every startup (`ddl-auto=update`,
which adds tables and columns without removing existing ones). The repository ships no demo data.
