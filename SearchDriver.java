import java.util.ArrayList;

public class SearchDriver{

  public static boolean insert(ArrayList<Integer> arr, Integer value) { // this is a function that adds each element to teh array
     if (r.size() == 0){
       this._arr.add(value);
     } else if (this._arr.get(0) > value) {
			this._arr.add(0,value);
			return true;

    }	else if (value > this._arr.get(this._arr.size()-1)) {
			this._arr.add(value);
			return true;

    }	else {
			for(int i = 0; i < this._arr.size(); i++) {
				if (this._arr.get(i) <= value && this._arr.get(i+1) >= value) { //should this be >= and <= or just > and <
					this._arr.add(i+1, value);
					return true;}
				}
			}
			return false;
		}//end addLinear

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
      b.add( (int) (Math.random() * 101) );
    }
    long endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime); // elapsed time in milliseconds


    startTime = System.currentTimeMillis();
    ArrayList<Integer> IntArr2 = new ArrayList<Integer>(1000000);
    for (int i = 0; i < 1000000; i++){
      c.add( (int) (Math.random() * 701) );
    }
    endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime);


    ArrayList<Integer> IntArr3 = new ArrayList<Integer>(1000000);
    for (int i = 0; i < 1000000; i++){
      Integer val = (int) Math.random() * 1000000;
      insert(IntArr3, val);
    }
  }
  //public static long currentTimeMillis();
}
