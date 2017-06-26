
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
    public static void main(String args[]) throws java.io.IOException {
        //initialize scanner object for user input
        String ans;
        Being newYou = new Human();
        String currentMessage = "";
        String winMessage = "Good job! You win!!";
        String loseMessage = "Terrible news! You lose!!";
        int currentState = 3;
        final String JSON_FILE_PATH = "/Users/emilyrunk/Dropbox/Emily/Code/human-vs-alien/Game1/Locations.json";


        Scanner userInput = new Scanner(System.in);
        FileReader jsonFile = loadJsonFile(JSON_FILE_PATH);
        Map<String, Location> map = getMap(jsonFile);


        // *********************** INITIAL LOCATION SET UP ***********************//
        Location currentLocation = map.get("outside");
        System.out.println("Hello, would you like to be an Alien(1) or a Human(2)?");

        ans = userInput.next();



        switch (ans) {
            case "1":
                newYou = new Alien();
                currentMessage = currentLocation.alienMessage;
                break;
            case "2":
                newYou = new Human();
                currentMessage = currentLocation.humanMessage;
                break;
            default:
                tooDumbToPlay();
        }
        //*********************** NEXT LOCATION SET UP***********************//
        System.out.println("\nCongrats, you are now " + newYou.getPrefixArticle() + " " + newYou.getType() + ".");
        System.out.println(currentMessage);



        while (currentState == 3) {

            //States: 1 Win
            //        2 Lose
            //        3 Continue

            System.out.println("You see a " + currentLocation.branch1 + "(1) and " + currentLocation.branch2 + "(2) in the distance. " +
                    "Where would you like to go?");

            ans = userInput.next();
            //Take player to next location
            switch (ans) {
                case "1":
                    currentLocation = map.get(currentLocation.branch1);
                    break;
                case "2":
                    currentLocation = map.get(currentLocation.branch2);
                    break;
                default:
                    tooDumbToPlay();
            }

            //Determine if player wins, loses, or continues based on state
            //Set message depending on whether player is human or alien
            if (newYou instanceof Human) {
                currentMessage = currentLocation.humanMessage;
                currentState = currentLocation.humanState;

            } else if (newYou instanceof Alien) {
                currentMessage = currentLocation.alienMessage;
                currentState = currentLocation.alienState;
            }

            //Print message associated with location
            System.out.println("\n"+currentMessage);

            //Notify player if they have won or lost
            if (currentState == 1) {
                System.out.println(winMessage);
                System.exit(0);

            } else if (currentState == 2) {
                System.out.println(loseMessage);
                System.exit(0);
            }


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



    private static void tooDumbToPlay() {
        System.out.println("Sorry, I don't know what that means. You're dumb. " +
                "I don't want to play with you anymore.");
        return;
    }

}

