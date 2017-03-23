package com.laojiang.utilslibrary.uitls;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 类介绍（必填）：字符串工具类
 * Created by Jiang on 2017/3/15 15:56.
 */

public class StringsUtils {
    /**
     * 判断是否是 数字
     * @param str
     * @return
     */
    public static boolean  isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
}
