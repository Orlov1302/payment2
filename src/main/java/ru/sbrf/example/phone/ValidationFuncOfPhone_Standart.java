package ru.sbrf.example.phone;

public class ValidationFuncOfPhone_Standart {
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
                       if ('0' <= cF && cF <= '9') {
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