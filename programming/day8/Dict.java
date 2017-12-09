/**
 * Interface for a dictionary data structure
 */
import java.util.ArrayList;

public class Dict<K extends Comparable<K>,V> implements IDict<K, V>{
  K key;
  V value;
  Item item;
  int size;
  ArrayList<Item> dictionary;

  public Dict(){
    item = new Item(null, null);
    size = 0;
    dictionary = new ArrayList<Item>();
  }
    /**
     * Adds a value to the dictionary, replacing the existing value if any.
     * @param k key for the new value
     * @param v value
     * @return the value replaced, otherwise null
     */
    public V add(K k, V v){
      // V tempValue = this.fetch(k);
      Item newItem = new Item(k, v);
      dictionary.add(newItem);
      size++;
      return null;
    }

    /**
     * Removes a value and key from the dictionary. An unmatched key should return null.
     * @param k key to remove
     * @return the value of the removed key
     */
    public V remove(K k){
      boolean found = false;
      V tempValue = this.fetch(k);
      int i = 0;
      while(!found){
        if(dictionary.get(i).key.equals(k)){
          found = true;
        }
        i++;
      }
      dictionary.remove(i);
      return value;
    }

    /**
     * Returns the size of the dictionary
     * @return the number of values stored in the dictionary
     */
    public int size(){
      return size;
    }

    /**
     * Returns the value associated with a particular key in the dictionary.
     * Returns null if there is no matching key.
     * @param k key to retrieve the value for
     * @return the value
     */
    public V fetch(K k){
      int i = 0;
      V returnValue = null;
      while(i < dictionary.size()){
        if(dictionary.get(i).key.equals(k)){
          returnValue = (V)dictionary.get(i).value;
          return returnValue;
        }
        i++;
      }
      return null;
    }

    /**
     * Returns an array of the keys in the dictionary
     * @return array of all keys
     */
    public K[] keys(){
      K[] keysArray = (K[]) new Object[size];
      for(int i = 0; i < dictionary.size(); i++){
        keysArray[i] = (K)dictionary.get(i);
      }
      return keysArray;
    }

    static class Item<K extends Comparable<K>, V>{
      K key;
      V value;
      private Item(K k, V v){
        key = k;
        value = v;
      }
    }


    public static void main(String[] args){
      Dict d = new Dict();

      d.add(1,1);
      d.add(0,0);
      d.add(4,4);
      d.add(3,3);
      d.add(6,6);
      d.add(5,5);
      d.add(2,2);
      System.out.println(d.keys());
      d.remove(1);
      for(int i = 0; i < d.size(); i++){
        System.out.println(d.fetch(i));
      }
    }
}
