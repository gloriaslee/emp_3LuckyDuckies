import java.util.ArrayList;

public class SearchDriver{

  // public static boolean insert(ArrayList<Integer> arr, Integer value) { // this is a function that adds each element to teh array
  //    if (arr.size() == 0){
  //      arr.add(value);
  //    } else if (arr.get(0) > value) {
	// 		arr.add(0,value);
	// 		return true;
  //
  //   }	else if (value > arr.get(arr.size()-1)) {
	// 		arr.add(value);
	// 		return true;
  //
  //   }	else {
	// 		for(int i = 0; i < arr.size(); i++) {
	// 			if (arr.get(i) < value && arr.get(i+1) > value) { //should this be >= and <= or just > and <
	// 				arr.add(i+1, value);
	// 				return true;}
	// 			}
	// 		}
	// 		return false;
	// 	}//end addLinear

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

    //~~==============TESTING INTS
  /*  int[] a = new int[100];
   for (int i = 0; i < 100; i++){
    a[i] = i;
 }
   */

    //~~==============TESTING INTEGER
    startTime = System.currentTimeMillis();
    ArrayList<Integer> IntArr1 = new ArrayList<Integer>(1000000); // 1 million
    for (int i = 0; i < 1000000; i++){
      IntArr1.add( (int) (Math.random() * 101) );
    }
    long endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime); // elapsed time in milliseconds


    startTime = System.currentTimeMillis();
    ArrayList<Integer> IntArr2 = new ArrayList<Integer>(1000000);
    for (int i = 0; i < 1000000; i++){
      IntArr2.add( (int) (Math.random() * 701) );
    }
    endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime);


    startTime = System.currentTimeMillis();
    // sets up an ordered test case
    ArrayList<Integer> IntArr3 = makeTestCase(100000);
    System.out.println(IntArr3);
  // N: With length 100 AND the print statement, it takes about 1-2 ms
  // N: With length 100 AND WITHOUT the print statement, it takes about 0-1 ms
  // N: the time it takes seems to be growing exponentially
    endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime);


  }


}
