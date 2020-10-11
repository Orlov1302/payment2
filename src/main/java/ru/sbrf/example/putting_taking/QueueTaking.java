package ru.sbrf.example.putting_taking;

import org.springframework.stereotype.Component;
import ru.sbrf.example.payment.PaymentParameters;
import ru.sbrf.example.putting_taking.Taking;

import java.util.concurrent.BlockingQueue;

@Component
public class QueueTaking implements Taking {
    private Queue_PaymentParameters queue_PaymentParameters;

    public QueueTaking( Queue_PaymentParameters queue_PaymentParameters ){
        if( queue_PaymentParameters == null ) {
            System.out.println("queue_PaymentParameters не может быть равен null, так как объект будет создан SPRING автоматически.");
        }
        this.queue_PaymentParameters = queue_PaymentParameters;
    }

    @Override
    public PaymentParameters takePayment(){
        try {
            return queue_PaymentParameters.getQueue().take();
        } catch (InterruptedException ex) {
            //System.out.println(ex.getMessage());
            return null;
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            return null;
        }
    }

    @Override
    public void stopTaking(){
        try {
            queue_PaymentParameters.getQueue().put(new PaymentParameters());
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

//