package com.xiyifen.miaosha.redis;

/**
 * @Author: fs.z
 * @Date: 2018/12/22 19:51
 * @Description:
 */
public interface KeyPrefix {

    public int expireSeconds();

    public String getPrefix();
}
