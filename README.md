# Employee Database App

## Project Overview
The **Employee Database App** is a Java console application that allows users to **perform CRUD operations** (Create, Read, Update, Delete) on an employee database using **MySQL**.  
It demonstrates the use of **Java JDBC** to connect to a MySQL database and manage employee records efficiently.

---

## Tools and Technologies
- **Programming Language:** Java  
- **Database:** MySQL  
- **JDBC Driver:** `mysql-connector-java`  
- **IDE:** VS Code or any Java IDE  
- **Java Version:** 8 or above  

---

## Features
1. **Add Employee** – Insert new employee records into the database.  
2. **View Employees** – Display all employees stored in the database.  
3. **Update Employee** – Modify existing employee information.  
4. **Delete Employee** – Remove an employee record by ID.  
5. **Exit Program** – Terminate the application gracefully.  
6. Handles invalid menu choices and prevents crashes.  

---

## Database Setup & SQL Queries

### 1. Create Employees Table

CREATE TABLE employees(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(100),
    salary DOUBLE
);

---
### 2. View Employees
SELECT * FROM employees;

### 3.Delete All Employees
DELETE FROM employees WHERE id > 0;

ALTER TABLE employees AUTO_INCREMENT = 1;

---

=== Employee Database Menu ===
1. Add Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Exit
Enter your choice:

---

## Compile and Run with MySQL JDBC Driver

### Compile the Java program

javac -cp ".;D:\Task7\mysql-connector-j-9.4.0.jar" EmployeeDatabaseApp.java
java -cp ".;D:\Task7\mysql-connector-j-9.4.0.jar" EmployeeDatabaseApp

---

## Screenshots

| Step | Menu Choice | Description | Screenshot File |
|------|------------|-------------|----------------|
| 1 | Choice 1 | Added the first employee using menu option 1. | `1st.png` |
| 2 | Choice 2 → Choice 1 | Viewed employees (choice 2) and added another employee (choice 1). The screenshot `1-2s.png` shows the SQL table with both employees added. | `1-2s.png` |
| 3 | Choice 3 | Updated an employee's information using menu option 3. The screenshot `3s.png` shows the updated database. | `3s.png` |
| 4 | Choice 4 → Choice 2 | Deleted an employee using menu option 4 and viewed the remaining employees with choice 2. The screenshot `4s.png` shows the database with only one employee remaining. | `4s.png` |
| 5 | Choice 9 → Choice 5 | Entered an invalid choice (9) and then exited the program using choice 5. | `5th.png` |

