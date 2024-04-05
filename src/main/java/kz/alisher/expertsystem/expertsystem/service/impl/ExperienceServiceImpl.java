package kz.alisher.expertsystem.expertsystem.service.impl;

import kz.alisher.expertsystem.expertsystem.dto.experiences.ExperienceCreate;
import kz.alisher.expertsystem.expertsystem.dto.experiences.ExperienceView;
import kz.alisher.expertsystem.expertsystem.entity.ExperienceEntity;
import kz.alisher.expertsystem.expertsystem.mapper.ExperienceMapper;
import kz.alisher.expertsystem.expertsystem.repository.ExperienceRepository;
import kz.alisher.expertsystem.expertsystem.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    private final ExperienceRepository repository;

    @Transactional
    @Override
    public void create(ExperienceCreate input) {
        repository.save(ExperienceMapper.INSTANCE.toEntity(input));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ExperienceView> findAll() {
        return repository.findAll().stream().map(ExperienceMapper.INSTANCE::toView).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public ExperienceEntity getEntityById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
