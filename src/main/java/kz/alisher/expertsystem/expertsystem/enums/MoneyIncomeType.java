package kz.alisher.expertsystem.expertsystem.enums;

import java.util.List;

public enum MoneyIncomeType {

    LOW("Низкий"),
    MIDDLE("Средний"),
    HIGH("Высокий");

    private String name;

    MoneyIncomeType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static List<MoneyIncomeType> getAll() {
        return List.of(LOW, MIDDLE, HIGH);
    }

}
