
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.Map;


//import org.json.simple.JSONObject;
//import org.json.simple.JSONArray;
//import org.json.simple.parser.ParseException;
//import org.json.simple.parser.JSONParser;


class Game {
        public static void main(String args[]){

            Scanner userInput = new Scanner(System.in);
            Being newYou;
            System.out.println("Hello, would you like to be an Alien(1) or a Human(2)?");
            String s = userInput.next();
//            System.out.printf("(%s)", s);
            if (s.equals("1")) {
                newYou = new Alien();
            } else if (s.equals("2")) {
                newYou = new Human();
            } else {
               System.out.println("Sorry, I don't know what that means. You're dumb. " +
                       "I don't want to play with you anymore.");
                return;
            }
            System.out.println("Congrats, you are now " + newYou.getPrefixArticle() + " " + newYou.getType() + ".");

            Gson g = new Gson();
            FileReader jsonFile = loadJsonFile("/Users/emilyrunk/Dropbox/Emily/Code/human-vs-alien/Game1/Locations.json");


            //fromJson() takes String or file from FileReader.
            Map<String, Object> map = g.fromJson(jsonFile, new TypeToken<Map<String, Object>>(){}.getType());
            System.out.println(map);
        }

        private static FileReader loadJsonFile(String filePath) {
            FileReader jsonFile;
            try {
                jsonFile = new FileReader(filePath);
            } catch (FileNotFoundException exception) {
                System.err.println("FileNotFoundException: " + exception.getMessage());
                return null;
            }
            return jsonFile;
            }
        }

