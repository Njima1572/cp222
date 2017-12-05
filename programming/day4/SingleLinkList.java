public class SingleLinkList<T> implements IList<T>{

  int head;
  int tail;
  int count;
  ISLink<T> curr;
  ISLink<T> first;
  ISLink<T> last;


  public SingleLinkList(){
    head = 0;
    count = 0;
    tail = 0;
    curr = new Cell(null, null);
    first = curr;
    last = curr;

  }

  public void insert(int idx, T v){
    ISLink<T> newLink = new Cell<T>(v, null);
    ISLink<T> temp = curr;
    int tempCount = count;
    ISLink<T> indexPrev;
    jumpToHead();
    if(idx == 1){
      indexPrev = first;
    }else if(idx == 0){
      indexPrev = null;
    }else{
      while(count < idx - 1){
        next();
      }
      indexPrev = curr;
    }

    if(first.equals(null)){
      first = newLink;
      last = newLink;
    }else if(idx > tail){
      last.setNext(newLink);
      last = newLink;
    }else{
      if(idx == head){
        newLink.setNext(head);
        head = newLink;
      }else if(idx == tail){
        last.setNext(newLink);
        newLink.setNext(null);
        last = newLink;
      }else{

      }
    }
    tail++;
    curr = temp;
  }

  public void append(T v){
    this.jumpToTail(); //moves the curr to the last and counter to tail
    ISLink<T> newLink = new Cell<T>(v, null); //this will be new last cell
    if(count == 0){
      first = newLink;
      curr = first;
    }
    curr.setNext(newLink); //set the last one's pointer to newLink
    last = newLink; //last one becomes newLink
    tail++; //increment tail
    this.jumpToTail();
  }
  //removes the current index.
  public void remove(){
    this.jumpToHead();
    if(curr.equals(first)){
      first = curr.getNext();
      tail--;
    }else if(curr.equals(last)){
      this.prev();
      curr.setNext(null);
      last = curr;
      tail--;
    }else{
      while(count < tail - 1){
        curr.getNext();
      }
      curr.setNext(null);
      tail--;
    }
  }

  public void remove(int idx){
    if(idx == head){
      first = curr.getNext();
    }else if(idx == tail){
      prev();
      last = curr;
      curr.setNext(null);
    }else{
      this.jumpToHead();
      while(count < idx){
        next();
      }
      ISLink<T> temp = curr.getNext().getNext();
      curr.setNext(temp);
    }

    tail--;
  }
  //swap the element of sidx to didx
  //the pointer pointing to sidx points to didx
  //the pointer pointing to didx will be from
  public void move(int sidx, int didx){
    ISLink<T> source;
    ISLink<T> sourcePrev;
    ISLink<T> dest;
    ISLink<T> destPrev;
    ISLink<T> temp = curr;
    int tempCount = count;
    //get Source Cell
    jumpToHead();
    while(count < sidx){
      next();
    }
    source = curr;

    //get Destination Cell
    jumpToHead();
    while(count < didx){
      next();
    }
    dest = curr;

    //get one before source.
    jumpToHead();
    if(sidx == 1){
      sourcePrev = first;
    }else if(sidx == 0){
      sourcePrev = null;

    }else{
      while(count < sidx - 1){
        next();
      }
      sourcePrev = curr;
    }

    //get one before destination.
    jumpToHead();
    if(didx == 1){
      destPrev = first;
    }else if(didx == 0){
      destPrev = null;
    }else{
      while(count < didx - 1){
        next();
      }
      destPrev = curr;
    }

    if(sidx < didx){ //source is after destination dp - d - s
      if(sidx == head){
        first = source.getNext();
        source.setNext(dest.getNext());
        dest.setNext(source);

      }else if(didx == tail){
        sourcePrev.setNext(source.getNext());
        last.setNext(source);
        last = source;
        source.setNext(null);

      }else{
        sourcePrev.setNext(source.getNext());
        source.setNext(dest.getNext());
        dest.setNext(source);
      }

    }else if(didx < sidx){ //destination is after source dp - s - d
      if(didx == head){
        sourcePrev.setNext(source.getNext());
        source.setNext(first);
        first = source;

      }else if(sidx == tail){
        sourcePrev.setNext(null);
        last = sourcePrev;
        source.setNext(dest);
        destPrev.setNext(source);

      }else{
        sourcePrev.setNext(source.getNext());
        source.setNext(dest);
        destPrev.setNext(source);
      }
    }
    curr = temp;
    count = tempCount;
  }

  public T fetch(){
    return curr.getValue();
  }

  public T fetch(int idx){
    ISLink<T> temp = curr;
    this.jumpToHead(); //moves the pointer to the head
    while(count != idx){ //the loop that will go to the index
      curr = curr.getNext(); //advances to next cell
      count++;
    }
    ISLink<T> requested = curr;
    curr = temp;
    return requested.getValue();

  }

  public void next(){
    if(curr.equals(last)){
      System.out.println("You are already at the last");
    }else{
      curr = curr.getNext();
      count++;
    }
  }

  public void prev(){
    int temp = count;
    // System.out.println(count);
    if(curr.equals(first)){
      System.out.println("You are already at the front");

    }else{
      this.jumpToHead();
      // System.out.println(count + " " + temp);
      // System.out.println(curr.getValue());
      while(count != (temp - 1)){
        next();
        // System.out.print(" " + count + " ");
      }
      // System.out.println(" " + curr.getValue());
    }
  }

  public void jumpToTail(){
    curr = last;
    count = tail;
  }

  public void jumpToHead(){
    curr = first;
    count = head;
  }

  public int size(){
    return (tail - head);
  }

private class Cell<T> implements ISLink<T>{
    T value;
    ISLink<T> next;

    public Cell(T v, Cell<T> c){
      value = v;
      next = c;
    }

    public T getValue(){
      return value;
    }

    public void setValue(T v){
      value = v;
    }

    public ISLink<T> getNext(){
      return next;
    }

    public void setNext(ISLink<T> c){
      next = c;
    }

  }

  public static void main(String[] args){
    IList<Integer> I = new SingleLinkList<Integer>();
    I.append(0);
    I.append(1);
    I.append(2);
    I.append(3);
    I.move(3, 2);
    System.out.println(I.fetch(0));
    System.out.println(I.fetch(1));
    System.out.println(I.fetch(2));
    System.out.println(I.fetch(3));
  }
}
