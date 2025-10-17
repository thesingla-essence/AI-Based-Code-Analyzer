import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Parser {
    private File file;

    public Parser(File file) {
        this.file = file;
    }

    public ParseResult parse() throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }

        // Patterns
        Pattern classPattern = Pattern.compile("\\b(class|interface|enum)\\s+(\\w+)");
        Pattern methodPattern = Pattern.compile("(public|protected|private|static|\\s)+[\\w<>\\[\\]]+\\s+(\\w+)\\s*\\(([^)]*)\\)\\s*\\{" );
        Pattern varPattern = Pattern.compile("(final\\s+)?(static\\s+)?[A-Za-z0-9_<>, \t\\[\\]]+\\s+(\\w+)\\s*(=\\s*[^;]+)?;" );

        List<CodeClass> classes = new ArrayList<>();
        List<CodeMethod> methods = new ArrayList<>();
        List<CodeVariable> variables = new ArrayList<>();
        Map<Integer, String> comments = new HashMap<>();

        // Simple state for current class/method
        CodeClass currentClass = null;
        CodeMethod currentMethod = null;

        int lineNo = 0;
        Deque<Integer> braceStack = new ArrayDeque<>();
        for (String rawLine : lines) {
            lineNo++;
            String line = rawLine.trim();

            // capture single-line comments
            if (line.startsWith("//")) {
                comments.put(lineNo, line);
            }
            // TODO: capture block comments (/* .. */) - naive approach
            if (line.startsWith("/*") || line.startsWith("/**")) {
                StringBuilder sb = new StringBuilder(line);
                int start = lineNo;
                while (!line.contains("*/") && lineNo < lines.size()) {
                    lineNo++;
                    line = lines.get(lineNo-1).trim();
                    sb.append("\n").append(line);
                }
                comments.put(start, sb.toString());
                continue;
            }

            Matcher cm = classPattern.matcher(line);
            if (cm.find()) {
                currentClass = new CodeClass(cm.group(2), lineNo);
                classes.add(currentClass);
            }

            Matcher mm = methodPattern.matcher(line);
            if (mm.find()) {
                String methodName = mm.group(2);
                String params = mm.group(3);
                currentMethod = new CodeMethod(methodName, lineNo);
                currentMethod.setParameterString(params);
                methods.add(currentMethod);
            }

            Matcher vm = varPattern.matcher(line);
            if (vm.find()) {
                String varName = vm.group(3);
                CodeVariable cv = new CodeVariable(varName, lineNo);
                variables.add(cv);
                if (currentMethod != null) {
                    currentMethod.addVariable(cv);
                }
            }

            // track braces to count method length and nesting
            for (char c : rawLine.toCharArray()) {
                if (c == '{') {
                    braceStack.push(lineNo);
                } else if (c == '}') {
                    if (!braceStack.isEmpty()) {
                        braceStack.pop();
                    }
                    // heuristics: when method closes, clear currentMethod
                    // If currentMethod started earlier and braceStack size decreased to a level
                }
            }

            // naive: associate comments just above class/method
            // (we'll re-evaluate in Analyzer)
        }

        ParseResult result = new ParseResult();
        result.setFileName(file.getName());
        result.setLines(lines);
        result.setClasses(classes);
        result.setMethods(methods);
        result.setVariables(variables);
        result.setComments(comments);
        return result;
    }
}

// Supporting data classes
class ParseResult {
    private String fileName;
    private List<String> lines;
    private List<CodeClass> classes;
    private List<CodeMethod> methods;
    private List<CodeVariable> variables;
    private Map<Integer, String> comments;

    // getters and setters
    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }
    public List<String> getLines() { return lines; }
    public void setLines(List<String> lines) { this.lines = lines; }
    public List<CodeClass> getClasses() { return classes; }
    public void setClasses(List<CodeClass> classes) { this.classes = classes; }
    public List<CodeMethod> getMethods() { return methods; }
    public void setMethods(List<CodeMethod> methods) { this.methods = methods; }
    public List<CodeVariable> getVariables() { return variables; }
    public void setVariables(List<CodeVariable> variables) { this.variables = variables; }
    public Map<Integer, String> getComments() { return comments; }
    public void setComments(Map<Integer, String> comments) { this.comments = comments; }
}

class CodeClass {
    private String name;
    private int lineNumber;

    public CodeClass(String name, int lineNumber) {
        this.name = name;
        this.lineNumber = lineNumber;
    }

    public String getName() { return name; }
    public int getLineNumber() { return lineNumber; }
}

class CodeMethod {
    private String name;
    private int startLine;
    private int endLine = -1;
    private String parameterString = "";
    private List<CodeVariable> variables = new ArrayList<>();

    public CodeMethod(String name, int startLine) {
        this.name = name;
        this.startLine = startLine;
    }

    public String getName() { return name; }
    public int getStartLine() { return startLine; }
    public int getEndLine() { return endLine; }
    public void setEndLine(int endLine) { this.endLine = endLine; }
    public void setParameterString(String p) { this.parameterString = p; }
    public String getParameterString() { return parameterString; }
    public List<CodeVariable> getVariables() { return variables; }
    public void addVariable(CodeVariable v) { variables.add(v); }
}

class CodeVariable {
    private String name;
    private int lineNumber;

    public CodeVariable(String name, int lineNumber) {
        this.name = name;
        this.lineNumber = lineNumber;
    }

    public String getName() { return name; }
    public int getLineNumber() { return lineNumber; }
}
