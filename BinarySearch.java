

public class BinarySearch {
    public static void main(String[] args){
        int[] arr = {10, 20, 30, 40, 45, 50};
        int key = 20;
        int l = 0, r = 0;
        while(l<=r){
            int mid = l + (r-1) / 2;
            if(arr[mid] == key){
                System.out.println("Index : " + mid);
                return;
            }
            else if(arr[mid] < key){
                l=mid+1;
            }else{
                r = mid - 1;
            }
        }
        System.out.println("Element not found");
    }
    
}
