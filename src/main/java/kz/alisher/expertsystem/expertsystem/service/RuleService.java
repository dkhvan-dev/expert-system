package kz.alisher.expertsystem.expertsystem.service;

import kz.alisher.expertsystem.expertsystem.dto.rules.RuleCreate;
import kz.alisher.expertsystem.expertsystem.dto.rules.RuleSearch;
import kz.alisher.expertsystem.expertsystem.dto.rules.RuleView;

import java.util.List;

public interface RuleService {

    void create(RuleCreate request);

    List<RuleView> findAll();

    List<RuleView> search(RuleSearch search);

    void delete(Long id);

}
