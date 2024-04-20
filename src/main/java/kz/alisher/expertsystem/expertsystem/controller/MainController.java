package kz.alisher.expertsystem.expertsystem.controller;

import kz.alisher.expertsystem.expertsystem.dto.rules.RuleSearch;
import kz.alisher.expertsystem.expertsystem.dto.rules.RuleView;
import kz.alisher.expertsystem.expertsystem.service.RuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final RuleService ruleService;

    @GetMapping("/build-types-available")
    public List<Long> getAvailableBuildTypes() {
        return List.of();
    }

    @PostMapping("/rules/search")
    public List<RuleView> searchRule(@RequestBody RuleSearch search) {
        return ruleService.search(search);
    }

}
