package com.connor.taotie.baseservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RepsponseDTO extends ResponseBase implements Serializable {

    private String responseMsg;
    private String responseCode;

    private String baseName;

    private Object date;

    public RepsponseDTO(String responseMsg, String responseCode, Object date) {
        this.responseMsg = responseMsg;
        this.responseCode = responseCode;
        this.date = date;
    }

    public RepsponseDTO(String responseMsg, String responseCode) {
        this.responseMsg = responseMsg;
        this.responseCode = responseCode;
    }

    public RepsponseDTO() {
    }
}

