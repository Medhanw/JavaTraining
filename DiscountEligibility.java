package JavaTraining;
import java.util.Scanner;

public class DiscountEligibility {
    public static void main(String[] args) {
        // Test Input
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();
        boolean premium = sc.nextBoolean();

        double discountPercentage = 0;
        if (amount >= 5000) {
            discountPercentage = 20;
        } else if (amount >= 3000) {
            discountPercentage = 10;
        }

        if (premium) {
            discountPercentage += 5;
        }

        double finalAmount = amount - (amount * (discountPercentage / 100.0));
        System.out.println("Final Amount = " + (int)finalAmount);
        sc.close();
    }
}