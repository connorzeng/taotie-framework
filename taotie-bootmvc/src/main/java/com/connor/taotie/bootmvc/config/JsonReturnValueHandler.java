package com.connor.taotie.bootmvc.config;

import com.alibaba.fastjson.JSON;
import com.connor.taotie.bootmvc.dto.ResponseDTO;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

public class JsonReturnValueHandler implements HandlerMethodReturnValueHandler {


    /**
     * 支持所有类型
     * @param returnType
     * @return
     */
    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return true;
    }


    /**
     *
     * @param returnValue
     * @param returnType
     * @param mavContainer
     * @param webRequest
     * @throws Exception
     */
    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {

        if (returnValue instanceof ResponseDTO){
            String jsonStr = JSON.toJSONString(returnValue);
            writeStr(webRequest.getNativeResponse(), jsonStr);
        }


    }

    private void writeStr(Object nativeResponse, String jsonStr) {



    }
}
