ALTER TABLE groups
ADD FOREIGN KEY (manager_id) REFERENCES users(user_id);

ALTER TABLE users_groups
ADD FOREIGN KEY (user_id) REFERENCES users(user_id);
ALTER TABLE users_groups
ADD FOREIGN KEY (group_id) REFERENCES groups(group_id);

ALTER TABLE users_roles
ADD FOREIGN KEY (user_id) REFERENCES users(user_id);
ALTER TABLE users_roles
ADD FOREIGN KEY (role_id) REFERENCES roles(role_id);

ALTER TABLE timesheets
ADD FOREIGN KEY (contract_id) REFERENCES contracts(contract_id);
ALTER TABLE timesheets
ADD FOREIGN KEY (user_id) REFERENCES users(user_id);

ALTER TABLE contracts
ADD FOREIGN KEY (manager_id) REFERENCES users(user_id);

ALTER TABLE users_contracts
ADD FOREIGN KEY (user_id) REFERENCES users(user_id);
ALTER TABLE users_contracts
ADD FOREIGN KEY (contract_id) REFERENCES contracts(contract_id);


