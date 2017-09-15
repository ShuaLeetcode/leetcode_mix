/**
 * 340. Longest Substring with At Most K Distinct Characters
 *
 * Created by qiuyankun on 19/6/17.
 */
public class LenOfLongest {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() <= k) {
            return s.length();
        }

        if (k == 0) {
            return 0;
        }

        String crossStr = "";
        int crossStrBegin = 0;
        int internalStrLen = 0;
        int crossStrLen = 0;
        int chaInCrossStr = 0;

        for (int index = 0; index < s.length(); index++) {
            crossStr = s.substring(crossStrBegin, index);
            crossStrLen = crossStr.length();
            if (!crossStr.contains(s.substring(index, index + 1))) {
                if (chaInCrossStr < k) {
                    chaInCrossStr ++;
                    crossStrLen ++;
                } else {
                    if (crossStrLen > internalStrLen) {
                        internalStrLen = crossStrLen;
                    }
                    int offset = 0;
                    while (crossStr.substring(offset + 1).contains(crossStr.substring(offset, offset + 1))) {
                        offset ++;
                        crossStrLen --;
                    }
                    offset ++;
                    crossStrBegin += offset;
                }
            } else {
                crossStrLen ++;
            }
        }

        if (internalStrLen > crossStrLen){
            return internalStrLen;
        } else {
            return crossStrLen;
        }

    }
}
