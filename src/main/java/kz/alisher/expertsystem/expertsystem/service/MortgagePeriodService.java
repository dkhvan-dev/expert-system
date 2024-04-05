package kz.alisher.expertsystem.expertsystem.service;

import kz.alisher.expertsystem.expertsystem.dto.mortgageperiods.MortgagePeriodCreate;
import kz.alisher.expertsystem.expertsystem.dto.mortgageperiods.MortgagePeriodView;
import kz.alisher.expertsystem.expertsystem.entity.MortgagePeriodEntity;

import java.util.List;

public interface MortgagePeriodService {

    void create(MortgagePeriodCreate input);

    List<MortgagePeriodView> findAll();

    MortgagePeriodEntity getEntityById(Long id);

    void delete(Long id);

}
