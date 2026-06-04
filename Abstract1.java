package JavaTraining;
abstract class Animal {
    int no_of_legs;
    String color;
    String modes_of_food;

    void eat(){
        System.out.println("Eating Time.....Dont Disturb me!!!");
    }
    void sleep(){
        System.out.println("Sleeping....");
    }
    abstract void speak();
}

class Rabbit extends Animal {
    void speak(){
        System.out.println("Rabbit says: Squeak");
    }
    void jump(){
        System.out.println("Rabbit is jumping...");
    }

}

abstract class Bird extends Animal {
    void fly(){
        System.out.println("Bird is flying...");
    }
    abstract void displayName();
}
class Koyal extends Bird {
    void speak(){
        System.out.println("Koo....Koo....");
    }
    void displayName(){
        System.out.println("Melodius Koyal");
    }
}
public class Abstract1 {
    public static void main(String[] args){
        //Rabbit r = new Rabbit(); 
        //r.jump();
        //r.eat();
        //r.color = "White with black spots";
        //System.out.println(r.color);
        Bird k = new Koyal();
        k.speak();
        k.fly();
        k.displayName();
    }
    
}
