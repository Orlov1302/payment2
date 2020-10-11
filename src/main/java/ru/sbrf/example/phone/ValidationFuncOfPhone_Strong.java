package ru.sbrf.example.phone;

public class ValidationFuncOfPhone_Strong {
    public static String func(Phone t) {
        if ( t == null || t.numberPhone == null || t.numberPhone.isEmpty() ) {
            return "Номер телефона пуст.";
        } else {
            String maskNumberPhone = t.getMaskNumberPhone();
            if (maskNumberPhone == null) {
                return "Маска номера телефона не задана.";
            } else if ( !maskNumberPhone.isEmpty()) {
                boolean errorFormat = false;
                if (t.numberPhone.length() != maskNumberPhone.length()) {
                    errorFormat = true;
                } else {
                    for (int x = 0; x < maskNumberPhone.length(); ++x) {
                        char cF = maskNumberPhone.charAt(x);
                        char cN = t.numberPhone.charAt(x);
                        if (cF == '9') {  // Единственное отличие от стандартной функции
                            if (!('0' <= cN && cN <= '9')) {
                                errorFormat = true;
                                break;
                            }
                        } else if (cN != cF) {
                            errorFormat = true;
                            break;
                        }
                    }
                }
                if (errorFormat) {
                    return "Телефонный номер должен быть формата " + maskNumberPhone;
                }
            }
        }
        return "";
    }
}

////