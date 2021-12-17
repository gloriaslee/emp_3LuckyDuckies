import java.util.ArrayList;


public class BinSearch
{

  /**
     int binSearch(Comparable[],Comparable) -- searches an array of
     Comparables for target Comparable
     pre:  input array is sorted in ascending order
     post: returns index of target, or returns -1 if target not found
  **/
  public static int binSearch ( ArrayList<Integer> a, Integer target )
{
  if (isSorted(a) == true){
    return binSearchRec( a, target, 0, a.size()-1 );
    //return binSearchRec( a, target, 0, a.length-1 );
  }
  return -1; //BinSearch only works if sorted
}


  public static int binSearchRec( ArrayList<Integer> a,
                                  Integer target,
                                  int lo, int hi )
  {
    int tPos = -1; //init return var to flag value -1

        int m = (lo + hi) / 2; //init mid pos var

        //exit case. If lo & hi have crossed, target not present
        if (lo > hi)
          return tPos; //-1

        // target found
        if ( cmpareTo(a.get(m), target) == 0 )
          tPos = m;
        // value at mid index higher than target
        else if ( cmpareTo( a.get(m), target) > 0 )
          tPos = binSearchRec( a, target, 0, m-1 );
        // value at mid index lower than target
        else if ( cmpareTo(a.get(m), target) < 0 )
          tPos = binSearchRec( a, target, m+1, hi );

        return tPos;
  }//end binSearchRec


  
  //tell whether an array is sorted in ascending order
  private static boolean isSorted( ArrayList<Integer> arr )
  {

    boolean retBoo = true; //init to true, assume array is sorted

    //Q: Why would a FOREACH loop not suffice here?
    //A. Because we need to refer to the indexes to make any statement regarding consecutive values
    for( int i=0; i < arr.size()-1; i++ ) {
      if ( ( cmpareTo(arr.get(i),arr.get(i+1)) > 0 ) ) {
        return false;
      }
    }
    return retBoo; //if entire array was traversed, it must be sorted
  }

 public static int cmpareTo(Integer a, Integer b){

     // should be some variant of subtraction
     Integer diff = a - b; 
     if (diff == 0) {
       return 0;
     } else if(diff > 0){
       return 1;
     } else {
       return -1;
     }
   }

  // utility/helper fxn to display contents of an array of Objects
  private static void printArray( ArrayList<Integer> arr ) {
    String output = "[ ";

    for( Integer c : arr )
	    output += c + ", ";

    output = output.substring( 0, output.length()-2 ) + " ]";

    System.out.println( output );
  }



  //main method for testing
  //minimal -- augment as necessary
  public static void main ( String[] args )
  {


    System.out.println("\nNow testing binSearch on Comparable array...");
    //Declare and initialize array of Comparables
    ArrayList<Integer> iArr = new ArrayList<Integer>();
	iArr.add(2); 
	iArr.add(4); 
	iArr.add(6); 
	iArr.add(8); 
	iArr.add(16); 
	iArr.add(42); 
    System.out.println( "iArr1 sorted? -- " + isSorted(iArr) );
    iArr.add(4, 13); 
    printArray( iArr );
    System.out.println( "iArr2 sorted? -- " + isSorted(iArr) );
    //Comparable[] iArr3 = new Integer[10000];
    /* for( int i = 0; i < iArr3.length; i++ ) {
    iArr3[i] = i * 2;
    }
    printArray( iArr3 );
    System.out.println( "iArr3 sorted? -- " + isSorted(iArr3) ); //fixed the typo */

  //search for 6 in array


    System.out.println( binSearch(iArr,2) );
    System.out.println( binSearch(iArr,4) );
    System.out.println( binSearch(iArr,6) );
    System.out.println( binSearch(iArr,8) );
    System.out.println( binSearch(iArr,13) );
    System.out.println( binSearch(iArr,42) );
    //search for 43 in array
    System.out.println( binSearch(iArr,43) );
    //System.out.println( "now testing binSearch on iArr3..." );
    /* System.out.println( binSearch(iArr3,4) );
    System.out.println( binSearch(iArr3,8) );
    System.out.println( binSearch(iArr3,5) );
    //search for 43 in array
    System.out.println( binSearch(iArr3,43) ); */
    /*----------------------------------------------------
    ====================================================*/


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  }//end main()

}//end class BinSearch2
