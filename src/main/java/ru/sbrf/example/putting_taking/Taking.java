package ru.sbrf.example.putting_taking;

import ru.sbrf.example.payment.PaymentParameters;

public interface Taking {
    PaymentParameters takePayment();
    void stopTaking();
}

//