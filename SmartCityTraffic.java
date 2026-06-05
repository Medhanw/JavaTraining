

public class SmartCityTraffic {
    public static void main(String[] args){
        int[] arr = {4, 8, 15, 3, 10, 12, 5, 9};
        int k = 3;
        int max = 0, curr = 0;
        for (int i=0;i<k;i++){
            curr += arr[i];
        }
        max = curr>max ? curr:max;
        for(int i=k;i<arr.length;i++){
            curr -= arr[i-k];
            curr += arr[i];
            max = curr>max? curr:max;
        }
        System.out.println(max);
    }
    
}
