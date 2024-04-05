package kz.alisher.expertsystem.expertsystem.service.impl;

import jakarta.persistence.criteria.Predicate;
import kz.alisher.expertsystem.expertsystem.dto.rules.RuleCreate;
import kz.alisher.expertsystem.expertsystem.dto.rules.RuleSearch;
import kz.alisher.expertsystem.expertsystem.dto.rules.RuleView;
import kz.alisher.expertsystem.expertsystem.entity.RuleEntity;
import kz.alisher.expertsystem.expertsystem.mapper.RuleMapper;
import kz.alisher.expertsystem.expertsystem.repository.RuleRepository;
import kz.alisher.expertsystem.expertsystem.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RuleServiceImpl implements RuleService {

    private final RuleRepository repository;
    private final BuildTypeService buildTypeService;
    private final MoneyIncomeService moneyIncomeService;
    private final ContributionService contributionService;
    private final CreditObligationService creditObligationService;
    private final ExperienceService experienceService;
    private final MortgagePeriodService mortgagePeriodService;

    @Transactional
    @Override
    public void create(RuleCreate request) {
        RuleEntity entity = RuleMapper.INSTANCE.toEntity(request);
        entity.setMoneyIncome(moneyIncomeService.getEntityById(request.getMoneyIncomeId()));
        entity.setBuildType(buildTypeService.getEntityById(request.getBuildTypeId()));
        entity.setContribution(contributionService.getEntityById(request.getContributionId()));
        entity.setCreditObligation(creditObligationService.getEntityById(request.getCreditObligationId()));
        entity.setExperience(experienceService.getEntityById(request.getExperienceId()));
        entity.setMortgagePeriod(mortgagePeriodService.getEntityById(request.getMortgagePeriodId()));

        repository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<RuleView> findAll() {
        return repository.findAll().stream().map(RuleMapper.INSTANCE::toView).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<RuleView> search(RuleSearch search) {
        Specification<RuleEntity> where = buildSpecification(search);

        return repository.findAll(where)
                .stream()
                .map(RuleMapper.INSTANCE::toView)
                .toList();
    }

    private Specification<RuleEntity> buildSpecification(RuleSearch search) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.and();

            if (search == null)
                return predicate;

            if (search.getAge() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("minAge"), search.getAge()));
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("maxAge"), search.getAge()));
            }

            if (search.getMortgagePeriod() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("mortgagePeriod").get("valueFrom"), search.getMortgagePeriod()));
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("mortgagePeriod").get("valueTo"), search.getMortgagePeriod()));
            } else {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.isNull(root.get("mortgagePeriod")));
            }

            if (search.getBuildTypeId() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("buildType").get("id"), search.getBuildTypeId()));
            } else {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.isNull(root.get("buildType")));
            }

            if (search.getMoneyIncome() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("moneyIncome").get("valueFrom"), search.getMoneyIncome()));
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("moneyIncome").get("valueTo"), search.getMoneyIncome()));
            } else {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.isNull(root.get("moneyIncome")));
            }

            if (search.getContribution() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("contribution").get("valueFrom"), search.getContribution()));
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("contribution").get("valueTo"), search.getContribution()));
            } else {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.isNull(root.get("contribution")));
            }

            if (search.getExperience() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("experience").get("valueFrom"), search.getExperience()));
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("experience").get("valueTo"), search.getExperience()));
            } else {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.isNull(root.get("experience")));
            }

            if (search.getCreditHistory() != null ) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("creditHistory"), search.getCreditHistory()));
            } else {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.isNull(root.get("creditHistory")));
            }

            if (search.getCreditObligation() != null ) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("creditObligation").get("minValue"), search.getCreditObligation()));
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("creditObligation").get("maxValue"), search.getCreditObligation()));
            } else {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.isNull(root.get("creditObligation")));
            }

            if (search.getResult() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("result"), search.getResult()));
            }

            return predicate;
        };
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
