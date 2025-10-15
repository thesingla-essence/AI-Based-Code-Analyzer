# ⚡ AI-Based Code Analyzer

<p align="center">
  <a href="https://www.java.com/">
    <img src="https://img.shields.io/badge/Made%20with-Java-orange?style=for-the-badge&logo=java" alt="Made with Java">
  </a>
  <a href="https://opensource.org/licenses/MIT">
    <img src="https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge" alt="License: MIT">
  </a>
  <img src="https://img.shields.io/badge/Open%20Source-💻-brightgreen?style=for-the-badge" alt="Open Source">
  <img src="https://img.shields.io/badge/Contributions-Welcome-purple?style=for-the-badge" alt="Contributions Welcome">
</p>

A **Java-based intelligent tool** that analyzes Java source files for **code quality metrics**, detects potential issues, and provides **smart suggestions** for improvement.

---

## 🚀 Features

- 🔍 **Automatic Code Analysis** – Scans Java source files for potential issues  
- 🧹 **Detects Unused Variables** – Helps reduce dead code  
- 📏 **Finds Long Methods** – Flags methods exceeding 30 lines  
- 🗒️ **Checks Missing Comments** – Promotes better documentation  
- 🧠 **Evaluates Code Complexity** – Measures control structure depth  
- 📊 **Generates Quality Score & Suggestions**  
- 📝 **Optional Report Export** – Save analysis results to a text file  

---

## 🛠️ Requirements

- ☕ **Java Development Kit (JDK)** 8 or later  
- 💻 **Command-line or Terminal** access  

---

## ⚙️ Build & Run

### 1️⃣ Compile all Java files:
```bash
javac *.java
```

### 2️⃣ Run the analyzer on your file:
```bash
java CodeAnalyzerApp path/to/your/file.java
```

### 3️⃣ Try the included sample:
```bash
java CodeAnalyzerApp sample/SampleClass.java
```

---

## 🧩 Project Structure

| File | Description |
|------|--------------|
| `CodeAnalyzerApp.java` | Main application entry point |
| `Parser.java` | Handles file reading and code parsing |
| `Analyzer.java` | Performs code analysis and scoring |
| `Reporter.java` | Generates analysis reports |
| `sample/` | Contains sample Java files for testing |

---

## 📈 Sample Output

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

## 📊 Code Quality Metrics

| Metric | Penalty |
|--------|----------|
| 🧩 Unused Variables | −5 points each |
| 📏 Long Methods | −10 points each |
| 🗒️ Missing Comments | −2 points each |
| ⚙️ Complexity (excessive control structures) | −1 point each |
| 🕳️ Deep Nesting (>4 levels) | −3 points per level |

---

## 👩‍🎓 Author

**Mahak Singla**  
📧 [minkisingla29@gmail.com](mailto:minkisingla29@gmail.com)

---

## ⭐ Contribute

Pull requests are welcome!  
If you find a bug 🐛 or have an idea 💡 for improvement, feel free to **open an issue** or **submit a PR**.

---


