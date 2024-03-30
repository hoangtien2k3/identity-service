# Identity-Service

## Getting Started

Follow these steps to set up and run the backend:

1. [Clone the repository:]()
    ```text
    git clone https://github.com/hoangtien2k3/identity-service.git
    ```

2. [Open in IDE Intellij or Other]()
    ```text
    cd indentity-service
    ```

3. [Build the project:]()
    ```text
     # Using Maven
     mvn clean install
    ```

4. [Configure the database:]()

    - Update `application.yml` with your database connection details.

    ```text
    CREATE DATABASE identity_service;
    ```

5. [Run the application:]()
    ```text
      # Using Maven
      mvn spring-boot:run
    ```

## API Demo

### SignUp

Endpoint

- Method: POST
- URL: http://localhost:8080/identity/api/user/signup
- Request Body:

```json
{
  "username": "tienanhhoang",
  "password": "123456789",
  "firstname": "Hoang",
  "lastname": "Anh Tien",
  "dob": "2003-12-04"
}
```

Response:

```json
{
  "code": 200,
  "message": "success",
  "ressult": {
    "id": "44706b95-3120-41cd-8acc-5842e8402441",
    "username": "tienanhhoang",
    "password": "$2a$10$rz/vur9f35/a3W3ggj0qt.L/GGAWk4CqOCNfq0yZzEF2MfbUo1hyi",
    "firstname": "Hoang",
    "lastname": "Anh Tien",
    "dob": "2003-12-04"
  }
}
```

### Login:

Endpoint

- Method: POST
- URL: http://localhost:8080/identity/auth/login
- Request Body:

```json
{
  "username": "tienanhhoang",
  "password": "123456789"
}
```

Response:

```json
{
  "code": 200,
  "message": "success",
  "result": {
    "authenticated": true,
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJob2FuZ3RpZW4yazMuY29tIiwic3ViIjoidGllbmFuaGhvYW5nIiwiZXhwIjoxNzExNjI3ODg4LCJjdXN0b21DbGFpbSI6IkN1c3RvbSIsImlhdCI6MTcxMTYyNDI4OH0.n3ZR7qZ7-WPPRhakelrM2T_CiInuUHXL5yyCfw59ABxdPgUXTKC31IyMrpPdOHa16C7OUkZPO40OmhUzyfdm5g"
  }
}
```

### Get Info:

Endpoint

- Method: POST
- URL: http://localhost:8080/identity/api/user

Response:

```json
{
  "code": 200,
  "message": "success",
  "result": [
    {
      "id": "4335ece2-2419-4dde-8ed0-3cd249d293c8",
      "username": "hoangtiencf113",
      "password": "12345678",
      "firstname": "Hoang",
      "lastname": "Anh Tien",
      "dob": "2003-12-04"
    },
    {
      "id": "44706b95-3120-41cd-8acc-5842e8402441",
      "username": "tienanhhoang",
      "password": "$2a$10$rz/vur9f35/a3W3ggj0qt.L/GGAWk4CqOCNfq0yZzEF2MfbUo1hyi",
      "firstname": "Hoang",
      "lastname": "Anh Tien",
      "dob": "2003-12-04"
    }
  ]
}
```

## License

This project is licensed under the [MIT License]().

