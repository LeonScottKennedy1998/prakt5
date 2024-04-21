package org.example;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
// Класс Действий с отвёртками
public class ScrewdriverManager {

    private static int setIdCounter = 1; // Счетчик для генерации уникальных ID наборов
    private static int IDCounter = 0; // Счетчик для генерации уникальных ID отвёрток

    // Листы для отвёрток и наборов отвёрток
    private List<Screwdriver> screwdrivers;
    private List<ScrewdriverSet> screwdriverSets;

    // Конструктор
    public ScrewdriverManager() {
        this.screwdrivers = new ArrayList<>();
        this.screwdriverSets = new ArrayList<>();
    }

    // Функция создания отвёртки
    public void createScrewdriver(String handleType, String tipType, int size) {
        int id = generateID();
        Screwdriver screwdriver = new Screwdriver(id, handleType, tipType, size);
        screwdrivers.add(screwdriver);
        System.out.println("Отвертка создана: " + screwdriver);
    }

    // Функция поиска отвёртки по id
    public void findScrewdriverByID(int id) {
        for (Screwdriver screwdriver : screwdrivers) {
            if (screwdriver.getId() == id) {
                System.out.println("Найдена отвертка:");
                System.out.println(screwdriver);
                return;
            }
        }
        System.out.println("Отвертка с указанным идентификатором не найдена.");
    }

    // Функция обновления данных об отвёртке
    public void updateScrewdriver(int id, String handleType, String tipType, int size) {
        for (Screwdriver screwdriver : screwdrivers) {
            if (screwdriver.getId() == id) {
                screwdriver.setHandleType(handleType);
                screwdriver.setTipType(tipType);
                screwdriver.setSize(size);
                System.out.println("Параметры отвертки с идентификатором " + id + " обновлены.");
                return;
            }
        }
        System.out.println("Отвертка с указанным идентификатором не найдена.");
    }

    // Функция для удаления отвёртки
    public void deleteScrewdriverById(int id) {
        for (Screwdriver screwdriver : screwdrivers) {
            if (screwdriver.getId() == id) {
                screwdrivers.remove(screwdriver);
                System.out.println("Отвертка с идентификатором " + id + " удалена.");
                return;
            }
        }
        System.out.println("Отвертка с указанным идентификатором не найдена.");
    }

    // Функция отображения всех отвёрток
    public void displayAllScrewdrivers() {
        if (screwdrivers.isEmpty()) {
            System.out.println("Список отверток пуст.");
        } else {
            System.out.println("Список всех отверток:");
            for (Screwdriver screwdriver : screwdrivers) {
                System.out.println(screwdriver);
            }
        }
    }

    // Функция подсчёта отвёрток конкретного размера
    public void countScrewdriversBySize(int size) {
        int count = 0;
        for (Screwdriver screwdriver : screwdrivers) {
            if (screwdriver.getSize() == size) {
                count++;
            }
        }
        System.out.println("Количество отверток размера " + size + ": " + count);
    }

    // Функция очистки списка отвёрток
    public void clearAllScrewdrivers() {
        screwdrivers.clear();
        System.out.println("Список отверток очищен.");
    }

    // Функция отображения статистики по отвёрткам
    public void displayScrewdriversStatistics() {
        if (screwdrivers.isEmpty()) {
            System.out.println("Список отверток пуст.");
        } else {
            int totalSize = 0;
            int minSize = Integer.MAX_VALUE;
            int maxSize = Integer.MIN_VALUE;

            for (Screwdriver screwdriver : screwdrivers) {
                totalSize += screwdriver.getSize();
                if (screwdriver.getSize() < minSize) {
                    minSize = screwdriver.getSize();
                }
                if (screwdriver.getSize() > maxSize) {
                    maxSize = screwdriver.getSize();
                }
            }

            double averageSize = (double) totalSize / screwdrivers.size();

            System.out.println("Статистика по отверткам:");
            System.out.println("Общее количество отверток: " + screwdrivers.size());
            System.out.println("Минимальный размер отвертки: " + minSize);
            System.out.println("Максимальный размер отвертки: " + maxSize);
            System.out.println("Средний размер отверток: " + String.format("%.2f", averageSize));
        }
    }


    // Функция создания набора отвёрток
    public void createSetOfScrewdrivers(Scanner scanner) {
        if (screwdrivers.isEmpty()) {
            System.out.println("Список отвёрток пуст. Нельзя создать набор.");
            return;
        }
        displayAllScrewdrivers();

        System.out.println("Введите количество отвёрток для добавления в набор:");
        int count = scanner.nextInt();
        scanner.nextLine();

        List<Screwdriver> newSet = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            System.out.println("Введите ID отвёртки для добавления в набор:");
            int screwdriverId = scanner.nextInt();
            scanner.nextLine();

            Screwdriver screwdriver = findScrewdriverByIdSet(screwdriverId);
            if (screwdriver != null) {
                newSet.add(screwdriver);
            } else {
                System.out.println("Отвёртка с ID " + screwdriverId + " не найдена.");
            }
        }
        ScrewdriverSet screwdriverSet = new ScrewdriverSet(setIdCounter++, newSet);
        screwdriverSets.add(screwdriverSet);

        System.out.println("Создан набор отвёрток #" + (screwdriverSet.getId()));
        System.out.println("Состав набора:");
        for (Screwdriver screwdriver : newSet) {
            System.out.println(screwdriver);
        }
    }

    // Функция для поиска отвёрток для набора
    private Screwdriver findScrewdriverByIdSet(int id) {
        for (Screwdriver screwdriver : screwdrivers) {
            if (screwdriver.getId() == id) {
                return screwdriver;
            }
        }
        return null;
    }

    // Функция для вывода информации о наборах
    public void displayAvailableSets() {
        if (screwdriverSets.isEmpty()) {
            System.out.println("Нет доступных наборов отвёрток.");
        } else {
            System.out.println("Доступные наборы отвёрток:");
            for (ScrewdriverSet set : screwdriverSets) {
                System.out.println(set);
            }
        }
    }

    // Функция увеличения ID отвёртки
    private static int generateID() {
        return ++IDCounter;
    }
}
