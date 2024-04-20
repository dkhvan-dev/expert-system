package kz.alisher.expertsystem.expertsystem.dto.rules;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RuleSearch {

    private Integer age;
    private Integer mortgagePeriod;
    private Long buildTypeId;
    private Integer moneyIncome;
    private Integer contribution;
    private Integer experience;
    private String creditHistory;
    private Integer creditObligation;
    private String result;

}
