public class ArrayList<T> implements IList<T>{

  T[] list;
  int curr, head, tail;
  public ArrayList(){
    list= (T[]) new Object[0];
    curr = 0;
    head = 0;
    tail = list.length - 1;
  }

  public void insert(int idx, T v){
    T[] temp = (T[]) new Object[list.length + 1];
    for(int i = 0; i < list.length; i++){
      if(i < idx){
        temp[i] = list[i];
      }else if(i == idx){
        temp[idx] = v;
      }else{
        temp[i] = list[i - 1];
      }
    }
    list = temp;
  }

  public void append(T v){
    T[] temp = (T[]) new Object[list.length + 1];
    for(int i = 0; i < list.length; i++){
      temp[i] = list[i];
    }
    temp[list.length] = v;
    list = temp;
    curr = tail;
  }

  public void remove(){
    T[] temp = (T[]) new Object[list.length - 1];
    for(int i = 0; i < curr; i++){
      temp[i] = list[i];
    }
    for(int i = curr; i < temp.length; i++){
      temp[i] = list[i + 1];
    }
    list = temp;
    if(curr != 0){
      curr--;
    }
  }

  public void remove(int idx){
    if(list.length > 0){
      T[] temp = (T[]) new Object[list.length - 1];
      for(int i = 0; i < list.length; i++){
        if(i < idx){
          temp[i] = list[i];
        }else if(i == idx){
        }else{
          temp[i - 1] = list[i];
        }
      }
      list = temp;
      curr--;
    }
  }

  public void move(int sidx, int didx){
    T[] temp = (T[]) new Object[list.length];
    for(int i = 0; i < list.length; i++){
      if(i < sidx && i < didx){
        temp[i] = list[i];
      }else if(i > sidx && i > didx){
        temp[i] = list[i];
      }else if(i == didx){
        temp[didx] = list[sidx];
      }else if(i <= sidx && i > didx){
        temp[i] = list[i - 1];
      }else if(i < didx && i >= sidx){
        temp[i] = list[i + 1];
      }
    }
    list = temp;
  }

  public T fetch(){
    return list[curr];
  }
  public T fetch(int idx){
    return list[idx];
  }


  public void next(){
    if(curr != tail){
      curr++;
    }
  }

  public void prev(){
    if(curr != head){
      curr--;
    }
  }

  public void jumpToTail(){
    if(list.length < 1){
      curr = 0;
    }
    curr = list.length - 1;
  }

  public void jumpToHead(){
    curr = head;
  }

  public int size(){
    return list.length;
  }
}
