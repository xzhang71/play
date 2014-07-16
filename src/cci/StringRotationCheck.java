package cci;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by xzhang71 on 7/13/14.
 */
public class StringRotationCheck {

    public static boolean isRotated(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        return isSubstring(str1 + str1, str2);
    }

    public static boolean isSubstring(String str1, String str2) {
        throw new NotImplementedException();
    }
}
