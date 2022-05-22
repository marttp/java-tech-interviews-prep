package additional;

public class StringRotation {

  public boolean isRotation(String s1, String s2) {
    // s1 base
    // s2 input
    String s1s1 = s1 + s1;
    return s1s1.contains(s2);
  }
}
