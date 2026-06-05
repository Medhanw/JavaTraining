

class Student {
    private int rollNo;
    private String name;
    private int age;
    private String course;

    int getrollno() {
        return this.rollNo;
    }

    void setrollno(int r) {
        this.rollNo = r;
    }

    String getname() {
        return this.name;
    }

    void setname(String n) {
        this.name = n;
    }

    int getage() {
        return this.age;
    }

    void setage(int a) {
        this.age = a;
    }

    String getcourse() {
        return this.course;
    }

    void setcourse(String c) {
        this.course = c;
    }

    void eat() {
        System.out.println("eating...");
    }

    void study() {
        System.out.println("Study...");
    }

}

public class Encaps1 {
    public static void main(String[] args) {
        Student s = new Student();
        s.setname("Medha");
        System.out.println(s.getname());
        s.setrollno(108);
        System.out.println(s.getrollno());
    }
}
