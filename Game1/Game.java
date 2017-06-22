
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
    public static void main(String args[]) {
        //initialize scanner object for user input
        Scanner userInput = new Scanner(System.in);
        Being newYou;
        String currentMessage;

        FileReader jsonFile = loadJsonFile("/Users/emilyrunk/Dropbox/Emily/Code/human-vs-alien/Game1/Locations.json");

        Map<String, Location> map = getMap(jsonFile);

        Location currentLocation = map.get("outside");


        System.out.println("Hello, would you like to be an Alien(1) or a Human(2)?");

        int ans = userInput.nextInt();
//            System.out.printf("(%s)", s);
        
        switch (ans){
            case 1:
                newYou = new Alien();
                currentMessage = currentLocation.alienMessage;
                break;
            case 2:
                newYou = new Human();
                currentMessage = currentLocation.humanMessage;
                break;
            default:
                System.out.println("Sorry, I don't know what that means. You're dumb. " +
                        "I don't want to play with you anymore.");
                return;
        }

        System.out.println("Congrats, you are now " + newYou.getPrefixArticle() + " " + newYou.getType() + ".");
        System.out.println(currentMessage);

        System.out.println("You see a " + currentLocation.branch1 + "(1) and " + currentLocation.branch2 + "(2) in the distance. " +
                "Where would you like to go?");

        ans = userInput.nextInt();
        if (ans == 1) {
            currentLocation = map.get(currentLocation.branch1);
        } else if (ans == 2) {
            currentLocation = map.get(currentLocation.branch2);
        }



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

    private static Map<String, Location> getMap(FileReader file) {
        Gson g = new Gson();
        Map <String, Location> map;
        //fromJson() takes String or file from FileReader.
        //Map<String,Location> where String is key, Location is Location object that was created
        map = g.fromJson(file, new TypeToken<Map<String, Location>>() {
        }.getType());

        return map;
    }

}

