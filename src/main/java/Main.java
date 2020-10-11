import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbrf.example.payment.Currency;
import ru.sbrf.example.payment.PaymentParameters;
import ru.sbrf.example.phone.Phone;
import ru.sbrf.example.phone.ValidationFuncOfPhone_Strong;
import ru.sbrf.example.phone.Phone_OnlyDigits;
import ru.sbrf.example.phone.Phone_PlusAndDigits;
import ru.sbrf.example.server.Server;
import ru.sbrf.example.putting_taking.QueuePutting;
import ru.sbrf.example.putting_taking.QueueTaking;
import ru.sbrf.example.user.User;

import java.util.Date;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ApplicationContext context = new AnnotationConfigApplicationContext(
                "ru.sbrf.example.user", "ru.sbrf.example.putting_taking");
        User user1 = context.getBean(User.class);
        QueuePutting queuePutting1 = context.getBean(QueuePutting.class);
        QueueTaking queueTaking1 = context.getBean(QueueTaking.class);

        user1.setNumberUser(123); //Установка переменной, которая потом не используется
        user1.setStringFIO("Иванов иван Иванович"); //Установка переменной, которая потом не используется
        user1.setNumberAccount("1234500001"); //Установка переменной, которая потом не используется

        user1.setPhone(new Phone_OnlyDigits("9O57770377"));
        System.out.println( user1.validationPhone() );

        user1.setPhone(new Phone_PlusAndDigits("+89057770377"));
        System.out.println( user1.validationPhone() );
        System.out.println( user1.validationPhone(ValidationFuncOfPhone_Strong::func) );

        user1.setPhone(new Phone_PlusAndDigits("+79057770555"));
        System.out.println( user1.validationPhone(ValidationFuncOfPhone_Strong::func) );
        System.out.println( user1.validationPhone((Phone t)->"Все номера телефонов плохие"));

        Server server1 = new Server(queueTaking1); //Запуск потока принимающего платежи

        Date date = new Date();
        PaymentParameters paymentParameters1 = user1.getParametersPayment(date, 400, Currency.RUB );
        queuePutting1.putPayment(paymentParameters1);
        queuePutting1.putPayment(paymentParameters1);

        System.out.println("========================================= ");
        sleep(3000);
        server1.stopServer();
    }
}

//