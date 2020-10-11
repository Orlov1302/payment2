package ru.sbrf.example.server;

import ru.sbrf.example.payment.PaymentParameters;
import ru.sbrf.example.putting_taking.Taking;

import java.util.HashSet;

public class Server implements Runnable {
    private Thread thread;
    private Taking taking;
    private HashSet<PaymentParameters> oldPayments; // Здесь храняться старые запросы

    public Server(Taking taking) {
        this.taking = taking;
        oldPayments = new HashSet<>();
        thread = new Thread(this);
        thread.start();
    }

    public void stopThread(){
        thread.interrupt();
    }

    public void stopServer(){
        taking.stopTaking();
    }

    public void run() {
	    while(true) {
            try {
                PaymentParameters paymentParameters;
                paymentParameters = taking.takePayment();
                if( paymentParameters == null ){
                    System.out.println("Поток остановлен жестко");
                    break;
                }else if( paymentParameters.getDate() == null ||
                        paymentParameters.getNumberAccount() == null ||
                        paymentParameters.getNumberPhone() == null ) {
                    System.out.println("Поток остановлен мягко");
                    break;
                }else{
                    System.out.print("Платеж со счета " + paymentParameters.getNumberAccount() +
                        " на телефон " + paymentParameters.getNumberPhone());
                    if (oldPayments.contains(paymentParameters)) {
                        System.out.println(" не выполнен. Запрос поступил повторно!!!");
                    } else {
                        System.out.println(" выполнен.");
                        oldPayments.add(paymentParameters);
                    }
                }
            }
            catch (Exception exc) {
                System.out.println(exc.getMessage());
                break;
            }
        }
    }
}

////