---

# 🚀 AI-Based Code Analyzer

> An **intelligent static analysis tool** built in **Java** that reviews Java source code for quality, complexity, and best practices — helping developers write cleaner, more maintainable programs.

![Java](https://img.shields.io/badge/Java-17-orange?logo=java\&logoColor=white)
![Platform](https://img.shields.io/badge/Platform-CLI-blue)
![License](https://img.shields.io/badge/License-MIT-green)
![Status](https://img.shields.io/badge/Version-1.0.0-purple)

---

## ✨ Features

* 🔍 **Automatic Code Review** — Analyzes Java source files for code quality issues.
* 🧩 **Unused Variable Detection** — Flags variables declared but never used.
* 📏 **Long Method Detection** — Identifies methods exceeding 30 lines.
* 🗒️ **Comment Analysis** — Detects missing class or method comments.
* ⚙️ **Complexity Evaluation** — Scores code based on control structures and nesting.
* 📊 **Quality Report Generation** — Produces detailed text reports with improvement suggestions.

---

## 🧠 How It Works

1. **Parses Java source files** using the built-in file reader.
2. **Analyzes code metrics** such as variables, method size, and comment density.
3. **Computes a complexity score** and assigns an overall quality rating.
4. **Generates a summary report** for developers to improve their code.

---

## 🧰 Requirements

* **Java Development Kit (JDK) 8 or higher**
* Works on **Windows**, **Linux**, and **macOS** (via command line)

---

## ⚙️ Build & Run Instructions

1. **Compile all source files**

   ```bash
   javac *.java
   ```

2. **Run the analyzer with your Java file**

   ```bash
   java CodeAnalyzerApp path/to/your/file.java
   ```

3. **Or test with the sample file**

   ```bash
   java CodeAnalyzerApp sample/SampleClass.java
   ```

---

## 📁 Project Structure

| File                   | Description                                   |
| ---------------------- | --------------------------------------------- |
| `CodeAnalyzerApp.java` | Main application entry point                  |
| `Parser.java`          | Handles file input and parsing                |
| `Analyzer.java`        | Core logic for code analysis                  |
| `Reporter.java`        | Generates and exports analysis reports        |
| `sample/`              | Contains sample Java source files for testing |

---

## 🧾 Sample Output

```
File: SampleClass.java
Total Methods: 3
Unused Variables: 2
Long Methods (>30 lines): 1
Missing Comments: 2
Complexity Score: 68/100
Overall Rating: Moderate
```

---

## 📈 Scoring Metrics

| Metric                   | Penalty             | Description                              |
| ------------------------ | ------------------- | ---------------------------------------- |
| Unused Variable          | -5 points           | Variable declared but unused             |
| Long Method              | -10 points          | Method exceeds 30 lines                  |
| Missing Comment          | -2 points           | Missing documentation on classes/methods |
| Extra Control Structures | -1 point each       | Loops, conditions, and branches          |
| Deep Nesting (>4 levels) | -3 points per level | Nested logic adds complexity             |

---

## 🧑‍💻 Tech Stack

* **Language:** Java
* **Paradigm:** Object-Oriented Programming
* **Core Concepts:** File Handling, String Manipulation, Static Analysis

---

## 👩‍🎓 Author

**Mahak Singla**
📧 [minkisingla29@gmail.com](mailto:minkisingla29@gmail.com)

---

