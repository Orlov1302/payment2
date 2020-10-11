package ru.sbrf.example.putting_taking;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.sbrf.example.payment.PaymentParameters;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class Queue_PaymentParameters {
    @Getter
    private LinkedBlockingQueue<PaymentParameters> queue;

    public Queue_PaymentParameters() {
        queue = new LinkedBlockingQueue<>();
    }
}

////