create table "users" (
	user_id      BIGSERIAL    NOT NULL,
	user_name    VARCHAR(255) NOT NULL UNIQUE,
	first_name   VARCHAR(255) NOT NULL,
	last_name    VARCHAR(255) NOT NULL,
	password     VARCHAR(255) NOT NULL,
	email        VARCHAR(255) NOT NULL UNIQUE,
	phone        VARCHAR(255) NOT NULL UNIQUE,
	avatar_url   VARCHAR(255),
	create_time  TIMESTAMP    NOT NULL,     
	update_time  TIMESTAMP    NOT NULL,
	PRIMARY KEY(user_id),
); 

create table "groups" (
	group_id            BIGSERIAL    NOT NULL,
	group_name          VARCHAR(255) NOT NULL UNIQUE,
	group_description   VARCHAR(255) NOT NULL,
	manager_id          BIGINT,
	create_time         TIMESTAMP    NOT NULL,     
	update_time         TIMESTAMP    NOT NULL,
	PRIMARY KEY(group_id),
); 

create table "users_groups"(
	user_id   BIGINT NOT NULL,
	group_id  BIGINT NOT NULL
);

create table "roles" (
	role_id     BIGSERIAL    NOT NULL,
	operation   VARCHAR(255) NOT NULL,
	PRIMARY KEY(role_id)
); 

create table "users_roles"(
	user_id  BIGINT NOT NULL,
	role_id  BIGINT NOT NULL
);

create table "timesheets"(
	timesheet_id     BIGSERIAL      NOT NULL,
	contract_id      BIGINT         NOT NULL,
	user_id          BIGINT         NOT NULL,
	timesheet_date   TIMESTAMP      NOT NULL,
	start_time       TIMESTAMP,
	end_time         TIMESTAMP,
	break_deduction  TIME,
	total_hour       TIME,
	status           VARCHAR(255)   NOT NULL,
	create_time      TIMESTAMP      NOT NULL,
	update_time      TIMESTAMP      NOT NULL,
	PRIMARY KEY(timesheet_id)
);

create table "contracts"(
	contract_id      BIGSERIAL      NOT NULL,
	manager_id       BIGINT         NOT NULL,
	contract_name    VARCHAR(255)   NOT NULL,
	company          VARCHAR(255)   NOT NULL,
	start_date       TIMESTAMP      NOT NULL,
	end_date         TIMESTAMP,
	create_time      TIMESTAMP      NOT NULL,
	update_time      TIMESTAMP      NOT NULL,
	PRIMARY KEY(contract_id)	   
);

create table "users_contracts"(
	user_id      BIGINT NOT NULL,
	contract_id  BIGINT NOT NULL
);
