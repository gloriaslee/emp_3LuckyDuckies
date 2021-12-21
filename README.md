# emp_3LuckyDuckies

#### 3LuckyDuckies: Gloria Lee, Ziying Jian, Nora Miller

## Tests Performed:
We ultimately used two different tests of the speeds of binary and linear search relative to array size.

The first test, nested in the MultCasesWrapper method, operates roughly like an average - it reports the elapsed time for each search type to search multiple randomly selected values within an array that is constant and is identical for both search types. The user may choose the size of the array being searched, and the number of random values being searched. Since the values are random, it is not necessarily the case (rather, extremely improbable) that the values being searched for will be the same between binary and linear search. However, searching for a large number of values ensures that the total runtime will be similar between trials.

The second test, nested in the WorstCaseWrapper method, records the runtime of the worst possible search case - the last value in the array - for both linear search and binary search. Here, both the array being searched and the value being searched are the same between the search types. Since doing this once requires less than a millisecond for binary search, this process is repeated 500 times, identically. As in the other test function, the user may specify the size of the array.

For each test, we ran the code three times to ensure replicability. However, because Nora's computer runs slowly, all tests were run either on the school computers or on Gloria's.

As discussed in class, we decided not to created a method to average the results because the results were so conclusive. We also removed a method recording the runtimes of linear search and binary search for a given number of individual searches for randomly selected values - see v3.


## Results:

### Testing elapsed time for searching randomly generated values:


For the same 20 million item-long array for all methods:

|           | Trial 1 | Trial 2 | Trial 3 |
| --------- | ----- | ---- | --- |
| Elapsed time for binary search for 200 random values in an array | 2 | 2 | 2 |
| Elapsed time for linear search of 200 newly generated random values | 3591 | 3551 | 3484 |
| Elapsed time for binary search for worst case | 3 | 4 | 3 |
| Elapsed time for linear search for worst case | 17445 | 17000 | 17330 |

For a different array of length 50 million (bigger array):

|           | Trial 1 | Trial 2 | Trial 3 |
| --------- | ----- | ---- | --- |
| Elapsed time for binary search for 200 random values in an array | 0 | 0 | 1 |
| Elapsed time for linear search of 200 newly generated random values | 9387 | 9658 | 10203s |
| Elapsed time for binary search for worst case | 0 | 1 | 2 |
| Elapsed time for linear search for worst case | 43758 | 43993 | 44769 |


## Conclusions:

We found that binary search is significantly faster than linear search in finding the target relative to the same array. In most of tests we ran, binary search never exceeded more than a few ms while linear search took multiple seconds. This theory prevailed even when the binary search was run multiple times or against a larger data set.

We can also look at the same type of search and their increments for more conclusive results about efficiency. When linear search searched for the worst cases, the time it took increased by about 14 thousand ms. That increment is significantly higher than the 1-2 additional ms it took for binary search to conduct the same search.
