import java.io.File;
import java.util.Scanner;

public class CodeAnalyzerApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printWelcome();

        while (true) {
            printMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    analyzeCustomFile();
                    break;
                case 2:
                    analyzeSampleFile();
                    break;
                case 3:
                    about();
                    break;
                case 4:
                    System.out.println("\nThank you for using AI-Based Code Analyzer!");
                    return;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }

            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }

    private static void printWelcome() {
        System.out.println("+--------------------------------+");
        System.out.println("|  AI-Based Code Analyzer 1.0   |");
        System.out.println("+--------------------------------+");
        System.out.println("Welcome to the Java Code Quality Analyzer!");
        System.out.println("This tool helps you improve your code quality.");
    }

    private static void printMenu() {
        System.out.println("\n========= Main Menu =========");
        System.out.println("1. Analyze Custom Java File");
        System.out.println("2. Analyze Sample File");
        System.out.println("3. About");
        System.out.println("4. Exit");
        System.out.print("\nEnter your choice (1-4): ");
    }

    private static int getUserChoice() {
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            return choice;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void analyzeCustomFile() {
        System.out.println("\n======= Analyze Custom File =======");
        System.out.print("Enter the path to your Java file: ");
        String path = scanner.nextLine();

        File file = new File(path);
        if (!file.exists()) {
            System.err.println("\nError: File not found: " + path);
            return;
        }

        analyzeFile(file);
    }

    private static void analyzeSampleFile() {
        System.out.println("\n======= Analyze Sample File =======");
        System.out.println("Using sample file: sample/SampleClass.java");

        File file = new File("sample/SampleClass.java");
        if (!file.exists()) {
            System.err.println("\nError: Sample file not found!");
            return;
        }

        analyzeFile(file);
    }

    private static void analyzeFile(File file) {
        try {
            System.out.println("\nAnalyzing file: " + file.getName());
            System.out.println("Please wait...");

            Parser parser = new Parser(file);
            ParseResult result = parser.parse();

            Analyzer analyzer = new Analyzer(result);
            AnalysisReport report = analyzer.analyze();

            Reporter reporter = new Reporter(report);

            System.out.println("\n======= Analysis Results =======");
            reporter.printReport();

            System.out.print("\nWould you like to export the report to a file? (y/n): ");
            String export = scanner.nextLine();

            if (export.toLowerCase().startsWith("y")) {
                String reportPath = "analysis_report.txt";
                reporter.exportToFile(reportPath);
                System.out.println("Report exported to: " + reportPath);
            }

        } catch (Exception e) {
            System.err.println("\nError during analysis: " + e.getMessage());
        }
    }

    private static void about() {
        System.out.println("\n======= About =======");
        System.out.println("AI-Based Code Analyzer v1.0");
        System.out.println("\nFeatures:");
        System.out.println("- Detects unused variables");
        System.out.println("- Identifies long methods (>30 lines)");
        System.out.println("- Checks for missing documentation");
        System.out.println("- Analyzes code complexity");
        System.out.println("- Provides improvement suggestions");
        System.out.println("\nMetrics Scoring:");
        System.out.println("- Unused Variables: -5 points each");
        System.out.println("- Long Methods: -10 points each");
        System.out.println("- Missing Comments: -2 points each");
        System.out.println("- Complex Control Flow: -1 point per excess");
        System.out.println("- Deep Nesting (>4 levels): -3 points per level");
    }
}
