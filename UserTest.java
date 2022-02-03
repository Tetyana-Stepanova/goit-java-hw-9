import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class User{
    private String name;
    private Integer age;
    public User(String name, Integer age){
        this.name = name;
        this.age = age;
    }
}

public class UserTest {
    public static void main(String[] args) throws IOException {
        List<Object> userList = new ArrayList<>();
        try {
            File file = new File("src/file.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {

                    line = reader.readLine();
                    if (line != null) {
                    String[] params = line.split(" ");
                    User newUser = new User(params[0], Integer.valueOf(params[1]));
                    userList.add(newUser);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonUsers = gson.toJson(userList);
        File jsonFile = new File("src/user.json");
        try (FileWriter writer = new FileWriter(jsonFile);)
        {
            writer.write(jsonUsers);
            writer.flush();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
