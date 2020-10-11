package ru.sbrf.example.phone;

public class Phone_PlusAndDigits extends Phone {
    public Phone_PlusAndDigits(String numberPhone) {
        super(numberPhone);
    }

    @Override
    public String getMaskNumberPhone() {
        return "+79999999999";
    }
}

////