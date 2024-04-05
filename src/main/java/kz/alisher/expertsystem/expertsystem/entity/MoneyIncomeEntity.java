package kz.alisher.expertsystem.expertsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import jakarta.persistence.*;
import kz.alisher.expertsystem.expertsystem.enums.MoneyIncomeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;

@Entity
@Table(name = "money_incomes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MoneyIncomeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value_from", nullable = false)
    private BigDecimal valueFrom;

    @Column(name = "value_to", nullable = false)
    private BigDecimal valueTo;

    @Column(name = "type", nullable = false)
    @Type(PostgreSQLEnumType.class)
    @Enumerated(EnumType.STRING)
    private MoneyIncomeType type;

    public MoneyIncomeEntity(BigDecimal valueFrom, BigDecimal valueTo, MoneyIncomeType type) {
        this.valueFrom = valueFrom;
        this.valueTo = valueTo;
        this.type = type;
    }

}
