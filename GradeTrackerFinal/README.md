# Student Grade Tracker

## Overview

A console-based Java application that allows teachers or students to:
- Add students by name and ID
- Record assignments and weighted exams
- View individual grade reports with letter grades
- View a class-wide summary and average
- Save/load data to a CSV file

---

## How to Run

### Prerequisites
- Java JDK 17 or higher installed
- VS Code with the "Extension Pack for Java" installed

### Steps
1. Clone or download this repository
2. Open the project folder in VS Code
3. Open `src/GradeTracker.java`
4. Click the **▶ Run** button above the `main` method (or press `Ctrl+F5`)

The app will launch in the terminal with 3 demo students pre-loaded so you can explore immediately.

---

## Project Structure

```
GradeTracker/
├── src/
│   ├── GradeTracker.java     ← Main application / entry point
│   ├── Student.java           ← Student class with ArrayList of assessments
│   ├── Assessment.java        ← Abstract base class (extends + abstract)
│   ├── Assignment.java        ← Concrete subclass of Assessment
│   ├── Exam.java              ← Concrete subclass with weight field
│   └── GradedItem.java        ← Interface (implements keyword)
└── README.md
```

---

## Requirements Checklist

| Requirement | How It's Met |
|---|---|
| **Variables** | `name`, `score`, `maxScore`, `weight`, `classTotal`, etc. throughout all classes |
| **Expressions** | Percentage calc `(score / maxScore) * 100`, weighted average, class average |
| **Conditionals** | Letter grade logic, input validation, menu routing (`if/else if` chains) |
| **Loops** | `for` and `while` loops for menu, student list, assessments, and class summary |
| **Functions** | All methods have function-level Javadoc comments |
| **Classes** | `Student`, `Assessment`, `Assignment`, `Exam`, `FileManager`, `GradeTracker` |
| **Collections Framework** | `ArrayList<Student>` in `GradeTracker`, `ArrayList<Assessment>` in `Student` |
| **File I/O** | `FileManager.saveToFile()` writes CSV; `FileManager.loadAndDisplay()` reads it |
| **Inheritance** | `Assignment` and `Exam` both extend the `abstract` class `Assessment` |
| **Interface** | `GradedItem` interface implemented by `Assessment` (and all subclasses) |

---

## Demo

When launched, the app auto-loads 3 students:
- **Alice Johnson** — solid B student with weighted exams
- **Bob Smith** — struggling, grades in the D–F range
- **Carol White** — near-perfect scores across the board

From the menu, choose option **4** to view the full class summary right away.

---

## Author

[Your Name]  
[Your Course / Institution]  
[Date]

## Video Demo

[Link to your video demo here]
