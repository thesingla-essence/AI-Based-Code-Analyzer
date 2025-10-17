import java.util.*;
import java.util.regex.*;

public class Analyzer {
    private ParseResult parseResult;

    public Analyzer(ParseResult parseResult) {
        this.parseResult = parseResult;
    }

    public AnalysisReport analyze() {
        AnalysisReport report = new AnalysisReport();
        report.fileName = parseResult.getFileName();
        report.totalMethods = parseResult.getMethods().size();

        // Detect unused variables: declared but never referenced
        Set<String> declared = new HashSet<>();
        for (CodeVariable v : parseResult.getVariables()) {
            declared.add(v.getName());
        }

        Set<String> referenced = new HashSet<>();
        Pattern wordPattern = Pattern.compile("\\b(\\w+)\\b");
        List<String> lines = parseResult.getLines();
        for (int i = 0; i < lines.size(); i++) {
            String l = lines.get(i);
            Matcher m = wordPattern.matcher(l);
            while (m.find()) {
                String w = m.group(1);
                if (declared.contains(w)) referenced.add(w);
            }
        }
        Set<String> unused = new HashSet<>(declared);
        unused.removeAll(referenced);
        report.unusedVariables = unused.size();
        report.unusedVariableNames = new ArrayList<>(unused);

        // Detect long methods (>30 lines) - naive: estimate method length by finding next method or end
        List<CodeMethod> methods = parseResult.getMethods();
        List<CodeMethod> longMethods = new ArrayList<>();
        for (int i = 0; i < methods.size(); i++) {
            CodeMethod m = methods.get(i);
            int start = m.getStartLine();
            int end = (i + 1 < methods.size()) ? methods.get(i+1).getStartLine() - 1 : lines.size();
            int length = end - start + 1;
            if (length > 30) {
                longMethods.add(m);
            }
            m.setEndLine(end);
        }
        report.longMethods = longMethods.size();
        report.longMethodNames = new ArrayList<>();
        for (CodeMethod lm : longMethods) report.longMethodNames.add(lm.getName());

        // Missing comments above class or method definitions
        int missingComments = 0;
        List<String> missingCommentTargets = new ArrayList<>();
        Map<Integer, String> comments = parseResult.getComments();
        // build set of comment lines
        Set<Integer> commentLines = comments.keySet();

        for (CodeClass c : parseResult.getClasses()) {
            int ln = c.getLineNumber();
            if (!hasCommentAbove(ln, commentLines, lines)) {
                missingComments++;
                missingCommentTargets.add("class " + c.getName());
            }
        }
        for (CodeMethod mm : methods) {
            int ln = mm.getStartLine();
            if (!hasCommentAbove(ln, commentLines, lines)) {
                missingComments++;
                missingCommentTargets.add("method " + mm.getName());
            }
        }
        report.missingComments = missingComments;
        report.missingCommentTargets = missingCommentTargets;

        // Count control structures and nested blocks for complexity
        int ifElseCount = 0;
        int loopCount = 0;
        int maxNesting = 0;
        int currentNesting = 0;
        for (String raw : lines) {
            String l = raw.trim();
            if (l.startsWith("if ") || l.startsWith("if(") || l.contains(" else ") || l.equals("else")) {
                ifElseCount++;
            }
            if (l.startsWith("for ") || l.startsWith("for(") || l.startsWith("while ") || l.startsWith("while(") || l.startsWith("do ")) {
                loopCount++;
            }
            for (char ch : raw.toCharArray()) {
                if (ch == '{') { currentNesting++; maxNesting = Math.max(maxNesting, currentNesting); }
                else if (ch == '}') { currentNesting = Math.max(0, currentNesting - 1); }
            }
        }
        report.ifElseCount = ifElseCount;
        report.loopCount = loopCount;
        report.maxNesting = maxNesting;

        // Simple scoring: start at 100, subtract penalties
        int score = 100;
        score -= report.unusedVariables * 5;
        score -= report.longMethods * 10;
        score -= report.missingComments * 2;
        score -= Math.max(0, (report.ifElseCount + report.loopCount) - 10); // complexity penalty
        score -= Math.max(0, report.maxNesting - 4) * 3;
        score = Math.max(0, Math.min(100, score));
        report.score = score;

        report.overall = ratingFromScore(score);

        // Suggestions
        List<String> suggestions = new ArrayList<>();
        if (report.unusedVariables > 0) suggestions.add("Remove or use unused variables: " + report.unusedVariableNames);
        if (report.longMethods > 0) suggestions.add("Consider splitting long methods: " + report.longMethodNames);
        if (report.missingComments > 0) suggestions.add("Add Javadoc comments above classes/methods: " + report.missingCommentTargets);
        if (report.maxNesting > 5) suggestions.add("Reduce nesting depth; consider early returns or refactoring.");
        report.suggestions = suggestions;

        return report;
    }

    private boolean hasCommentAbove(int lineNo, Set<Integer> commentLines, List<String> lines) {
        // check up to 3 lines above for a comment or javadoc
        for (int i = lineNo - 1; i >= Math.max(0, lineNo - 4); i--) {
            if (i < 0 || i >= lines.size()) continue;
            String l = lines.get(i).trim();
            if (l.startsWith("//") || l.startsWith("/*") || l.startsWith("/**")) return true;
            if (!l.isEmpty() && !l.startsWith("\"")) break; // stop if code found
        }
        return false;
    }

    private String ratingFromScore(int s) {
        if (s >= 85) return "Excellent";
        if (s >= 70) return "Good";
        if (s >= 50) return "Moderate";
        return "Poor";
    }
}

class AnalysisReport {
    String fileName;
    int totalMethods;
    int unusedVariables;
    List<String> unusedVariableNames;
    int longMethods;
    List<String> longMethodNames;
    int missingComments;
    List<String> missingCommentTargets;
    int ifElseCount;
    int loopCount;
    int maxNesting;
    int score;
    String overall;
    List<String> suggestions;
}
