import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {

  public static void main(String[] args) {
    // Step 1: read scores from file
    ArrayList<String> gradeContent = readScores("scores.txt");
    ArrayList<Integer> gradeList = processScores(gradeContent);
    // initializing all values
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    int countA = 0;
    int countB = 0;
    int countC = 0;
    int countD = 0;
    int countF = 0;
    // Step 2: calculate statistics
    // min and max score
    for (int grade : gradeList) {
      // calculating max
      if (max < grade)
        max = grade;
      // calculating min
      if (min > grade)
        min = grade;
      // counters
      if (grade < 60)
        countF += 1;
      else if (grade >= 60 && grade < 70)
        countD += 1;
      else if (grade >= 70 && grade < 80)
        countC += 1;
      else if (grade >= 80 && grade < 90)
        countB += 1;
      else if (grade >= 90 && grade <= 100)
        countA += 1;
    }
    if (max == Integer.MIN_VALUE)
      max = 0;
    if (min == Integer.MAX_VALUE)
      min = 0;
    // average
    Double avg = calculateAverage(gradeList);
    // skipped lines
    int skipped = gradeContent.size() - gradeList.size();
    // groups
    int[] groups = { countA, countB, countC, countD, countF };
    // Step 3: write and print report
    writeReport(gradeList, avg, max, min, skipped, groups);
  }

  // Returns a list of valid scores read from the file
  public static ArrayList<String> readScores(String filename) {
    ArrayList<String> content = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        content.add(line);
      }
    } catch (IOException e) {
      System.out.println("Unable to read grade file: " + e.getMessage());
    }
    return content;
  }

  // Reads a file and return a list with its content
  public static ArrayList<Integer> processScores(ArrayList<String> scores) {
    ArrayList<Integer> list = new ArrayList<>();
    for (String line : scores) {
      String cleanLine = line.trim();
      if (cleanLine.isEmpty())
        continue;
      int Grade;
      try {
        Grade = Integer.parseInt(cleanLine);
      } catch (NumberFormatException numE) {
        System.out.println("Grade: " + cleanLine + " is not valid");
        continue;
      }
      list.add(Grade);
    }
    return list;
  }

  // Returns the average of a list of scores, or 0.0 if the list is empty
  public static double calculateAverage(ArrayList<Integer> scores) {
    if (scores.size() == 0)
      return 0.0;

    int sum = 0;
    for (int score : scores)
      sum = sum + score;

    return sum / scores.size();
  }

  // Generate report
  public static void writeReport(ArrayList<Integer> scores,
      double avg, int high, int low,
      int skipped, int[] groups) {

    ArrayList<String> reportContent = new ArrayList<>();
    reportContent.add("=== Grade Analysis Report ===\n");
    reportContent.add(String.format("Total Scores processed: %d%n", scores.size()));
    reportContent.add(String.format("Invalid lines skipped: %d%n", skipped));

    reportContent.add("\n");

    reportContent.add(String.format("Average score: %.2f%n", avg));
    reportContent.add(String.format("Highest score: %d%n", high));
    reportContent.add(String.format("Lowest score: %d%n", low));
    reportContent.add("\n");

    reportContent.add("Grade Distribution:\n");
    reportContent.add(String.format("  A (90-100): %d%n", groups[0]));
    reportContent.add(String.format("  B (80-90): %d%n", groups[1]));
    reportContent.add(String.format("  C (70-80): %d%n", groups[2]));
    reportContent.add(String.format("  D (60-70): %d%n", groups[3]));
    reportContent.add(String.format("  F (below 60): %d%n", groups[4]));

    // write into file
    writeFileReport((reportContent));
    // prints in terminal
    for (String l : reportContent)
      System.out.print(l);
  }

  // Write content to a file report
  public static void writeFileReport(ArrayList<String> fileContent) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt"))) {
      for (String line : fileContent) {
        writer.write(line);
      }
    } catch (IOException e) {
      System.out.println("Unable to write report file: " + e.getMessage());
    }
  }
}