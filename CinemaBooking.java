
import java.util.Scanner;
public class CinemaBooking {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] seats = new int[n];

        for(int i=0; i<n; i++){
            seats[i] = sc.nextInt();
        }
        int max = 0;
        int curr = 0;

        for(int i=0;i<n;i++){
            if(seats[i] == 0){
                curr++;

                if(curr > max){
                    max = curr;
                }
            }
            else{
                curr = 0;
            }
            
        }
        System.out.println(max);
        sc.close();

    }
    
}
