package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    private static final Faker faker = new Faker(new Locale("en"));

    public static String getRandomNonExistentEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomWrongPassword() {
        return faker.internet().password(8, 16) + "!@#";
    }
}