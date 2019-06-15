package processFileParameterization;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcessFile {

    public static String processFile(BufferedReaderProcessor processor) throws IOException{
        try (BufferedReader br =
                     new BufferedReader(new FileReader("resources/data.txt"))){
                return processor.process(br);
            }
    }

    public static void main (String[] args){

        try {
            String oneLine = processFile((BufferedReader br) -> br.readLine());

            System.out.println(oneLine);

            String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());

            System.out.println(twoLines);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
