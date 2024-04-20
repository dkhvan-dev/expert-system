package kz.alisher.expertsystem.expertsystem.dto.moneyincomes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoneyIncomeCreate {

    private BigDecimal valueFrom;
    private BigDecimal valueTo;
    private String type;

}
