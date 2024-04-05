package kz.alisher.expertsystem.expertsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import jakarta.persistence.*;
import kz.alisher.expertsystem.expertsystem.enums.CreditHistory;
import kz.alisher.expertsystem.expertsystem.enums.MoneyIncomeType;
import kz.alisher.expertsystem.expertsystem.enums.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "rules")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_resident", nullable = false)
    private boolean isResident = false;

    @Column(name = "min_age", nullable = false)
    private int minAge;

    @Column(name = "max_age", nullable = false)
    private int maxAge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mortgage_period_id", nullable = false)
    private MortgagePeriodEntity mortgagePeriod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "build_type_id", nullable = false)
    private BuildTypeEntity buildType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "money_income_id", nullable = false)
    private MoneyIncomeEntity moneyIncome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contribution_id", nullable = false)
    private ContributionEntity contribution;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "experience_id", nullable = false)
    private ExperienceEntity experience;

    @Column(name = "credit_history", nullable = false)
    @Type(PostgreSQLEnumType.class)
    @Enumerated(EnumType.STRING)
    private CreditHistory creditHistory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_obligation_id", nullable = false)
    private CreditObligationEntity creditObligation;

    @Column(name = "result", nullable = false)
    @Enumerated(EnumType.STRING)
    private Result result;

}