# FCIH_Parallel_Fall2019_PrefixSum_20160480
## Team :
 - نورهان ابراهيم عبدالله 20160480
 - همس محمد ناجى 20160494
 - سلمى محمد احمد 20160185
 
# Serial_PrefixSum :
    1.First We create two arrays 
       - First array store orginal elements .
       - second array called prefix_sum _array, to fill it we run through index 1 to last and keep on adding present element with previous
         value in prefix sum array by this code --> prefix_Sum_array[i] = prefix_Sum_array[i-1] + arr[i]; 
       
    2.Second we take the orginal arr from user 
    3.Then we create for loop to fill prefix_sum_array
          - prefix_Sum_array[0]=arr[0];
          - for(int i = 1 ; i < n ; i++) { prefix_Sum_array[i] = prefix_Sum_array[i-1] + arr[i] } 
             n is the size of orginal arr.
         
 # Parallel_PrefixSum:
    We have implemented the parallel algorithm in coarse-grained concurrent version 
    Firstly, we’ve implemented it in class (ParallelPrefixSum) .. we intialized the array and printed the result in it.
    We called our ParallelGroup class and passed to it the number of elements in the array and the array it self.
    **In the PrallelGroup class:**
    we have the Inarr which is the array itself,Outarr which will contain our output,Thrnum which is the number of threads,the executor,elemNum,the prefixSumArr which will be an array with the same number of elements , firstIndex which is zero by default, lastIndex which is the last element's index
