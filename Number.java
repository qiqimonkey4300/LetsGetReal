public abstract class Number {

  public abstract double getValue();

  public int compareTo(Number other) {
    if (this.equals(other)) {
      return 0;
    } else if (getValue() > other.getValue()) {
      return 1;
    }
    return -1;
  }

  public boolean equals(Number other){
    double avg = getValue() + other.getValue()/2;
    if (getValue() == 0.0 || other.getValue() == 0.0) {
      if (getValue() == other.getValue()) {
        return true;
      }
      return false;
    } else if ((Math.abs(getValue() - other.getValue())/(avg) * 100) <= 0.001) {
      return true;
    }
    return false;
  }

}
