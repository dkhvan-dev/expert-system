package kz.alisher.expertsystem.expertsystem.dto.contributions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContributionCreate {

    private int valueFrom;
    private int valueTo;

}
