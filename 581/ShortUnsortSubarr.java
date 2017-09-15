/**
 * Created by qiuyankun on 9/9/17.
 */
import java.util.Arrays;
public class ShortUnsortSubarr {
    public static int findUnsortedSubarray(int[] nums) {
        int[] sort = new int[nums.length];

        for (int k = 0; k < nums.length; k++) {
            sort[k] = nums[k];
        }

        int i = 0, j = nums.length - 1;
        Arrays.sort(sort);

        while (i < nums.length && nums[i] == sort[i]) i ++;
        while (j >=0 && nums[j] == sort[j]) j --;

        if (i > j){
            return 0;
        } else {
            return j - i + 1;
        }
    }
}
