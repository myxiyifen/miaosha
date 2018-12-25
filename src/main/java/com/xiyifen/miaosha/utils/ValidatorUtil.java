package com.xiyifen.miaosha.utils;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: fs.z
 * @Date: 2018/12/22 23:08
 * @Description:
 */
public class ValidatorUtil {

    private static final Pattern mobile_pattern=Pattern.compile("1\\d{10}");

    public static boolean isMobile(String str){
        if (StringUtils.isEmpty(str)){
            return false;
        }
        Matcher matcher = mobile_pattern.matcher(str);
        return matcher.matches();
    }

//    public static void main(String[] args) {
////        System.out.println(isMobile("12345678900"));
////        System.out.println(isMobile("1234567890"));
//    }
}
