import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class GradeAnalyzerTest {

  @Test
  void getLetterGrade_returnsA_forScoreOf90() {
    assertEquals("A", GradeAnalyzer.getLetterGrade(90));
  }

  @Test
  void getLetterGrade_returnsA_forScoreOf100() {
    assertEquals("A", GradeAnalyzer.getLetterGrade(100));
  }

  @Test
  void getLetterGrade_returnsB_forScoreOf89() {
    assertEquals("B", GradeAnalyzer.getLetterGrade(89));
  }

  @Test
  void getLetterGrade_returnsF_forScoreOf59() {
    assertEquals("F", GradeAnalyzer.getLetterGrade(59));
  }

  @Test
  void calculate_average() {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(100);
    list.add(90);
    list.add(80);
    assertEquals(GradeAnalyzer.calculateAverage(list), 90);
  }

  @Test
  void calculate_average_empty() {
    ArrayList<Integer> list = new ArrayList<>();
    assertEquals(GradeAnalyzer.calculateAverage(list), 0);
  }
}
