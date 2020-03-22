package com.xproject.product.Utils;

import com.xproject.product.VO.ResultVO;

public class ResultVOUtils {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        return resultVO;
    }
}
