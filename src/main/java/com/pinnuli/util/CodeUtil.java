package com.pinnuli.util;

import java.util.UUID;

/**
 * @description: 激活码生成类
 * @author: pinnuli
 * @date: 2018-4-26
 */

public class CodeUtil {

    /**
     * 生成唯一的激活码
     *
     * @return 激活码
     */
    public static String generateActiveCode() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
