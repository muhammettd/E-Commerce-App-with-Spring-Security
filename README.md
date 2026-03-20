## E-Commerce API with Spring Security 🛒🔐 ##
A robust E-commerce backend application built with Java and Kotlin, featuring a comprehensive security layer with Spring Security. This project demonstrates the integration of multiple languages within a single Spring Boot ecosystem and focuses on secure, role-based user management.

🚀 Key Features
Polyglot Development: Leverages Kotlin for lightweight, concise Data Classes (Models & DTOs) and Java for core business logic and services.

Advanced Security: Fully integrated Spring Security with database-backed authentication.

Role-Based Access Control (RBAC): Users can perform actions based on specific roles (e.g., ADMIN, USER) stored in the database.

Product Management: Complete CRUD operations for an e-commerce catalog.

User Persistence: Custom user details service linked to a relational database for secure login and registration.

🛠️ Technical Stack
Backend: Java 17+, Kotlin

Framework: Spring Boot 3.x, Spring Security, Spring Data JPA

Database: MySQL

Architecture: Layered Architecture (Controller, Service, Repository, DTO)

🔑 Security Configuration
The app secures endpoints based on user roles:

ADMIN: Can manage products and view all user data.

USER: Can browse products and manage their own profile.
