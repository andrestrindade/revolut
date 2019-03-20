INSERT INTO client VALUES (123456, 'John Smith');
INSERT INTO client VALUES (7891011, 'Mary Smith');
INSERT INTO operation_type (operation_name) VALUES ('transfer');
INSERT INTO operation_type (operation_name) VALUES ('deposit');
INSERT INTO operation_type (operation_name) VALUES ('withdraw');
INSERT INTO account (balance, fk_client_passport_number) VALUES (5000, 123456);
INSERT INTO account (balance, fk_client_passport_number) VALUES (8000, 7891011);