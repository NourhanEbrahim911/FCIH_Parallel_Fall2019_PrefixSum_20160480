/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parallel_Group;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author nourhan
 */
public class Task implements Runnable {
    
    int mood;
    int index_prefixSumArr;
    int startI;
    int endI;
    int n;
    int Inarr [];
    int Outarr[];
    int PrefixSumArr[];
    CountDownLatch endControler;
    public Task(int startI,int endI, int n , int index_prefixSumArr , int mood , int Inarr[] ,int Outarr[] ,int PrefixSumArr[] , CountDownLatch endControler ){
        
       
        this.startI= startI;
        this.endI = endI;
        this.n = n;
        this.Inarr = Inarr;
        this.Outarr = Outarr;
        this.PrefixSumArr = PrefixSumArr;
        this.endControler = endControler;
        this.mood = mood;
        this.index_prefixSumArr = index_prefixSumArr;
        
    }
    @Override
	/**
	 * Concurrent task that calculates the distance between the example and the train instances between
	 * the startIndex and the endIndex 
	 */
	public void run() {
                // input Outarr empty , output: prefSumArray:19 31 52 71 (the third array) && outputArray: secondArray
		if (mood == 0){
                    if(startI < n){ 
                         Outarr[startI]=Inarr[startI]; 
                    } 
                    for(int j = startI+1 ; j < endI ; j++){
                         Outarr[j]=Outarr[j-1]+Inarr[j]; 
                    }

                PrefixSumArr[index_prefixSumArr]+=Outarr[endI-1];
                endControler.countDown();
                }
                // input: second array , output: third array (longest one
                else if (mood == 1){
                    for(int j = startI ; j < endI ; j++){
                        Outarr[j]+=PrefixSumArr[index_prefixSumArr];   

                    }
                endControler.countDown();
                }
  
	}
    
    
    
    

}
