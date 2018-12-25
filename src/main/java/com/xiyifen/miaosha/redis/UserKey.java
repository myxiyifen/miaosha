package com.xiyifen.miaosha.redis;

/**
 * @Author: fs.z
 * @Date: 2018/12/22 20:15
 * @Description:
 */
public class UserKey extends BasePrefix {

    private UserKey(String prefix){
        super(prefix);
    }

   public static UserKey getById= new UserKey("id");

    public static UserKey getByName=new UserKey("name");
}
