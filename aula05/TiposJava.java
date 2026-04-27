public class TiposJava {
  public static void main(String[] args) {
    double myDouble = 9.78d;
    int myInt = (int) myDouble; // Explicit casting: double to int

    System.out.println(myDouble);
    System.out.println(myInt);

    int myInt2 = 9;
    double myDouble1 = myInt2; // Automatic casting: int to double

    System.out.println(myInt2);
    System.out.println(myDouble1);
  }
}

