## Flight Booking System

### Overview
This Flight Booking System is a Java Spring Boot application that allows users to view available flights, sort them by various criteria, and book flights. The application uses Thymeleaf for the frontend and integrates with a MySQL database to store flight and booking information.

### Features
- View a list of available flights
- Sort flights by flight number, departure time, arrival time, and price
- Book a selected flight
- View a list of all bookings

## Demo
![](/images/flight1.PNG)
![](/images/flight2.PNG)

### Technologies Used
- Java 21
- Spring Boot 2.7.x
- Spring Data JPA
- Thymeleaf
- Tailwind CSS
- MySQL

### Getting Started
1. Clone the repository:
```
git clone https://github.com/ArjunAraneta/Java-Spring-ThymeLeaf-Flight-Booking-System.git
```
2. Navigate to the project directory:
```
cd Java-Spring-ThymeLeaf-Flight-Booking-System
```
3. Build the project:
```
./mvnw clean install
```
4. Run the application:
```
./mvnw spring-boot:run
```
5. Open your web browser and navigate to `http://localhost:8080/flights` to access the application.

### License
This project is licensed under the [Apache License, Version 2.0](LICENSE). The Apache License is a permissive open-source license that allows users to use, modify, and distribute the software, including for commercial purposes, as long as they provide attribution to the original authors and comply with the other terms of the license.

### Contributing
Contributions to the Flight Booking System are welcome! If you find any issues or have suggestions for improvements, please feel free to open an issue or submit a pull request.
