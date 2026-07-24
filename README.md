## 🎯 Project Goals

This project aims to:

- Simplify grievance registration and tracking
- Demonstrate clean Java programming practices
- Provide a foundation for future enhancements# 📝 Grievance Handling System

A **console-based Java application** for managing public grievance complaints.
Designed with **clean layered architecture** and **interview-ready code quality**.

---

## 📦 Project Structure

```
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
```

---

## 🏗️ Architecture

```
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
```

---

## ⚙️ How to Build & Run

### 🔹 Prerequisites

* Java 11 or later

```bash
java -version
```

### 🔹 Run with Script

```bash
cd GrievanceSystem
chmod +x build.sh
./build.sh
```

### 🔹 Manual Run

```bash
mkdir -p out
find src -name "*.java" | xargs javac -d out -sourcepath src
cd out && java Main
```

---

## 🚀 Features

### 👤 User Portal

| Feature            | Description                                       |
| ------------------ | ------------------------------------------------- |
| Register Complaint | Submit a new complaint with category and priority |
| View by ID         | Check current status using complaint ID           |

---

### 🔐 Admin Panel

**Login Credentials:**

```
username: admin
password: admin123
```

| Feature             | Description                                |
| ------------------- | ------------------------------------------ |
| View All Complaints | List all complaints                        |
| Update Status       | PENDING → IN_PROGRESS → RESOLVED           |
| Delete Complaint    | Remove a complaint with confirmation       |
| Filter by Status    | Show complaints by status                  |
| Filter by Category  | Show complaints by category                |
| Summary Report      | Totals, counts per status, resolution rate |

---

## 📊 Data Model

| Field         | Type          | Notes                                                 |
| ------------- | ------------- | ----------------------------------------------------- |
| `id`          | String        | 8-char UUID prefix                                    |
| `userName`    | String        | Min 2 characters                                      |
| `description` | String        | 10–500 characters                                     |
| `category`    | Enum          | ELECTRICITY, WATER, INTERNET, SANITATION, ROAD, OTHER |
| `priority`    | Enum          | LOW, MEDIUM, HIGH                                     |
| `status`      | Enum          | PENDING, IN_PROGRESS, RESOLVED                        |
| `createdAt`   | LocalDateTime | Set at creation                                       |
| `updatedAt`   | LocalDateTime | Updated on change                                     |

---

## 💾 Persistence

* File: `data/complaints.csv`
* Format: Pipe-delimited (`|`)
* Auto-created if not present
* Loaded at startup
* Saved after every mutation

---

## 🧠 Design Principles

* **OOP** → Encapsulation and modular design
* **Layered Architecture** → UI → Service → Repository
* **Repository Pattern** → Centralized data access
* **Service Layer** → Business logic separation
* **Enums** → Type-safe values
* **Input Validation** → Clear error handling
* **Defensive Programming** → Safe data exposure
* **Robust I/O Handling** → Graceful handling of malformed CSV

---

## 📌 Highlights

* Clean, interview-ready structure
* Pure Java (no external dependencies)
* Easily extensible (DB, REST API, GUI)
* Strong separation of concerns

---

## 🔮 Future Improvements

* Database integration (MySQL / PostgreSQL)
* REST API using Spring Boot
* GUI or web-based frontend
* Authentication & role-based access
* Search, sorting, and pagination

---

## 👨‍💻 Author

Developed as a **practice + portfolio project** to demonstrate:

* Java fundamentals
* Clean architecture
* Real-world problem solving

---
