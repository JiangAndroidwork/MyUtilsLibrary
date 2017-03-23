package com.laojiang.utilslibrary.uitls.systemsetting;

import com.laojiang.utilslibrary.volley.util.StringUtils;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/23 9:56.
 */

public class FilesUtils {
    /**
     * 根据URL 获取文件名称
     * @param url
     * @return
     */
    public static String getFileName(String url){
        if(StringUtils.isEmpty(url)) return "";
        String extension = "";
        String[] strs = url.split("/");

        String temp = strs[strs.length-1];

        return temp;
    }
}
