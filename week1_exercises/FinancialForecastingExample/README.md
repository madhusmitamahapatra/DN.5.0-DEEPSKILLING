# Financial Forecasting Example

This example demonstrates recursive algorithms for financial forecasting, including performance analysis and optimization techniques.

## Approaches Implemented

1. **Naive Recursive** - Direct recursion without optimization
   - Time Complexity: O(2^n) exponential
   - Space Complexity: O(n) call stack
   - Issue: Exponential redundant calculations

2. **Memoized Recursive** - Recursion with caching
   - Time Complexity: O(n) linear
   - Space Complexity: O(n) cache + stack
   - Benefit: Eliminates redundant calculations

3. **Iterative** - Loop-based approach (optimal)
   - Time Complexity: O(n) linear
   - Space Complexity: O(1) constant
   - Best for production use

## Formula

```
futureValue(n) = initialValue * (1 + growthRate)^n
```

Recursively:
```
futureValue(n) = futureValue(n-1) * (1 + growthRate)
Base case: futureValue(0) = initialValue
```

## Run Instructions

```powershell
cd .\week1_exercises\FinancialForecastingExample\src
javac *.java
java ForecastTest
```

## Expected Output

- Forecasted future values from all three approaches
- Execution times for performance comparison
- Complexity analysis explanation
