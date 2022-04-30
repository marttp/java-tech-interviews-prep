import lc.general.EvaluateRPN_150;
import utility.GenerateExample;

public class Main {

  public static void main(String[] args) {
    String creator = "Thanaphoom Babparn";
    System.out.printf("Creator: %s%n", creator);
    tryQuestion(new EvaluateRPN_150());
  }

  public static void tryQuestion(GenerateExample genExample) {
    genExample.example();
  }
}