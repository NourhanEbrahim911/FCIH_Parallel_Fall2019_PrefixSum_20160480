/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parallel_Group;

/**
 *
 * @author nourhan
 */

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ParallelGroup {
    
    	
       private int n = 16 ;
    private int Inarr[];
    private int Outarr[];
    private int ThrNum ;
    private ThreadPoolExecutor executor;
    private int ElementNum ;
    private int PrefixSumArr[] ;
    private int firstIndex  , lastIndex ;
    
    
    public ParallelGroup( int n , int Inarr[]) {
        this.n = n;
        this.Inarr = Inarr;
        Outarr = new int[n];
        ThrNum = Runtime.getRuntime().availableProcessors();
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(ThrNum);
        ElementNum = n/ThrNum;
        PrefixSumArr = new int[ThrNum];
        firstIndex = 0;
        lastIndex = ElementNum ;
    }
    
    
    public int[] result() throws Exception {
           CountDownLatch endControler = new CountDownLatch(ThrNum);
           CountDownLatch endControler2 = new CountDownLatch(ThrNum);
            for(int i = 0 ; i < ThrNum ; i++) {
                Task task = new Task(firstIndex ,lastIndex ,n,i,0,Inarr,Outarr,PrefixSumArr,endControler);
                firstIndex=lastIndex;
                if (i<ThrNum-1) {
                        lastIndex=lastIndex+ElementNum; 
                } else {
                        lastIndex=n;
                }
                executor.execute(task);
            } 
            endControler.await();  
            for(int i = 1 ; i<ThrNum; i++) {
                PrefixSumArr[i]+=PrefixSumArr[i-1];
                //19 31 52 71
            }
            
            firstIndex=ElementNum; 
            lastIndex=firstIndex+ElementNum;
            for(int i = 0 ; i < ThrNum-1 ; i++) { 
                Task Task = new Task(firstIndex ,lastIndex ,n,i,1,Inarr,Outarr,PrefixSumArr,endControler2);
                executor.execute(Task);
                firstIndex=lastIndex; 
                if (i<ThrNum-1) {
                    lastIndex=lastIndex+ElementNum; 
                } 
                else {
                    lastIndex=n; 
                }
              
            }
            endControler.await();
       
            
        return Outarr;
    }
    
    public void destroy(){
        executor.shutdown();
    }
    
}