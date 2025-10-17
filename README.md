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

## ⚙️ How to Run

### 🧩 Step 1 — Compile the Source Files

#### 🪟 For Windows (PowerShell)
```powershell
cd "C:\path\to\AI_Code_Analyzer"
javac -encoding UTF-8 *.java sample/*.java
```

#### 🐧 For Linux / Mac (Terminal)
```bash
cd /path/to/AI_Code_Analyzer
javac -encoding UTF-8 *.java sample/*.java
```

---

### 🚀 Step 2 — Run the Analyzer

#### ➤ Analyze a Single File
```bash
java -cp . CodeAnalyzerApp sample/SampleClass.java
```

#### ➤ Analyze an Entire Folder
```bash
java -cp . CodeAnalyzerApp sample/
```

#### ➤ Export the Output to a Report File
```bash
java -cp . CodeAnalyzerApp sample/SampleClass.java > reports/output.txt
```

> 💡 *Tip:* Always use `-encoding UTF-8` during compilation to avoid encoding issues.

---

## 🎥 Demo Video

Watch a short walkthrough of the AI-Based Code Analyzer in action 👇  

<p align="center">
  <a href="https://drive.google.com/file/d/1Pli6mMXCu0Td5tvw8nnJYSSxrtEXM6xv/view?usp=drivesdk" target="_blank">
    <img src="https://img.youtube.com/vi/demo-link-here/0.jpg" alt="Watch Demo" width="70%" style="border-radius:12px;">
  </a>
</p>

> 🎬 *Replace the YouTube link above with your demo video once it’s uploaded.*

---

## 🖼️ Screenshots

<p align="center">
  <img src="assets/1.png" alt="Main Menu" width="80%" style="border-radius:12px; margin-bottom: 10px;"><br>
  <img src="assets/2.png" alt="Code Analysis Output" width="80%" style="border-radius:12px; margin-bottom: 10px;"><br>
  <img src="assets/3.png" alt="Generated Report" width="80%" style="border-radius:12px;">
</p>

> 🧾 *Store your screenshots in the `assets/` folder and update the file paths above.*

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
| 🧩 **Unused Variables** | −5 points each |
| 📏 **Long Methods** | −10 points each |
| 🗒️ **Missing Comments** | −2 points each |
| ⚙️ **Complexity (excessive control structures)** | −1 point each |
| 🕳️ **Deep Nesting (>4 levels)** | −3 points per level |

---

## 👩‍🎓 Author

**Mahak Singla**  
📧 [minkisingla29@gmail.com](mailto:minkisingla29@gmail.com)

---

## ⭐ Contribute

Pull requests are welcome!  
If you find a **bug 🐛** or have an **idea 💡** for improvement, feel free to **open an issue** or **submit a PR**.

Together, let’s make Java code smarter 💪
