/**
 * 482. License Key Formatting
 *
 * Created by qiuyankun on 19/6/17.
 */
public class LicenseKeyFormat {
    public static String licenseKeyFormatting(String S, int K) {
        String res = "";
        int count = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            String temp = S.substring(i, i + 1);
            if (!temp.equals("-")) {
                if (temp.charAt(0) >= '0' && temp.charAt(0) <= '9') {
                    res = temp + res;
                    count ++;
                } else {
                    res = temp.toUpperCase() + res;
                    count ++;
                }
                if (count % K == 0) {
                    res = "-" + res;
                }
            }
        }

        if (!res.equals("") && res.charAt(0) == '-'){
            res = res.substring(1);
        }
        return res;

    }
}
