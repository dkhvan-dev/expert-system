package kz.alisher.expertsystem.expertsystem.service;

import kz.alisher.expertsystem.expertsystem.dto.buildtypes.BuildTypeView;
import kz.alisher.expertsystem.expertsystem.entity.BuildTypeEntity;

import java.util.List;

public interface BuildTypeService {

    void create(String name);

    List<BuildTypeView> findAll();

    BuildTypeEntity getEntityById(Long id);

    void delete(Long id);

}
