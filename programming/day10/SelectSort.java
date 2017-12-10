/** 12/10/2017
  * Kochi Nakajima - CP222 day10 assignment
  */


public class SelectSort<T extends Comparable> implements ISort<T>{
  /**
   * Sorts an array of items in place
   * @param in An array to sort
   */
  public void sort(T[] in){
    int minIdx;
    T[] sortingArray = (T[]) new Comparable[in.length];

    for(int j = 0; j < in.length; j++){
      minIdx = j;
      for(int i = j; i < in.length; i++){
        if(in[minIdx].compareTo(in[i]) > 0){
          minIdx = i;
        }
      }
      sortingArray[j] = in[minIdx];
      in[minIdx] = in[j];
    }
    for(int i = 0; i < in.length; i++){
      in[i] = sortingArray[i];
    }
  }
  /**
   * Produces the name of the kind of sort implemented
   * @return the name of the sort algorithm
   */
  public String sortName(){
    return "Select Sort";
  }
}
