import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class WordsCount {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        try {
            File file = new File("src/words.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                list.add(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> singlList = new ArrayList<>();
        for (int i=0; i<list.size();i++){
            String[] listsLine= list.get(i).split(" +");
            for (int j=0; j< listsLine.length; j++){
                singlList.add(listsLine[j]);
            }
        }

        Map<String, Integer> wordsMap = new HashMap<>();
        for (int i=0; i<singlList.size(); i++){
            int count = 0;
            if (wordsMap.get(singlList.get(i))==null & singlList.get(i)!=null & !singlList.get(i).trim().isEmpty()){
                for(int j=0; j< singlList.size(); j++){
                    if(singlList.get(i).equals(singlList.get(j))){
                        count++;
                    }
                }
                wordsMap.put(singlList.get(i), count);
            }
        }

        wordsMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }
}
