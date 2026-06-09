import java.util.Scanner;

class TravelAgencies {
    public int regno;
    public String agencyName;
    public String packageType;
    public int price;
    public boolean flightFacility;

    TravelAgencies(int regno, String agencyName, String packageType, int price, boolean flightFacility) {
        this.regno = regno;
        this.agencyName = agencyName;
        this.packageType = packageType;
        this.price = price;
        this.flightFacility = flightFacility;
    }

    int getregno() {
        return regno;
    }

    void setregno(int regno) {
        this.regno = regno;
    }

    String getagencyName() {
        return agencyName; // Fixed: Now returns the variable, not the method
    }

    void setagencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    String getpackageType() {
        return packageType; // Fixed: Now returns the variable, not the method
    }

    void setpackageType(String packageType) {
        this.packageType = packageType;
    }

    int getprice() {
        return price;
    }

    void setprice(int price) {
        this.price = price;
    }

    boolean getflightFacility() { // Fixed: Changed wrapper 'Boolean' to primitive 'boolean'
        return flightFacility; // Fixed: Now returns the variable, not the method
    }

    void setflightFacility(boolean flightFacility) {
        this.flightFacility = flightFacility;
    }
}

public class Tcsipa1 {

    static int findAgencyWithHighestPackagePrice(TravelAgencies[] arr) {
        int max = 0;
        for (TravelAgencies agency : arr) {
            if (agency.getprice() > max) {
                max = agency.getprice();
            }
        }
        return max;
    }

    // Fixed parameter type from TravelAgencies to TravelAgencies[]
    static TravelAgencies agencyDetailsforGivenIdAndType(TravelAgencies[] arr, int regno, String packageType) {
        for (TravelAgencies agency : arr) {
            // Using getflightFacility() instead of non-existent isflightFacility()
            if (agency.getflightFacility() && agency.getregno() == regno && agency.getpackageType().equalsIgnoreCase(packageType)) {
                return agency;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // IPA questions usually expect an array of 4 objects
        TravelAgencies[] agencies = new TravelAgencies[4];

        for (int i = 0; i < 4; i++) {
            int regno = sc.nextInt(); sc.nextLine(); // Clear buffer
            String agencyName = sc.nextLine();
            String packageType = sc.nextLine();
            int price = sc.nextInt(); sc.nextLine(); // Clear buffer
            boolean flightFacility = sc.nextBoolean(); sc.nextLine(); // Clear buffer

            agencies[i] = new TravelAgencies(regno, agencyName, packageType, price, flightFacility);
        }

        // Inputs for search criteria
        int searchRegNo = sc.nextInt(); sc.nextLine();
        String searchPackageType = sc.nextLine();

        // Method 1 Output
        int highestPrice = findAgencyWithHighestPackagePrice(agencies);
        System.out.println(highestPrice);

        // Method 2 Output
        TravelAgencies matchedAgency = agencyDetailsforGivenIdAndType(agencies, searchRegNo, searchPackageType);
        if (matchedAgency != null) {
            System.out.println(matchedAgency.getagencyName() + ":" + matchedAgency.getprice());
        }
        
        sc.close();
    }
}