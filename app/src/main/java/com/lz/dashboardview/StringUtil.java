package com.lz.dashboardview;

import java.math.BigDecimal;

public class StringUtil {
    /**
     * float 转成一位小数
     *
     * @param value
     * @return
     */
    public static String floatFormat(float value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(0, BigDecimal.ROUND_HALF_DOWN);
        return bd.toString();
    }
}
