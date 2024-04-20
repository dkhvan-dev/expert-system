package kz.alisher.expertsystem.expertsystem.mapper;

import kz.alisher.expertsystem.expertsystem.dto.rules.RuleCreate;
import kz.alisher.expertsystem.expertsystem.dto.rules.RuleView;
import kz.alisher.expertsystem.expertsystem.entity.RuleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { BuildTypeMapper.class, MortgagePeriodMapper.class, MoneyIncomeMapper.class, ContributionMapper.class, ExperienceMapper.class, CreditObligationMapper.class })
public interface RuleMapper {

    RuleMapper INSTANCE = Mappers.getMapper(RuleMapper.class);

    RuleView toView(RuleEntity entity);

    @Mapping(target = "resident", source = "isResident")
    RuleEntity toEntity(RuleCreate input);

}
