import java.util.ArrayList;
import java.util.Scanner;

public class CitiesGame {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Харків");
        cities.add("Амстердам");
        cities.add("Варшава");
        cities.add("Лондон");
        cities.add("Київ");

        ArrayList<String> usedCities = new ArrayList<>();
        char lastLetter = ' ';

        System.out.println("Давай пограємо у «Міста». Ти перший називай!");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String userCity = scanner.nextLine();

            if (userCity.isEmpty()) {
                System.out.println("Ти не ввів жодного міста. Спробуй ще раз!");
                continue;
            }

            if (usedCities.contains(userCity)) {
                System.out.println("Це місто вже було назване. Спробуй ще раз!");
                continue;
            }

            if (usedCities.size() == cities.size()) {
                System.out.println("Я програв, ти знаєш більше за міста!");
                break;
            }

            if (usedCities.size() > 0 && userCity.charAt(0) != lastLetter) {
                System.out.println("Твоє місто повинно починатися на літеру '" + lastLetter + "'. Спробуй ще раз!");
                continue;
            }

            usedCities.add(userCity);
            lastLetter = userCity.charAt(userCity.length() - 1);

            String computerCity = findCityStartingWith(cities, lastLetter, usedCities);
            if (computerCity == null) {
                System.out.println("Я програв, ти знаєш більше за міста!");
                break;
            } else {
                System.out.println("Місто комп'ютера: " + computerCity);
                usedCities.add(computerCity);
                lastLetter = computerCity.charAt(computerCity.length() - 1);
            }
        }
    }

    private static String findCityStartingWith(ArrayList<String> cities, char letter, ArrayList<String> usedCities) {
        for (String city : cities) {
            if (city.charAt(0) == letter && !usedCities.contains(city)) {
                return city;
            }
        }
        return null;
    }
}
