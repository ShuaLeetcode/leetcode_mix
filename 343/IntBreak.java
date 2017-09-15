import java.util.HashMap;

/**
 *
 * Created by qiuyankun on 5/9/17.
 */
public class IntBreak {
    static public int integerBreak(int n) {
        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
        result.put(2, 1);
        result.put(3, 2);
        for (int value = 4; value <= n ; value++) {
            int maximum = 0;
            for (int factor = 2; factor <= value /2; factor ++) {
                int factorPrime = value - factor;
                int multiplierOne = factor > result.get(factor)? factor : result.get(factor);
                int multiplierTwo = factorPrime > result.get(factorPrime)?factorPrime:result.get(factorPrime);
                if (maximum < multiplierOne * multiplierTwo) {
                    maximum = multiplierOne * multiplierTwo;
                }
            }
            result.put(value, maximum);
        }
        return result.get(n);
    }
}
