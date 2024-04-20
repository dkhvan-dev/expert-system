package kz.alisher.expertsystem.expertsystem.service.impl;

import kz.alisher.expertsystem.expertsystem.dto.moneyincomes.MoneyIncomeCreate;
import kz.alisher.expertsystem.expertsystem.dto.moneyincomes.MoneyIncomeView;
import kz.alisher.expertsystem.expertsystem.entity.MoneyIncomeEntity;
import kz.alisher.expertsystem.expertsystem.mapper.MoneyIncomeMapper;
import kz.alisher.expertsystem.expertsystem.repository.MoneyIncomeRepository;
import kz.alisher.expertsystem.expertsystem.service.MoneyIncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MoneyIncomeServiceImpl implements MoneyIncomeService {

    private final MoneyIncomeRepository repository;

    @Transactional
    @Override
    public void create(MoneyIncomeCreate input) {
        MoneyIncomeEntity entity = MoneyIncomeMapper.INSTANCE.toEntity(input);
        repository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<MoneyIncomeView> findAll() {
        return repository.findAll().stream().map(MoneyIncomeMapper.INSTANCE::toView).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public MoneyIncomeEntity getEntityById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
