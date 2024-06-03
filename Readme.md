# CampusOverflow

## Description

CampusOverflow is a Q&A platform designed for campus communities. It allows users to ask questions, provide answers, comment on posts, and vote on questions and answers. The application aims to facilitate knowledge sharing and problem-solving within campus environments.

## Technologies Used

### Backend
- Spring Boot
- Spring Security
- JWT
- BCrypt
- Spring Data JPA
- JPA Auditing
- PostgreSQL
- Lombok
- ModelMapper
- JUnit
- Mockito
- Swagger
- Docker
- Mail Dev

### Frontend
- Angular
- Angular Material

## Installation

### Prerequisites
- Node.js (v20 or higher)
- Angular CLI
- Java (JDK 21 or higher)

### Backend Setup
1. Clone the repository:
    ```sh
    git clone https://github.com/GitHackerz/CampusOverflow
    cd campusoverflow/CampusOverflow-Back
    ```
   2. Configure the database:
      Update the `application-dev.yml` file with your database configurations.
       ```properties
       spring:
           datasource:
               url: jdbc:postgresql://localhost:5432/campus_overflow
               username: user
               password: password
       ```

### Frontend Setup
1. Navigate to the frontend directory:
    ```sh
    cd ../CampusOverflow-Front
    ```
2. Install the dependencies:
    ```sh
    npm install
    ```
3. Run the Angular application:
    ```sh
    npm start
    ```
   The application will be accessible at `http://localhost:4200`.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any inquiries or issues, please contact:

- Name: BIBANI Med Habib Allah
- Email: Bibani.MedHabibAllah@gmail.com
- GitHub: [GitHackerz](https://github.com/GitHackerz)
