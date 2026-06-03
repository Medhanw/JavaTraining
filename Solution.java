package JavaTraining; 
import java.util.*;

class Phone {
    private int phoneId;
    private String os;
    private String brand;
    private int price;

    // Parameterized Constructor
    public Phone(int phoneId, String os, String brand, int price) {
        this.phoneId = phoneId;
        this.os = os;
        this.brand = brand;
        this.price = price;
    }

    // Getters and Setters
    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

public class Solution {

    // Method to find total price for given brand
    public static int findPriceForGivenBrand(Phone[] phones, String brand) {
        int sum = 0;

        for (Phone p : phones) {
            if (p.getBrand().equalsIgnoreCase(brand)) {
                sum += p.getPrice();
            }
        }

        return sum;
    }

    // Method to get Phone object based on OS and price >= 50000
    public static Phone getPhoneIdBasedOnOs(Phone[] phones, String os) {

        for (Phone p : phones) {
            if (p.getOs().equalsIgnoreCase(os) && p.getPrice() >= 50000) {
                return p;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Phone[] phones = new Phone[4];

        // Reading 4 phone objects
        for (int i = 0; i < 4; i++) {
            int id = Integer.parseInt(sc.nextLine());
            String os = sc.nextLine();
            String brand = sc.nextLine();
            int price = Integer.parseInt(sc.nextLine());

            phones[i] = new Phone(id, os, brand, price);
        }

        // Reading brand and os
        String brand = sc.nextLine();
        String os = sc.nextLine();

        // Calling findPriceForGivenBrand
        int totalPrice = findPriceForGivenBrand(phones, brand);

        if (totalPrice > 0) {
            System.out.println(totalPrice);
        } else {
            System.out.println("The given Brand is not available");
        }

        // Calling getPhoneIdBasedOnOs
        Phone result = getPhoneIdBasedOnOs(phones, os);

        if (result != null) {
            System.out.println(result.getPhoneId());
        } else {
            System.out.println("No phones are available with specified os and price range");
        }

        sc.close();
    }
}