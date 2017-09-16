/**
 * 11.  Container With Most Water
 *
 * There are two ways to make the area biggest. The highest one with someone else together, or we just begin from the
 * first one and the last one, each time move the index on which the bar is shorter, until these two indexes come across.
 * During the process, record the max area so far.
 *
 * Created by qiuyankun on 16/9/17.
 */
public class MostWater {
    public static int maxArea(int[] height) {
        int highestIndex = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[highestIndex] < height[i]) highestIndex = i;
        }

        int max1 = maxWithinRange(height, 0, height.length - 1, highestIndex);
        int max2 = maxWithinRange(height, 0, highestIndex, highestIndex);
        int max3 = maxWithinRange(height, highestIndex, height.length - 1, highestIndex);
        return Math.max(Math.max(max1,max2),max3);

    }

    public static int maxWithinRange(int[] height, int lo, int hi,int highest) {
        int maxArea = 0;
        int curArea = 0;
        while (lo < hi) {
            if (height[lo] < height[hi]) {
                curArea = height[lo] * (hi - lo);
                lo ++;
            } else {
                curArea = height[hi] * (hi - lo);
                if (height[lo] == height[hi]) {
                    if (hi - highest > highest - lo) {
                        lo ++;
                    } else {
                        hi --;
                    }
                } else {
                    hi --;
                }
            }
            if (curArea > maxArea) {
                maxArea = curArea;
            }
        }
        return maxArea;
    }
}
