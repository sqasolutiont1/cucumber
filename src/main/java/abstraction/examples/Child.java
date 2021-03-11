package abstraction.examples;

public class Child extends Parent{
    @Override
    void printLastName() {
        System.out.println("Kamenev");
    }

    void printFirstName(){
        System.out.println("Vladimir");
    }
}
