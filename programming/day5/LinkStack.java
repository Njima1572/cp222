/** 12/4/2017
  * Kochi Nakajima
  * cite - day 6 lecture
  */



public class LinkStack<T> implements IStack<T>{

  Cell<T> top;
  int size;
  int length;

  public LinkStack(int max_size){

    top = null;
    length = max_size;
    size = 0;
  }
  /**
   * renew the top element to the input paramenter
   */
  public void push(T v) throws OverFlowException{
    if(size >= length){throw new OverFlowException();}
    Cell<T> n = new Cell<T>(v, top);
    top = n;
    size++;

    //if the input value was syntax, then do other stuff.
  }
  /**
   * returns the top element and change the top to the one lower level.
   */
  public T pop() throws UnderFlowException{
    if(size == 0) {throw new UnderFlowException();}
    T temp = top.getValue();
    top = top.getPrev();
    size--;
    return temp;

  }

  static class Cell<T>{
    T value;
    Cell<T> pointer;

    public Cell(T v, Cell<T> p){
      value = v;
      pointer = p;
    }

    public T getValue(){
      return value;
    }

    public void setValue(T v){
      value = v;
    }
    public Cell<T> getPrev(){
      return pointer;
    }

    public void setPrev(Cell<T> c){
      pointer = c;
    }
  }
}
