package kz.alisher.expertsystem.expertsystem.service;

import kz.alisher.expertsystem.expertsystem.dto.moneyincomes.MoneyIncomeCreate;
import kz.alisher.expertsystem.expertsystem.dto.moneyincomes.MoneyIncomeView;
import kz.alisher.expertsystem.expertsystem.entity.MoneyIncomeEntity;
import kz.alisher.expertsystem.expertsystem.enums.MoneyIncomeType;

import java.math.BigDecimal;
import java.util.List;

public interface MoneyIncomeService {

    void create(MoneyIncomeCreate input);

    List<MoneyIncomeView> findAll();

    MoneyIncomeEntity getEntityById(Long id);

    void delete(Long id);

}
