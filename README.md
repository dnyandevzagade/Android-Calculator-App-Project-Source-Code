# 📱 Simple Android Calculator App

This is a beginner-friendly Android Calculator app project. The app was selected as part of **CODTECH Internship Task 4**, where the objective was **code refactoring and performance optimization** of an open-source Android app.

---

## 🚀 Features

- Basic arithmetic operations: `+`, `-`, `*`, `/`
- ✅ Decimal point support
- ✅ Runtime error handling (e.g., divide by zero)
- ✅ Refactored code for better readability and performance
- ✅ Calculation history displayed below the result

---

## 📸 Screenshots

<img src="screenshots/main_ui.png" width="300" />
<img src="screenshots/history_ui.png" width="300" />

> (Replace with your own screenshots if needed)

---

## 🧠 Task Objective (CODTECH Task 4)

> **Task:** Code Refactoring and Performance Optimization  
> **Instructions:**
> - Take an open-source project and refactor it to improve readability and performance.
> - Submit a report on changes made and their impact on performance.

---

## 🔧 Refactored Improvements

| 🔴 Before                         | ✅ After                                  |
|----------------------------------|-------------------------------------------|
| Long, repetitive click listeners | One reusable click listener with lambda   |
| Only integer calculations        | Added support for decimal numbers         |
| No input validation              | Added error handling for divide by zero   |
| No history                      | Added a history scroll view below result |

---

## 📂 Folder Structure

app/
├── java/
│ └── MainActivity.java
├── res/
│ ├── layout/
│ │ └── activity_main.xml
├── AndroidManifest.xml



---

## 🛠 How to Run

1. Open in **Android Studio**
2. Make sure to use `compileSdk = 34` or higher
3. Clean & Build project
4. Run on emulator or physical device

---

## 📑 Report & Documentation

- ✅ Report (`CODTECH_Task_4_Report_Dnyandev.docx`) explaining refactor before vs after
- ✅ `MainActivity.java` and `activity_main.xml` fully commented
- ✅ Included `CODTECH_Task_4_Code_Comparison_With_XML.docx` file with code comparison

---

## 🙋‍♂️ Author

**Dnyandev Rama Zagade**  
Intern @ CODTECH  

---

## 📃 License

This project is based on [ProjectWorlds.in](https://projectworlds.in/android-projects-with-source-code/android-calculator-app-project-source-code/).  
Refactored under the **CODTECH Internship Program** for educational purposes only.
