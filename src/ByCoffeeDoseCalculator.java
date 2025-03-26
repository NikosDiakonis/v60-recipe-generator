public class ByCoffeeDoseCalculator extends CoffeeCalculator {

    public ByCoffeeDoseCalculator(int process, int roastLevel, double coffeeDose) {
        super(process,roastLevel);
        calculateBrewRatio();
        setCoffeeDose(coffeeDose);

        calculateTotalWater();
        calculateFinalBeverage();
        calculatePours();
        calculateTemperature();
    }

    public double calculateTotalWater(){
        setTotalWater(getCoffeeDose() * calculateBrewRatio());
        return getTotalWater();
    }
}
