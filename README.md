# emp_3LuckyDuckies

#### 3LuckyDuckies: Gloria Lee, Ziying Jian, Nora Miller

## Tests Performed:
We ultimately used two different tests of the speeds of binary and linear search relative to array size.

The first test, nested in the MultCasesWrapper method, operates roughly like an average - it reports the elapsed time for each search type to search multiple randomly selected values within an array that is constant and is identical for both search types. The user may choose the size of the array being searched, and the number of random values being searched. Since the values are random, it is not necessarily the case (rather, extremely improbable) that the values being searched for will be the same between binary and linear search. However, searching for a large number of values ensures that the total runtime will be similar between trials. This was eun 200 times for each trial.

The second test, nested in the WorstCaseWrapper method, records the runtime of the worst possible search case - the last value in the array - for both linear search and binary search. Here, both the array being searched and the value being searched are the same between the search types. Since doing this once requires less than a millisecond for binary search, this process is repeated 500 times, identically. As in the other test function, the user may specify the size of the array.

For each test, we ran the code three times to ensure replicability. However, because Nora's computer runs slowly, all tests were run either on the school computers or on Gloria's.

As discussed in class, we decided not to created a method to average the results because the results were so conclusive. We also removed a method recording the runtimes of linear search and binary search for a given number of individual searches for randomly selected values - see v3.


## Results:

Elapsed time, in milliseconds, for the following test cases: 

| Array length | Trial | Bin. search of 500 random values | Lin. search of 500 random values | Worst case bin. search | Worst case lin. search 3 |
| ----- | --------- | ----- | ---- | --- | ---- |
|  1,000,000 | 1 | 2 | 286 | 1 | 669 |
|   | 2 | 2 | 272 | 1 | 600 |
|  | 3 | 2 | 262 | 2 | 600 |
|  2,000,000 | 1 | 1 | 855 | 0 | 1603 |
|   | 2 | 1 | 820 | 1 | 1483 |
|  | 3 | 1 | 863 | 0 | 1522 |
|  5,000,000 | 1 | 1 | 2275 | 0 | 3993 |
|   | 2 | 1 | 2136 | 1 | 4153 |
|  | 3 | 0 | 2136 | 2 | 4092 |
| 10,000,000 | 1 | 0 | 3254 | 1 | 6400 |
|  | 2 | 1 | 3453 | 1 | 6445 |
|   | 3 | 0 | 3296 | 0 | 6407 |
|  20,000,000 | 1 | 0 | 9396 | 1 | 15065 |
|   | 2 | 1 | 9228 | 1 | 15255 |
|  | 3 | 1 | 9260 | 1 | 14894 |


## Conclusions:

We found that binary search is significantly faster than linear search in finding the target relative to the same array. In most of tests we ran, binary search never exceeded more than a few ms while linear search took multiple ms. This theory prevailed even when the binary search was run multiple times or against a larger data set.

We can also look within search types and the increases in runtimes that result from increases in array size for more conclusive results. When linear search searched for the worst cases, the time it took increased by about 14 thousand ms. Increases in worst-case runtime for linear search appear to be linear, while increases in run-time for binary search are so minimal that we don't have the data to describe their pattern. 
