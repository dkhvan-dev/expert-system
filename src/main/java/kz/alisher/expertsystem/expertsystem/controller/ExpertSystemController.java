package kz.alisher.expertsystem.expertsystem.controller;

import kz.alisher.expertsystem.expertsystem.service.BuildTypeService;
import kz.alisher.expertsystem.expertsystem.service.ContributionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ExpertSystemController {

    private final BuildTypeService buildTypeService;
    private final ContributionService contributionService;

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("buildTypes", buildTypeService.findAll());
        model.addAttribute("contributions", contributionService.findAll());

        return "index";
    }

}
