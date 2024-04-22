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

    // Геттер ID
    public int getId() {
        return id;
    }

    // Сеттер ID
    public void setId(int id) {
        this.id = id;
    }

    // Сеттер HandleType
    public void setHandleType(String handleType) {
        this.handleType = handleType;
    }

    // Геттер HandleType
    public String getHandleType() {
        return handleType;
    }

    // Сеттер TipType
    public void setTipType(String tipType) {
        this.tipType = tipType;
    }

    // Геттер TipType
    public String getTipType() {
        return tipType;
    }

    // Геттер Size
    public int getSize() {
        return size;
    }

    // Сеттер Size
    public void setSize(int size) {
        this.size = size;
    }

    // Вывод информации о отвёртке
    public String toString() {
        return "Отвертка [Идентификатор: " + id + ", Тип рукоятки: " + handleType +
                ", Тип наконечника: " + tipType + ", Размер: " + size + "]";
    }
}
