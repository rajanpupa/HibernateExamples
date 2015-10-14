package test;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        int count = sc.nextInt();
        int sum = 0;
        int temp = 0;
        
        int [] ab = new int[3];
        
        while(count>0){
            temp = sc.nextInt();
            sum+=temp;
            count--;
        }
    }
}