package icu.hao.haomall.exception;

public class Exception extends RuntimeException {
    private final Integer code;
    private final String message;

    public Exception(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Exception(ExceptionEnum ex) {
        this(ex.getCode(), ex.getMsg());
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
