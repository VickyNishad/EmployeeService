This project based on emplyee create updatation some basic details. This service based on JWT Authentication JWT Authentication implmentaed Swagger also implementad In this project use H2 database for storing data

This method generate token for authentication

Method=POST service-1 https://localhost:8080/api/v1/auth/login request- { "userName":"vicky", "password":"vicky" } response- { "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2aWNreSIsImlhdCI6MTcwNjY1NDQ2OCwiZXhwIjoxNzA2NjcyNDY4fQ.Pjusw7k3_6uMXEkCiLssO8jhJ9idJvV6vXW9BCz75rQzqZ9Tpt2YuR1IMB_ex06aR_NDGaLDEReJZF8YwGhOeA", "username": "vicky" }

Method=POST service-1 https://localhost:8080/api/v1/employee/submitEmployeeDetails

Method=POST service-2 https://localhost:8080/api/v1/employee/updateEmployeeDetails

Method=GET service-3 https://localhost:8080/api/v1/employee/getEmployeeByid

Method=GET service-4 https://localhost:8080/api/v1/employee/search
