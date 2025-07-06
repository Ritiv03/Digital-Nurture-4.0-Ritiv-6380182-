package DSA2;
public class GrowthPredictor {

    public static double calculateFutureValue(double presentValue, double rate, int years) {
        if (years == 0) {
            return presentValue;
        }

        double newValue = presentValue * (1 + rate);
        return calculateFutureValue(newValue, rate, years - 1);
    }

    public static void main(String[] args) {
        double initialValue = 1000.0;   
        double growthRate = 0.10;      
        int years = 5;

        double futureValue = calculateFutureValue(initialValue, growthRate, years);
        System.out.printf("Future value after %d years: %.2f%n", years, futureValue);
    }
}
