package kz.alisher.expertsystem.expertsystem.service.impl;

import kz.alisher.expertsystem.expertsystem.dto.buildtypes.BuildTypeView;
import kz.alisher.expertsystem.expertsystem.entity.BuildTypeEntity;
import kz.alisher.expertsystem.expertsystem.mapper.BuildTypeMapper;
import kz.alisher.expertsystem.expertsystem.repository.BuildTypeRepository;
import kz.alisher.expertsystem.expertsystem.service.BuildTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuildTypeServiceImpl implements BuildTypeService {

    private final BuildTypeRepository repository;

    @Transactional
    @Override
    public void create(String name) {
        repository.save(new BuildTypeEntity(name));
    }

    @Transactional(readOnly = true)
    @Override
    public List<BuildTypeView> findAll() {
        return repository.findAll().stream().map(BuildTypeMapper.INSTANCE::toView).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public BuildTypeEntity getEntityById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
