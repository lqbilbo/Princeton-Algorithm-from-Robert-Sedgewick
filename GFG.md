## Problems:

- 1. Given an array C of size N-1 and given that these are numbers from 1 to N with one element missing,
the missing number is to be found.
Input:
The first line of input contains an integer T denoting the number of test cases. For each test case 
first line contains N(size of array). The subsequent line contains N-1 array elements.

Output:
Print the missing number in array.

Constraints:
1 ≤ T ≤ 200
1 ≤ N ≤ 107
1 ≤ C[i] ≤ 107

Example:
Input:
2
5
1 2 3 5
10
1 2 3 4 5 6 7 8 10

Output:
4
9

1.Get the sum of numbers which is total = n * (n+1) / 2
2.Subtract all the numbers from sum and you will get the missing number

Time Complexity: O(n)

to avoid overflow, we can pick one number from known numbers and subtract one number from given numbers.

~Method 2~
Use XOR
1.XOR all the array elements, let the result of XOR be X1.
2.XOR all numbers from 1 to n, let XOR be X2.
3.XOR of X1 and X2 gives the missing number.

- 2. Given an array A of N elements. Find the majority element in the array. A majority element in an
 array A of size N is an element that appears more than N/2 times in the array.

Input:  
The first line of the input contains T denoting the number of testcases. The first line of the test 
case will be the size of array and second line will be the elements of the array.

Output: 
For each test case the output will be the majority element of the array. Output "-1" if no majority 
element is there in the array.

Constraints:
1 <= T<= 100
1 <= N <= 107
0 <= Ai <= 106

Example:
Input:
2
5
3 1 3 3 2
3
1 2 3

Output:
3
-1


~Method 1 Using Moore's Voting Algorithm~ 
```
findCandidate(a[], size)
1.  Initialize index and count of majority element
     maj_index = 0, count = 1
2.  Loop for i = 1 to size – 1
    (a) If a[maj_index] == a[i]
          count++
    (b) Else
        count--;
    (c) If count == 0
          maj_index = i;
          count = 1
3.  Return a[maj_index]
```
Above algorithm loops through each element and maintains a count of a[maj_index]. 
If the next element is same then increment the count, if the next element is not same then decrement 
the count, and if the count reaches 0 then changes the maj_index to the current element and set the 
count again to 1. So, the first phase of the algorithm gives us a candidate element.

In the second phase we need to check if the candidate is really a majority element. Second phase is 
simple and can be easily done in O(n). We just need to check if count of the candidate element is 
greater than n/2.

```
printMajority (a[], size)
1.  Find the candidate for majority
2.  If candidate is majority. i.e., appears more than n/2 times.
       Print the candidate
3.  Else
       Print "No Majority Element"
```