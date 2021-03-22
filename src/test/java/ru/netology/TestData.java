package ru.netology;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

@Data
@Value
public class TestData {
    public String enterName() {
        Faker faker = new Faker(new Locale("ru"));
        String name = faker.name().fullName();
        return name;
    }

    public String enterPhone() {
        Faker faker = new Faker(new Locale("ru"));
        String phone = faker.numerify("+7##########");
        return phone;

    }

    public String getCity() {
        String[] city = {"Москва", "Кемерово", "Смоленск", "Тамбов", "Казань", "Махачкала", "Курган"};
        int rnd = new Random().nextInt(city.length);
        return city[rnd];
    }

    public static String getDatePlusThree() {
        LocalDate date = LocalDate.now();
        LocalDate dateDelivery = date.plusDays(3);
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String dataText = dateDelivery.format(formatters);
        return dataText;
    }

    public static String getDatePlusSix() {
        LocalDate date = LocalDate.now();
        LocalDate dateDelivery = date.plusDays(6);
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String dataText = dateDelivery.format(formatters);
        return dataText;
    }
}
