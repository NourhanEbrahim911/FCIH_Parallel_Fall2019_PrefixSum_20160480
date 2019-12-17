/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Parallel_Group.ParallelGroup;

/**
 *
 * @author nourhan
 */
public class Parallel_Prefix_Sum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        int n=16;
        int res[];
        int arr[] = {4,9,5,1,0,5,1,6,6,4,6,5,1,6,9,3}; 
        ParallelGroup object = new ParallelGroup(n,arr);
        res=object.result();
        for(int i = 0 ; i < n ; i++) { 
            System.out.print(res[i] + " ");
        } 
       
    }
    
}
