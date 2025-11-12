package Task1;

import java.util.Scanner;

public class SortedArray {
    public static void arrayAscending(){
        System.out.println("Enter your array:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i =0;i<n;i++) arr[i] = in.nextInt();

        int k = 0;
        for (int i =1;i<arr.length; i++){
            if (arr[i - 1] > arr[i]) {
                k++;
            }
        }

        if(k>0){
            System.out.println("false");
        }else {
            System.out.println("true");
        }
    }
}
