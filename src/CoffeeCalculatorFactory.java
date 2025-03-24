public class CoffeeCalculatorFactory {
public CoffeeCalculator createdByTotalWater(int process, int roastLevel, double totalWater){
    return new CoffeeCalculator(process,roastLevel,totalWater);
}

public CoffeeCalculator createdByCoffeeDose(int process, int roastLevel, double coffeeDose){
    CoffeeCalculator createdByCoffeeDose = new CoffeeCalculator(process,roastLevel,0);
    createdByCoffeeDose.setCoffeeDose(coffeeDose);
    createdByCoffeeDose.calculateBrewRatio();
    createdByCoffeeDose.calculateTotalWater();
    createdByCoffeeDose.calculateFinalBeverage();
    createdByCoffeeDose.calculatePours();
    createdByCoffeeDose.calculateTemperature();
    return createdByCoffeeDose;

}
}
