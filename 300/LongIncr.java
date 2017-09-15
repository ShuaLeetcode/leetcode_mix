/**
 * Created by qiuyankun on 8/9/17.
 */
import java.util.Arrays;
public class LongIncr {
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) {
//                dp[i] = x;
                len++;
            }
        }
        return len;
    }
}
