package kz.alisher.expertsystem.expertsystem.service.impl;

import kz.alisher.expertsystem.expertsystem.dto.mortgageperiods.MortgagePeriodCreate;
import kz.alisher.expertsystem.expertsystem.dto.mortgageperiods.MortgagePeriodView;
import kz.alisher.expertsystem.expertsystem.entity.MortgagePeriodEntity;
import kz.alisher.expertsystem.expertsystem.mapper.MortgagePeriodMapper;
import kz.alisher.expertsystem.expertsystem.repository.MortgagePeriodRepository;
import kz.alisher.expertsystem.expertsystem.service.MortgagePeriodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MortgagePeriodServiceImpl implements MortgagePeriodService {

    private final MortgagePeriodRepository repository;

    @Transactional
    @Override
    public void create(MortgagePeriodCreate input) {
        repository.save(MortgagePeriodMapper.INSTANCE.toEntity(input));
    }

    @Transactional(readOnly = true)
    @Override
    public List<MortgagePeriodView> findAll() {
        return repository.findAll().stream().map(MortgagePeriodMapper.INSTANCE::toView).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public MortgagePeriodEntity getEntityById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
