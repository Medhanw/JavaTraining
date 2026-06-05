
import java.util.Scanner;

public class SmartElectricityBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int units = sc.nextInt();
        int bill;

        if (units <= 100)
            bill = units * 5;
        else if (units <= 200)
            bill = units * 7;
        else
            bill = units * 10;

        double surcharge = 0;

        if (bill > 2000)
            surcharge = bill * 0.10;

        double total = bill + surcharge;

        System.out.println("Bill = " + bill);
        System.out.println("Surcharge = " + surcharge);
        System.out.println("Total = " + total);
        sc.close();
    }
    
}
