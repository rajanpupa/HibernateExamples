package test;

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialBigInt {
//	public static void main(String[] args) {
//		 /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        BigInteger ans = BigInteger.valueOf(1);
//        
//        while(num>0){
//            ans = ans.multiply(BigInteger.valueOf(num--));
//        }
//        
//        System.out.println(ans);
//	}
	
//	public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int count = sc.nextInt();
//        
//        int[] ans = new int[count];
//        
//        for(int i=0; i< count; i++){
//            int num = sc.nextInt();
//            int num2 = num;
//            
//            int digits = 0;
//            
//            do{
//                int digit = num2%10;
//                if(digit !=0 && num%digit == 0){
//                    digits ++;
//                }
//                num2/=10;
//            }while(num2 > 0);
//            
//            ans[i]=digits;
//        }
//        
//        for(int i=0; i< ans.length; i++){
//        	System.out.println(ans[i]);
//        }
//    }
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        
        int count = sc.nextInt();
        
        int [] ansa = new int[count];
        
        for(int i=0; i<count; i++){
            int first = sc.nextInt();
            int last = sc.nextInt();
            
//            System.out.println(Math.floor(Math.sqrt(first)));
//            System.out.println(Math.floor(Math.sqrt(last)));
            int ans = 0;
            for(int j=(int) Math.floor(Math.sqrt(last)); j > Math.floor(Math.sqrt(first)); j--){
            	ans++;
            }
            ansa[i] = ans;
           // System.out.println(ans);
        }
        
        for(int i=0; i<ansa.length; i++){
        	System.out.println(ansa[i]);
        }
    }
}
