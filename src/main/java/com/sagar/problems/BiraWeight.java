package com.sagar.problems;

import java.util.Arrays;
import java.util.Scanner;

public class BiraWeight {

    public static void main(String args[] ) throws Exception {

        Scanner sc = new Scanner(System.in);
        int b = Integer.parseInt(sc.next());
        int n = Integer.parseInt(sc.next());
        int[] b_weights= new int[b];
        int[] n_weights= new int[n];

        for(int i=0; i<b;i++){
            b_weights[i]= Integer.parseInt(sc.next());
        }
        for(int i=0; i<n;i++){
            n_weights[i]= Integer.parseInt(sc.next());
        }
        
        Arrays.sort(b_weights);
        Arrays.sort(n_weights);
        
        
        for(int i=0; i<b;i++){
            System.out.print(b_weights[i]+" ");
        }
        System.out.println();
        for(int i=0; i<n;i++){
            System.out.print(n_weights[i]+" ");
        }
        

        boolean canTransfer=false;

        int time=0;

        while(b > 0){
            canTransfer=false;
            for(int i=0; i<n;i++){
                if(canTransferBira(b_weights,n_weights[i])){
                    canTransfer=true;
                    b--;
                }
            }
            if(canTransfer)
            {
                time=time+2;
            }
        }
        sc.close();
        System.out.println(time-1);
   }

   public static boolean canTransferBira(int[] b_weight,int wt){

        for(int i=0; i<b_weight.length;i++){

            if(b_weight[i]!=-1 && b_weight[i] <= wt){
                b_weight[i]=-1;
                return true;
            }
        }
        return false;
   }
}
