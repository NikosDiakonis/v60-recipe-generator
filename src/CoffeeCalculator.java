public class CoffeeCalculator {
    private int recipeChoice;
    private int process;
    private  int roastLevel;
    private  double totalWater;
    private  double finalBeverage;
    private double coffeeDose;
    private  double brewRatio;
    private int temperature;
    private static final int[][] TEMPERATURE_TABLE = {
            // Process:          Washed | W+F | Y.Honey | R.Honey | Natural | N+F
            /* Very Light */    {   96,    95,       94,       93,      92,   91 },
            /* Light      */    {   95,    94,       93,       92,      91,   90 },
            /* Medium Light*/   {   94,    93,       92,       91,      90,   89 },
            /* Medium Dark */   {   93,    92,       91,       90,      89,   88 },
            /* Dark        */   {   92,    91,       90,       89,      88,   87 },
            /* Very Dark   */   {   91,    90,       89,       88,      87,   86 }
    };
            /* static γιατί ένα αντίγραφο για όλα τα αντικείμενα της κλάσης
             final γιατί η τιμή του πίνακα δν θα αλλαχθεί. */


    private  double bloom;
    private  double firstPour;
    private double secondPour;
    private double finalPour;



    public CoffeeCalculator(int process, int roastLevel, double totalWater) {
        if(process<1 || process>6){
            throw new IllegalArgumentException("Process must be between 1-6");
        }
        this.process = process;
        if(roastLevel<1 || roastLevel>6)
            throw new IllegalArgumentException("Roast Level must be between 1-6");
        this.roastLevel = roastLevel;
        this.totalWater = totalWater;
        calculateBrewRatio();
        calculateCoffeeDose();
        calculateFinalBeverage();
        calculatePours();
        calculateTemperature();
    }

    public double getFinalBeverage() {
        return finalBeverage;
    }

    public void setFinalBeverage(double finalBeverage) {
        this.finalBeverage = finalBeverage;
    }

    public int getRecipeChoice() {
        return recipeChoice;
    }

    public void setRecipeChoice(int recipeChoice) {
        this.recipeChoice = recipeChoice;
    }

    public int getProcess() {
        return process;
    }

    public void setProcess(int process) {
        this.process = process;
    }

    public int getRoastLevel() {
        return roastLevel;
    }

    public void setRoastLevel(int roastLevel) {
        if(roastLevel<1 || roastLevel>6)
            throw new IllegalArgumentException("Roast Level must be between 1-6");
        this.roastLevel = roastLevel;
    }

    public double getTotalWater() {
        return totalWater;
    }

    public void setTotalWater(double totalWater) {
        this.totalWater = totalWater;
    }

    public double getCoffeeDose() {
        return coffeeDose;
    }

    public void setCoffeeDose(double coffeeDose) {
        this.coffeeDose = coffeeDose;
    }

    public double getBrewRatio() {
        return brewRatio;
    }

    public void setBrewRatio(double brewRatio) {
        if(brewRatio<=0){
            throw new IllegalArgumentException("The brew ratio must be greater than 0");
        }
        this.brewRatio = brewRatio;

    }

    private double calculateBrewRatio (){
        switch (this.process){
            case 1 -> this.brewRatio = 16.6; // 1 = Washed
            case 2 -> this.brewRatio = 16.6; // 2 = Washed + Ferment
            case 3 -> this.brewRatio = 16.2; // 3 = Yellow Honey
            case 4 -> this.brewRatio = 16.8; // 4 = Red Honey
            case 5 -> this.brewRatio = 16.8; // 5 = Natural
            case 6 -> this.brewRatio = 15; // 6 = Natural + Ferment
        }
        return this.brewRatio;
    } ;

    private double calculateCoffeeDose(){
        this.coffeeDose = this.totalWater / this.brewRatio;
        return this.coffeeDose;
    }

    private double [] calculatePours(){
        this.bloom = 0.20 * this.totalWater;
         this.firstPour = 0.53 * this.totalWater;
         this.secondPour = 0.80 * this.totalWater;
         this.finalPour = this.totalWater;
         return new double[]{this.bloom, this.firstPour, this.secondPour, this.finalPour};

    }

    private int calculateTemperature(){
            this.temperature = TEMPERATURE_TABLE[this.roastLevel  - 1][this.process - 1];
            return this.temperature;
    }

    private double calculateTotalWater(){
        this.totalWater = this.coffeeDose * this.brewRatio;
        return this.totalWater;
    }

    private double calculateFinalBeverage(){
        this.finalBeverage = this.totalWater * 0.867;
        return this.finalBeverage;
    }

    public void showRecipe() {
        System.out.println("\n================= ☕ Coffee Recipe ☕ =================");
        System.out.printf("• %-20s : %.2fg%n", "Coffee Dose", this.coffeeDose);
        System.out.printf("• %-20s : %d°C%n", "Water Temperature", this.temperature);
        System.out.printf("• %-20s : %.2fml%n","Final Beverage Yield",this.finalBeverage);



        System.out.println("\n---------  \uD83D\uDCA7  Pouring Guide  \uD83D\uDCA7  ------------");
        System.out.printf("• %-18s : %.2fg  → stop at 0:30%n", "Bloom", this.bloom);
        System.out.printf("• %-18s : %.2fg  → stop at 1:00%n", "First pour", this.firstPour);
        System.out.printf("• %-18s : %.2fg → stop at 1:30%n", "Second pour", this.secondPour);
        System.out.printf("• %-18s : %.2fg → stop at 2:30 - 2:45%n", "Final pour", this.finalPour);
        System.out.println("---------------------------------------------");

        System.out.println("\n💡 If your coffee has a lot of fines,");
        System.out.println("   skip the second pour and go straight to final.");
        System.out.println("==================================================\n");
    }


    // Factory method γιατι δεν μπορώ να έχω 2 constructor me int int double
    public static CoffeeCalculator byTotalWater(int process, int roastLevel, double totalWater){

        CoffeeCalculator byTotalWater = new CoffeeCalculator(process,roastLevel,totalWater);
        return byTotalWater;
    }

    public static CoffeeCalculator byCoffeeDose(int process, int roastLevel, double coffeeDose){

        CoffeeCalculator byCoffeeDose = new CoffeeCalculator(process,roastLevel,0); // Χρησιμοποιούμε προσωρινά 0 ως totalWater γιατί ο constructor απαιτεί τιμή
                                                                                          //  αλλά θα υπολογιστεί σωστά αμέσως μετά με βάση τη δόση καφέ και το brew ratio
     byCoffeeDose.setCoffeeDose(coffeeDose);
     byCoffeeDose.calculateBrewRatio();
     byCoffeeDose.calculateTotalWater();
     byCoffeeDose.calculateFinalBeverage();
     byCoffeeDose.calculatePours();
     byCoffeeDose.calculateTemperature();
     return byCoffeeDose;
    }
}
