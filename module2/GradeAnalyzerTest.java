import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
}
