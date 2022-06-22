package com.webdesign;

public class CommonUtils {

    public static boolean stringIsBlank(String s) {
        return s == null || s.isBlank();
    }

    public static boolean isInteger(String s) {
        if (s == null) {
            return false;
        }

        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }


}
