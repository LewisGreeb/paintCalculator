import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main (String[] args){

        // Instantiate scanner.
        Scanner scanner = new Scanner(System.in);

        // Set available paint colours.
        String[] paintColours = {"Green", "Blue", "Red", "Black", "White"};
        // Set available paint can sizes.
        int[] paintSizes = {1, 2, 5};

        // Make list to store walls.
        ArrayList<Wall> walls = new ArrayList<>();

        // Get number of walls.
        System.out.println("How many walls are there?");
        String wallNum = scanner.nextLine();
        int iWallNum = Integer.parseInt(wallNum);

        // Get data for each wall.
        for (int i = 0; i < iWallNum; i++){

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

        // Calculate how many cans of paint are required for each colour.

        /*
        * Loop through walls
        * Build HashMap with colour and volume (String and int)
        * Divide volume into cans of different sizes, with the minimal number of cans used.
        * Display the number of cans required for each colour.
        * */


        /*
        // Instantiate surface area variable.
        double surfaceArea = 0;

        // Get number of walls.
        System.out.println("How many walls are there?");
        String wallNum = scanner.nextLine();
        int iWallNum = Integer.parseInt(wallNum);

        surfaceArea = Utils.walls(iWallNum, scanner);

        // Get size of paint can.
        System.out.println("What size of paint can are you using? (1 litre, 2 litre, 5 litre)");
        String paintSize = scanner.nextLine();

        // Default paint can size is 1.
        int iPaintSize = 1;

        // Check user inputted paint can size.
        if (paintSize.contains("1")) {
            System.out.println("Selected 1 litre paint cans.");
        } else if (paintSize.contains("2")) {
            iPaintSize = 2;
            System.out.println("Selected 2 litre paint cans.");
        } else if (paintSize.contains("5")) {
            iPaintSize = 5;
            System.out.println("Selected 5 litre paint cans.");
        } else {
            System.out.println("No valid size detected. Default paint can size is 1 litre.");
        }


        // Calculate number of paint cans required.
        double paintCansRequired = surfaceArea / (12 * iPaintSize);
        // Round up to ensure coverage.
        int rPaintCansRequired = (int) Math.ceil(paintCansRequired);

        // Print response.
        System.out.println("The number of " + iPaintSize + " litre paint cans required to paint this wall is " + rPaintCansRequired);

        // Get and display chosen paint colour.
        Utils.selectPaint(rPaintCansRequired, scanner);*/
    }

}
