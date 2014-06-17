package leetcode;

/**
 * Created by xzhang on 6/12/14.
 */
public class MultiplyStrings {

    public static void main(String[] args) {
        MultiplyStrings ms = new MultiplyStrings();
        String result = ms.multiply("99", "99");
        System.out.println(result);
    }

    public String multiply(String num1, String num2) {
        char[] result = new char[num1.length() + num2.length() + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = '0';
        }
        num1 = reverse(num1);
        num2 = reverse(num2);
        int carry = 0;

        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int t = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + (result[i + j] - '0') + carry;
                result[i + j] = (char) ('0' + t % 10);
                carry = t / 10;
            }
            if (carry > 0) {
                int k = i + num2.length();
                while (carry > 0) {
                    result[k] = (char) (carry % 10 + '0');
                    carry = carry / 10;
                }
            }
        }

        String output = String.valueOf(reverse(result));
        int k = 0;
        // "0" * "0" = "0" rather than ""
        // to keep the last "0", the right bound of k is length - 1
        while (k < output.length() - 1 && output.charAt(k) == '0') {
            k++;
        }

        return output.substring(k, output.length());
    }

    private String reverse(String num) {
        char[] arr = num.toCharArray();
        arr = reverse(arr);
        return String.valueOf(arr);
    }

    private char[] reverse(char[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }
}
