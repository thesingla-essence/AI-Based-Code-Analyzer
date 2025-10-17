import java.io.*;
import java.util.*;

public class Reporter {
    private AnalysisReport report;

    public Reporter(AnalysisReport report) {
        this.report = report;
    }

    public void printReport() {
        // Header
        System.out.println("+--------------------------------+");
        System.out.println("|          Analysis Report           |");
        System.out.println("+--------------------------------+");
        
        // Basic metrics
        System.out.println("\n📁 File: " + report.fileName);
        System.out.println("📊 Code Metrics:");
        System.out.println("   • Methods: " + report.totalMethods);
        System.out.println("   • Control Flow:");
        System.out.println("     - If/Else blocks: " + report.ifElseCount);
        System.out.println("     - Loops: " + report.loopCount);
        System.out.println("     - Maximum nesting: " + report.maxNesting);
        
        // Issues found
        System.out.println("\n⚠️ Issues Found:");
        System.out.println("   • Unused Variables: " + report.unusedVariables);
        if (report.unusedVariables > 0) {
            System.out.println("     Variables: " + report.unusedVariableNames);
        }
        
        System.out.println("   • Long Methods: " + report.longMethods);
        if (report.longMethods > 0) {
            System.out.println("     Methods: " + report.longMethodNames);
        }
        
        System.out.println("   • Missing Comments: " + report.missingComments);
        
        // Score and rating
        System.out.println("\n🎯 Quality Score: " + report.score + "/100");
        System.out.println("📈 Overall Rating: " + getEmoji(report.overall) + " " + report.overall);
        
        // Suggestions
        if (report.suggestions != null && !report.suggestions.isEmpty()) {
            System.out.println("\n💡 Improvement Suggestions:");
            for (String s : report.suggestions) {
                System.out.println("   • " + s);
            }
        }
    }
    
    private String getEmoji(String rating) {
        switch (rating.toLowerCase()) {
            case "excellent": return "🌟";
            case "good": return "✅";
            case "moderate": return "⚠️";
            default: return "❌";
        }
    }

    public void exportToFile(String path) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            pw.println("File: " + report.fileName);
            pw.println("Total Methods: " + report.totalMethods);
            pw.println("Unused Variables: " + report.unusedVariables);
            if (report.unusedVariables > 0) pw.println("Unused Variable Names: " + report.unusedVariableNames);
            pw.println("Long Methods (>30 lines): " + report.longMethods);
            if (report.longMethods > 0) pw.println("Long Method Names: " + report.longMethodNames);
            pw.println("Missing Comments: " + report.missingComments);
            pw.println("If/Else Count: " + report.ifElseCount + ", Loops: " + report.loopCount + ", Max Nesting: " + report.maxNesting);
            pw.println("Complexity Score: " + report.score + "/100");
            pw.println("Overall Rating: " + report.overall);
            if (report.suggestions != null && !report.suggestions.isEmpty()) {
                pw.println("Suggestions:");
                for (String s : report.suggestions) pw.println(" - " + s);
            }
            System.out.println("Report exported to: " + path);
        } catch (IOException e) {
            System.err.println("Failed to export report: " + e.getMessage());
        }
    }
}
