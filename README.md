⚡ EV Charging Slot Booking Portal
     
A full-stack web application for booking EV charging slots online. Users can register, login, browse nearby charging stations, select available time slots, and make secure payments — all from a single web interface.
________________________________________
📋 Table of Contents
•	About the Project
•	Tech Stack
•	Features
•	Database Design
•	REST API Endpoints
•	Project Structure
•	Getting Started
•	Screenshots
•	Future Scope
________________________________________
🚀 About the Project
The EV Charging Slot Booking Portal is designed to solve the problem of unorganized EV charging station management. With the rapid growth of electric vehicles in India, there is an increasing demand for an efficient and digital slot booking system.
This project provides:
•	🔐 User Registration & Login
•	📍 Browse Charging Stations
•	⏰ Real-time Slot Availability
•	📅 Online Slot Booking
•	💳 Secure Payment System
•	📊 User Dashboard & Reports
•	👨‍💼 Admin Panel for complete management
________________________________________
🛠️ Tech Stack
Frontend
Technology	Purpose
HTML5	Structure of web pages
CSS3	Styling and responsive design
JavaScript (ES6)	Dynamic behavior and Fetch API
Google Fonts	Playfair Display + Plus Jakarta Sans
Backend
Technology	Purpose
Java 17	Programming language
Spring Boot 3.5.13	REST API framework
Spring Data JPA	Database ORM
Hibernate 6.6	Object-relational mapping
Maven	Build and dependency management
Database
Technology	Purpose
MySQL 8.0	Relational database
MySQL Workbench	Database management
Tools
Tool	Purpose
Eclipse IDE	Java development
VS Code + Live Server	Frontend development
Postman	API testing
GitHub	Version control
________________________________________
✨ Features
👤 User Features
•	✅ 3-step user registration (Personal Info → Vehicle Details → Password)
•	✅ Secure login with session management (localStorage)
•	✅ Browse all charging stations
•	✅ View real-time slot availability
•	✅ Book charging slots
•	✅ Multiple payment methods (UPI, Card, Net Banking, Wallet)
•	✅ Personal dashboard with booking history
•	✅ Cancel bookings
•	✅ Update profile
👨‍💼 Admin Features
•	✅ Admin login portal
•	✅ View all bookings and payments
•	✅ Add / Delete charging stations
•	✅ Add / Delete time slots
•	✅ Manage all users
•	✅ Station-wise, Payment-wise, User-wise Reports
•	✅ Revenue analytics
________________________________________
🗄️ Database Design
Database Name: ev_charging_station
Tables
Table	Primary Key	Description
users	user_id	Registered users
stations	station_id	Charging stations
slots	slot_id	Time slots per station
bookings	booking_id	User bookings
payments	payment_id	Payment records
admin	admin_id	Admin credentials
all_primary_keys	id	Master reference table
Relationships
users ──────── bookings ──────── slots
                   │                │
               payments         stations

admin (manages everything)
________________________________________
🔌 REST API Endpoints
Base URL: http://localhost:8080
👤 User APIs
Method	Endpoint	Description
POST	/api/users/register	Register new user
POST	/api/users/login	User login
GET	/api/users/all	Get all users
PUT	/api/users/update	Update user profile
DELETE	/api/users/delete/{id}	Delete user
📍 Station APIs
Method	Endpoint	Description
POST	/api/stations/add	Add new station
GET	/api/stations/all	Get all stations
DELETE	/api/stations/delete/{id}	Delete station
⏰ Slot APIs
Method	Endpoint	Description
POST	/api/slots/add	Add new slot
GET	/api/slots/all	Get all slots
GET	/api/slots/station/{id}	Get slots by station
GET	/api/slots/available	Get available slots
DELETE	/api/slots/delete/{id}	Delete slot
📅 Booking APIs
Method	Endpoint	Description
POST	/api/bookings/create	Create booking
GET	/api/bookings/all	Get all bookings
GET	/api/bookings/user/{id}	Get user bookings
PUT	/api/bookings/cancel/{id}	Cancel booking
💳 Payment APIs
Method	Endpoint	Description
POST	/api/payments/pay	Make payment
GET	/api/payments/all	Get all payments
📊 Report APIs
Method	Endpoint	Description
GET	/api/reports/summary	Overall summary
GET	/api/reports/station-wise	Station wise bookings
GET	/api/reports/station-revenue	Station wise revenue
GET	/api/reports/user-wise	User wise bookings
GET	/api/reports/user/{id}	Single user report
GET	/api/reports/slot-wise	Slot wise popularity
________________________________________
📁 Project Structure
ev-charging-portal/
│
├── src/main/java/com/evcharging/
│   ├── model/
│   │   ├── User.java
│   │   ├── Station.java
│   │   ├── Slot.java
│   │   ├── Booking.java
│   │   ├── Payment.java
│   │   └── Admin.java
│   │
│   ├── repository/
│   │   ├── UserRepository.java
│   │   ├── StationRepository.java
│   │   ├── SlotRepository.java
│   │   ├── BookingRepository.java
│   │   ├── PaymentRepository.java
│   │   └── AdminRepository.java
│   │
│   ├── service/
│   │   ├── UserService.java
│   │   ├── StationService.java
│   │   ├── SlotService.java
│   │   ├── BookingService.java
│   │   └── PaymentService.java
│   │
│   ├── controller/
│   │   ├── UserController.java
│   │   ├── StationController.java
│   │   ├── SlotController.java
│   │   ├── BookingController.java
│   │   ├── PaymentController.java
│   │   ├── AdminController.java
│   │   └── ReportController.java
│   │
│   └── EvChargingPortalApplication.java
│
├── src/main/resources/
│   └── application.properties
│
├── Frontend/
│   ├── index.html
│   ├── register.html
│   ├── login.html
│   ├── booking.html
│   ├── payment.html
│   ├── dashboard.html
│   ├── admin.html
│
└── pom.xml
________________________________________
🚀 Getting Started
Prerequisites
•	Java 17+
•	MySQL 8.0
•	Eclipse IDE
•	VS Code + Live Server Extension
•	Postman (for API testing)
Step 1 — Clone the Repository
git clone https://github.com/sakshi-bhuyar08/ev-charging-slot-booking-portal
cd ev-charging-slot-booking-portal
Step 2 — Setup MySQL Database
CREATE DATABASE ev-charging-slot-booking-portal;
USE ev-charging-slot-booking-portal;
Run the provided SQL scripts to create tables.
Step 3 — Configure application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/ev_charging_station
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080

Step 4 — Run Spring Boot Backend
# In Eclipse
Right Click on EvChargingPortalApplication.java
→ Run As → Spring Boot App
Backend starts at: http://localhost:8080
Step 5 — Run Frontend
# In VS Code
Right Click on index.html
→ Open with Live Server
Frontend starts at: http://127.0.0.1:5501
Step 6 — Add Admin
INSERT INTO admin (name, email, password)
VALUES ('Admin', 'admin@evchargepro.com', 'admin123');
Step 7 — Add Sample Station & Slots via Postman
POST http://localhost:8080/api/stations/add
{
  "stationName": "Mauli EV Station",
  "location": "Shegaon Naka, Amravati",
  "totalSlots": 20,
  "contactNo": "9876543345"
} 
________________________________________
🌐 Pages Overview
Page	File	Description
Home	index.html	Landing page with features
Register	register.html	3-step user registration
Login	login.html	User & Admin login
Book Slot	booking.html	Station & slot selection
Payment	payment.html	Online payment
Dashboard	dashboard.html	User bookings & profile
Admin Panel	admin.html	Complete admin management
Reports	report.html	Analytics & reports
________________________________________
🔮 Future Scope
•	📱 Mobile App — React Native / Flutter
•	🗺️ GPS Integration — Google Maps for nearby stations
•	🔔 Notifications — Email/SMS booking alerts
•	💳 Payment Gateway — Razorpay / PayU integration
•	📊 Advanced Analytics — Monthly revenue charts
•	🔋 IoT Integration — Real-time charging status
•	🌍 Multi-language — Hindi & regional languages
________________________________________
👩‍💻 Developed By
Sakshi Satish Bhuyar
Master of Computer Application
P. R. Pote Patil College of Engineering & Management, Amravati
Academic Year: 2025-2026
________________________________________
📄 License
This project is developed for academic purposes.
________________________________________
🌟 Support this project by giving it a star on GitHub!

