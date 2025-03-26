import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int userProcess;
        int userRoastLevel;
        int userRecipeChoice;
        double userCoffeeDose;
        double userTotalWater;

        System.out.println("☕ Coffee Process Selection");
        System.out.println("1️⃣ - Washed");
        System.out.println("2️⃣ - Washed + Ferment");
        System.out.println("3️⃣ - Yellow Honey");
        System.out.println("4️⃣ - Red Honey");
        System.out.println("5️⃣ - Natural");
        System.out.println("6️⃣ - Natural + Ferment");
        System.out.println("👉 Choose between (1 - 6): ");
        System.out.print("Enter your choice: ");

        userProcess = validatedIntRangeInput(scanner, 1, 6,
                "⚠️ Invalid input. Process must be between 1-6. Please try again ⚠️");

        System.out.println("🔥 Roast Level Selection");
        System.out.println("1️⃣ - Very Light");
        System.out.println("2️⃣ - Light");
        System.out.println("3️⃣ - Medium Light");
        System.out.println("4️⃣ - Medium Dark");
        System.out.println("5️⃣ - Dark");
        System.out.println("6️⃣ - Very Dark");
        System.out.println("👉 Choose a roast level (1 - 6):");
        System.out.print("Enter your choice: ");

        userRoastLevel = validatedIntRangeInput(scanner, 1, 6,
                "⚠️ Invalid input. Roast Level must be between 1-6. Please try again ⚠️");

        System.out.println("📋 Recipe Setup");
        System.out.println("💡 Would you like to build your recipe based on:");
        System.out.println("  1️⃣  Coffee dose (how much coffee you want to grind, in grams)");
        System.out.println("  2️⃣  Final brew water (how much water you want to pour, in ml)");
        System.out.print("👉 Enter 1 for grams of coffee or 2 for total brew water: ");

        userRecipeChoice = validatedIntRangeInput(scanner, 1, 2,
                "⚠️ Invalid input. Choose between 1-2. Please try again ⚠️");

        if (userRecipeChoice == 1) {
            // ☕ Χρήστης θέλει να ξεκινήσει από ΔΟΣΟΛΟΓΙΑ ΚΑΦΕ -> TotalWaterCalculator
            System.out.println("👉 Please enter your desired coffee dose:");
            System.out.println("The coffee dose must be between 10g and 30g");

            userCoffeeDose = validDoubleRangeInput(scanner, 10, 30,
                    "⚠️ Invalid input. Please type between 10 to 30 ⚠️");

            ByCoffeeDoseCalculator madeByCoffeeDose = new ByCoffeeDoseCalculator(
                    userProcess, userRoastLevel, userCoffeeDose
            );
            madeByCoffeeDose.showRecipe();
        } else {
            // 💧 Χρήστης θέλει να ξεκινήσει από ΣΥΝΟΛΙΚΟ ΝΕΡΟ -> DoseCalculator
            System.out.println("💧 Total Brew Water Selection ");
            System.out.println("👉  Please choose between 180ml and 500ml:");

            userTotalWater = validDoubleRangeInput(scanner, 180, 500,
                    "⚠️ Invalid input. Please type between 180 to 500 ⚠️");

            ByTotalWaterCalculator madeByTotalWater = new ByTotalWaterCalculator(
                    userProcess, userRoastLevel, userTotalWater
            );
            madeByTotalWater.showRecipe();
        }
    }

    private static int validatedIntRangeInput(Scanner scanner, int min, int max, String errorMessage) {
        while (true) {
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input >= min && input <= max) {
                    return input;
                }
            } else {
                scanner.next(); // discard invalid input
            }
            System.out.println(errorMessage);
        }
    }

    private static double validDoubleRangeInput(Scanner scanner, double min, double max, String errorMessage) {
        while (true) {
            String input = scanner.next();
            try {
                double value = Double.parseDouble(input.replace(",", "."));
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException ignored) {}
            System.out.println(errorMessage);
        }
    }
}
