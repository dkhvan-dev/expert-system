package kz.alisher.expertsystem.expertsystem.controller;

import kz.alisher.expertsystem.expertsystem.dto.contributions.ContributionCreate;
import kz.alisher.expertsystem.expertsystem.dto.creditobligations.CreditObligationCreate;
import kz.alisher.expertsystem.expertsystem.dto.experiences.ExperienceCreate;
import kz.alisher.expertsystem.expertsystem.dto.moneyincomes.MoneyIncomeCreate;
import kz.alisher.expertsystem.expertsystem.dto.mortgageperiods.MortgagePeriodCreate;
import kz.alisher.expertsystem.expertsystem.dto.rules.RuleCreate;
import kz.alisher.expertsystem.expertsystem.enums.CreditHistory;
import kz.alisher.expertsystem.expertsystem.enums.MoneyIncomeType;
import kz.alisher.expertsystem.expertsystem.enums.Result;
import kz.alisher.expertsystem.expertsystem.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin-panel")
@RequiredArgsConstructor
public class AdminController {

    private final BuildTypeService buildTypeService;
    private final MoneyIncomeService moneyIncomeService;
    private final MortgagePeriodService mortgagePeriodService;
    private final ContributionService contributionService;
    private final ExperienceService experienceService;
    private final CreditObligationService creditObligationService;
    private final RuleService ruleService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public String adminPanel(Model model) {
        model.addAttribute("moneyIncomeTypes", MoneyIncomeType.getAll());

        model.addAttribute("buildTypes", buildTypeService.findAll());
        model.addAttribute("moneyIncomes", moneyIncomeService.findAll());
        model.addAttribute("mortgagePeriods", mortgagePeriodService.findAll());
        model.addAttribute("contributions", contributionService.findAll());
        model.addAttribute("experiences", experienceService.findAll());
        model.addAttribute("creditObligations", creditObligationService.findAll());

        return "adminPanel";
    }

    // TODO: Money Incomes
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/money-incomes")
    public String addMoneyIncome(MoneyIncomeCreate input) {
        moneyIncomeService.create(input);

        return "redirect:/admin-panel";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/money-incomes/{id}")
    public String deleteMoneyIncome(@PathVariable Long id) {
        moneyIncomeService.delete(id);

        return "redirect:/admin-panel";
    }

    // TODO: Build types
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/build-types")
    public String addBuildType(@RequestParam("name") String name) {
        buildTypeService.create(name);

        return "redirect:/admin-panel";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/build-types/{id}/delete")
    public String deleteBuildType(@PathVariable Long id) {
        buildTypeService.delete(id);

        return "redirect:/admin-panel";
    }

    // TODO: Mortgage period
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/mortgage-periods")
    public String addMortgagePeriod(MortgagePeriodCreate input) {
        mortgagePeriodService.create(input);

        return "redirect:/admin-panel";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/mortgage-periods/{id}")
    public String deleteMortgagePeriod(@PathVariable Long id) {
        mortgagePeriodService.delete(id);

        return "redirect:/admin-panel";
    }

    // TODO: Contribution
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/contributions")
    public String addContribution(ContributionCreate input) {
        contributionService.create(input);

        return "redirect:/admin-panel";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/contributions/{id}")
    public String deleteContribution(@PathVariable Long id) {
        contributionService.delete(id);

        return "redirect:/admin-panel";
    }

    // TODO: Experience
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/experiences")
    public String addExperience(ExperienceCreate input) {
        experienceService.create(input);

        return "redirect:/admin-panel";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/experiences/{id}")
    public String deleteExperience(@PathVariable Long id) {
        experienceService.delete(id);

        return "redirect:/admin-panel";
    }

    // TODO: Credit Obligation
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/credit-obligations")
    public String addCreditObligation(CreditObligationCreate input) {
        creditObligationService.create(input);

        return "redirect:/admin-panel";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/credit-obligations/{id}")
    public String deleteCreditObligation(@PathVariable Long id) {
        creditObligationService.delete(id);

        return "redirect:/admin-panel";
    }

    // TODO: Rules
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/rules")
    public String rulesPage(Model model) {
        model.addAttribute("creditHistories", CreditHistory.getAll());

        model.addAttribute("rules", ruleService.findAll());
        model.addAttribute("buildTypes", buildTypeService.findAll());
        model.addAttribute("moneyIncomes", moneyIncomeService.findAll());
        model.addAttribute("mortgagePeriods", mortgagePeriodService.findAll());
        model.addAttribute("contributions", contributionService.findAll());
        model.addAttribute("experiences", experienceService.findAll());
        model.addAttribute("creditObligations", creditObligationService.findAll());
        model.addAttribute("results", Result.getAll());

        return "rules";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/rules")
    public String addRule(RuleCreate input) {
        ruleService.create(input);

        return "redirect:/admin-panel/rules";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/rules/{id}")
    public String deleteRule(@PathVariable Long id) {
        ruleService.delete(id);

        return "redirect:/admin-panel/rules";
    }

}
