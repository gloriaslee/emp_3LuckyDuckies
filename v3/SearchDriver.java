import java.util.ArrayList;

public class SearchDriver{



/*
ArrayList<Integer> makeTestCase - wrapper method to streamline test case creation
*/
  public static Comparable[] makeTestCase(int size) {
    Comparable[] arr = new Comparable[](size);
    for (int i = 0; i < size; i++){
      arr[i] = i*2;
    }
     return arr;
  }



  public static void main(String[] args) {

    //~~==============TESTING the timing stuff
    startTime = System.currentTimeMillis();
    // sets up an ordered test case
    ArrayList<Integer> fridge = makeTestCase(1000000); // 10^6
    // Notes to self: do not print the array itself
  // N: With length 100 AND the print statement, it takes about 1-2 ms
  // N: With length 100 AND WITHOUT the print statement, it takes about 0-1 ms
    endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime);


  // TESTING BINSEACH VS. LINSEARCH
    ArrayList<Integer> linSResults = new ArrayList<Integer>(); // to record searcn results
    ArrayList<Long> linSTimes = new ArrayList<Long>(); // to record the search times for linSearch

    System.out.println("Testing the search function");
    ArrayList<Integer> files = makeTestCase(100000);
  //System.out.println(files);

    for (int x = 0; x < 10; x++ ) { // the upper bound here will deterint the sizes of the two ArrayLists above
      Integer val = (int)(Math.random()*100000);
    //System.out.print(val + " at ");

    startTime = System.currentTimeMillis();
      int found = LinSearch.linSearch(files, val);
    endTime = System.currentTimeMillis();

      linSTimes.add(endTime - startTime);
    //linSResults.add(found);

    }// doing a bunch of searches of values on bob
  //System.out.println(linSResults);
  System.out.println(linSTimes);
  }



}
