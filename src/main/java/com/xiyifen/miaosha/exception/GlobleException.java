package com.xiyifen.miaosha.exception;

import com.xiyifen.miaosha.result.CodeMsg;

/**
 * @Author: fs.z
 * @Date: 2018/12/23 10:45
 * @Description:
 */
public class GlobleException extends RuntimeException {

    private static final long serialVersionUID = 2035710952900065202L;

    private CodeMsg codeMsg;
    public GlobleException(CodeMsg codeMsg) {
        super(codeMsg.toString());
        this.codeMsg=codeMsg;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }

    public void setCodeMsg(CodeMsg codeMsg) {
        this.codeMsg = codeMsg;
    }
}
