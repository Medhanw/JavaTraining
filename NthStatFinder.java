
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class NthStatFinder {

    // Function to find the Nth Smallest number using a Max-Heap
    public static int findNthSmallest(int[] arr, int n) {
        // Create a Max-Heap (Collections.reverseOrder())
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            maxHeap.add(num);
            // If the heap grows larger than n, remove the largest element
            if (maxHeap.size() > n) {
                maxHeap.poll();
            }
        }
        // The root of the max-heap is now the Nth smallest element
        return maxHeap.peek();
    }

    // Function to find the Nth Largest number using a Min-Heap
    public static int findNthLargest(int[] arr, int n) {
        // Create a Min-Heap (default PriorityQueue behavior)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.add(num);
            // If the heap grows larger than n, remove the smallest element
            if (minHeap.size() > n) {
                minHeap.poll();
            }
        }
        // The root of the min-heap is now the Nth largest element
        return minHeap.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input Array
        int[] arr = {7, 10, 4, 3, 20, 15};
        
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        // Edge case handling
        if (n <= 0 || n > arr.length) {
            System.out.println("Invalid value of n.");
            sc.close();
            return;
        }

        // Output results
        int nthSmallest = findNthSmallest(arr, n);
        int nthLargest = findNthLargest(arr, n);

        System.out.println(n + "nd/rd/th Smallest number: " + nthSmallest);
        System.out.println(n + "nd/rd/th Largest number: " + nthLargest);

        sc.close();
    }
}
