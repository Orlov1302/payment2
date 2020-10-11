package ru.sbrf.example.phone;

import lombok.Setter;
import ru.sbrf.example.my_exception.PhoneException;

public class PhoneValidator<T extends Phone>{
    private T tPhone;
    // Внешняя функция для проверки валидности телефонного номера,
    // по умолчанию при создании класса заполняется стандартной функцией.
    // В случае валидности фукция возвращает пустую строку, иначе строку с текстом ошибки.
    @Setter private ValidationFuncOfPhone validationFuncOfPhone;

    public PhoneValidator(T t) {
        validationFuncOfPhone = ValidationFuncOfPhone_Standart::func;
        tPhone = t;
    }

    // Проверка валидности телефонного номера
    public void validationPhone() throws PhoneException {
        if( validationFuncOfPhone != null && tPhone != null ){
            String error = validationFuncOfPhone.func(tPhone); //Вызов внешней функции
            if( error == null ){ //Функция не должна возращать null
                error = "Исключение NULL при проверке телефона.";
            }
            if( !error.equals("") ){
                throw new PhoneException(error, tPhone.numberPhone);
            }
        }
    }
}

////