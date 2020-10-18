public class MethodCalc {
  public int calc ( int n1, String op, int n2)
  {
    int res = 0;
    switch (op)
    {
      case "+":
        res = n1+n2;
        break;
      case "-":
        res = n1-n2;
        break;
      case "*":
        res = n1*n2;
        break;
      case "/":
        if (n2 != 0) res = n1/n2; else res = -1;
        break;
      default:
        res = 0;
        break;
    }
    return res;
  }
}
