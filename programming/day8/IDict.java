/**
 * Interface for a dictionary data structure
 */
public interface IDict<K extends Comparable<K>,V> {
    /**
     * Adds a value to the dictionary, replacing the existing value if any.
     * @param k key for the new value
     * @param v value
     * @return the value replaced, otherwise null
     */
    public V add(K k, V v);
    
    /**
     * Removes a value and key from the dictionary. An unmatched key should return null.
     * @param k key to remove
     * @return the value of the removed key
     */
    public V remove(K k);
    
    /**
     * Returns the size of the dictionary
     * @return the number of values stored in the dictionary
     */
    public int size();
    
    /**
     * Returns the value associated with a particular key in the dictionary.
     * Returns null if there is no matching key.
     * @param k key to retrieve the value for
     * @return the value
     */
    public V fetch(K k);
    
    /**
     * Returns an array of the keys in the dictionary
     * @return array of all keys
     */
    public K[] keys();
}