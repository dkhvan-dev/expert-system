create type money_income_type as enum ('LOW', 'MIDDLE', 'HIGH');
create type credit_history as enum ('BAD', 'GOOD', 'EXCELLENT');

create table if not exists build_types (
    id bigserial primary key not null,
    name varchar(255) not null unique
);

create table if not exists mortgage_periods (
    id bigserial primary key not null,
    value_from int not null,
    value_to int not null
);

create unique index uk_mortgage_periods_direction_value on mortgage_periods(value_from, value_to);

create table if not exists money_incomes (
    id bigserial primary key not null,
    value_from bigint not null,
    value_to bigint not null,
    type money_income_type not null
);

create unique index uk_money_incomes_values on money_incomes(value_from, value_to, type);

create table if not exists contributions (
    id bigserial primary key not null,
    value_from int not null,
    value_to int not null
);

create unique index uk_contributions_direction_value on contributions(value_from, value_to);

create table if not exists experiences (
    id bigserial primary key not null,
    value_from int not null,
    value_to int not null
);

create unique index uk_experiences_direction_value on experiences(value_from, value_to);

create table if not exists credit_obligations (
    id bigserial primary key not null,
    min_value int not null,
    max_value int not null
);

create unique index uk_credit_obligations_values on credit_obligations(min_value, max_value);

create table if not exists users (
    id bigserial primary key not null,
    created_at timestamp not null default now(),
    username varchar(255) not null unique,
    password varchar(255) not null,
    full_name varchar(255) not null,
    role varchar(10) not null
);

create table if not exists rules (
    id bigserial primary key not null,
    is_resident boolean not null,
    min_age bigint not null,
    max_age bigint not null,
    mortgage_period_id bigint references mortgage_periods(id),
    build_type_id bigint references build_types(id),
    money_income_id bigint references money_incomes(id),
    contribution_id bigint references contributions(id),
    experience_id bigint references experiences(id),
    credit_history credit_history,
    credit_obligation_id bigint references credit_obligations(id),
    result varchar(7) not null
);

create unique index uk_rules on rules(is_resident, min_age, max_age, mortgage_period_id, build_type_id, money_income_id, contribution_id, experience_id, credit_history, credit_obligation_id, result);