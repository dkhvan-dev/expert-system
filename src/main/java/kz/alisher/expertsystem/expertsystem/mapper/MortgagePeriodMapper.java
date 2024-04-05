package kz.alisher.expertsystem.expertsystem.mapper;

import kz.alisher.expertsystem.expertsystem.dto.mortgageperiods.MortgagePeriodCreate;
import kz.alisher.expertsystem.expertsystem.dto.mortgageperiods.MortgagePeriodView;
import kz.alisher.expertsystem.expertsystem.entity.MortgagePeriodEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface MortgagePeriodMapper {

    MortgagePeriodMapper INSTANCE = Mappers.getMapper(MortgagePeriodMapper.class);

    MortgagePeriodEntity toEntity(MortgagePeriodCreate input);

    MortgagePeriodView toView(MortgagePeriodEntity entity);

}
