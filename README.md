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
 
;l;al;ls;lsa
