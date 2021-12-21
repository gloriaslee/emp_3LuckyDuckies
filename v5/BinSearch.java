public class BinSearch
{
  public static int binSearch ( Comparable[] a, Comparable target ){
    return binSearchIter(a, target, 0, a.length-1);
  }


  public static int binSearchIter( Comparable[] a,
                                   Comparable target, // a value
                                   int lo, int hi ) // an index
  {
    int tPos = -1; //init return var to flag value -1
    int m = (lo + hi) / 2; //init mid pos var

    while( lo <= hi ) { // run until lo & hi cross

      m = (lo + hi) / 2; //update mid pos var

      // target found
      if ( a[m].compareTo(target) == 0 )
        return m;

      // value at mid index higher than target
      else if ( a[m].compareTo(target) > 0 )
        hi = m - 1; //move hi to index to left of mid

      // value at mid index lower than target
      else if ( a[m].compareTo(target) < 0 )
        lo = m + 1; //move lo to index to right of mid
    }
    return m;
  }
}//end class BinSearch2
