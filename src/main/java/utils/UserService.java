package utils;

import com.github.javafaker.Faker;
import utils.dto.User;

public final class UserService {
    public static final String EMAIL_DOMAIN = "relxv.com";
    public static final String PASSWORD = "p!as$w0Rd";

    public static User generateNewRandomUser() {
        return User.builder()
                .name(generateUserName())
                .email(generateUserEmail())
                .password(generateUserPassword())
                .build();
    }

    private static String generateUserName() {
        Faker faker = new Faker();
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    private static String generateUserEmail() {
        return System.currentTimeMillis() + "@" + EMAIL_DOMAIN;
    }

    private static String generateUserPassword() {
        return PASSWORD;
    }
}
