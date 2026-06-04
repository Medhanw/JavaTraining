package JavaTraining;
import java.util.Scanner;
public class Merging {
    public static void mergesort(int[] arr, int p, int r){
        if(p<r){
            int q = (p + r) / 2;
            mergesort(arr, p, q);
            mergesort(arr, q+1, r);
            merge(arr, p, q, r);
        }
    }

    static void merge(int[] arr, int p, int q, int r){
        int n1 = q-p+1;
        int n2 = r-q;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i=0;i<n1;i++){
            L[i]  = arr[p + i];
        }
        for(int j=0;j<n2;j++){
            R[j] = arr[q+1+j];
        }
        int i=0, j=0, k=p;
        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                arr[k]= L[i];
                k++;
                i++;
            }
            else{
                arr[k] = R[j];
                k++;
                j++;
            }
        }
        while(i<n1){
            arr[k] = L[i];
            k++;
            i++;
        }
        while(j<n2){
            arr[k] = R[j];
            k++;
            j++;
        }

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        mergesort(arr,0,n-1);

        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }

        sc.close();

    }
   
        
    
}
