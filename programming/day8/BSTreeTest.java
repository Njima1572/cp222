import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Random;

public class BSTreeTest{

  public static void main(String[] args) throws Exception{

    BufferedReader br=new BufferedReader(new FileReader("shortlist.txt"));
    IList<String> words=new SingleLinkList<String>();
    String l=br.readLine();
    while(l!=null) {
        words.append(l);
        l=br.readLine();
    }

    System.out.println("Doing the inserts");
    // Add them to the dictionaries in random order
    String[] allwords = new String[words.size()];

    IDict<String,Integer> tree   = new BSTree<String,Integer>();
    Random rand = new Random();
    for(int i=0; words.size()>0; i++) {
        int idx = rand.nextInt(words.size());
        allwords[i]=words.fetch(idx);
        words.remove(idx);
        tree.add(allwords[i],i);
    }
    System.out.println("Timing 100,000 fetches");
    long s;
    long e;
    rand.setSeed(0);
    s = System.currentTimeMillis();
    for(int i=0; i<100000; i++) {
        int idx = rand.nextInt(allwords.length);
        if(tree.fetch(allwords[idx]) != idx) {
            System.out.println("bad fetch "+allwords[idx]);
        }
    }
    e = System.currentTimeMillis();
    System.out.println("Tree dict took "+(e-s)+"ms");
  }
}
