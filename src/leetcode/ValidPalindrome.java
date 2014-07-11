package leetcode;

/**
 * Created by xzhang71 on 7/5/14.
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome obj = new ValidPalindrome();
        System.out.println(obj.isPalindrome("a."));
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            while (i < j && !isAlphanumeric(arr[i])) {
                i++;
            }
            while (i < j && !isAlphanumeric(arr[j])) {
                j--;
            }
            if (!isEqual(arr[i], arr[j])) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    private boolean isAlphanumeric(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
            return true;
        }
        return false;
    }

    private boolean isEqual(char a, char b) {
        if (a == b) {
            return true;
        }

        if (a >= 'A' && a <= 'Z') {
            a = (char) (a - 'A' + 'a');
        }

        if (b >= 'A' && b <= 'Z') {
            b = (char) (b - 'A' + 'a');
        }

        return a == b;
    }
}
