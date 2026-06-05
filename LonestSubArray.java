
import java.util.HashMap;
public class LonestSubArray {
    public static void main(String[] args) {
        int[] arr = new int[] {3, -2, 5, -1, 2, -3, 6, -2, 4};
        int k = 7;
        HashMap<Integer, Integer > map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        System.out.println("Total subarrays with sum " + k + " is: " + count);
    }
}

