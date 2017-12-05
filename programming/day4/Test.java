/**
 * A basic set of tests for IList implementations
 */
public class Test {
    /**
     * Function that exercises list methods
     * Note: This test method has only been tested for n>=10... Small values of
     *       n might fail due to bugs in runTest rather than bugs in the List
     */
    public static void runTest(IList<Integer> list, int n) throws TestFailedException {
        boolean test_failed = false;
        int s; // temp value to support some tests

        // Append n elements to the list
        for(int i=0; i<n; i++) {
            list.append(i);
        }
        System.out.println("A");

        // Check the size
        if(list.size() != n) { test_failed=true; }
        if(test_failed) {
            debugPrint(list);
            throw new TestFailedException("Incorrect list size after append");
        }
        System.out.println("B");


        // Use the index calls to check the elements are there
        for(int i=0; i<n; i++) {
            if(list.fetch(i) != i) { test_failed=true; }
        }
        if(test_failed) {
            debugPrint(list);
            throw new TestFailedException("Incorrect content by index after append");
        }
        System.out.println("C");

        // Use the next call to check the elements are there in order
        list.jumpToHead();
        for(int i=0; i<n; i++) {
            if(list.fetch() != i) { test_failed=true; }
            list.next();
        }
        if(test_failed) {
            debugPrint(list);
            throw new TestFailedException("Incorrect content by next() after append");
        }
        System.out.println("D");



        // Use the prev call to check the elements are there in order
        list.jumpToHead();
        list.jumpToTail();
        for(int i=n-1; i>-1; i--) {
            list.prev();

            if(list.fetch() != i) { test_failed=true; }

            // System.out.println(i + " " + list.fetch());
            // System.out.println(i + " " + list.fetch());
            // System.out.println("----");

        }
        if(test_failed) {
            debugPrint(list);
            throw new TestFailedException("Incorrect content by prev() after append");
        }
        System.out.println("E");

        // Use the move call to mutate the list
        // Use forward moves to put the first element near the end
        for(int i=0; i+2<n; i+=2) {
            list.move(i, i+2);
        }
        // Use backward moves to put the last element near the start
        if(n%2==0) { s=n-1; } else { s=n-2; }
        for(int i=s; i-2>0; i-=2) {
            list.move(i, i-2);
        }
        if(list.fetch(n-1) != 0) { test_failed=true; }
        if(list.fetch(1) != (n-1)) { test_failed=true; }
        if(list.fetch(0) != 1) { test_failed=true; }
        for(int i=2; i<n-2; i++) {
            if(list.fetch(i) != i) { test_failed=true; }
        }
        // Check the size and order
        if(test_failed) {
            debugPrint(list);
            throw new TestFailedException("Incorrect content after moves");
        }
        System.out.println("F");

        // Quick sanity check insert/remove
        list.insert(n/2, -42);
        if(list.fetch(n/2) != -42) { test_failed=true; }
        if(test_failed) {
            debugPrint(list);
            throw new TestFailedException("Incorrect content by after insert by index");
        }
        list.remove(n/2);
        if(list.fetch(n/2) != n/2) { test_failed=true; }
        if(test_failed) {
            debugPrint(list);
            throw new TestFailedException("Incorrect content by after insert by index");
        }
        System.out.println("G");

        // remove half the elements with index calls
        for(int i=1; i<n/2; i++) {
            list.remove(i);
        }
        if(list.fetch(0)!=1) { test_failed=true; }
        for(int i=1; i<n/2-1; i++) {
            if(list.fetch(i) != i*2)  { test_failed=true; }
        }
        // Check the size and order
        if(test_failed) {
            debugPrint(list);
            throw new TestFailedException("Incorrect content by after remove by index");
        }
        System.out.println("H");

        // remove half the elements with remove()
        list.jumpToHead();
        list.remove();
        for(int i=0; i<n/4; i++) {
            list.next();
            list.remove();
            list.next();
        }
        for(int i=0; i<n/4-1; i++) {
            if(list.fetch(i) != 2+i*4) { test_failed=true; }
        }
        // Check the size and order
        if(test_failed) {
            debugPrint(list);
            throw new TestFailedException("Incorrect content after remove()");
        }
        // All tests passed
        System.out.println("All tests passed!");
    }

    /**
     * Exercises functions for several list implementations
     * @param argv incoming command line arguments
     */
    public static void main(String[] argv) throws TestFailedException {
        // Construct three new list instances
        // IList<Integer> arrayList  = new ArrayList<Integer>();
        IList<Integer> singleList = new SingleLinkList<Integer>();
        // IList<Integer> doubleList = new DoubleLinkList<Integer>();
        //
        // Run the tests on each list implementation
        // runTest(arrayList, 105);
        runTest(singleList, 105);
        // runTest(doubleList, 105);
    }

    public static void debugPrint(IList l) {
        for(int i=0; i<l.size(); i++) {
            System.out.println(i+": "+l.fetch(i));
        }
    }
}
