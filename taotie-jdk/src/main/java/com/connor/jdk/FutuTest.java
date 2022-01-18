package com.connor.jdk;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FutuTest {

    private static Map<Character, Integer> CHAR_MAP = new HashMap<Character, Integer>();

    static {
        CHAR_MAP.put('K', 1024);
        CHAR_MAP.put('M', 1024 * 1024);
        CHAR_MAP.put('G', 1024 * 1024 * 1024);
    }

    public static void main(String[] args) {

        strToInt("99999999999999G");
    }

    private static int strToInt(String param) {
        long result = -1;

        if (param == null || param.isEmpty()) {
            return (int) result;
        }

        BigDecimal max = new BigDecimal(Integer.MAX_VALUE);
        BigDecimal num = null;
        //截取最后一位判断
        Character last = param.charAt(param.length() - 1);
        if (CHAR_MAP.get(last) == null) {

            //数字
            num = new BigDecimal(last);
        } else {
            Integer key = CHAR_MAP.get(last);
            String numStr = param.substring(0, param.length() - 1);
            num = new BigDecimal(numStr);
            num = num.multiply(new BigDecimal(key));
        }

        if (num.compareTo(max) > 0) {
            return -1;
        }
        return num.intValue();
    }


}

