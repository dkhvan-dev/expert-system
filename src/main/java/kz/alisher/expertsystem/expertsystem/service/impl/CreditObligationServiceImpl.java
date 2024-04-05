package kz.alisher.expertsystem.expertsystem.service.impl;

import kz.alisher.expertsystem.expertsystem.dto.creditobligations.CreditObligationCreate;
import kz.alisher.expertsystem.expertsystem.dto.creditobligations.CreditObligationView;
import kz.alisher.expertsystem.expertsystem.entity.CreditObligationEntity;
import kz.alisher.expertsystem.expertsystem.mapper.CreditObligationMapper;
import kz.alisher.expertsystem.expertsystem.repository.CreditObligationRepository;
import kz.alisher.expertsystem.expertsystem.service.CreditObligationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditObligationServiceImpl implements CreditObligationService {

    private final CreditObligationRepository repository;

    @Transactional
    @Override
    public void create(CreditObligationCreate input) {
        repository.save(CreditObligationMapper.INSTANCE.toEntity(input));
    }

    @Transactional(readOnly = true)
    @Override
    public List<CreditObligationView> findAll() {
        return repository.findAll().stream().map(CreditObligationMapper.INSTANCE::toView).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public CreditObligationEntity getEntityById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
