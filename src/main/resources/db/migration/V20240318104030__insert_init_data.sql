insert into users (username, password, full_name, role)
    values ('alisher', '$2y$10$ESbdYDTDIk.lfIuQuM/HzeKR1z8G9xP2bqSrXJZHa83Znsfs15PBG', 'Alisher Bekkalpenov', 'ROLE_ADMIN');

insert into build_types(name)
    values ('Бетон'), ('Кирпич'), ('Блок');

insert into mortgage_periods(value_from, value_to)
    values (0, 35), (36, 100);

insert into money_incomes(value_from, value_to, type)
    values (0, 250000, 'LOW'), (250001, 500000, 'MIDDLE'), (500001, 99999999999, 'HIGH');

insert into contributions(value_from, value_to)
    values (0, 19),
           (20, 100);

insert into experiences(value_from, value_to)
    values (0, 3),
           (12, 100),
           (3, 12);

insert into credit_obligations(min_value, max_value)
    values (0, 30),
           (30, 100),
           (30, 50),
           (50, 100);

insert into rules (is_resident, min_age, max_age, result)
    values (true, 0, 20, 'REJECT'),
           (true, 68, 9999999, 'REJECT');

insert into rules (is_resident, min_age, max_age, mortgage_period_id, result)
    values (true, 0, 20, 1, 'REJECT'),
           (true, 68, 9999999, 1, 'REJECT'),
           (true, 21, 68, 1, 'REJECT');

insert into rules (is_resident, min_age, max_age, mortgage_period_id, build_type_id, result)
    values (true, 0, 20, 1, 2, 'REJECT'),
           (true, 68, 9999999, 1, 2, 'REJECT'),
           (true, 21, 68, 1, 2, 'REJECT'),
           (true, 21, 68, 2, 2, 'REJECT');

insert into rules (is_resident, min_age, max_age, mortgage_period_id, build_type_id, money_income_id, result)
    values (true, 0, 20, 1, 2, 1, 'REJECT'),
           (true, 68, 9999999, 1, 2, 1, 'REJECT'),
           (true, 21, 68, 1, 2, 1, 'REJECT'),
           (true, 21, 68, 2, 1, 1, 'REJECT'),
           (true, 63, 68, 2, 1, 1, 'REJECT'),
           (true, 63, 68, 2, 1, 2, 'REJECT');

insert into rules (is_resident, min_age, max_age, mortgage_period_id, build_type_id, money_income_id, contribution_id, result)
    values (true, 0, 20, 1, 2, 1, 1, 'REJECT'),
           (true, 68, 9999999, 1, 2, 1, 1, 'REJECT'),
           (true, 21, 68, 1, 2, 1, 1, 'REJECT'),
           (true, 21, 68, 2, 1, 2, 1, 'REJECT'),
           (true, 63, 68, 2, 1, 3, 1, 'REJECT'),
           (true, 21, 63, 2, 1, 2, 1, 'REJECT');

insert into rules (is_resident, min_age, max_age, mortgage_period_id, build_type_id, money_income_id, contribution_id, experience_id, credit_history, result)
    values (true, 21, 68, 2, 1, 2, 2, 1, 'GOOD', 'REJECT'),
           (true, 21, 68, 2, 1, 2, 2, 1, 'BAD', 'REJECT'),
           (true, 21, 68, 2, 1, 2, 2, 2, 'EXCELLENT', 'APPROVE'),
           (true, 21, 68, 2, 1, 2, 2, 3, 'EXCELLENT', 'APPROVE');

insert into rules (is_resident, min_age, max_age, mortgage_period_id, build_type_id, money_income_id, contribution_id, credit_history, credit_obligation_id, result)
values (true, 63, 68, 2, 1, 3, 2, 'BAD', 1, 'REJECT'),
       (true, 63, 68, 2, 1, 3, 2, 'BAD', 2, 'REJECT'),
       (true, 63, 68, 2, 1, 3, 2, 'BAD', 3, 'REJECT'),
       (true, 63, 68, 2, 1, 3, 2, 'BAD', 4, 'REJECT'),
       (true, 63, 68, 2, 1, 3, 2, 'EXCELLENT', 1, 'APPROVE'),
       (true, 63, 68, 2, 1, 3, 2, 'EXCELLENT', 2, 'APPROVE'),
       (true, 63, 68, 2, 1, 3, 2, 'EXCELLENT', 3, 'APPROVE'),
       (true, 63, 68, 2, 1, 3, 2, 'EXCELLENT', 4, 'APPROVE'),
       (true, 63, 68, 2, 1, 3, 2, 'GOOD', 1, 'APPROVE');

insert into rules (is_resident, min_age, max_age, mortgage_period_id, build_type_id, money_income_id, contribution_id, experience_id, credit_history, credit_obligation_id, result)
    values (true, 21, 68, 2, 1, 2, 2, 1, 'EXCELLENT', 1, 'APPROVE'),
       (true, 21, 68, 2, 1, 2, 2, 1, 'EXCELLENT', 2, 'REJECT'),
       (true, 21, 68, 2, 1, 2, 2, 3, 'GOOD', 4, 'REJECT'),
       (true, 21, 68, 2, 1, 2, 2, 3, 'GOOD', 2, 'APPROVE'),
       (true, 63, 68, 2, 1, 3, 2, 3, 'GOOD', 2, 'APPROVE');

insert into rules (is_resident, min_age, max_age, mortgage_period_id, build_type_id, money_income_id, contribution_id, experience_id, credit_history, credit_obligation_id, result)
    values (true, 0, 20, 1, 2, 1, 1, 1, 'BAD', 1, 'REJECT'),
           (true, 21, 68, 2, 2, 1, 1, 1, 'BAD', 1, 'REJECT');