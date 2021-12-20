import java.util.ArrayList;

public class SearchDriver{

    /*
    ArrayList<Integer> makeTestCase - wrapper method to streamline test case creation
    */
    public static Comparable[] makeIntTestCase(int size) {
        Comparable[] arr = new Comparable[size];
        for (int i = 0; i < size; i++){
            arr[i] = i*2;
        }
        return arr;
    }

    /*
    toString() method - used to correctly output Comparables
    */
    public static String printArray(Comparable[] arr){

        String output = "[ ";

        for( Comparable c : arr ){
            output += c + ", ";
        }

        output = output.substring( 0, output.length()-2 ) + " ]";

        return output;
    }


    public static String printIndivResults( int trials, int arrLength) // wrapper method for testing individual trials, so that you get a commprehensible printed result
      { //int counter = 0;
        Comparable[][] experResults = testIndvCases(trials, arrLength);
        String output="";
        output += ("linear search results: "+ printArray(experResults[0]) + "\n");
        output += ("linear search times: "+ printArray(experResults[1]) + "\n\n");
        output += ("binary search results (should be the same as linear search results): " + printArray(experResults[2]) + "\n");
        output += ("binary search times: "+ printArray(experResults[3]) + "\n");

        return output;
      }


    public static Comparable[][] testIndvCases(int trialsPerArray, int arrSize){ // returns the two lists of times; linear search first
      Comparable[] linSResults = new Comparable[trialsPerArray]; // will be populated with the search results
      Comparable[] linSTimes = new Comparable[trialsPerArray]; // will be populated with the search times for linSearch
      Comparable[] binSResults = new Comparable[trialsPerArray];
      Comparable[] binSTimes = new Comparable[trialsPerArray];

      System.out.println("Testing the search function ");
      Comparable[] files = makeIntTestCase(arrSize); // making an array of this size

      for (int x = 0; x < trialsPerArray; x++ ) {
          int targetIndex = (int)(Math.random()*(arrSize+1)); // generates random index
          Comparable target = files[targetIndex]; //the value of the targeted element

// ~~====== TESTING BINSEARCH FOR INDIVIDUAL ELEMENTS
          long startTime = System.currentTimeMillis();
          int foundBin = BinSearch.binSearch(files, target);
          long endTime = System.currentTimeMillis();
          binSResults[x] = foundBin; // to check if the times below make sense
          binSTimes[x] = (endTime - startTime);


// ~~====== TESTING lINSEARCH FOR INDIVIDUAL CASES
          //System.out.print(val + " at ");
          startTime = System.currentTimeMillis();
          int foundLin = LinSearch.linSearch(files, target);
          endTime = System.currentTimeMillis();
          linSResults[x] = foundLin; // to check if the times below make sense
          linSTimes[x] = (endTime - startTime);

      }//end for loop

      Comparable[][] toReturn = new Comparable[4][trialsPerArray];
      toReturn[0] = linSResults;
      toReturn[1] = linSTimes;
      toReturn[2] = binSResults;
      toReturn[3] = binSTimes;
      return toReturn;

    }

    public static String MultCasesWrapper(int trials, int arrLength){
      long[] results = testMultipleCases(trials, arrLength);
      String output = "";
      output += ("Elapsed time for binary search for " + trials + " random values in an array of length " + arrLength + ": ");
      output += (results[0] + "\n");
      output += ("Elapsed time for linear search of " + trials + " random values (that are not necessarily the same): ");
      output += (results[1] + "\n");
      return output;
    }


    public static long[] testMultipleCases(int trialsPerArray, int arrSize){ // returns the
      long[] output = new long[2];
      Comparable[] files = makeIntTestCase(arrSize); // making an array of this size
        // ~~====== TESTING BINSEARCH

      long elapStartTime = System.currentTimeMillis(); // elapsed start time
      for (int x = 0; x < trialsPerArray; x++ ) {
          int targetIndex = (int)(Math.random()*(arrSize+1)); // generates random index
          Comparable target = files[targetIndex]; //the value of the targeted element

          int foundBin = BinSearch.binSearch(files, target);
        }//end for loop
      long elapEndTime = System.currentTimeMillis();
      output[0] = elapEndTime - elapStartTime; // this represents the time for binary search

// ~~====== TESTING lINSEARCH
      elapStartTime = System.currentTimeMillis();
      for (int x = 0; x < trialsPerArray; x++ ) {
        int targetIndex = (int)(Math.random()*(arrSize+1)); // generates random index
        Comparable target = files[targetIndex]; //the value of the targeted element

          int foundLin = LinSearch.linSearch(files, target);
        }
       elapEndTime = System.currentTimeMillis();
        output[1] = elapEndTime - elapStartTime; // this represents the time for linear search

    return output;
  }
    
    public static long[] testWorstCase(int trialsPerArray, int arrSize){
      Comparable[] files = makeIntTestCase(arrSize); // making an array of this size
        long[] totalArray = new long[2];
        for (int i = 0; i < 500; i++){
          long elapStartTime = System.currentTimeMillis(); // elapsed start time
          int targetIndex = arrSize - 1; // generates random index
          Comparable target = files[targetIndex]; //the value of the targeted element
          int foundBin = BinSearch.binSearch(files, target);
          long elapEndTime = System.currentTimeMillis();
          totalArray[0] += (elapEndTime - elapStartTime);
            
          elapStartTime = System.currentTimeMillis();
         targetIndex = arrSize - 1; // generates random index
         target = files[targetIndex]; //the value of the targeted element
          int foundLin = LinSearch.linSearch(files, target);
           elapEndTime = System.currentTimeMillis();
            totalArray[1] += (elapEndTime - elapStartTime);
        }//end for loop
    return totalArray;
    }
    

      public static String WorstCaseWrapper(int trials, int arrLength){
      long[] results = testWorstCase(trials, arrLength);
      String output = "";
      Comparable[] outArr = new Comparable[2];
      output += ("Elapsed time for binary search for worst case: ");
      output += (results[0] + "\n");
      output += ("Elapsed time for linear search for worst case: ");
      output += (results[1] + "\n");
      return output;
    }


public static void main(String[] args) {
  System.out.println("Timing searches for multiple values together \n");
  System.out.println(MultCasesWrapper(200, 20_000_000));
  System.out.println(WorstCaseWrapper(200, 20_000_000));
  // System.out.println("Timing the searches of each value searched \n");
  // System.out.println(printIndivResults(20, 80_000_000));

      }//end main
    }//end class
