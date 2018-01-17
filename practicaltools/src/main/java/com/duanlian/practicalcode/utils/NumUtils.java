package com.duanlian.practicalcode.utils;

import java.text.NumberFormat;

/**
 * Created by duanlian on 2018/1/11.
 * Description :
 */

public class NumUtils {
    /**
     * 截取Double类型的数据
     * @param i 要截取的数据
     * @param j 需要保留几位小数
     * @return string类型的
     */
    public static String retaindDecimal(Double i,int j) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(j);
        return nf.format(i);
    }
}
