package kz.alisher.expertsystem.expertsystem.mapper;

import kz.alisher.expertsystem.expertsystem.dto.contributions.ContributionCreate;
import kz.alisher.expertsystem.expertsystem.dto.contributions.ContributionView;
import kz.alisher.expertsystem.expertsystem.entity.ContributionEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContributionMapper {

    ContributionMapper INSTANCE = Mappers.getMapper(ContributionMapper.class);

    ContributionEntity toEntity(ContributionCreate input);

    ContributionView toView(ContributionEntity entity);

}
