# 🧾 File Handling Utility — CODTECH Internship Task 1

## 📘 Project Overview
This project is a **Java-based File Handling Utility** developed as part of the **CODTECH Internship Program (Task 1)**.  
It demonstrates essential file operations such as **reading**, **writing**, **modifying**, and **deleting** text files with strong **error handling** and **input validation** using modern Java (Java 17+).

---

## ⚙️ Features
✅ Create and manage text files automatically  
✅ Read content from files  
✅ Write (append) new content safely  
✅ Modify text inside files (find & replace)  
✅ Delete files with confirmation  
✅ Handles all error cases gracefully (no program crashes)  
✅ Automatic recreation of missing files when needed  
✅ Input validation to prevent blank or invalid entries  

---

## 🧠 Concepts Used
- **File Handling** (NIO.2 API — `java.nio.file`)  
- **Exception Handling** (`try-catch` blocks)  
- **Input Validation**  
- **Scanner-based Menu System**  
- **String Replacement and I/O Streams**  
- **UTF-8 Encoding** for multi-language compatibility  

---

## 🏗️ Project Structure

---
FileHandlingUtility/
│
├── src/
│ └── FileHandlingUtility.java # Main source file
│
├── example.txt # Sample text file (auto-created)
│
└── README.md # Project documentation

## 🧩 How It Works
The program provides a **menu-driven interface** where the user can:
1. Write content to a text file  
2. Read content from the file  
3. Modify existing content  
4. Delete the file safely  
5. Exit the program  

If the file doesn’t exist, it is automatically created when performing read/write/modify operations.

---

## 🚀 How to Run the Project

### **1. Clone the Repository**
```bash
git clone https://github.com/ektas-22/file-handling-utility.git
cd FileHandlingUtility
2️⃣ Compile the Java File
javac src/FileHandlingUtility.java

3️⃣ Run the Program
java -cp src FileHandlingUtility

💻 Program Menu Example
==== File Handling Utility ====
1. Write to File
2. Read from File
3. Modify File
4. Delete File
5. Exit
👉 Enter choice (1-5): 1
Enter text to write: Hello CODTECH Internship!
✅ Successfully wrote to file.
