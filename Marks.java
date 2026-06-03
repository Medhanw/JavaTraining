package JavaTraining;
import java.util.Scanner;
class Marks{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        double w1 = sc.nextDouble();
        int m2 = sc.nextInt();
        double w2 = sc.nextDouble();
        int m3 = sc.nextInt();
        double w3 =sc.nextDouble();

        double total = (m1*w1 + m2*w2 + m3*w3);
        if(total>=90){
            System.out.println("Grade A");
        }
        else if(total>=80){
            System.out.println("Grade B");
        }
        else if(total>=70){
            System.out.println("Grade C");

        }
        else if(total>=60){
            System.out.println("Grade E");
        }
        else if(total<60){
            System.out.println("Grade F");
        }
        sc.close();
    }
}