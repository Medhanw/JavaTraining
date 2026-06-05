import java.util.*;
public class Prefix1 {
    public static void main(String[] args){
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int k =6;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];

            if(map.containsKey(sum-k)) {
                int currentLength = i - map.get(sum - k);
                minLength = Math.min(minLength, currentLength);
            }
          
            map.put(sum, i);
        }
        
        if (minLength == Integer.MAX_VALUE) {
            System.out.println("No continuous interval found with sum " + k);
        } else {
            System.out.println("Minimum length over continuous interval is: " + minLength);
        }
        } 


    }
    
