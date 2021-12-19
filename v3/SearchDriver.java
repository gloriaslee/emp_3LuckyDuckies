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

    // public static double arrayAvg(Comparable[] array){ // note that this only works if the Comparables are numbers
    //     double sum = 0;
    //     // N: Comparable doesn't recognize the plus operation
    //     for (Comparable x : array) {
    //         double numX = (double)(x);
    //         sum += numX;
    //     }
    //     return (sum / array.length );
    // }
    public static String printExperResults( int trials, int arrLength) // wrapper method for testing individual trials, so that you get a commprehensible printed result
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



public static void main(String[] args) {

  System.out.println(printExperResults(20, 80_000_000));

  //   int trialsPerArray = 2; // num of trials
  //   int arrSize = 60_000_000; // array size is 60 mil
  //
  //
  //         Comparable[] linSResults = new Comparable[trialsPerArray]; // will be populated with the search results
  //         Comparable[] linSTimes = new Comparable[trialsPerArray]; // will be populated with the search times for linSearch
  //         double linAvgTime; // average time
  //
  //         Comparable[] binSResults = new Comparable[trialsPerArray];
  //         Comparable[] binSTimes = new Comparable[trialsPerArray];
  //         double binAvgTime;
  //
  //         System.out.println("Testing the search function ");
  //         Comparable[] files = makeIntTestCase(arrSize); // making an array of this size
  //
  //         long elapStartTime = System.currentTimeMillis(); // elapsed start time
  //         for (int x = 0; x < trialsPerArray; x++ ) {
  //             int targetIndex = (int)(Math.random()*(arrSize+1)); // generates random index
  //             Comparable target = files[targetIndex]; //the value of the targeted element
  //
  // // ~~====== TESTING BINSEARCH FOR INDIVIDUAL ELEMENTS
  //             long startTime = System.currentTimeMillis();
  //             int foundBin = BinSearch.binSearch(files, target);
  //             long endTime = System.currentTimeMillis();
  //             binSResults[x] = foundBin; // to check if the times below make sense
  //             binSTimes[x] = (endTime - startTime);
  //           }//end for loop
  //
  // // ~~====== PRINTING BINSEARCH DATA
  //         long elapEndTime = System.currentTimeMillis(); // elapsed end time
  //         System.out.println("Elasped time: " + (elapEndTime - elapStartTime) );
  //
  //         elapStartTime = System.currentTimeMillis();
  //         for (int x = 0; x < trialsPerArray; x++ ) {
  //           int targetIndex = (int)(Math.random()*(arrSize+1)); // generates random index
  //           Comparable target = files[targetIndex]; //the value of the targeted element
  //
  // // ~~====== TESTING lINSEARCH FOR INDIVIDUAL CASES
  //             long startTime = System.currentTimeMillis();
  //             int foundLin = LinSearch.linSearch(files, target);
  //             long endTime = System.currentTimeMillis();
  //             linSResults[x] = foundLin; // to check if the times below make sense
  //             linSTimes[x] = (endTime - startTime);
  //
  //         }//end for loop
  //
  // // ~~====== PRINTING LINSEARCH DATA
  //         System.out.println("Testing the linSearch function");
  //         elapEndTime = System.currentTimeMillis();
  //         System.out.println("Elasped time: " + (elapEndTime - elapStartTime) );
      }//end main
    }//end class
