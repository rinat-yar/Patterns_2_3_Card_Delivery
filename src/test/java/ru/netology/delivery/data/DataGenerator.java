package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

import static org.apache.commons.lang3.RandomUtils.nextInt;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
     }

    public static String generateCity() {
        var cities = new String[]{"Абакан", "Барнаул","Белгород", "Благовещенск", "Брянск", "Великий Новгород",
                "Владивосток", "Владикавказ","Владимир", "Волгоград", "Грозный", "Екатеринбург", "Иваново", "Ижевск",
                "Йошкар-Ола", "Казань", "Калининград", "Киров", "Краснодар", "Курск",
                "Липецк", "Москва", "Оренбург", "Пенза", "Псков", "Самара", "Санкт-Петербург",
                "Севастополь", "Тамбов", "Тула", "Улан-Удэ", "Чита",};
        return cities[new Random().nextInt(cities.length)];
        }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + ' ' + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}