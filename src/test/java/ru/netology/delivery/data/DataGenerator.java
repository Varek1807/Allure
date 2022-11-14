package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    private static Faker faker = new Faker(new Locale("ru"));

    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) {
        var city = new String[]{"Москва", "Красногорск", "Тверь", "Смоленск", "Калуга", "Брянск", "Тула", "Орёл", "Рязань",
                "Владимир", "Иваново", "Кострома", "Ярославль", "Курск", "Белгород", "Липецк", "Воронеж", "Тамбов",
                "Санкт-Петербург", "Великий Новгород", "Псков", "Вологда", "Петрозаводск", "Мурманск", "Архангельск",
                "Нарьян-Мар", "Сыктывкар", "Калининград", "Нижний Новгород", "Киров", "Йошкар-Ола", "Чебоксары", "Саранск",
                "Казань", "Ульяновск", "Пенза", "Саратов", "Самара", "Пермь", "Ижевск", "Казань", "Уфа", "Оренбург", "Волгоград",
                "Астрахань", "Элиста", "Ростов-на-Дону", "Краснодар", "Майкоп", "Симферополь", "Севастополь", "Черкесск",
                "Нальчик", "Владикавказ", "Магас", "Грозный", "Махачкала", "Екатеринбург", "Челябинск", "Курган", "Тюмень",
                "Ханты-Мансийск", "Салехард", "Омск", "Томск", "Новосибирск", "Кемерово", "Барнаул", "Горно-Алтайск", "Красноярск",
                "Абакан", "Кызыл", "Иркутск", "Улан-Удэ", "Чита", "Якутск", "Магадан", "Анадырь", "Петропавловск-Камчатский",
                "Благовещенск", "Биробиджан", "Хабаровск", "Владивосток", "Южно-Сахалинск"};
        //faker.address().city();
        return city[new Random().nextInt(city.length)];
    }

    public static String generateName(String locale) {
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        @Contract("_ -> new")
        public static @NotNull UserInfo generateUser(String locale) {
            return new UserInfo(
                    generateCity("ru"),
                    generateName("ru"),
                    generatePhone("ru")

            );
            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
            // generateName(locale), generatePhone(locale)
            // return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
