package kz.alisher.expertsystem.expertsystem.mapper;

import kz.alisher.expertsystem.expertsystem.dto.buildtypes.BuildTypeView;
import kz.alisher.expertsystem.expertsystem.entity.BuildTypeEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BuildTypeMapper {

    BuildTypeMapper INSTANCE = Mappers.getMapper(BuildTypeMapper.class);

    BuildTypeView toView(BuildTypeEntity entity);

}
