package kz.alisher.expertsystem.expertsystem.mapper;

import kz.alisher.expertsystem.expertsystem.dto.creditobligations.CreditObligationCreate;
import kz.alisher.expertsystem.expertsystem.dto.creditobligations.CreditObligationView;
import kz.alisher.expertsystem.expertsystem.entity.CreditObligationEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreditObligationMapper {

    CreditObligationMapper INSTANCE = Mappers.getMapper(CreditObligationMapper.class);

    CreditObligationView toView(CreditObligationEntity entity);

    CreditObligationEntity toEntity(CreditObligationCreate input);

}
