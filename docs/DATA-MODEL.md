# Modèle de données

**Français** · [English](DATA-MODEL.en.md)

Retour au [README](../README.md).

Le paquet `se.pidev.entities` contient **24 entités JPA** et **10 énumérations**. Hibernate crée les tables au
démarrage (`spring.jpa.hibernate.ddl-auto=update`) dans la base MySQL `KinderGartenPIdevDataBase`. Les noms de
tables ci-dessous sont ceux du DDL généré lors de la CI.

## Règles communes

- **Aucune relation JPA** (`@OneToMany`, `@ManyToOne`…) : chaque entité est une table indépendante, sans clé
  étrangère.
- **Identifiant** : attribut `Long` généré par `GenerationType.IDENTITY` (colonne `bigint auto_increment`).
- **Types** : un attribut sans type indiqué ci-dessous est une `String` (`varchar(255)`) ; les attributs `Date`
  (`java.util.Date`, sans `@Temporal`) deviennent des colonnes `datetime`.
- **Énumérations** : stockées par leur nom (`@Enumerated(EnumType.STRING)`), dans une colonne `varchar(255)`.
- **Noms de colonnes** : la stratégie de nommage de Spring Boot met les noms en minuscules et insère `_` aux
  changements de casse (`Kindergarden_Matricule_Fiscale` → `kindergarden_matricule_fiscale`, table
  `T_BusDrivers` → `t_bus_drivers`). Trois identifiants sont renommés par `@Column` : `Appoinment_Id` →
  `appointment_id`, `Note_Id` → `notes_id`, `Post_Id` → `posts_id`.
- **Moteur** : le dialecte `MySQL5Dialect` crée des tables MyISAM.
- **Exposition** : seules `User` et `Meeting` ont un dépôt Spring Data, un service et un contrôleur REST. Les
  clés JSON de l'API suivent les accesseurs (`getUser_Email()` → `user_Email`, `getMeeting_Date()` →
  `meeting_Date`).

## Utilisateurs et profils

| Entité | Table | Attributs |
|---|---|---|
| `User` | `t_users` | `User_Id` (id), `User_Email`, `User_Password` |
| `Parent` | `t_parents` | `Parent_Id` (id), `Parent_First_name`, `Parent_Last_name`, `Parent_Adresse`, `Parent_Telephone`, `Parent_Cin`, `Parent_Date` |
| `Staff` | `t_staff` | `Staff_Id` (id), `Staff_First_name`, `Staff_Last_name`, `Staff_Adresse`, `Staff_Telephone`, `Staff_Cin`, `Staff_Date`, `role` (`Role`) |
| `KindergartenOwner` | `t_kindergarten_owners` | `KindergardenOwner_Id` (id) uniquement |
| `Educator` | `t_educators` | `Educator_Id` (id) uniquement |
| `Doctor` | `t_doctors` | `Doctor_Id` (id) uniquement |
| `BusDriver` | `t_bus_drivers` | `BusDriver_Id` (id) uniquement |

`Parent_Date` et `Staff_Date` sont des `String`, pas des dates.

## Vie du jardin d'enfants

| Entité | Table | Attributs |
|---|---|---|
| `Kindergarten` | `t_kindergartens` | `Kindergarden_Id` (id), `Kindergarden_name`, `kindergarden_adresse`, `Kindergarden_phone` (`Long`), `Kindergarden_Matricule_Fiscale`, `Kindergarden_Date` (`Date`), `Kindergarden_Email` |
| `Child` | `t_child` | `Child_ID` (id), `Child_F_name`, `Child_L_name`, `Child_Birth_Date` (`Date`), `Child_Adresse` |
| `Course` | `t_courses` | `Courses_ID` (id), `Courses_name`, `Courses_Details` |
| `Activity` | `t_activities` | `Activity_Id` (id), `Activity_Name`, `Activity_Type`, `Activity_Date_Begin` (`Date`), `Activity_Date_Finish` (`Date`), `Activity_Description`, `Activity_Image` |
| `Note` | `t_notes` | `Note_Id` (id), `Note_Creation_Date` (`Date`), `Note_Description`, `note_subject` (`Note_Subject`), `note_type` (`Note_Type`) |
| `Club` | `t_clubs` | `Club_Id` (id), `Club_Description`, `club_type` (`Club_Type`) |
| `Event` | `t_events` | `Event_Id` (id), `Event_Date_Begin` (`Date`), `Event_Date_Finish` (`Date`), `Event_Description`, `event_place` (`Event_Place`), `event_type` (`Event_Type`) |

## Communication

| Entité | Table | Attributs |
|---|---|---|
| `Meeting` | `t_meetings` | `Meeting_Id` (id), `Meeting_Topic`, `Meeting_Duration` (`Long`), `Meeting_Location`, `Meeting_Details`, `Meeting_Date` (`Date`) |
| `Appointment` | `t_appointments` | `Appoinment_Id` (id), `Appoinment_Date` (`Date`), `Appoinment_Subject`, `appoitnment_place` (`Appointment_Place`), `appoitnment_type` (`Appoitnment_Type`) |
| `Notification` | `t_notifications` | `Notification_Id` (id), `Notification_Date` (`Date`), `Notification_Text`, `Notification_Type` |
| `Chat` | `t_chat` | `Chat_Id` (id), `Chat_Text`, `Chat_Date` (`Date`) |
| `Forum` | `t_forums` | `Forum_Id` (id), `Forum_Subject`, `Forum_Date_Creation` (`Date`) |
| `Post` | `t_posts` | `Post_Id` (id), `Post_Date` (`Date`), `Post_Description`, `post_Title` |
| `Comment` | `t_comments` | `Comment_Id` (id), `Comment_Date` (`Date`), `Comment_text` |

## Services

| Entité | Table | Attributs |
|---|---|---|
| `Path` (trajet du bus scolaire) | `t_paths` | `Itinarary_Id` (id), `Itinarary_Bus_Ref`, `Itinarary_Place_Number` (`int`), `path_from` (`Path_From`), `path_to` (`Path_To`) |
| `Claim` (réclamation) | `t_claims` | `Claims_Id` (id), `Claims_Description`, `Claims_Date` (`Date`), `Claims_image`, `Claims_Type` |
| `Satisfaction` (avis de satisfaction) | `t_satisfactions` | `Satisfaction_Id` (id), `Satisfaction_Date` (`Date`), `Satisfaction_Text` |

## Énumérations

Valeurs reproduites telles qu'elles sont écrites dans le code.

| Énumération | Valeurs | Utilisée par |
|---|---|---|
| `Role` | `DOCTOR`, `EDUCATOR`, `BUSDRIVER`, `KINDERGARDEN_OWNER` | `Staff.role` |
| `Appointment_Place` | `DOCTOR_OFFICE`, `ADMINISTRATION_OFFICE`, `DEAN_OFFICE`, `EDUCATOR_OFFICE`, `OTHER` | `Appointment.appoitnment_place` |
| `Appoitnment_Type` | `MEDICAL`, `EDUCATIF`, `ADMINISTRATIF`, `SPORTIF`, `FINANCIAL`, `OTHER` | `Appointment.appoitnment_type` |
| `Club_Type` | `COMEDY`, `EDUCATIF`, `MUSICAL`, `SPORTS`, `TECHNOLOGIE`, `OTHER` | `Club.club_type` |
| `Event_Place` | `KINDERGARDEN`, `OTHER` | `Event.event_place` |
| `Event_Type` | `PARTY`, `COMMEDY`, `EDUCATIF`, `MUSICAL`, `SPORTIF`, `COMETITION`, `TECHNOLOGIE`, `OTHER` | `Event.event_type` |
| `Note_Subject` | `PSYCHOLOGY`, `CRONICAL_ILNESS`, `ORTHOPEDIST`, `PEDIATRIE`, `OTHER` | `Note.note_subject` |
| `Note_Type` | mêmes valeurs que `Note_Subject` | `Note.note_type` |
| `Path_From` | `ADRESSE_CHILD`, `KINDERGARDEN`, `OTHER` | `Path.path_from` |
| `Path_To` | `ADRESSE_CHILD`, `KINDERGARDEN`, `OTHER` | `Path.path_to` |

## Migrations et données

Aucun outil de migration (Flyway, Liquibase) : le schéma suit les entités à chaque démarrage
(`ddl-auto=update`, qui ajoute tables et colonnes sans supprimer l'existant). Le dépôt ne fournit pas de
données de démonstration.
