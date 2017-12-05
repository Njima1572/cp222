public class DoubleLinkList<T> implements IList<T>{

  final int head;
  int tail;
  int count;
  IDLink<T> curr;
  IDLink<T> first;
  IDLink<T> last;

  public DoubleLinkList(){
    head = 0;
    tail = 0;
    count = 0;
    curr = new Cell<T>(null, null, null);
    first = curr;
    last = curr;
  }

  public void insert(int idx, T v){
    IDLink<T> newLink = new Cell<T>(v, null, null);
    IDLink<T> temp = curr;
    if(first.equals(null)){
      first = newLink;
      last = newLink;
    }else if(idx > tail){
      last.setNext(newLink);
      last = newLink;
    }else{
      this.jumpToHead();
      while(count < idx){
        next();
      }
      newLink.setPrev(curr);
      newLink.setNext(curr.getNext());
      curr.setNext(newLink);
      newLink.getNext().setPrev(newLink);
    }
    tail++;
  }

  public void append(T v){
    IDLink<T> newLink = new Cell<T>(v, null, null);
    if(this.size() == 0){
      first = newLink;
      last = newLink;
      curr = newLink;
      tail++;
      count = tail;
    }else{
      jumpToTail();
      curr.setNext(newLink);
      newLink.setPrev(curr);
      last = newLink;
      curr = last;
      tail++;
      count = tail;
    }
  }

  public void remove(){
    if(curr.equals(first)){
      first = curr.getNext();
      first.setPrev(null);
      tail--;

    }else if(curr.equals(last)){
      this.prev();
      curr.setNext(null);
      tail--;
      last = curr;
      count = tail;
    }else{
      IDLink<T> temp = curr.getNext();
      curr.getNext().setPrev(curr.getPrev());
      curr.getPrev().setNext(curr.getNext());
      curr = null;
      curr = temp;
      tail--;

    }
  }

  public void remove(int idx){
    if(idx == head){
      first = curr.getNext();
      curr.setPrev(null);
    }else if(idx == tail){
      last = curr.getPrev();
      curr.setNext(null);
    }else{
      this.jumpToHead();
      while(count < idx){
        next();
      }
      IDLink<T> temp = curr.getNext();
      curr.getNext().setPrev(curr.getPrev());
      curr.getPrev().setNext(curr.getNext());
      curr = null;
      curr = temp;
    }
    tail--;
  }

  public void move(int sidx, int didx){
    IDLink<T> source;
    IDLink<T> dest;
    IDLink<T> temp = curr;
    int tempCount = count;
    //get Source cell
    jumpToHead();
    while(count < sidx){
      next();
    }
    source = curr;

    //get Destination cell
    jumpToHead();
    while(count < didx){
      next();
    }
    dest = curr;

    if(sidx < didx){ //source is after destination dp - d - s - dn // sp - sn
      System.out.println("tail, head : " + tail + " " + head);
      if(sidx == head){ // first - sn // dp - d - s - dn
        source.getNext().setPrev(null);
        first = source.getNext();
        source.setNext(dest.getNext());
        dest.getNext().setPrev(source);
        dest.setNext(source);
        source.setPrev(dest);

      }else if(didx == tail){// dp - d - s // sp - sn
        source.getPrev().setNext(source.getNext());
        source.getNext().setPrev(source.getPrev());
        dest.setNext(source);
        source.setPrev(dest);
        source.setNext(null);
        last = source;

      }else{//dp - d - s - dn // sp - sn
        source.getPrev().setNext(source.getNext());
        source.getNext().setPrev(source.getPrev());
        source.setNext(dest.getNext());
        dest.getNext().setPrev(source);
        dest.setNext(source);
        source.setPrev(dest);

      }

    }else if(didx < sidx){ //destination is after source dp - s - d - dn // sp - sn
      if(didx == head){// s - d - dn // sp - sn
        source.getPrev().setNext(source.getNext());
        source.getNext().setPrev(source.getPrev());
        source.setNext(dest);
        dest.setPrev(source);
        source.setPrev(null);
        first = source;

      }else if(sidx == tail){ // dp - s - d - dn // sp - last
        source.getPrev().setNext(null);
        last = source.getPrev();
        source.setPrev(dest.getPrev());
        dest.setPrev(source);
        dest.getPrev().setNext(source);
        source.setNext(dest);

      }else{
        source.getPrev().setNext(source.getNext());
        source.getNext().setPrev(source.getPrev());
        source.setPrev(dest.getPrev());
        dest.setPrev(source);
        dest.getPrev().setNext(source);
        source.setNext(dest);
      }
    }
    curr = temp;
    count = tempCount;
  }
  // public void move(int sidx, int didx){
  //   if(sidx == didx){
  //
  //   }
  //   else{
  //     IDLink<T> source = first;
  //     int index = 0;
  //     while(index < sidx){
  //       source = source.getNext();
  //       index++;
  //     }
  //     remove(sidx);
  //     insert(didx, source.getValue());
  //   }
  // }

  public T fetch(){
    return curr.getValue();

  }
  public T fetch(int idx){
    count = 0;
    curr = first;
    while(count < idx){
      next();
    }
    return curr.getValue();
  }

  public void next(){
    if(curr.equals(last)){

    }else{
      curr = curr.getNext();
      count++;
    }
  }

  public void prev(){
    if(curr.equals(first)){

    }else{
      curr = curr.getPrev();
      count--;
    }
  }

  public void jumpToTail(){
    count = tail;
    curr =  last;
  }

  public void jumpToHead(){
    count = head;
    curr = first;
  }

  public int size(){
    return (tail - head);
  }

private class Cell<T> implements IDLink<T>{
    T value;
    IDLink<T> next;
    IDLink<T> prev;

    public Cell(T v, Cell<T> p, Cell<T> n){
      value = v;
      next = n;
      prev = p;

    }
    public T getValue(){
      return value;
    }

    public void setValue(T v){
      value = v;
    }

    public IDLink<T> getNext(){
      return next;
    }

    public IDLink<T> getPrev(){
      return prev;
    }

    public void setNext(IDLink<T> c){
      next = c;
    }

    public void setPrev(IDLink<T> c){
      prev = c;
    }
  }
}
