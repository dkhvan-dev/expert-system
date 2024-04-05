package kz.alisher.expertsystem.expertsystem.service;

import kz.alisher.expertsystem.expertsystem.dto.creditobligations.CreditObligationCreate;
import kz.alisher.expertsystem.expertsystem.dto.creditobligations.CreditObligationView;
import kz.alisher.expertsystem.expertsystem.entity.CreditObligationEntity;

import java.util.List;

public interface CreditObligationService {

    void create(CreditObligationCreate input);

    List<CreditObligationView> findAll();

    CreditObligationEntity getEntityById(Long id);

    void delete(Long id);

}
