import java.util.Scanner;
class TravelAgencies {
    public int regno;
    public  String agencyName;
    public String packageType;
    public  int price;
    public boolean flightFacility;
    
    TravelAgencies(int regno,String agencyName,String packageType,int price,boolean flightFacility) 
    {
        this.regno=regno;
        this.agencyName=agencyName;
        this.packageType=packageType;
        this.price=price;
        this.flightFacility=flightFacility;
    }
            int getregno()
            {
                return regno;
            }
            void setregno(int regno)
            {
                this.regno=regno;
            }

            String getagencyName()
            {
                return getagencyName();
            }
            void setagencyName(String agencyName)
            {
                this.agencyName=agencyName;
            }
            
            String getpackageType()
            {
                return getpackageType();
            }
            void setpackageType(String packageType)
            {
                this.packageType=packageType;
            }

            int getprice()
            {
                return price;
            }
            void setprice(int price)
            {
                this.price=price;
            }

            Boolean getflightFacility()
            {
                return getflightFacility();
            }
            void setflightFacility(Boolean flightFacility)
            {
                this.flightFacility=flightFacility;
            }
}

public class Tcsipa1 {

    static int findAgencyWithHighestPackagePrice(TravelAgencies[] arr){
        int max=0;
        for(TravelAgencies agency : arr){
            if(agency.getprice()>max){
                max=agency.getprice();
            }
        }
        return max;
    }
    static TravelAgencies agencyDetailsforGivenIdAndType(TravelAgencies arr, int regno, String packageType) 
    {
        for(TravelAgencies agency : arr){
            if(agency.isflightFacility() && agency.getregno()==regno && agency.getpackageType().equalsIgnoreCase(packageType)){
                    return agency;
            }
            }
            return null;
        }  
        
        public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Registration Number : ");
        regno =sc.nextInt();

        System.out.println("Enter Agency Name : ");
        agencyName=sc.nextLine();
        sc.nextLine();
        System.out.println("Enter Package Type : ");
        packageType=sc.nextLine();
        sc.nextLine();

        System.out.println("Enter Price : ");
        price =sc.nextInt();
        sc.nextLine();


        System.out.println("Enter Flight Facility : ");
        flightFacility=sc.nextBoolean();

        

    }
    }