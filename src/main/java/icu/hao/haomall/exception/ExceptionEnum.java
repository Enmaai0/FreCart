package icu.hao.haomall.exception;

public enum ExceptionEnum {
    NEED_USER_NAME(10001, "User name should not be empty"),
    NEED_PASSWORD(10002, "Password cannot be empty"),
    PASSWORD_TOO_SHORT(10003, "Password length cannot less than 8"),
    NAME_EXISTED(10004, "Name existed"),
    INSERT_FAILED(10005, "Insert failed, try again"),
    INCORRECT_PASSWORD(10006, "Password is not correct"),
    NEED_LOGIN(10007, "Haven't sign in"),
    UPDATE_FAILED(10008,"Update failed"),
    NEED_ADMIN(10009, "Need admin"),
    PARA_NOT_NULL(10010, "Params cannot be null"),
    RRQUEST_PARAM_ERROR(10011, "Faulty param"),
    DELETE_FAILED(10012, "Delete failed"),
    SYSTEM_ERROR(20000, "System error");

    Integer code;
    String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
