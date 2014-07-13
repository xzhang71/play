package cci;

/**
 * Created by xzhang on 7/10/14.
 */
public class BinaryHexEqual {

    /**
     * Check if the value of a binary number as a string equals the hexadecimal number as a string
     */

    /*
    public static boolean equal(String bin, String hex) {
        // bin null
        // hex null
        // bin only 0 and 1
        // hex 0x...
        // hex only 0 to F

        int left = 0;
        for (int i = 0; i < bin.length(); i++) {
            left = left * 2 + (bin.charAt(i) - '0');
        }

        int right = 0;
        for (int i = 2; i < hex.length(); i++) {
            char ch = hex.charAt(i);
            int num = 0;
            if (ch >= 'A' && ch <= 'F') {
                num = ch - 'A' + 10;
            } else if (ch >= 'a' && ch <= 'f') {
                num = ch - 'a' + 10;
            } else if (ch >= '0' && ch <= '9') {
                num = ch - '0';
            }
            right = right * 16 + num;
        }

        return left == right;
    }
    */
    public static boolean equal(String bin, String hex) {
        return toDecimal(2, bin) == toDecimal(16, hex);
    }

    private static int toDecimal(int base, String str) {
        if (base == 2 || base == 8 || base == 10 || base == 16) {
            int val = 0;
            for (int i = 0; i < str.length(); i++) {
                val = val * base + charToInt(str.charAt(i));
            }
            return val;
        } else {
            throw new RuntimeException(base + " is not valid");
        }
    }

    private static int charToInt(char ch) {
        if (ch >= 'A' && ch <= 'F') {
            return ch - 'A' + 10;
        } else if (ch >= 'a' && ch <= 'f') {
            return ch - 'a' + 10;
        } else if (ch >= '0' && ch <= '9') {
            return ch - '0';
        } else {
            throw new RuntimeException(ch + " is not valid");
        }
    }

    public static void main(String[] args) {
        System.out.println(BinaryHexEqual.equal("101011111001010101010101110", "57CAAAE"));
        System.out.println(BinaryHexEqual.equal("101011111001010101010101111", "57CAAAE"));
    }
}
