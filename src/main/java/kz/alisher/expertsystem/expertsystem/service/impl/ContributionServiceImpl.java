package kz.alisher.expertsystem.expertsystem.service.impl;

import kz.alisher.expertsystem.expertsystem.dto.contributions.ContributionCreate;
import kz.alisher.expertsystem.expertsystem.dto.contributions.ContributionView;
import kz.alisher.expertsystem.expertsystem.entity.ContributionEntity;
import kz.alisher.expertsystem.expertsystem.mapper.ContributionMapper;
import kz.alisher.expertsystem.expertsystem.repository.ContributionRepository;
import kz.alisher.expertsystem.expertsystem.service.ContributionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContributionServiceImpl implements ContributionService {

    private final ContributionRepository repository;

    @Transactional
    @Override
    public void create(ContributionCreate request) {
        repository.save(ContributionMapper.INSTANCE.toEntity(request));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ContributionView> findAll() {
        return repository.findAll().stream().map(ContributionMapper.INSTANCE::toView).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public ContributionEntity getEntityById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
