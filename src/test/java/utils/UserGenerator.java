package utils;

import com.github.javafaker.Faker;
import dto.CountryCode;
import dto.User;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class UserGenerator {

    private static final Faker faker = new Faker();
    private static final DateTimeFormatter DOB_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE; // yyyy-MM-dd

    private static CountryCode randomCountry() {
        CountryCode[] values = CountryCode.values();
        return values[new Random().nextInt(values.length)];
    }

    public static User generateUser() {

        LocalDate dob = faker.date()
                .birthday(18, 70)
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        return User.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .dateOfBirth(dob)
                .street(faker.address().streetAddress())
                .postalCode(faker.address().zipCode())
                .city(faker.address().city())
                .state(faker.address().state())
                .country(randomCountry())
                .phone(generateValidPhone())
                .email(faker.internet().emailAddress())
                .password(generateValidPassword())
                .build();
    }

    public static String formatDob(LocalDate dob) {
        return dob.format(DOB_FORMAT); // yyyy-MM-dd
    }

    private static String generateValidPhone() {
        return "972" + faker.number().digits(9);
    }

    private static String generateValidPassword() {
        return "A" + faker.lorem().characters(8, 16).toLowerCase()
                + faker.number().digit()
                + "!";
    }
}

