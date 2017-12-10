/** 12/10/2017
  * Kochi Nakajima - CP222 day10 assignment
  */

public class MergeSort<T extends Comparable> implements ISort<T>{
  /**
   * Sorts an array of items in place
   * @param in An array to sort
   */
  public void sort(T[] in){
    T[] split1;
    T[] split2;

    if(in.length == 1){
      return;
    }else if(in.length%2 == 1){
      split1 = (T[]) new Comparable[in.length/2];
      split2 = (T[]) new Comparable[in.length/2 + 1];
      for(int i = 0; i < in.length/2; i++){
        split1[i] = in[i];
        split2[i] = in[i + (in.length/2)];
      }
      split2[split2.length - 1] = in[in.length - 1];
    }else{
      split1 = (T[]) new Comparable[in.length/2];
      split2 = (T[]) new Comparable[in.length/2];
      for(int i = 0; i < in.length/2; i++){
        split1[i] = in[i];
        split2[i] = in[i + in.length/2];
      }
    }
    sort(split1); // should come out with sorted order
    sort(split2); // should come out with sorted order

    int i = 0;
    int j = 0;
    while(i < split1.length || j < split2.length){
      if(i == split1.length){
        for(j = j; j < split2.length; j++){
          in[i + j] = split2[j];
        }
      }else if(j == split2.length){
        for(i = i; i < split1.length; i++){
          in[i + j] = split1[i];
        }
      }else if(split1[i].compareTo(split2[j]) <= 0){

        in[i + j] = split1[i];
        i++;
      }else if(split1[i].compareTo(split2[j]) >= 0){
        in[i + j] = split2[j];
        j++;
      }
    }
  }
  /**
   * Produces the name of the kind of sort implemented
   * @return the name of the sort algorithm
   */
  public String sortName(){
    return "Merge Sort";
  }
}
