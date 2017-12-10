import java.util.Random;

/**
 * Runs a performance test on sort algorithms using ISort interface
 */
public class Test {
    public static void main(String[] argv) {
        long s;
        long e;
        ISort[] sorts = new ISort[2];
        sorts[0] = new SelectSort<Integer>();
        sorts[1] = new MergeSort<Integer>();
        
        Random r = new Random();
        // Process each algorithm
        for(int i=0; i<sorts.length; i++) {
            // Scale from 100 to 1000000 by 10s
            for(int l=100; l<1000000; l*=10) {
                // Prepare the array
                Integer[] a = new Integer[l];
                for(int j=0; j<l; j++) {
                    a[j] = r.nextInt();
                }
                // Time the sort
                s = System.currentTimeMillis();
                sorts[i].sort(a);
                e = System.currentTimeMillis();
                System.out.println("Sorted "+l+" items in "+(e-s)+"ms using "+sorts[i].sortName());
            }
        }
    }
}