package g214.tests.utils;

import com.github.javafaker.Faker;

public class RandomUtils {


    public static String randomHeaderName() {

        return new Faker().name().firstName();

    }

    public static String randomPhone() {
        return new Faker().phoneNumber().subscriberNumber(10);
    }

    public static String randomMail() {

        return new Faker().internet().emailAddress();
    }

    public static String randomPrice() {
        return new Faker().phoneNumber().subscriberNumber(3);
    }


}
