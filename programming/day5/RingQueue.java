public class RingQueue<T> implements IQueue<T>{
  int front;
  int back;
  T[] ringqueue;


  public RingQueue(int size){
    front = 0;
    back = 0;
    ringqueue = (T[]) new Object[size];

  }
  public T dequeue() throws UnderFlowException{
    T temp = ringqueue[front % ringqueue.length];
    front = (front + 1) % ringqueue.length;
    return temp;
  }

  public void enqueue(T v) throws OverFlowException{
    ringqueue[back % ringqueue.length] = v;
    back = (back + 1) % ringqueue.length;
  }

}
