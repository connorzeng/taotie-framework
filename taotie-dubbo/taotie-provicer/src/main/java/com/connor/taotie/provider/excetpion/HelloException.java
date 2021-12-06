package com.connor.taotie.provider.excetpion;

public class HelloException extends RuntimeException {

    private String responseCode;
    private String responseMsg;


    public HelloException() {
    }

    public HelloException(String responseCode, String responseMsg) {
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
    }

    public HelloException(String message, String responseCode, String responseMsg) {
        super(message);
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
    }

    public HelloException(String message, Throwable cause, String responseCode, String responseMsg) {
        super(message, cause);
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
    }

    public HelloException(Throwable cause, String responseCode, String responseMsg) {
        super(cause);
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
    }

    public HelloException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String responseCode, String responseMsg) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
    }
}
