import java.util.HashMap;
import java.util.Map;

/**
 * Financial forecasting using recursive algorithms.
 * Demonstrates naive recursion and optimization via memoization.
 */
public class FinancialForecaster {
    
    /**
     * Naive recursive approach to calculate future value.
     * Formula: futureValue(n) = futureValue(n-1) * (1 + growthRate)
     * Base case: futureValue(0) = initialValue
     * 
     * Time Complexity: O(2^n) - exponential
     * Space Complexity: O(n) - call stack depth
     * 
     * @param initialValue the starting amount
     * @param growthRate the annual growth rate (e.g., 0.05 for 5%)
     * @param years number of years to forecast
     * @return the predicted future value
     */
    public static double naiveRecursiveForecast(double initialValue, double growthRate, int years) {
        if (years == 0) {
            return initialValue;
        }
        return naiveRecursiveForecast(initialValue, growthRate, years - 1) * (1 + growthRate);
    }

    /**
     * Optimized recursive approach using memoization.
     * Stores computed results to avoid redundant calculations.
     * 
     * Time Complexity: O(n) - each year computed once
     * Space Complexity: O(n) - memoization cache + call stack
     * 
     * @param initialValue the starting amount
     * @param growthRate the annual growth rate
     * @param years number of years to forecast
     * @return the predicted future value
     */
    public static double memoizedForecast(double initialValue, double growthRate, int years) {
        Map<Integer, Double> memo = new HashMap<>();
        return memoizedForecastHelper(initialValue, growthRate, years, memo);
    }

    private static double memoizedForecastHelper(double initialValue, double growthRate, 
                                                   int years, Map<Integer, Double> memo) {
        if (years == 0) {
            return initialValue;
        }
        if (memo.containsKey(years)) {
            return memo.get(years);
        }
        double result = memoizedForecastHelper(initialValue, growthRate, years - 1, memo) * (1 + growthRate);
        memo.put(years, result);
        return result;
    }

    /**
     * Iterative approach (optimal for this problem).
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param initialValue the starting amount
     * @param growthRate the annual growth rate
     * @param years number of years to forecast
     * @return the predicted future value
     */
    public static double iterativeForecast(double initialValue, double growthRate, int years) {
        double result = initialValue;
        for (int i = 0; i < years; i++) {
            result *= (1 + growthRate);
        }
        return result;
    }
}
