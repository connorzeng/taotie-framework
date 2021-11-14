package com.connor.taotie.bootmvc.dto;

public class ResponseDTO {

    public ResponseDTO(String responseMessage, String responseCode, Object data) {
        this.responseMessage = responseMessage;
        this.responseCode = responseCode;
        this.data = data;
    }

    private String responseMessage = "success";
    private String responseCode = "000000";

    private Object data;


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}
