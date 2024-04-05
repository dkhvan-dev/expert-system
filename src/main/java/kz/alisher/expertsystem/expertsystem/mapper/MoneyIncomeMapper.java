package kz.alisher.expertsystem.expertsystem.mapper;

import kz.alisher.expertsystem.expertsystem.dto.moneyincomes.MoneyIncomeCreate;
import kz.alisher.expertsystem.expertsystem.dto.moneyincomes.MoneyIncomeView;
import kz.alisher.expertsystem.expertsystem.entity.MoneyIncomeEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MoneyIncomeMapper {

    MoneyIncomeMapper INSTANCE = Mappers.getMapper(MoneyIncomeMapper.class);

    MoneyIncomeEntity toEntity(MoneyIncomeCreate input);

    MoneyIncomeView toView(MoneyIncomeEntity entity);

}
