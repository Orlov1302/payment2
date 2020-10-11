package ru.sbrf.example.putting_taking;

import org.springframework.stereotype.Component;
import ru.sbrf.example.payment.PaymentParameters;

@Component
public class QueuePutting implements Putting {
    private Queue_PaymentParameters queue_PaymentParameters;

    public QueuePutting( Queue_PaymentParameters queue_PaymentParameters ){
        if( queue_PaymentParameters == null ) {
            System.out.println("queue_PaymentParameters не может быть равен null, так как объект будет создан SPRING автоматически.");
        }
        this.queue_PaymentParameters = queue_PaymentParameters;
    }

    @Override
    public void putPayment(PaymentParameters paymentParameters){
        try {
            queue_PaymentParameters.getQueue().put(paymentParameters);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

//
