/**
 * 357. Count Numbers with Unique Digits
 *
 * Created by qiuyankun on 4/9/17.
 */
public class UniqueDigits {
    static public int countNumbersWithUniqueDigits(int n) {
        int[] result = new int[11];
        result[0] = 1;
        result[1] = 9;
        result[2] = 81;
        int totalNum = 0;
        for (int i = 3; i < 11; i++) {
            result[i] = result[i - 1] * (10 - i + 1);
        }
        if (n < 10) {
            for (int i = 0; i <= n; i++) {
                totalNum += result[i];
            }
        } else {
            for (int i = 0; i <= 10; i++) {
                totalNum += result[i];
            }
        }
        return totalNum;
    }
}
