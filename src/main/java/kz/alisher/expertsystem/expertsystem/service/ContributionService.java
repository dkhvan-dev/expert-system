package kz.alisher.expertsystem.expertsystem.service;

import kz.alisher.expertsystem.expertsystem.dto.contributions.ContributionCreate;
import kz.alisher.expertsystem.expertsystem.dto.contributions.ContributionView;
import kz.alisher.expertsystem.expertsystem.entity.ContributionEntity;

import java.util.List;

public interface ContributionService {

    void create(ContributionCreate request);

    List<ContributionView> findAll();

    ContributionEntity getEntityById(Long id);

    void delete(Long id);

}
