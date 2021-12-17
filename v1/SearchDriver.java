import java.util.ArrayList;

public class SearchDriver{

    public static void insert2(ArrayList<Integer> arr, Integer newVal)
      {
        //initialize high, low, midpt indices
        int lo = 0;
        int med = 0;
        int hi = arr.size()-1;

        while ( lo <= hi ) { //running until target is found or bounds cross

          med = (lo + hi) / 2;
          int x = arr.get(med).compareTo( newVal );

          if ( x == 0 ) {
            //equal value found, insert here
            arr.add( med, newVal );
            return;
          }
          else if ( x > 0 )
            //newVal < med, so look at lower half of data
            hi = med - 1;
          else
            //newVal > med, so look at upper half of data
            lo = med + 1;
        }
        // If you made it this far, newVal is not present.
        // So insert at lo.
        arr.add( lo, newVal );
        //Q: How do you know lo is correct insertion index?
      }

/*
ArrayList<Integer> makeTestCase - wrapper method to streamline test case creation
*/
  public static ArrayList<Integer> makeTestCase(int size) {
    ArrayList<Integer> arr = new ArrayList<Integer>(size);
    for (int i = 0; i < size; i++){
      Integer val = (int) (Math.random() * size);
      insert2(arr, val);
    }
     return arr;
  }



  public static void main(String[] args) {

    // invoking START
    long startTime = System.currentTimeMillis();
    // N: currentTimeMillis is a method of class System
    // N: currentTimeMillis is invoked upon variable creation


    //~~==============TESTING the timing stuff
    startTime = System.currentTimeMillis();
    // sets up an ordered test case
    ArrayList<Integer> IntArr3 = makeTestCase(100000);
    System.out.println(IntArr3);
  // N: With length 100 AND the print statement, it takes about 1-2 ms
  // N: With length 100 AND WITHOUT the print statement, it takes about 0-1 ms
  // N: the time it takes seems to be growing exponentially
    endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime);



    ArrayList<Integer> linSearchTimes = new ArrayList<Integer>(); // to record the search times for linSearch

    // first time testing linSearch vs binSearch:

    ArrayList<Integer> bob = makeTestCase(100000);
    for (int x = 0; x < 10; x++ ) {
      val = Math.random(10000)
      bob.linSearch()
    }// doing a bunch of searches of values on bob

  }


}
