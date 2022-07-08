import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main (String[] args){

        // Instantiate scanner.
        Scanner scanner = new Scanner(System.in);

        // Set available paint colours.
        String[] paintColours = {"Green", "Blue", "Red", "Black", "White"};

        // Make list to store walls.
        ArrayList<Wall> walls = getWalls(scanner, paintColours);

        // Run check of paint volumes.
        runPaintCheck(walls);

    }

    public static ArrayList<Wall> getWalls(Scanner scanner, String[] paintColours){
        // Store walls.
        ArrayList<Wall> walls = new ArrayList<>();

        // Get number of walls.
        System.out.println("How many walls are there?");
        String wallNum = scanner.nextLine();
        int iWallNum = Integer.parseInt(wallNum);

        // Get data for each wall.
        for (int i = 0; i < iWallNum; i++){

            System.out.println(" ");
            System.out.println("Wall " + (i+1));

            // Get wall height.
            System.out.println("Please enter the height of your wall in meters.");
            String height = scanner.nextLine();
            double dHeight = Double.parseDouble(height);

            // Get wall length.
            System.out.println("Please enter the length of your wall in meters.");
            String length = scanner.nextLine();
            double dLength = Double.parseDouble(length);

            // Create and instantiate wall class.
            Wall wall = new Wall(dLength, dHeight);

            // Calculate obstructions.
            wall.calculateObsArea(scanner);

            // Get wall colour and calculate litres of paint required.
            wall.calculatePaint(scanner, paintColours);

            // Add to list.
            walls.add(wall);
        }

        return walls;
    }

    public static void runPaintCheck(ArrayList<Wall> walls){
        System.out.println(" ");

        // Store selected colours and associated volumes here.
        HashMap<String, Integer> paints = new HashMap<>();

        // Calculate how many cans of paint are required for each colour.
        for (Wall wall : walls){
            if(paints.containsKey(wall.getPaintColour())){
                int val = paints.get(wall.getPaintColour());
                val += wall.getPaintVolume();
                paints.put(wall.getPaintColour(), val);
            }else{
                paints.put(wall.getPaintColour(), wall.getPaintVolume());
            }
        }

        for (Map.Entry<String, Integer> entry : paints.entrySet()) {   // For each colour.

            HashMap<String, Integer> cans = new HashMap<>();   // Store number of each can type.
            // Initialise cans hashmap.
            cans.put("1", 0);
            cans.put("2", 0);
            cans.put("5", 0);

            String colour = entry.getKey();   // Store current colour.
            int volume = entry.getValue();   // Store volume of current colour.

            while (volume > 0){ // Using if statements in this while block is kinda cheating.
                if(volume >= 5){
                    int current = cans.get("5");
                    current++;
                    cans.put("5", current);
                    volume -= 5;
                }else if(volume >= 2){
                    int current = cans.get("2");
                    current++;
                    cans.put("2", current);
                    volume -= 2;
                }else{
                    int current = cans.get("1");
                    current++;
                    cans.put("1", current);
                    volume -= 1;
                }
            }

            System.out.println("You require " + cans.get("5") + " five litre cans, " + cans.get("2") + " two litre cans, and " + cans.get("1") + " one litre cans of " + colour + " paint.");
        }
    }

}
