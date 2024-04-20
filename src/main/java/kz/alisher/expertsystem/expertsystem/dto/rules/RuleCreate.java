package kz.alisher.expertsystem.expertsystem.dto.rules;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RuleCreate {

    private String isResident;
    private int minAge;
    private int maxAge;
    private Long mortgagePeriodId;
    private Long buildTypeId;
    private Long moneyIncomeId;
    private Long contributionId;
    private Long experienceId;
    private String creditHistory;
    private Long creditObligationId;
    private String result;

}
