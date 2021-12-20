public class LinSearch
{
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
}//end class LinSearch
