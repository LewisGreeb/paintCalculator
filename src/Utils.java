import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

    public static double walls (int count, Scanner scanner){
        double surfaceArea = 0;

        // Loop for each wall.
        for(int x = 0; x < count; x++) {
            System.out.println("Wall " + (x+1));

            // Get wall height.
            System.out.println("Please enter the height of your wall in meters.");
            String height = scanner.nextLine();
            double dHeight = Double.parseDouble(height);

            // Get wall length.
            System.out.println("Please enter the length of your wall in meters.");
            String length = scanner.nextLine();
            double dLength = Double.parseDouble(length);

            // Calculate wall surface area.
            surfaceArea += dLength * dHeight;

            // Check if there are obstructions.
            System.out.println("Are there any obstructions?");
            String obstructions = scanner.nextLine();

            while(!obstructions.equals("y") && !obstructions.equals("n")){
                System.out.println("Please enter \'n\' or \'y\'");
                obstructions = scanner.nextLine();
            }

            if(obstructions.equals("y")){
                // Check how many obstructions.
                System.out.println("How many obstructions are there?");
                String obsNum = scanner.nextLine();
                int iObsNum = Integer.parseInt(obsNum);

                surfaceArea -= Utils.obstructions(iObsNum, scanner);
            }
        }

        return surfaceArea;
    }

    public static double obstructions (int count, Scanner scanner){

        double obstructionArea = 0;

        // Get details per obstruction.
        for(int i = 0; i < count; i++){
            System.out.println("Obstruction " + (i+1));

            // Get obstruction type.
            System.out.println("Is this obstruction a square, rectangle or circle?");
            String type = scanner.nextLine();
            String lType = type.toLowerCase();
            // Check user type entry.
            while(!lType.equals("square") && !lType.equals("rectangle") && !lType.equals("circle")){
                System.out.println("Please enter \'square\', \'rectangle\' or \'circle\'");
                type = scanner.nextLine();
                lType = type.toLowerCase();
            }

            // Declare common variables used in one or more cases.
            String oLength;
            double dOLength;

            switch (lType){

                case "rectangle":

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

                    // Exit case.
                    break;

                case "circle":

                    // Get obstruction radius.
                    System.out.println("Please enter the radius of the obstruction.");
                    String oRadius = scanner.nextLine();
                    double dORadius = Double.parseDouble(oRadius);
                    // Calculate and subtract surface area of obstruction.
                    obstructionArea += (Math.PI * (dORadius * dORadius));

                    // Exit case.
                    break;

                case "square":

                    // Get obstruction length.
                    System.out.println("Please enter the length of the obstruction.");
                    oLength = scanner.nextLine();
                    dOLength = Double.parseDouble(oLength);
                    // Calculate and subtract surface area of obstruction.
                    obstructionArea += (dOLength * dOLength);

                    // Exit case.
                    break;
            }
        }

        return obstructionArea;
    }

    public static void selectPaint (int numOfCans, Scanner scanner){
        String[] paintColours = {"Green", "Blue", "Red", "Black", "White"};
        ArrayList<String> chosenPaints = new ArrayList<>();
        String chosenPaint = "";

        // Create a gap in the console.
        System.out.println(" ");

        StringBuilder msgText = new StringBuilder();
        // Build string with options.
        for (String paint : paintColours){
            msgText.append(paint);
            msgText.append(", ");
        }

        boolean done = false;

        do {
            // Boolean variable to control while loop.
            boolean valid = false;
            // Get and check paint choice input.
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
                        // Add choice to list.
                        chosenPaints.add(chosenPaint);
                        valid = true;
                        break;
                    }
                }
                if (!valid){
                    System.out.println("Invalid entry, please try again.");
                    System.out.println(" ");
                }

            } while (!valid);

            // Check if user wants multiple colours.
            System.out.println("Would you like to select another colour?");

            // Get user input.
            String yN = scanner.nextLine();
            // Check if user input is valid.
            while(!yN.equals("y") && !yN.equals("n")){
                System.out.println("Please enter \'n\' or \'y\'");
                yN = scanner.nextLine();
            }
            // Set boolean based on user input.
            if(yN.equals("n")){
                done = true;
            }

        }while(!done);
/*
        if (chosenPaints.size() > 1) {
            System.out.println("The number of paint cans required is " + numOfCans);

            // Choose number of each type of paints.
            for (String paint : chosenPaints) {
                boolean valid = false;

                do {
                    System.out.println("Please enter how many " + paint + " cans you would like.");

                    String rsp = scanner.nextLine();
                    int iRsp = Integer.parseInt(rsp);

                    if (iRsp <= 0 || iRsp >= numOfCans) {
                        System.out.println("Please enter a number greater than 0 and less than the total number of cans.");
                    }else if (){

                    }else{
                        valid = true;
                    }
                }while(!valid);
            }
        }else{
            System.out.println(numOfCans + " cans of " + chosenPaints.get(0) + " have been selected.");
        }*/
    }

}
