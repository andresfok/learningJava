import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

public class ProcessFile {


    public static String processFile(Function<BufferedReader, String> f) throws IOException{

        try (BufferedReader br =
                     new BufferedReader(new FileReader("resources/data.txt"))){
            return f.apply(br);
        }

    }

    public static void main (String[] args){

       Function<BufferedReader, String> one = (BufferedReader b) -> {
           try{
               return b.readLine();
           } catch (IOException e) {
              throw new RuntimeException(e);
           }
       };

        Function<BufferedReader, String> two = (BufferedReader b) -> {
            try{
                return b.readLine() + b.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        try {

            String oneLine = processFile(one);
            System.out.println(oneLine);
            String twoLines = processFile(two);
            System.out.println(twoLines);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
