package com.xiyifen.miaosha.dao;

import com.xiyifen.miaosha.domain.MiaoshaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: fs.z
 * @Date: 2018/12/22 23:00
 * @Description:
 */
@Mapper
public interface MiaoshaUserDao {

    @Select("select * from miaosha_user where id=#{id}")
    public MiaoshaUser getById(@Param("id")long id);
}
