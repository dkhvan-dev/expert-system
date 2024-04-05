package kz.alisher.expertsystem.expertsystem.dto.creditobligations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreditObligationCreate {

    private int minValue;
    private int maxValue;

}
