import java.util.Scanner;

public class Wall {

    private double surfaceArea; // Surface area.
    private String paintColour; // Colour of paint for this wall.
    private int paintVolume; // Litres of paint required. (Rounding up to ensure coverage.)

    // Constructor
    public Wall(double length, double height){
        this.surfaceArea = length * height;
    }

    // Getters.
    public String getPaintColour() {
        return paintColour;
    }

    public int getPaintVolume() {
        return paintVolume;
    }

    public void calculatePaint(Scanner scanner, String[] paintColours){
        String chosenPaint = "";

        // Create a gap in the console.
        System.out.println(" ");

        StringBuilder msgText = new StringBuilder();
        // Build string with options.
        for (String paint : paintColours){
            msgText.append(paint);
            msgText.append(", ");
        }

        // Boolean variable to control while loop.
        boolean valid = false;

        // Get chosen colour for this wall.
        do {
            // Display options.
            System.out.println("Available paints include: " + msgText);

            // Ask for input.
            System.out.println("Please choose a paint colour from the options above:");
            // Get chosen paint.
            chosenPaint = scanner.nextLine();
            // Check choice validity.
            for (String paint : paintColours) {
                if (chosenPaint.equalsIgnoreCase(paint)) {
                    // Display choice.
                    System.out.println(chosenPaint + " paint has been selected.");
                    this.paintColour = chosenPaint;
                    valid = true;
                    break;
                }
            }
            if (!valid){
                System.out.println("Invalid entry, please try again.");
                System.out.println(" ");
            }

        } while (!valid);

        // Calculate volume of paint required in litres.
        double litresRequired = surfaceArea / 12;
        // Round up to ensure coverage.
        this.paintVolume = (int) Math.ceil(litresRequired);

        System.out.println("Litres required: " + paintVolume);
    }

    public void calculateObsArea(Scanner scanner){
        // Check if there are obstructions.
        System.out.println("Are there any obstructions?");
        String obstructions = scanner.nextLine();
        // Validate input.
        while(!obstructions.equalsIgnoreCase("y") && !obstructions.equalsIgnoreCase("n")){
            System.out.println("Please enter \'n\' or \'y\'");
            obstructions = scanner.nextLine();
        }

        // If there are obstructions.
        if(obstructions.equalsIgnoreCase("y")){
            // Check how many obstructions.
            System.out.println("How many obstructions are there?");
            String obsNum = scanner.nextLine();
            int iObsNum = Integer.parseInt(obsNum);

            double obstructionArea = 0;

            // Get details per obstruction.
            for(int i = 0; i < iObsNum; i++){
                System.out.println("Obstruction " + (i+1));

                // Get obstruction type.
                System.out.println("Is this obstruction a square, rectangle or circle?");
                String type = scanner.nextLine();
                String lType = type.toLowerCase();
                // Check user type entry.
                while(!type.equals("square") && !type.equals("rectangle") && !type.equals("circle")){
                    System.out.println("Please enter \'square\', \'rectangle\' or \'circle\'");
                    type = scanner.nextLine();
                    lType = type.toLowerCase();
                }

                // Declare common variables used in one or more cases.
                String oLength;
                double dOLength;

                switch (lType) {
                    case "rectangle" -> {

                        // Get obstruction length.
                        System.out.println("Please enter the length of the obstruction.");
                        oLength = scanner.nextLine();
                        dOLength = Double.parseDouble(oLength);
                        // Get obstruction height.
                        System.out.println("Please enter the height of the obstruction.");
                        String oHeight = scanner.nextLine();
                        double dOHeight = Double.parseDouble(oHeight);
                        // Calculate and subtract surface area of obstruction.
                        obstructionArea += (dOLength * dOHeight);
                    }

                    case "circle" -> {

                        // Get obstruction radius.
                        System.out.println("Please enter the radius of the obstruction.");
                        String oRadius = scanner.nextLine();
                        double dORadius = Double.parseDouble(oRadius);
                        // Calculate and subtract surface area of obstruction.
                        obstructionArea += (Math.PI * (dORadius * dORadius));
                    }

                    case "square" -> {

                        // Get obstruction length.
                        System.out.println("Please enter the length of the obstruction.");
                        oLength = scanner.nextLine();
                        dOLength = Double.parseDouble(oLength);
                        // Calculate and subtract surface area of obstruction.
                        obstructionArea += (dOLength * dOLength);
                    }
                }
            }

            this.surfaceArea -= obstructionArea;

            System.out.println("Surface area: " + surfaceArea);
        }
    }
}
