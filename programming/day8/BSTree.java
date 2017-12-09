/**
* Interface for a dictionary data structure
*/
public class BSTree<K extends Comparable<K>, V> implements IDict<K, V>{

  Node root;
  Node curr;
  int size;
  K[] keysArray;


  public BSTree(){
    root = new Node(null, null);
    curr = root;
    size = 0;
    keysArray = (K[]) new Comparable[1000000];

  }


  /**
   * Adds a value to the dictionary, replacing the existing value if any.
   * @param k key for the new value
   * @param v value
   * @return the value replaced, otherwise null
   */
   public V add(K k, V v){
     V tempValue = getNode(k).value;
     getNode(k).setValue(v);
     size++;
     return tempValue;
   }

  // THIS WORKS FINE
  // public V add(K k, V v){
  //   Node newNode = new Node(k, v);
  //   Node parent;
  //   boolean inserted = false;
  //   V returnValue = null;
  //   curr = root;
  //   if(root.getKey() == null){
  //     root = newNode;
  //     size++;
  //     keysArray[size - 1] = k;
  //     return returnValue;
  //   }
  //   while(!inserted){
  //     if(k.compareTo((K)curr.key) < 0){ //if key is before curr.getKey
  //       if(curr.leftNode == null){
  //         curr.setLeft(newNode);
  //         inserted = true;
  //       }else{
  //         parent = curr;
  //         curr = curr.leftNode;
  //         if(k.equals((K)curr.key)){
  //           returnValue = (V)curr.value;
  //           curr.setValue(v);
  //           inserted = true;
  //         }
  //       }
  //     }else if(k.compareTo((K)curr.getKey()) > 0){
  //       if(curr.rightNode == null){
  //         curr.setRight(newNode);
  //         inserted = true;
  //       }else{
  //         parent = curr;
  //         curr = curr.rightNode;
  //         if(k.equals((K)curr.key)){
  //           returnValue = (V)curr.value;
  //           curr.setValue(v);
  //           inserted = true;
  //         }
  //       }
  //     }
  //   }
  //   size++;
  //   keysArray[size - 1] = k;
  //   return returnValue;
  // }
  //


  /**
   * Removes a value and key from the dictionary. An unmatched key should return null.
   * @param k key to remove
   * @return the value of the removed key
   */

   public V remove(K k){
     Node removing = getNode(k);
     V returnValue = (V)removing.value;

     if(root == removing){//if removing element is a root

       if(removing.rightNode == null && removing.leftNode == null){

         root = new Node(null, null); //NOTHING LEFT ON THIS TREE;
         return getNode(k).value;
       }else if(removing.rightNode == null || removing.leftNode == null){

         if(removing.rightNode != null){
           root = removing.rightNode;
           return returnValue;
         }
       }else{ //if root has two children
         Node switching = removing.rightNode;
         Node switchingParent = removing;
         int count = 0;

         while(switching.leftNode != null){
           switchingParent = switching;
           switching = switching.leftNode;
           count++;
         }
         if(count > 0){
           switchingParent.setLeft(switching.rightNode);
           switching.setLeft(removing.leftNode);
           switching.setRight(removing.rightNode);
           root = switching;
           return returnValue;
         }else if(count == 0){


           switching.setLeft(removing.leftNode);
           removing.leftNode.setParent(switching);


           switching.setParent(null);
           removing.setLeft(null);
           removing.setRight(null);
           root = switching;
           return returnValue;
         }
       }
     }else if(removing.isLeaf()){//if removing element is a leaf
       if(removing.parent.rightNode == (removing)){
         removing.parent.setRight(null);
         removing.setParent(null);
      }
       else if(removing.parent.leftNode == (removing)){
         removing.parent.setLeft(null);
         removing.setParent(null);
       }

     }else if(removing.rightNode == null){ //if removing element only has a child
       if(removing.parent.rightNode == (removing)){
         removing.parent.setRight(removing.leftNode);
         removing.leftNode.setParent(removing.parent);
      }
       if(removing.parent.leftNode == (removing)){
         removing.parent.setLeft(removing.leftNode);
         removing.leftNode.setParent(removing.parent);
      }

     }else if(removing.leftNode == null){//if removing element only has a child #2
       if(removing.parent.rightNode == (removing)){removing.parent.setRight(removing.rightNode);}
       if(removing.parent.leftNode == (removing)){removing.parent.setLeft(removing.rightNode);}

     }else{ //if removing element has two children
       Node removingParent = removing.parent;
       Node switching = removing.rightNode;
       Node switchingParent = removing;
       int count = 0;
       while(switching.leftNode != null){
         switchingParent = switching;
         switching = switching.leftNode;
         count++;
       }
       if(count > 0){
         removingParent.setLeft(switching);
         switching.setLeft(removing.leftNode);
         switching.setRight(removing.rightNode);
         if(removingParent.rightNode == (removing)){removingParent.setRight(switching);}
         if(removingParent.leftNode == (removing)){removingParent.setLeft(switching);}
       }else{
         removingParent.setRight(switching);
         switching.setLeft(removing.leftNode);
         removing.setParent(null);
         removing.leftNode.setParent(switching);

       }
     }

     return (V)removing.value;
   }





   // public V remove(K k){
   //   Node removing = getNode(k);
   //   Node parent = removing.parent;
   //
   //   if(removing.getRight() == null && removing.getLeft() == null){
   //     if(parent.getRight().equals(removing)){
   //       parent.setRight(null);
   //     }
   //     if(parent.getLeft().equals(removing)){
   //       parent.setLeft(null);
   //     }
   //     return (V)removing.value;
   //   }
   //   if(removing.getRight() == null || removing.getLeft() == null){
   //     if(removing.getRight() == null){
   //       if(parent.getRight() == removing){
   //         parent.setRight(removing.getLeft());
   //       }else{
   //         parent.setLeft(removing.getLeft());
   //       }
   //     }else{
   //       if(parent.getLeft() == removing){
   //         parent.setRight(removing.getRight());
   //       }else{
   //         parent.setLeft(removing.getRight());
   //       }
   //     }
   //     return (V)removing.value;
   //   }
   //   Node swapping = getNode(k).getRight();
   //   Node swappingParent = getNode(k);
   //   while(swapping.getLeft() != null){
   //     swappingParent = swapping;
   //     swapping = swapping.getLeft();
   //   }
   //
   //   swappingParent.setLeft(swapping.getRight());
   //   swapping.setLeft(removing.getLeft());
   //   swapping.setRight(removing.getRight());
   //   if(parent.getRight()==removing){
   //     parent.setRight(swapping);
   //   }else{
   //     parent.setLeft(swapping);
   //   }
   //
   //   return (V)removing.value;
   //
   // }

  // public V remove(K k){
  //   Node<K, V> removing = getNode(k);
  //   Node<K, V> removingParent = getParent(removing);
  //   Node<K, V> replacingNode;
  //
  //   if(removingParent != null){
  //     if(removing.leftNode == null && removing.rightNode == null){
  //       if(k.compareTo(removingParent.key) < 0){ //k is smaller than removing parent
  //         removingParent.setLeft(null);
  //       }
  //       if(k.compareTo(removingParent.key) > 0){
  //         removingParent.setRight(null);
  //       }
  //     }else if(removing.leftNode == null){
  //       if(removingParent.rightNode.equals(removing)){
  //         removingParent.setRight(removing.rightNode);
  //       }else if(removingParent.leftNode.equals(removing)){
  //         removingParent.setLeft(removing.rightNode);
  //       }
  //     }else if(removing.rightNode == null){
  //       if(removingParent.rightNode.equals(removing)){
  //         removingParent.setRight(removing.leftNode);
  //       }else if(removingParent.leftNode.equals(removing)){
  //         removingParent.setLeft(removing.leftNode);
  //       }
  //     }else{
  //       replacingNode = removing.rightNode;
  //       while(replacingNode.leftNode != null){
  //         replacingNode = replacingNode.leftNode;
  //       }
  //       replacingNode.setRight(removing.rightNode);
  //       replacingNode.setLeft(removing.leftNode);
  //       System.out.println(removingParent.leftNode.key);
  //
  //       System.out.println(removingParent.rightNode.key);
  //       if(removingParent.rightNode.equals(removing)){
  //         removingParent.setRight(replacingNode);
  //       }else if(removingParent.leftNode.equals(removing)){
  //         removingParent.setLeft(replacingNode);
  //       }
  //     }
  //   }
  //   return (V)removing.getValue();
  // }

  // public V remove(K k){
  //   Node removing = getNode(k);
  //   Node removingParent = getParent(removing);
  //   Node replacing;
  //   if(removingParent != null){
  //     if(removingParent.rightNode.equals(removing)){//if right node is the removing
  //       if(removing.hasTwoChildren()){ //if removing has two children, get the left most
  //         replacing = removing.rightNode;
  //         while(replacing.leftNode != null){
  //           replacing = replacing.leftNode;
  //         }
  //         replacing.setRight(removing.rightNode);
  //         replacing.setLeft(removing.leftNode);
  //         removingParent.setRight(replacing);
  //       }else if(removing.rightNode == null && removing.leftNode == null){//if removing has no children
  //         removingParent.setRight(null); //kill the child
  //       }else{//if removing has only one child
  //         if(removing.rightNode == null){
  //           removingParent.setRight(removing.leftNode);
  //         }else{
  //           removingParent.setRight(removing.rightNode);
  //         }
  //       }
  //     }else if(removingParent.leftNode.equals(removing)){//if left node is the removing
  //       if(removing.hasTwoChildren()){ //if removing has two children, get the left most
  //         replacing = removing.rightNode;
  //         while(replacing.leftNode != null){
  //           replacing = replacing.leftNode;
  //         }
  //         replacing.setRight(removing.rightNode);
  //         replacing.setLeft(removing.leftNode);
  //         removingParent.setLeft(replacing);
  //       }else if(removing.rightNode == null && removing.leftNode == null){//if removing has no children
  //         removingParent.setRight(null); //kill the child
  //       }else{//if removing has only one child
  //         if(removing.rightNode == null){
  //           removingParent.setLeft(removing.leftNode);
  //         }else{
  //           removingParent.setLeft(removing.rightNode);
  //         }
  //       }
  //     }
  //   }else{
  //     replacing = removing.rightNode;
  //     System.out.println(replacing.key);
  //     if(replacing.leftNode == null){
  //       replacing.setRight(removing.rightNode);
  //       replacing.setLeft(removing.leftNode);
  //       System.out.println("NOPARENT");
  //       size--;
  //       root = replacing;
  //       return (V)removing.value;
  //     }
  //     while(replacing.leftNode != null){
  //       replacing = replacing.leftNode;
  //     }
  //     replacing.setRight(removing.rightNode);
  //     replacing.setLeft(removing.leftNode);
  //     root = replacing;
  //
  //   }
  //   size--;
  //   return (V)removing.value;
  // }

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
    return (V)getNode(k).value;
  }

  /**
   * Returns an array of the keys in the dictionary
   * @return array of all keys
   */

  public K[] keys(){
    return keysArray;
  }

  public Node<K, V> getNode(K k){
    Node<K, V> designated;
    curr = root;
    if(root.key == null){
      root.key = k;
    }
    if(curr.key.equals(k)){
      designated = curr;
      designated.setParent(null);
      return designated;
    }
    while(!curr.key.equals(k)){
      if(k.compareTo((K)curr.key) < 0){ //move to left
        if(curr.leftNode != null){
          curr = curr.leftNode;
        }else if(curr.leftNode == null){
          designated = new Node(k, null);
          curr.setLeft(designated);
          designated.setParent(curr);
          return designated;
        }
      }else if(k.compareTo((K)curr.key) > 0){//  move to right
        if(curr.rightNode != null){
          curr = curr.rightNode;
        }else if(curr.rightNode == null){
          designated = new Node(k, null);
          curr.setRight(designated);
          designated.setParent(curr);
          return designated;
        }
      }
    }
    designated = curr;
    return designated;
  }

  // public Node findEmpty(){
  //   return null;
  // }



  public class Node<K extends Comparable<K>, V>{
    K key;
    V value;
    Node leftNode;
    Node rightNode;
    boolean complete;
    Node parent;

    public Node(K k, V v){
      key = k;
      value = v;
      leftNode = null;
      // rightNode = null;
    }

    public void setParent(Node p){
      parent = p;
    }

    public K getKey(){
      if(key == null){
        return null;
      }
      return key;
    }


    public V getValue(){
      if(value == null){
        return null;
      }
      return value;
    }


    public Node getLeft(){
      if(leftNode == null){
        return null;
      }
      return leftNode;
    }


    public Node getRight(){
      if(rightNode == null){
        return null;
      }
      return rightNode;
    }

    public void setValue(V v){
      value = v;
    }


    public void setRight(Node right){
      rightNode = right;
    }

    public void setLeft(Node left){
      leftNode = left;
    }

    public boolean isLeaf(){
      if(rightNode == null && leftNode == null){
        return true;
      }
      return false;
    }
    public boolean hasTwoChildren(){
      if(this.getRight() == null || this.getLeft() == null){
        return false;
      }
      return true;

    }
    public boolean equals(Node o){
      return (this.key.equals(o.key) && this.value.equals(o.value));
    }

    public void setKey(K k){
      key = k;
    }

  }

  public static void main(String[] args){
    BSTree<Integer, Integer> tree = new BSTree<Integer, Integer>();
    tree.add(3,3);
    tree.add(1,1);
    tree.add(0,0);
    tree.add(2,2);
    tree.add(5,5);

    tree.add(4,4);
    tree.add(6,6);

    for(int i = 0; i < 7; i++){
      System.out.println("i: " + i + " fetched: " + tree.fetch(i));
    }
    System.out.println("-------------");

    // for(int i = 0; i < tree.keysArray.length; i++){
    //   System.out.print(" " + tree.keysArray[i] + "  ");
    //
    // }
    // tree.remove(1);

    tree.remove(5);
    tree.remove(4);
    // tree.remove(3);
    // tree.remove(2);
    for(int i = 0; i < 7; i++){
      System.out.println("i: " + i + " fetched: " + tree.fetch(i));
    }
  }
}
