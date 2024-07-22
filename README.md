Hotel Room Reservation System
The Hotel Room Reservation System is a Java-based web application that allows users to view, book, and manage hotel rooms. The system includes features for user registration, login, room viewing, booking, and payment. It utilizes Jakarta Persistence API (JPA) for database interactions and is built using the Spring framework.

Features
User registration and login
Viewing available rooms
Booking rooms
Making payments for booked rooms
Viewing booking status and payment status
Prerequisites
Java 8 or higher
Maven 3.6 or higher
MySQL 5.7 or higher
An IDE (IntelliJ IDEA, Eclipse, etc.)
Setup Instructions
Step 1: Clone the Repository
git clone https://github.com/Opudo-Shaz/HotelReservationSystem-java.git

Step 2: Configure the Database
Create a MySQL database named hotel_reservation_system.
Open the src/main/resources/application.properties file and update the following properties with your MySQL credentials:
properties

spring.datasource.url=jdbc:mysql://localhost:3306/hotel_reservation_system
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update

Step 3: Build and Run the Application
mvn clean install
mvn spring-boot:run

Step 4: Access the Application
Open your web browser and go to http://localhost:8080.

How to Use
1. User Registration and Login
   Sign Up
   Go to the registration page at http://localhost:8080/signup.
   Fill in the required details (username, password, email) and submit the form.
   After successful registration, you will be redirected to the login page.
   Log In
   Go to the login page at http://localhost:8080/login.
   Enter your username and password.
   Upon successful login, you will be redirected to the home page where you can view available rooms.
2. Viewing Available Rooms
   After logging in, navigate to the rooms page at http://localhost:8080/rooms.
   The page will display a list of available rooms with details such as room number, type, price, and availability status.
3. Booking a Room
   On the rooms page, select a room you want to book and click on the "Book Now" button.
   You will be redirected to a booking confirmation page.
   Confirm your booking by clicking the "Confirm Booking" button.
4. Making Payment
   After booking a room, navigate to the payments page at http://localhost:8080/payments.
   Select the booking for which you want to make a payment.
   Enter the payment details and submit the payment form.
   Upon successful payment, the payment status for the booking will be updated.
