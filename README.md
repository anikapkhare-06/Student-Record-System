#  Student Record Management System

##  Project Overview

This project is a **Student Record Management System** developed using **Java**. It is a simple and efficient console-based application that helps in managing student data such as adding, viewing, searching, updating, and deleting records.

The system uses **file handling** to store data permanently, ensuring that records are not lost even after the program is closed.


##  Features

*  Add new student records
*  View all student records
*  Search student by ID
*  Update student details
*  Delete student record
*  Prevent duplicate student IDs
*  Data persistence using file handling


##  Technologies Used

* Java Programming Language
* Object-Oriented Programming (OOP)
* ArrayList (Dynamic Data Structure)
* File Handling (BufferedReader, BufferedWriter)


##  Project Structure

```
Student-Record-System/
│
├── Student.java
├── Main.java
├── students.txt
└── README.md
```


##  How to Run the Project

Follow these simple steps to run the project on your system:

### 1️ Install Java

Make sure Java is installed.
Check using:

```
java -version
```

### 2️ Download or Clone the Repository

```
git clone https://github.com/anikapkhare-06/Student-Record-System
```

### 3️ Open Project Folder

```
cd Student-Record-System
```

### 4️ Compile the Code

```
javac Main.java
```

### 5️ Run the Program

```
java Main
```


##  How It Works

* The program uses a **menu-driven interface**.
* Data is stored in an **ArrayList** during runtime.
* All records are saved in a file (`students.txt`) for permanent storage.
* Every operation (Add, Update, Delete) updates both:

  * Memory (ArrayList)
  * File (students.txt)


##  Sample Menu

```
====== STUDENT RECORD SYSTEM ======
1. Add Student
2. View Students
3. Search Student
4. Update Student
5. Delete Student
0. Exit
```


##  Challenges Faced

* Handling file reading and writing
* Managing user input errors
* Keeping data consistent


##  Limitations

* No graphical user interface (GUI)
* No database integration
* Basic security features


##  Future Scope

* Add GUI using Java Swing
* Integrate MySQL database
* Add login/authentication system
* Convert into a web-based application


##  What I Learned

* Implementation of OOP concepts
* File handling in Java
* Real-world problem solving
* Designing modular applications


##  Conclusion

This project demonstrates how Java can be used to build a simple yet effective real-world application. It reduces manual work, improves efficiency, and ensures data is stored safely.




