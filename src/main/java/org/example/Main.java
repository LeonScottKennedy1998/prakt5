package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScrewdriverManager screwdriverManager = new ScrewdriverManager();

        // Вывод меню действий
        while (true) {
            printMenu();
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                processUserChoice(choice, scanner, screwdriverManager);
            }
            else {
                System.out.println("Некорректный ввод. Пожалуйста, введите число от 1 до 11.");
                scanner.nextLine();
            }
        }
    }

    // Функция для меню действий
    public static void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Создать новую отвертку");
        System.out.println("2. Найти отвертку по идентификатору");
        System.out.println("3. Обновить параметры отвертки");
        System.out.println("4. Удалить отвертку по идентификатору");
        System.out.println("5. Вывести список всех отверток");
        System.out.println("6. Подсчитать количество отверток определенного размера");
        System.out.println("7. Очистить список отверток");
        System.out.println("8. Посмотреть статистику по отвёрткам");
        System.out.println("9. Создать набор отвёрток");
        System.out.println("10. Показать доступные наборы отвёрток");
        System.out.println("11. Выход");
    }

    // Функция выбора действий
    public static void processUserChoice(int choice, Scanner scanner, ScrewdriverManager screwdriverManager) {
        switch (choice) {
            case 1:
                System.out.println("Введите тип рукоятки:");
                String handleType = scanner.nextLine();
                System.out.println("Введите тип наконечника:");
                String tipType = scanner.nextLine();
                System.out.println("Введите размер:");
                if (scanner.hasNextInt()) {
                    int size = scanner.nextInt();
                    scanner.nextLine();
                    screwdriverManager.createScrewdriver(handleType, tipType, size);
                }
                else {
                    System.out.println("Некорректный ввод размера. Размер должен быть целым числом.");
                    scanner.nextLine();
                }
                break;
            case 2:
                System.out.println("Введите идентификатор отвертки:");
                if (scanner.hasNextInt()) {
                    int idToFind = scanner.nextInt();
                    scanner.nextLine();
                    screwdriverManager.findScrewdriverByID(idToFind);
                }
                else {
                    System.out.println("Некорректный ввод ID. ID должен быть целым числом.");
                    scanner.nextLine();
                }
                break;
            case 3:
                System.out.println("Введите идентификатор отвертки для обновления:");
                if (scanner.hasNextInt()) {
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Введите новый тип рукоятки:");
                    String newHandleType = scanner.nextLine();
                    System.out.println("Введите новый тип наконечника:");
                    String newTipType = scanner.nextLine();
                    System.out.println("Введите новый размер:");
                    if (scanner.hasNextInt()) {
                        int newSize = scanner.nextInt();
                        scanner.nextLine();
                        screwdriverManager.updateScrewdriver(idToUpdate, newHandleType, newTipType, newSize);
                    }
                    else{
                        System.out.println("Некорректный ввод размера. Размер должен быть целым числом.");
                        scanner.nextLine();
                    }
                }
                else {
                    System.out.println("Некорректный ввод ID. ID должен быть целым числом.");
                    scanner.nextLine();
                }
                break;
            case 4:
                System.out.println("Введите идентификатор отвертки для удаления:");
                if (scanner.hasNextInt()) {
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine();
                    screwdriverManager.deleteScrewdriverById(idToDelete);
                }
                else{
                    System.out.println("Некорректный ввод ID. ID должен быть целым числом.");
                    scanner.nextLine();
                }
                break;
            case 5:
                screwdriverManager.displayAllScrewdrivers();
                break;
            case 6:
                System.out.println("Введите размер отвертки для подсчета:");
                if (scanner.hasNextInt()) {
                    int sizeToCount = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера
                    screwdriverManager.countScrewdriversBySize(sizeToCount);
                }
                else{
                    System.out.println("Некорректный ввод размера. Размеры должен быть целым числом.");
                    scanner.nextLine();
                }
                break;
            case 7:
                screwdriverManager.clearAllScrewdrivers();
                break;
            case 8:
                screwdriverManager.displayScrewdriversStatistics();
                break;
            case 9:
                screwdriverManager.createSetOfScrewdrivers(scanner);
                break;
            case 10:
                screwdriverManager.displayAvailableSets();
                break;
            case 11:
                System.out.println("Программа завершена.");
                System.exit(0);
                break;
            default:
                System.out.println("Некорректный выбор. Пожалуйста, введите число от 1 до 10.");
        }
    }
}
