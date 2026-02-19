# Overview

As a software engineer focused on strengthening my foundation in object-oriented programming, I wanted to build a project that forced me to think in terms of classes, inheritance, and clean code structure rather than just writing procedural scripts.

This is a console-based Student Grade Tracker written in Java. It allows a user to add students, record assignments and weighted exams, view individual grade reports with letter grades, see a full class summary, and save all data to a CSV file. The app launches with demo students pre-loaded so the features are immediately visible.

My purpose in writing this software was to get hands-on experience with core Java concepts — specifically interfaces, abstract classes, inheritance, the Collections Framework, and file I/O — by applying them to a real, working program rather than isolated exercises.

[Software Demo Video](https://youtu.be/WZq08qxaCak)

# Development Environment

I developed this project using Visual Studio Code with the Extension Pack for Java by Microsoft, which provides language support, debugging, and an integrated run button. The project is compiled and run using the Java JDK 17.

The project is written entirely in Java with no external libraries. It uses only the Java standard library, including `java.util.ArrayList` and `java.util.Scanner` for data handling and user input, and `java.io.PrintWriter`, `java.io.FileWriter`, and `java.io.BufferedReader` for file reading and writing.

# Useful Websites

- [Oracle Java Documentation](https://docs.oracle.com/en/java/)
- [W3Schools Java Tutorial](https://www.w3schools.com/java/)
- [GeeksforGeeks - Java ArrayList](https://www.geeksforgeeks.org/arraylist-in-java/)
- [Baeldung - Abstract Classes in Java](https://www.baeldung.com/java-abstract-class)

# Future Work

- Add the ability to fully reload students and their assessments from the CSV file on startup
- Build a simple GUI using Java Swing to replace the console menu
- Allow students to be deleted or have their assessments edited after entry