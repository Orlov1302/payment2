package ru.sbrf.example.payment;

public enum Currency {
    RUB(643),
    RUR(810),  // old code 1998
    EUR(978),
    USD(840);

    private int code;

    Currency(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}

////