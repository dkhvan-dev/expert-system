package kz.alisher.expertsystem.expertsystem.enums;

import java.util.List;

public enum CreditHistory {

    BAD("Плохая"),
    GOOD("Хорошая"),
    EXCELLENT("Отличная");

    private String name;

    CreditHistory(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static List<CreditHistory> getAll() {
        return List.of(BAD, GOOD, EXCELLENT);
    }

}
