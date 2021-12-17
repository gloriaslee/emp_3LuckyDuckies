/**
3 Lucky Duckies - Gloria Lee, Ziying Jian, Nora Miller
APCS
HW 48_search
   class LinSearch
2021 - 12 - 15
Time Spent: 1.5 h
QCC:
What is the syntax for comparing comparables to each other?
Is it possible to typecast comparables into int? And if so, what's the syntax for doing so?
Is it more efficient to binary search recursively or iteratively?
DISCO:
We cannot compare Comparables to each other using the simple == or < or > operators.
We cannot typecast Comparables using (int).
When compiling, a warning comes up, but this warning can be ignored. Why?
**/

public class LinSearch
{

  /**
     int linSearch(Comparable[],Comparable) -- searches an array of
     Comparables for target
     post: returns index of first occurrence of target, or
     returns -1 if target not found
  **/
  public static int linSearch ( Comparable[] a, Comparable target )
  {
    int tPos = -1;
    int i = 0;

    while ( i < a.length ) {
      if (a[i].equals(target) ) {
        tPos = i;

        break;
      }
      i+=1;

    }
    return tPos;
  }


  // utility/helper fxn to display contents of an array of Objects
  private static void printArray( Object[] arr )
  {
    String output = "[ ";

    for( Object o : arr )
      output += o + ", ";

    output = output.substring( 0, output.length()-2 ) + " ]";

    System.out.println( output );
  }


  //main method for testing
  //minimal -- augment as necessary
  public static void main ( String[] args )
  {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    System.out.println("\nNow testing linSearch on int array...");
    //Declare an array of Comparables and initialize it using ints
    //   Each int will be autoboxed to class Integer,
    //   which implements Comparable.
    Comparable[] iArr = { 2, 4, 6, 8, 6, 42 };
    printArray( iArr );
    //search for 6 in array
    System.out.println( linSearch(iArr,6) ); // expecting 2

    //search for 43 in array
    System.out.println( linSearch(iArr,43) ); // expecting -1
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    System.out.println("\nNow testing linSearch on Comparable arrays...");
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    System.out.println("\nNow testing linSearch on String array...");
    //declare and initialize an array of Strings
    String[] sArr = { "kiwi", "watermelon", "orange", "apple",
                      "peach", "watermelon" };
    printArray( sArr );
    //search for "watermelon" in array
    System.out.println( linSearch(sArr,"watermelon") ); // expecting 1
    //search for "lychee" in array
    System.out.println( linSearch(sArr,"lychee") ); // expecting -1
/*----------------------------------------------------
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ----------------------------------------------------*/

  }//end main()

}//end class LinSearch
