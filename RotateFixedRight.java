package JavaTraining;

import java.util.Arrays;
import java.util.Scanner;

public class RotateFixedRight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1. Array initialization using your sample data
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};
        int n = arr.length;
        
        // Inputs for k and m
        int k = sc.nextInt(); // Enter 2
        int m = sc.nextInt(); // Enter 3
        
        // The size of the section that actually rotates
        int activeSize = n - m; 
        
        // Optimize k so we don't perform duplicate complete rotations
        k = k % activeSize;
        
        // 2. Anticlockwise (Left) Rotation Loop
        for (int i = 1; i <= k; i++) {
            // Save the FIRST element of the active rotation partition
            int temp = arr[0];
            
            // Shift only within the active block bounds (0 to activeSize - 1)
            for (int j = 0; j < activeSize - 1; j++) {
                arr[j] = arr[j + 1];
            }
            
            // Place the saved first element at the end of the ACTIVE block
            arr[activeSize - 1] = temp;
            
            // Print the array status after each rotation step
            System.out.println(Arrays.toString(arr));
        }
        
        sc.close();
    }
}
