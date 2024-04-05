package kz.alisher.expertsystem.expertsystem.service;

import kz.alisher.expertsystem.expertsystem.dto.experiences.ExperienceCreate;
import kz.alisher.expertsystem.expertsystem.dto.experiences.ExperienceView;
import kz.alisher.expertsystem.expertsystem.entity.ExperienceEntity;

import java.util.List;

public interface ExperienceService {

    void create(ExperienceCreate input);

    List<ExperienceView> findAll();

    ExperienceEntity getEntityById(Long id);

    void delete(Long id);

}
