# AI-Based Code Analyzer

A Java-based tool that analyzes Java source files for code quality metrics and provides suggestions for improvement.

## Features

- Analyzes Java source files for code quality issues
- Detects unused variables
- Identifies long methods (>30 lines)
- Checks for missing class/method comments
- Evaluates code complexity based on control structures
- Generates quality score and suggestions
- Optional export of analysis report to text file

## Requirements

- Java Development Kit (JDK) 8 or later
- Command line or terminal access

## Building and Running

1. Compile all Java files:
```bash
javac *.java
```

2. Run the analyzer with a Java source file:
```bash
java CodeAnalyzerApp path/to/your/file.java
```

Or run with the included sample:
```bash
java CodeAnalyzerApp sample/SampleClass.java
```

## Project Structure

- `CodeAnalyzerApp.java` - Main application entry point
- `Parser.java` - Handles file reading and code parsing
- `Analyzer.java` - Performs code analysis and scoring
- `Reporter.java` - Generates analysis reports
- `sample/` - Contains sample Java files for testing

## Sample Output

```
File: SampleClass.java
Total Methods: 3
Unused Variables: 2
Long Methods (>30 lines): 1
Missing Comments: 2
Complexity Score: 68/100
Overall Rating: Moderate
```

## Code Quality Metrics

- **Unused Variables**: -5 points each
- **Long Methods**: -10 points each
- **Missing Comments**: -2 points each
- **Complexity Penalties**:
  - High number of control structures: -1 point each above threshold
  - Deep nesting (>4 levels): -3 points per level
## 👩‍🎓 Author

**Mahak Singla**
📧 [minkisingla29@gmail.com](mailto:minkisingla29@gmail.com)

---

