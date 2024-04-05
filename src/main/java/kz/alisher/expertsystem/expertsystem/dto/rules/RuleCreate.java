package kz.alisher.expertsystem.expertsystem.dto.rules;

import kz.alisher.expertsystem.expertsystem.enums.CreditHistory;
import kz.alisher.expertsystem.expertsystem.enums.MoneyIncomeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RuleCreate {

    private boolean isResident;
    private int minAge;
    private int maxAge;
    private Long mortgagePeriodId;
    private Long buildTypeId;
    private Long moneyIncomeId;
    private Long contributionId;
    private Long experienceId;
    private CreditHistory creditHistory;
    private Long creditObligationId;
    private String result;

}
