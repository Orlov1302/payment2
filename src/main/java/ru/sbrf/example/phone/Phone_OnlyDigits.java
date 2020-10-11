package ru.sbrf.example.phone;

public class Phone_OnlyDigits extends Phone {
    public Phone_OnlyDigits(String numberPhone) {
        super(numberPhone);
    }

    @Override
    public String getMaskNumberPhone() {
        return "9999999999";
    }
}

//