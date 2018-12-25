package com.xiyifen.miaosha.controller;

import com.xiyifen.miaosha.result.CodeMsg;
import com.xiyifen.miaosha.result.Result;
import com.xiyifen.miaosha.service.MiaoshaUserService;
import com.xiyifen.miaosha.utils.ValidatorUtil;
import com.xiyifen.miaosha.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;


/**
 * @Author: fs.z
 * @Date: 2018/12/22 22:16
 * @Description:
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    MiaoshaUserService miaoshaUserService;

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(@Valid LoginVo loginVo) {
        logger.info(loginVo.toString());

//        // 参数校验
//        String mobile = loginVo.getMobile();
//        String password = loginVo.getPassword();
//        if(StringUtils.isEmpty(mobile)){
//            return Result.error(CodeMsg.MOBILE_EMPTY);
//        }
//        if (StringUtils.isEmpty(password)){
//            return Result.error(CodeMsg.PASSWORD_EMPTY);
//        }
//        if (!ValidatorUtil.isMobile(mobile)){
//            return Result.error(CodeMsg.MOBILE_ERROR);
//        }
        // 登录
        miaoshaUserService.login(loginVo);
        return Result.success(true);
    }
}
