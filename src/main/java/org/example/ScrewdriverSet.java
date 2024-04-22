package org.example;
import java.util.List;
// Класс Наборов отвёрток
public class ScrewdriverSet {
    private int setId;
    private List<Screwdriver> screwdrivers;
    // Конструктор
    public ScrewdriverSet(int setId, List<Screwdriver> screwdrivers) {
        this.setId = setId;
        this.screwdrivers = screwdrivers;
    }
    // Функция для получения id
    public int getId() {
        return setId;
    }
    // Вывод информации о наборе отвёрток
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Набор отвёрток #").append(setId).append(": [");
        for (int i = 0; i < screwdrivers.size(); i++) {
            sb.append(screwdrivers.get(i));
            if (i < screwdrivers.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
