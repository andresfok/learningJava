/*
    This code takes advantage of a Functional Interface in Java 8

    A Functional Interface is an interface that implements only one
    abstract method
 */
public class FunctionalInterface {

    //Uses lambda expressions to implement run
    private static Runnable r1 = () -> System.out.println("Hello World 1");

    //Uses anonymous class to implement run
    private static Runnable r2 = new Runnable() {
        @Override
        public void run() {
            System.out.println("Hello World 2");
        }
    };

    //This only runs a Runnable object
    public static void process (Runnable r){
        r.run();
    }

    public static void main(String[] args){
       process(r1);  //Prints HW 1
       process(r2);  //Prints HW 2
       process(()-> System.out.println("Hello World 3")); //Prints HW3 using lambda passed directly

    }

}
