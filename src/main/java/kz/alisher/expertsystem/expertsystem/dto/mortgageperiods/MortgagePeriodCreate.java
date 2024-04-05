package kz.alisher.expertsystem.expertsystem.dto.mortgageperiods;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MortgagePeriodCreate {

    private int valueFrom;
    private int valueTo;

}
