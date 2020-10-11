package ru.sbrf.example.user;

import lombok.Getter;
import lombok.Setter;
import ru.sbrf.example.my_exception.PhoneException;
import org.springframework.stereotype.Component;
import ru.sbrf.example.payment.*;
import ru.sbrf.example.phone.ValidationFuncOfPhone;
import ru.sbrf.example.phone.Phone;
import ru.sbrf.example.phone.PhoneValidator;

import java.util.Date;

@Setter
@Getter
@Component
public class User {
    public long numberUser;
    public String stringFIO;
    String numberAccount;
    Phone phone;

    public User(){
        this.numberUser = 0;
        this.stringFIO = "нет";
    }

    public String validationPhone(){
        return validationPhone(null);
    }

    // Из данной функции вызывается одноименная функция, что усложняет код,
    // но сделано так:
    // - для демонстрации работы исключений;
    // - для демонстрации передачи в виде аргумента лямбда функции;
    // - для написания тестирующего кода в классе Main.
    public String validationPhone(ValidationFuncOfPhone validationFunc){
        PhoneValidator<Phone> phoneValidator;
        try{
            phoneValidator = new PhoneValidator<>(phone);
            if( validationFunc != null ){
                phoneValidator.setValidationFuncOfPhone(validationFunc); //Замена стандартной функции тестировани
            }
            phoneValidator.validationPhone(); // Проверка валидности номера телефона
        }
        catch(PhoneException p_ex){
            return "Иcключeниe: " + p_ex.getMessage() + "\n" + "Номер телефона: " + p_ex.getPhone() + "\n";
        }
        catch(Exception ex){
            return "Иcключeниe: " + ex.getMessage() + "\n";
        }
        return "Телефон "+ phone.getNumberPhone() + " соответсвует формату " + phone.getMaskNumberPhone() + "\n";
    }


    public PaymentParameters getParametersPayment(Date date, long summa, Currency currency ){
        if( numberAccount == null || phone == null || date == null ){
            return new PaymentParameters(new Date(),"", "", 0, currency);
        }else{
            return new PaymentParameters(date, numberAccount, phone.getNumberPhone(), summa, currency);
        }
    }

}

////
