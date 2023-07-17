/*Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий фильтрации
и выведет ноутбуки, отвечающие фильтру.
Критерии фильтрации можно хранить в Map.
Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …

Далее нужно запросить минимальные значения для указанных критериев -
сохранить параметры фильтрации можно также в Map.

Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям. */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Laptop> laptops = createLaptopSet();

        Map<String, Object> filter = runFilter();

        Set<Laptop> filteredLaptops = filterLaptops(laptops, filter);

        printResults(filteredLaptops);
    }

    // Метод для создания набора ноутбуков
    public static Set<Laptop> createLaptopSet() {
        Set<Laptop> laptops = new HashSet<>();
// Создаем несколько экземпляров класса "Ноутбук" и добавляем их в набор
        Laptop laptop1 = new Laptop("1", 8, 500, "Windows");
        Laptop laptop2 = new Laptop("2", 16, 1000, "MacOS");
        Laptop laptop3 = new Laptop("3", 12, 750, "Linux");

        laptops.add(laptop1);
        laptops.add(laptop2);
        laptops.add(laptop3);

        return laptops;
    }

    // Метод для запуска фильтрации
    public static Map<String, Object> runFilter() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите желаемую модель ноутбука: ");
        String model = scanner.nextLine();

        System.out.print("Введите минимальный обьем ОЗУ : ");
        int minRamSize = scanner.nextInt();

        System.out.print("Введите минимальный объем жесткого диска: ");
        int minStorageSize = scanner.nextInt();
        scanner.nextLine();// Считываем оставшийся перевод строки

        System.out.print("Введите желаемую операционную систему: ");
        String operatingSystem = scanner.nextLine();
        // Создаем и заполняем фильтр с введенными значениями
        Map<String, Object> filter = new HashMap<>();
        filter.put("model", model);
        filter.put("ramSize", minRamSize);
        filter.put("storageSize", minStorageSize);
        filter.put("operatingSystem", operatingSystem);

        return filter;
    }

    // Метод для фильтрации ноутбуков по заданному критерию
    public static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, Object> filter) {
        Set<Laptop> filteredLaptops = new HashSet<>();

        for (Laptop laptop : laptops) {
            if (matchesFilter(laptop, filter)) {
                filteredLaptops.add(laptop);
            }
        }

        return filteredLaptops;
    }

    // Метод для проверки соответствия ноутбука заданному фильтру
    public static boolean matchesFilter(Laptop laptop, Map<String, Object> filter) {
        if (!filter.get("model").equals(laptop.getModel())) {
            return false;
        }

        if (laptop.getRamSize() < (int) filter.get("ramSize")) {
            return false;
        }

        if (laptop.getStorageSize() < (int) filter.get("storageSize")) {
            return false;
        }
        if (!filter.get("operatingSystem").equals(laptop.getOperatingSystem())) {
            return false;
        }


        return true;
    }

    // Метод для вывода результатов фильтрации
    public static void printResults(Set<Laptop> filteredLaptops) {
        if (filteredLaptops.isEmpty()) {
            System.out.println("Нет ноутбуков удовлетворяющих критериям поиска");
        } else {
            System.out.println("Желаемая модель найденна:");
            for (Laptop laptop : filteredLaptops) {
                System.out.println("Model: " + laptop.getModel());
                System.out.println("RAM size: " + laptop.getRamSize());
                System.out.println("Storage size: " + laptop.getStorageSize());
                System.out.println("Operating system: " + laptop.getOperatingSystem());
                System.out.println();
            }
        }
    }
}