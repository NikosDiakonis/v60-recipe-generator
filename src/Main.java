import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int userProcess = 0;
        int userRoastLevel = 0;
        int userRecipeChoice = 0;
        double userCoffeeDose = 0;
        double userTotalWater = 0;

            System.out.println("☕ Coffee Process Selection");
            System.out.println("1️⃣ - Washed");
            System.out.println("2️⃣ - Washed + Ferment");
            System.out.println("3️⃣ - Yellow Honey");
            System.out.println("4️⃣ - Red Honey");
            System.out.println("5️⃣ - Natural");
            System.out.println("6️⃣ - Natural + Ferment");
            System.out.println("👉 Choose between (1 - 6): ");
            System.out.print("Enter your choice: ");

            userProcess = validatedIntRangeInput(scanner,1,6,"⚠\uFE0F Invalid input. Process must be between 1-6 Please try again ⚠\uFE0F");

            System.out.println("🔥 Roast Level Selection");
            System.out.println("1️⃣ - Very Light");
            System.out.println("2️⃣ - Light");
            System.out.println("3️⃣ - Medium Light");
            System.out.println("4️⃣ - Medium Dark");
            System.out.println("5️⃣ - Dark");
            System.out.println("6️⃣ - Very Dark");
            System.out.println("👉 Choose a roast level (1 - 6), based on how dark the beans are:");
            System.out.print("Enter your choice: ");

            userRoastLevel = validatedIntRangeInput(scanner,1,6,"⚠\uFE0F Invalid input. Roast Level must be between 1-6 Please try again ⚠\uFE0F");

            System.out.println("📋 Recipe Setup");
            System.out.println("\uD83D\uDCA1 Would you like to build your recipe based on:");
            System.out.println("  1️⃣  Coffee dose (how much coffee you want to grind, in grams)");
            System.out.println("  2️⃣  Final brew water (how much water you want to pour, in ml)");
            System.out.print("\uD83D\uDC49 Enter 1 for grams of coffee or 2 for total brew water: ");
            userRecipeChoice  = validatedIntRangeInput(scanner,1,2,"⚠\uFE0F Invalid input. Choose between 1-2. Please try again ⚠\uFE0F");
                if(userRecipeChoice == 1){
                System.out.println("\uD83D\uDC49 Please enter your desired coffee dose: ");
                System.out.println("The coffee dose must be between 10g and 30g");

                userCoffeeDose = validDoubleRangeInput(scanner,10,30,"⚠\uFE0F Invalid input. Please type between 10 to 30 ⚠\uFE0F");

            CoffeeCalculator madeByCoffeeDose = CoffeeCalculator.byCoffeeDose(userProcess,userRoastLevel,userCoffeeDose);
            madeByCoffeeDose.showRecipe();
        }else {
            System.out.println("\uD83D\uDCA7 Total Brew Water Selection ");
            System.out.println("\uD83D\uDC49  Please choose between 180ml and 500ml: ");

            userTotalWater = validDoubleRangeInput(scanner, 180, 500, "⚠️ Invalid input. Please type between 180 to 500 ⚠️");
            CoffeeCalculator madeByTotalWater = CoffeeCalculator.byTotalWater(userProcess, userRoastLevel, userTotalWater);
            madeByTotalWater.showRecipe();


        }
    }
    private static int validatedIntRangeInput(Scanner intScanned, int min, int max, String errorMessage) {
        int input;
        while (true) {
            if (intScanned.hasNextInt()) {
                input = intScanned.nextInt();
                if (input >= min && input <= max) {
                    return input;
                }
            } else {
                intScanned.next(); // διαγράφει την λάθος τιμή
            }
            System.out.println(errorMessage);
        }
    }

    private static double validDoubleRangeInput(Scanner doubleScanned, double min, double max, String errorMessage) {
        double value;
        while (true) {
            String input = doubleScanned.next();
            try{
            value = Double.parseDouble(input.replace(",", "."));

            if (value >= min && value <= max) {
                return value;
            }
            } catch (NumberFormatException e){

            }
            System.out.println(errorMessage);
        }
    }
}


