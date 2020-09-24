INSERT INTO groups(group_name, group_description, manager_id, create_time, update_time)
VALUES ('Full Stack Training Team', 'Training Team', 6, now(), now());

INSERT INTO users_groups(user_id, group_id)
VALUES (1, 1)

INSERT INTO users_groups(user_id, group_id)
VALUES (2, 1)