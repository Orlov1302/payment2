package ru.sbrf.example.my_exception;

public class PhoneException extends Exception{
    private String strPhone;

    public PhoneException(String strPhone) {
        this.strPhone = strPhone;
    }

    public PhoneException(String message, String strPhone) {
        super(message);
        this.strPhone = strPhone;
    }

    public PhoneException(String message, Throwable cause, String strPhone) {
        super(message, cause);
        this.strPhone = strPhone;
    }

    public PhoneException(Throwable cause, String strPhone) {
        super(cause);
        this.strPhone = strPhone;
    }

    public PhoneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String strPhone) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.strPhone = strPhone;
    }

    public String getPhone(){
        return strPhone;
    }
}

//