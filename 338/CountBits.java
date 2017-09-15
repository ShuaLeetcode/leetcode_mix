/**
 * Created by qiuyankun on 8/9/17.
 */
public class CountBits {
    public static int[] countBits(int num){
        int[] res = new int[num + 1];
        for (int i = 0; i <= num / 2; i++) {
            res[2 * i] = res[i];
            if(2 * i != num) {
                res[2 * i + 1] = res[i] + 1;
            }
        }
        return res;
    }
}
