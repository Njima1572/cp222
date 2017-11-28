/*
Kochi Nakajima - 11/27/2017
CP222 daily assignment day1
*/

public class IntPoint2D implements IIntPoint2D{
  int x;
  int y;
  public IntPoint2D(int __x, int __y){
    x = __x;
    y = __y;
  }

  public int getX(){
    return x;

  }
  public int getY(){
    return y;
  }
  //It doesn't make sense intuitively to have interface as a input value.
  //I would appreciate if you could explain it during the class.
  public int manhattanDistance(IIntPoint2D o){
    int man = Math.abs(this.getX() - o.getX()) + Math.abs(this.getY() + o.getY());
    return man;
  }

  public double distance(IIntPoint2D o){
    double dist;
    dist = Math.sqrt(Math.pow((this.getX() - o.getX()), 2) + Math.pow((this.getY() - o.getY()), 2));
    return dist;
  }

  public String toString(){
    return "(" + this.getX() + "," + this.getY() + ")";
  }

  public boolean equals(IntPoint2D o){
    return (this.getX() == o.getX() && this.getY() == o.getY());
  }

  public int hashcode(){
    return (this.getX() << 16) + this.getY();

  }

}
