import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PhoneReader {
    public static void main(String[] args) {
        try {
            File file = new File("src/file.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            
            String line = reader.readLine();
            while (line != null) {
               if (line.length() == 12){
                    if (line.charAt(3) == 45 && line.charAt(7) == 45) {
                        System.out.println(line);
                        line = reader.readLine();
                    }
                    else {
                        line = reader.readLine();
                    }

                }
                else if (line.length() == 14){
                    if (line.charAt(0) == 40 & line.charAt(4) == 41 & line.charAt(5) == 32 & line.charAt(9) == 45) {
                        System.out.println(line);
                        line = reader.readLine();
                    }
                    else{
                        line = reader.readLine();
                    }
                }
                else {
                    line = reader.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
