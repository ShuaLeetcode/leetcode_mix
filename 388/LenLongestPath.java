import java.util.HashMap;

/**
 * 388. Longest Absolute File Path
 *
 * Created by qiuyankun on 19/6/17.
 */
public class LenLongestPath {
    public static int lengthLongestpath(String input) {
        String[] filePath = input.split("\n");
        HashMap<Integer, String> curLevel = new HashMap<Integer, String>();

        int preLevel = -1;
        int longestPath = 0;

        for (String str : filePath) {
            String currentPath = "";
            int i = 0;
            while (str.substring(i, i + 1).equals("\t")) {
                i ++;
            }

            String validPart = str.substring(i);
            Boolean ifFile = validPart.contains(".");

            if (i == preLevel) {

                if (ifFile) {
                    for (int j = 0; j < i; j++) {
                        currentPath = currentPath + curLevel.get(j);
                        currentPath = currentPath + "/";
                    }
                    currentPath = currentPath + validPart;
                    if (currentPath.length() > longestPath) longestPath = currentPath.length();
                } else {
                    if (curLevel.containsKey(i)) {
                        curLevel.remove(i);
                    }
                    curLevel.put(i, validPart);
                }

            } else if (i > preLevel) {
                if (ifFile) {
                    for (int j = 0; j < i; j++) {
                        currentPath = currentPath + curLevel.get(j);
                        currentPath = currentPath + "/";
                    }
                    currentPath = currentPath + validPart;
                    if (currentPath.length() > longestPath) longestPath = currentPath.length();
                } else {
                    curLevel.put(i, validPart);
                }
            } else {
                curLevel.remove(preLevel);
                if (ifFile) {
                    for (int j = 0; j < i; j++) {
                        currentPath = currentPath + curLevel.get(j);
                        currentPath = currentPath + "/";
                    }
                    currentPath = currentPath + validPart;
                    if (currentPath.length() > longestPath) longestPath = currentPath.length();
                } else {
                    if (curLevel.containsKey(i)) {
                        curLevel.remove(i);
                    }
                    curLevel.put(i, validPart);
                }
            }

            preLevel = i;

        }
        return longestPath;
    }
}
