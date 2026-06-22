public class ForecastTest {
    public static void main(String[] args) {
        double initialValue = 1000.0;  // Starting investment
        double growthRate = 0.05;      // 5% annual growth
        int years = 20;

        System.out.println("=== Financial Forecasting Example ===\n");
        System.out.println("Initial Value: $" + initialValue);
        System.out.println("Annual Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Years: " + years);
        System.out.println();

        // Iterative approach (safest for larger years)
        System.out.println("--- Iterative Approach (Optimal) ---");
        long start = System.nanoTime();
        double iterResult = FinancialForecaster.iterativeForecast(initialValue, growthRate, years);
        long iterTime = System.nanoTime() - start;
        System.out.println("Future Value: $" + String.format("%.2f", iterResult));
        System.out.println("Time: " + iterTime + " ns");
        System.out.println("Complexity: O(n) time, O(1) space\n");

        // Memoized recursive approach
        System.out.println("--- Memoized Recursive Approach ---");
        start = System.nanoTime();
        double memoResult = FinancialForecaster.memoizedForecast(initialValue, growthRate, years);
        long memoTime = System.nanoTime() - start;
        System.out.println("Future Value: $" + String.format("%.2f", memoResult));
        System.out.println("Time: " + memoTime + " ns");
        System.out.println("Complexity: O(n) time, O(n) space\n");

        // Naive recursive (only for small years to avoid stack overflow)
        System.out.println("--- Naive Recursive Approach ---");
        int smallYears = 20;  // Limit to avoid exponential explosion
        start = System.nanoTime();
        double naiveResult = FinancialForecaster.naiveRecursiveForecast(initialValue, growthRate, smallYears);
        long naiveTime = System.nanoTime() - start;
        System.out.println("Future Value: $" + String.format("%.2f", naiveResult));
        System.out.println("Time: " + naiveTime + " ns");
        System.out.println("Complexity: O(2^n) time, O(n) space (exponential!)\n");

        System.out.println("=== Analysis ===");
        System.out.println("Naive recursion becomes impractical quickly due to exponential growth.");
        System.out.println("Memoization reduces redundant calculations (O(n) instead of O(2^n)).");
        System.out.println("Iteration is the most efficient solution for this problem.\n");
        System.out.println("Performance ratio (Naive vs Memoized): " + 
                          String.format("%.2fx", (double) naiveTime / memoTime) + "x");
    }
}
