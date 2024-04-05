package kz.alisher.expertsystem.expertsystem.dto.moneyincomes;

import kz.alisher.expertsystem.expertsystem.enums.MoneyIncomeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoneyIncomeView {

    private Long id;
    private BigDecimal valueFrom;
    private BigDecimal valueTo;
    private MoneyIncomeType type;

}
