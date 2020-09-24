INSERT INTO public.contracts(
	manager_id, contract_name, company, start_date, end_date, create_time, update_time)
	VALUES ( 6, 'FullStackTrainingContract', 'Authright', '2020-9-20', '2021-9-20', now(), now());
	
Insert into users_contracts(user_id, contract_id)
	Values (1, 1);
	
Insert into users_contracts(user_id, contract_id)
	Values (2, 1)