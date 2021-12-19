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
    public static void printArray(Comparable[] arr){

        String output = "[ ";

        for( Comparable c : arr ){
            output += c + ", ";
        }

        output = output.substring( 0, output.length()-2 ) + " ]";

        System.out.println(output);
    }

    public static double arrayAvg(Comparable[] array){ // note that this only works if the Comparables are numbers
        double sum = 0;
        // N: Comparable doesn't recognize the plus operation
        for (Comparable x : array) {
            double numX = (double)(x);
            sum += numX;
        }
        return (sum / array.length );
    }


    public static void main(String[] args) {
        // TESTING BINSEACH VS. LINSEARCH
        int trialsPerArray = 20; // num of trials
        int arrSize = 250_000_000; // array size is 60 mil

        Comparable[] linSResults = new Comparable[trialsPerArray]; // will be populated with the search results
        Comparable[] linSTimes = new Comparable[trialsPerArray]; // will be populated with the search times for linSearch
        double linAvgTime; // average time

        Comparable[] binSResults = new Comparable[trialsPerArray];
        Comparable[] binSTimes = new Comparable[trialsPerArray];
        double binAvgTime;

        System.out.println("Testing the search function ");
        Comparable[] files = makeIntTestCase(arrSize); // making an array of this size

    /*
    Generates a random index in the array and finds it in the array using the
    search methods
    */
        for (int x = 0; x < trialsPerArray; x++ ) {
            int targetIndex = (int)(Math.random()*(arrSize+1)); // generates random index
            Comparable target = files[targetIndex]; //the value of the targeted element

// ~~====== TESTING BINSEARCH
            //System.out.print(val + " at ");
            long startTime = System.currentTimeMillis();
            int foundBin = BinSearch.binSearch(files, target);
            long endTime = System.currentTimeMillis();
            binSResults[x] = foundBin; // to check if the times below make sense
            binSTimes[x] = (endTime - startTime);


// ~~====== TESTING lINSEARCH
            //System.out.print(val + " at ");
            startTime = System.currentTimeMillis();
            int foundLin = LinSearch.linSearch(files, target);
            endTime = System.currentTimeMillis();
            linSResults[x] = foundLin; // to check if the times below make sense
            linSTimes[x] = (endTime - startTime);

        }//end for loop

// ~~====== PRINTING LINSEARCH DATA
        System.out.println("Search results (indexes) from the linear search: ");
        printArray(linSResults);
        System.out.println("Search times from the linear search: ");
        printArray(linSTimes);

// ~~====== PRINTING BINSEARCH DATA
        System.out.println("Search results for the binary search: ");
        printArray(binSResults);
        System.out.println("Search times from the binary search: ");
        printArray(binSTimes);
    }//end main
}//end class
