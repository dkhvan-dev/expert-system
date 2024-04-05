package kz.alisher.expertsystem.expertsystem.dto.experiences;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceCreate {

    private int valueFrom;
    private int valueTo;

}
