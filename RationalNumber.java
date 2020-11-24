public class RationalNumber extends RealNumber {
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *  If the denominator is negative, negate both numerator and denominator
  *@param nume the numerator
  *@param deno the denominator
  */

  public RationalNumber(int nume, int deno){
    super(0.0);//this value is ignored!
    if (deno == 0) {
      nume = 0;
      deno = 1;
    }
    if (deno < 0) {
      deno *= -1;
      nume *= -1;
    }
    if (nume == 0) {
      deno = 1;
    }
    numerator = nume;
    denominator = deno;
    reduce();
  }

  public double getValue(){
    return (double)numerator/denominator;
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    RationalNumber x = new RationalNumber(denominator, numerator);
    return x;
  }

  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return (numerator == other.getNumerator()
    && denominator == other.getDenominator());
  }

  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    return getNumerator() + "/" + getDenominator();
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */

  private static int gcd(int a, int b){
    /*use euclids method or a better one*/
    //http://sites.math.rutgers.edu/~greenfie/gs2004/euclid.html
    if (a < b) {
      int t = a; a = b; b = t;
    }
    if (a == b) {
      return a;
    }
    int r = b;
    while (r != 0) {
      r = a % b;
      a = b; b = r;
    }
    return a;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int x = gcd(numerator, denominator);
    numerator /= Math.abs(x);
    denominator /= Math.abs(x);
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    RationalNumber x = new RationalNumber(
    numerator * other.getNumerator(), denominator * other.getDenominator());
    x.reduce();
    return x;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    RationalNumber x = new RationalNumber(
    numerator * other.getDenominator(), denominator * other.getNumerator());
    x.reduce();
    return x;
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    RationalNumber x = new RationalNumber
    (numerator * other.getDenominator() + other.getNumerator() * denominator,
    denominator * other.getDenominator());
    x.reduce();
    return x;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    RationalNumber x = new RationalNumber
    (numerator * other.getDenominator() - other.getNumerator() * denominator,
    denominator * other.getDenominator());
    x.reduce();
    return x;
  }
}
