/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author nourhan
 */
public class Serial_prefix_sum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n=16;
        int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16 }; 
        int prefix_Sum_arr[] = new int[n];
        prefix_Sum_arr[0]=arr[0];
        for(int i = 1 ; i < n ; i++) { 
            prefix_Sum_arr[i] = prefix_Sum_arr[i-1] + arr[i];
        }   
        for(int i = 0 ; i < n ; i++) { 
            System.out.print(prefix_Sum_arr[i] + " ");
        } 
    }
    
}
