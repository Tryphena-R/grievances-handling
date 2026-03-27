Grievance Handling System
A console-based Java application for managing public grievance complaints.  
Designed with clean layered architecture and interview-ready code quality.
---
Project Structure
```
GrievanceSystem/
├── build.sh                    ← One-shot build + run script
├── README.md
└── src/
    ├── Main.java               ← Entry point, top-level menu
    ├── model/
    │   ├── Complaint.java      ← Domain object (ID, status, category, CSV I/O)
    │   └── User.java           ← User domain object with role
    ├── repository/
    │   └── ComplaintRepository.java  ← In-memory store + file persistence
    ├── service/
    │   └── ComplaintService.java     ← Business logic + input validation
    ├── ui/
    │   ├── UserMenu.java       ← Console UI for regular users
    │   └── AdminMenu.java      ← Console UI for administrators
    └── util/
        └── FileHandler.java    ← CSV read/write to data/complaints.csv
```
---
Architecture
```
┌──────────┐   ┌───────────┐
│ UserMenu │   │ AdminMenu │
└────┬─────┘   └─────┬─────┘
     └────────┬───────┘
              ▼
     ┌─────────────────┐
     │ ComplaintService │  ← business logic, validation
     └────────┬────────┘
              ▼
   ┌──────────────────────┐
   │ ComplaintRepository  │  ← in-memory List<Complaint>
   └──────────┬───────────┘
              ▼
       ┌────────────┐
       │ FileHandler│  ← CSV persistence (data/complaints.csv)
       └────────────┘
```
---
How to Build & Run
Prerequisites
Java 11 or later (`java -version`)
Steps
```bash
cd GrievanceSystem
chmod +x build.sh
./build.sh
```
Or manually:
```bash
mkdir -p out
find src -name "*.java" | xargs javac -d out -sourcepath src
cd out && java Main
```
---
Features
User Portal
Feature	Description
Register Complaint	Submit a new complaint with category and priority
View by ID	Check current status of any complaint by its ID
Admin Panel (login: `admin` / `admin123`)
Feature	Description
View All Complaints	List every complaint with full details
Update Status	Change status: PENDING → IN_PROGRESS → RESOLVED
Delete Complaint	Remove a complaint with confirmation prompt
Filter by Status	Show only PENDING, IN_PROGRESS, or RESOLVED
Filter by Category	Show only ELECTRICITY, WATER, etc.
Summary Report	Totals, counts per status, resolution rate
---
Data Model
Field	Type	Notes
`id`	`String`	8-char UUID prefix, auto-generated
`userName`	`String`	Min 2 chars, alphanumeric
`description`	`String`	10–500 characters
`category`	`Category` (enum)	ELECTRICITY, WATER, INTERNET, SANITATION, ROAD, OTHER
`priority`	`Priority` (enum)	LOW, MEDIUM, HIGH
`status`	`Status` (enum)	PENDING, IN_PROGRESS, RESOLVED
`createdAt`	`LocalDateTime`	Set at creation
`updatedAt`	`LocalDateTime`	Updated on status/priority change
---
Persistence
Complaints are stored in `data/complaints.csv` (pipe-delimited, created automatically).  
The file is loaded at startup and flushed after every mutation.
---
Design Principles Applied
OOP: Encapsulation in model, separation of concerns across layers
Repository Pattern: All data access goes through `ComplaintRepository`
Service Layer: Business logic isolated from UI and storage
Enums: Type-safe status, priority, and category fields
Input Validation: Handled in `ComplaintService` with clear error messages
Defensive Copies: `findAll()` returns a new list to prevent external mutation
Error Handling: All I/O wrapped in try/catch; malformed CSV lines are skipped gracefully
