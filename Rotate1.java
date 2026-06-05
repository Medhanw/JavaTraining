

import java.util.Arrays;
import java.util.Scanner;

public class Rotate1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        
        for(int i=1; i<=k; i++){
            int temp = arr[n-1]; // Save the last element
            
            // FIX: Start at n-2 so that (j+1) points to the last index (n-1)
            for(int j = n - 2; j >= 0; j--){
                arr[j+1] = arr[j];
            }
            
            arr[0] = temp; // Put the saved element at the front
            System.out.println(Arrays.toString(arr));
        }
        sc.close();
    }
}