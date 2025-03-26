public class ByTotalWaterCalculator extends CoffeeCalculator {
    public ByTotalWaterCalculator(int process, int roastLevel, double totalWater){
        super(process,roastLevel);
        calculateBrewRatio();
        setTotalWater(totalWater);
        calculateCoffeeDose();
        calculateFinalBeverage();
        calculatePours();
        calculateTemperature();

    }

    public double calculateCoffeeDose(){
        setCoffeeDose(super.getTotalWater()/super.getBrewRatio());
        return getCoffeeDose();
    }
}
