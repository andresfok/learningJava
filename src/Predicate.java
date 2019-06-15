import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/*
@java.lang.FunctionalInterface
public interface Predicate<T>{
    boolean test (T t);
}

@java.lang.FunctionalInterface
interface Consumer<T>{
    void accept(T t);
}

@java.lang.FunctionalInterface
interface Function<T, R>{
    R apply(T t);
}
*/

class PredicateTest {

    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> results = new ArrayList<>();
        for(T t: list){
            if(p.test(t)){
                results.add(t);
            }
        }
        return results;
    }

    public static <T> void forEach(List<T> list, Consumer<T> consumer){
        for(T t: list){
            consumer.accept(t);
        }
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f){

        List<R> result = new ArrayList<>();

        for(T t: list){
            result.add(f.apply(t));
        }
        return result;
    }


    public static void main(String[] args){

        List<String> listOfString = Arrays.asList("hello", "world", "", "", "!");

        /* Define Predicates for String */
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        Predicate<String> onlyEmptyStringPredicate = (String s) -> s.isEmpty();
        Predicate<String> more1LengthStringPredicate = (String s) -> s.length()>1;

        List<String> nonEmpty = filter(listOfString, nonEmptyStringPredicate);
        List<String> empty = filter(listOfString, onlyEmptyStringPredicate);
        List<String> larger = filter(listOfString, more1LengthStringPredicate);

        System.out.println(nonEmpty.toString());
        System.out.println(empty.toString());
        System.out.println(larger.toString());

        /* Define Consumer Predicates */
        List<Integer> listOfInteger = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        forEach(listOfInteger, (Integer i)-> System.out.println(i));

        /*Define Function Predicates */
        List<Integer> list = map(Arrays.asList("Function", "Predicate", "Consumer"), (String s) -> s.length());

        System.out.println(list);

        /* Other Functions Applications*/

        //Supplier is useful when creating new objects
        Supplier<Integer> supplier = () -> new Integer(42);

        //This avoids autoboxing (faster and less memory)
        ToIntFunction<String> toLength = (String s) -> s.length();

        //To multiply two int without needed to Autoboxing
        IntBinaryOperator multiply = (int a, int b) -> a*b;

    }

}
