package ru.sbrf.example.user;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import ru.sbrf.example.phone.Phone_OnlyDigits;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

class PhoneTest {
    public User user1;

    @Before
    public void before() {
        user1 = new User();
        user1.setNumberAccount("1234500001");
    }

    @Test
    public void test_1() {
        before(); // Если убрать, то тест не будет пройден.
        user1.setPhone(new Phone_OnlyDigits("9O57770377"));
        assertNotEquals(user1.validationPhone().substring(0,10), "Исключение");
    }

    @Test
    public void test_2() {
        before(); // Если убрать, то тест не будет пройден.
        user1.setPhone(new Phone_OnlyDigits("9057770377"));
        assertEquals(user1.validationPhone().substring(0,7), "Телефон");
    }
}

////