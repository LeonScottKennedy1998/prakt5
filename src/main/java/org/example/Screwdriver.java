package org.example;
// Класс Отвёртка
public class Screwdriver {
    private int id;
    private String handleType;
    private String tipType;
    private int size;

    // Конструктор
    public Screwdriver(int id, String handleType, String tipType, int size) {
        this.id = id;
        this.handleType = handleType;
        this.tipType = tipType;
        this.size = size;
    }

    // Функция для получения id
    public int getId() {
        return id;
    }

    // Функция для установления типа рукоятки
    public void setHandleType(String handleType) {
        this.handleType = handleType;
    }

    // Функция для установления типа наконечника
    public void setTipType(String tipType) {
        this.tipType = tipType;
    }

    // Функция для получения размера отвёртки
    public int getSize() {
        return size;
    }

    // Функция для установления размера отвёртки
    public void setSize(int size) {
        this.size = size;
    }


    // Переопределение функции
    @Override
    public String toString() {
        return "Отвертка [Идентификатор: " + id + ", Тип рукоятки: " + handleType +
                ", Тип наконечника: " + tipType + ", Размер: " + size + "]";
    }
}
