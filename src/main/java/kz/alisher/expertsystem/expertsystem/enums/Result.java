package kz.alisher.expertsystem.expertsystem.enums;

import java.util.List;

public enum Result {

    REJECT("Отказ"),
    APPROVE("Одобрено");

    private String name;

    Result(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static List<Result> getAll() {
        return List.of(Result.REJECT, Result.APPROVE);
    }

}
