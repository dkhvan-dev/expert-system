package kz.alisher.expertsystem.expertsystem.dto.rules;

import kz.alisher.expertsystem.expertsystem.dto.buildtypes.BuildTypeView;
import kz.alisher.expertsystem.expertsystem.dto.contributions.ContributionView;
import kz.alisher.expertsystem.expertsystem.dto.creditobligations.CreditObligationView;
import kz.alisher.expertsystem.expertsystem.dto.experiences.ExperienceView;
import kz.alisher.expertsystem.expertsystem.dto.moneyincomes.MoneyIncomeView;
import kz.alisher.expertsystem.expertsystem.dto.mortgageperiods.MortgagePeriodView;
import kz.alisher.expertsystem.expertsystem.enums.CreditHistory;
import kz.alisher.expertsystem.expertsystem.enums.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RuleView {

    private Long id;
    private boolean isResident;
    private int minAge;
    private int maxAge;
    private MortgagePeriodView mortgagePeriod;
    private BuildTypeView buildType;
    private MoneyIncomeView moneyIncome;
    private ContributionView contribution;
    private ExperienceView experience;
    private CreditHistory creditHistory;
    private CreditObligationView creditObligation;
    private Result result;

}
