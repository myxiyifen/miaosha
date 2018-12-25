package com.xiyifen.miaosha.service;

import com.xiyifen.miaosha.dao.MiaoshaUserDao;
import com.xiyifen.miaosha.domain.MiaoshaUser;
import com.xiyifen.miaosha.exception.GlobleException;
import com.xiyifen.miaosha.result.CodeMsg;
import com.xiyifen.miaosha.utils.MD5Util;
import com.xiyifen.miaosha.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: fs.z
 * @Date: 2018/12/22 22:59
 * @Description:
 */
@Service
public class MiaoshaUserService {

    @Autowired
    MiaoshaUserDao miaoshaUserDao;

    public MiaoshaUser getById(long id){
        return miaoshaUserDao.getById(id);
    }

    public boolean login(LoginVo loginVo) {
        if (loginVo == null) {
            throw new GlobleException(CodeMsg.Server_ERROR);
        }
        String mobile = loginVo.getMobile();
        String formPass = loginVo.getPassword();
        // 判断手机号是否存在
        MiaoshaUser user = getById(Long.parseLong(mobile));
        if (user == null) {
            throw new GlobleException(CodeMsg.MOBILE_NOT_EXIST);
        }
        // 验证密码
        String dbpass = user.getPassword();
        String dbSalt = user.getSalt();
        String calcPass = MD5Util.formPassToDBPass(formPass, dbSalt);
        if (!calcPass.equals(dbpass)){
            throw new GlobleException(CodeMsg.PASSWORD_ERROR);
        }
        return true;
    }

   /* public CodeMsg login(LoginVo loginVo) {
        if (loginVo == null) {
            return CodeMsg.Server_ERROR;
        }
        String mobile = loginVo.getMobile();
        String formPass = loginVo.getPassword();
        // 判断手机号是否存在
        MiaoshaUser user = getById(Long.parseLong(mobile));
        if (user == null) {
            return CodeMsg.MOBILE_NOT_EXIST;
        }
        // 验证密码
        String dbpass = user.getPassword();
        String dbSalt = user.getSalt();
        String calcPass = MD5Util.formPassToDBPass(formPass, dbSalt);
        if (!calcPass.equals(dbpass)){
            return CodeMsg.PASSWORD_ERROR;
        }
        return CodeMsg.SUCCESS;
    }*/
}
