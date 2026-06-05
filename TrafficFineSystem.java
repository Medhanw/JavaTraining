
import java.util.Scanner;
public class TrafficFineSystem {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int speed = sc.nextInt();
        boolean repeated = sc.nextBoolean();
        int fine = 0;

        if(speed > 100){
            fine = 1000;
        }
        else if(speed > 80){
            speed = 500;
        }

        if(repeated){
            fine = fine * 2;
        }

        System.out.println(fine);
        sc.close();
    }
    
}
