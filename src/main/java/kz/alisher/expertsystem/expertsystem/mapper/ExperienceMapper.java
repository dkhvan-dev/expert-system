package kz.alisher.expertsystem.expertsystem.mapper;

import kz.alisher.expertsystem.expertsystem.dto.experiences.ExperienceCreate;
import kz.alisher.expertsystem.expertsystem.dto.experiences.ExperienceView;
import kz.alisher.expertsystem.expertsystem.entity.ExperienceEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExperienceMapper {

    ExperienceMapper INSTANCE = Mappers.getMapper(ExperienceMapper.class);

    ExperienceEntity toEntity(ExperienceCreate input);

    ExperienceView toView(ExperienceEntity entity);

}
