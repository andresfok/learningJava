import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.util.Comparator.comparing;

public class Apple {

    private int weight;
    private String color;

    public Apple(int weight){
        this.weight = weight;
    }

    public Integer getWeight(){
        return weight;
    }

    public String toString() {
        return String.format("Weight = %s", weight);
    }

}

/*
class AppleComparator implements Comparator<Apple>{
    public int compare (Apple a1, Apple a2){
        return a1.getWeight().compareTo(a2.getWeight());
    }
}
*/

class Main {

    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f){

        List<Apple> result = new ArrayList<>();

        for(Integer i: list){
            result.add(f.apply(i));
        }

        return result;
    }

    public static void main(String[] args){

        List<Integer> weights = Arrays.asList(7, 55, 35, 10, 12, 3, 8);

        Consumer<List<Apple>> printer = System.out::println;

        List<Apple> inventory = map(weights, Apple::new);

        // Version 1: Solution using lambdas rather than implementing an Comparator interface //
        //inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));

        // Version 2: JVM Type inferring //
        //inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));

        // Version 3: Using the Functional Interface Comparator.comparing (static)
        //Comparator<Apple> comparator = Comparator.comparing(apple -> apple.getWeight());
        //inventory.sort(comparator);

        // Version 4: Using lambdas and comparator
        //inventory.sort(comparing(apple -> apple.getWeight()));

        // Version 5: Using lambdas and comparator and method references
        inventory.sort(comparing(Apple::getWeight));

        //Reverse the list
        inventory.sort(comparing(Apple::getWeight).reversed());

        printer.accept(inventory);
    }
}


