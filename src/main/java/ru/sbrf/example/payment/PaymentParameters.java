package ru.sbrf.example.payment;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class PaymentParameters {
    private Date date;
    private String numberAccount;
    private String numberPhone;
    private long summa;
    private Currency currency;

    public PaymentParameters(){
        this(null,null,null,0, Currency.RUB);
    }
}

////
