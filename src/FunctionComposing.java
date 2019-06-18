import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class FunctionComposing {

    public static void main(String[] args){

        IntUnaryOperator f = x -> x+1;
        IntUnaryOperator g = y -> y*2;

        IntUnaryOperator h = f.andThen(g);
        IntUnaryOperator j = f.compose(g);

        //Result 6
        System.out.println(h.applyAsInt(2));

        //Result 5
        System.out.println(j.applyAsInt(2));

    }
}
