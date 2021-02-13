INSERT INTO transaction_type (id, trx_type, created_date) VALUES (1, 'Credit', '2021-02-12');
INSERT INTO transaction_type (id, trx_type, created_date) VALUES (2, 'Debit', '2021-02-12');

INSERT INTO account_type (id, acc_type, created_date) VALUES (1, 'Checking', '2021-02-12');
INSERT INTO account_type (id, acc_type, created_date) VALUES (2, 'Saving', '2021-02-12');
INSERT INTO account_type (id, acc_type, created_date) VALUES (3, 'Deposit', '2021-02-12');

INSERT INTO user (id, username, password) VALUES (1, 'Ipin', '$2a$10$iH7jR0hgZwWgy1mMMSlI/.OYrFSMeFAef8TCB8wFQMw5NaoooEVRi')
INSERT INTO user (id, username, password) VALUES (2, 'mario', '$2a$10$iH7jR0hgZwWgy1mMMSlI/.OYrFSMeFAef8TCB8wFQMw5NaoooEVRi')
INSERT INTO user (id, username, password) VALUES (3, 'dika', '$2a$10$iH7jR0hgZwWgy1mMMSlI/.OYrFSMeFAef8TCB8wFQMw5NaoooEVRi')

INSERT INTO staff (id, user_id, id_card, name, gender, address, phone_number, role, division, created_date) VALUES (1, 1, 1, 'staff', 'Male', 'Ragunan', '081234567893', 'IT Support', 'R&D' ,'2021-02-12');

INSERT INTO customer (id, user_id, account_type_id, id_card, name, gender, address, phone_number, no_account, balance, created_date) VALUES (1, 2, 2, 334012346, 'Mario', 'Male', 'Ragunan', '081234567892', 123457 , 1000000, '2021-02-12');
INSERT INTO customer (id, user_id, account_type_id, id_card, name, gender, address, phone_number, no_account, balance, created_date) VALUES (2, 3, 3, 334012347, 'Dika', 'Male', 'Ragunan', '081234567893', 123458 , 2000000, '2021-02-12');

INSERT INTO transaction_status (id, status, created_date ) VALUES (1, 'Success', '2021-02-12');

INSERT INTO transaction (id, customer_id, trx_type_id, trx_status_id, amount, created_date) VALUES (1, 1,  2, 1, 50000, '2021-02-12');
