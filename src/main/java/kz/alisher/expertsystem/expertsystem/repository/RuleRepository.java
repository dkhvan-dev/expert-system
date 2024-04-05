package kz.alisher.expertsystem.expertsystem.repository;

import kz.alisher.expertsystem.expertsystem.entity.RuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RuleRepository extends JpaRepository<RuleEntity, Long>, JpaSpecificationExecutor<RuleEntity> {
}
