📝 Grievance Handling System

A console-based Java application for managing public grievance complaints.
Designed with clean layered architecture, good coding practices, and interview-ready structure.

📦 Project Structure
GrievanceSystem/
├── build.sh                    # One-shot build + run script
├── README.md
└── src/
    ├── Main.java               # Entry point, top-level menu
    ├── model/
    │   ├── Complaint.java      # Domain object (ID, status, category, CSV I/O)
    │   └── User.java           # User domain object with role
    ├── repository/
    │   └── ComplaintRepository.java  # In-memory store + file persistence
    ├── service/
    │   └── ComplaintService.java     # Business logic + validation
    ├── ui/
    │   ├── UserMenu.java       # Console UI for users
    │   └── AdminMenu.java      # Console UI for admins
    └── util/
        └── FileHandler.java    # CSV read/write (data/complaints.csv)
🏗️ Architecture
┌──────────┐   ┌───────────┐
│ UserMenu │   │ AdminMenu │
└────┬─────┘   └─────┬─────┘
     └────────┬───────┘
              ▼
     ┌─────────────────┐
     │ ComplaintService │  ← Business logic + validation
     └────────┬────────┘
              ▼
   ┌──────────────────────┐
   │ ComplaintRepository  │  ← In-memory storage
   └──────────┬───────────┘
              ▼
       ┌────────────┐
       │ FileHandler│  ← CSV persistence
       └────────────┘
⚙️ How to Build & Run
🔹 Prerequisites
Java 11 or later
java -version
🔹 Run with Script
cd GrievanceSystem
chmod +x build.sh
./build.sh
🔹 Manual Run
mkdir -p out
find src -name "*.java" | xargs javac -d out -sourcepath src
cd out && java Main
🚀 Features
👤 User Portal
Feature	Description
Register Complaint	Submit complaint with category & priority
View by ID	Track complaint status using ID
🔐 Admin Panel

Login Credentials:

username: admin  
password: admin123
Feature	Description
View All Complaints	List all complaints
Update Status	PENDING → IN_PROGRESS → RESOLVED
Delete Complaint	Remove complaint with confirmation
Filter by Status	View specific statuses
Filter by Category	View specific categories
Summary Report	Stats + resolution rate
📊 Data Model
Field	Type	Notes
id	String	8-char UUID prefix
userName	String	Min 2 chars
description	String	10–500 chars
category	Enum	ELECTRICITY, WATER, INTERNET, SANITATION, ROAD, OTHER
priority	Enum	LOW, MEDIUM, HIGH
status	Enum	PENDING, IN_PROGRESS, RESOLVED
createdAt	LocalDateTime	Auto-set
updatedAt	LocalDateTime	Updated on changes
💾 Persistence
Data stored in:
data/complaints.csv
Format: Pipe-delimited (|)
Auto-created if not present
Loaded on startup
Saved after every update
🧠 Design Principles
✅ OOP → Encapsulation & modular design
✅ Layered Architecture → UI → Service → Repository
✅ Repository Pattern → Centralized data handling
✅ Service Layer → Business logic separation
✅ Enums → Type-safe fields
✅ Input Validation → Clean error handling
✅ Defensive Programming → Safe data exposure
✅ Robust I/O Handling → Fault-tolerant CSV parsing
📌 Highlights
Clean, interview-ready structure
No external dependencies (pure Java)
Easily extensible (DB, REST API, GUI)
Separation of concerns clearly demonstrated
🔮 Future Improvements
Add database support (MySQL / PostgreSQL)
REST API using Spring Boot
Web or GUI frontend
Authentication system with roles
Search & pagination
👨‍💻 Author

Developed as a practice + portfolio project to demonstrate:

Java fundamentals
Clean architecture
Real-world problem solving
