CREATE SCHEMA revolut;
CREATE TABLE client
(
 passport_number numeric(14) NOT NULL,
 name  VARCHAR(50)  NOT NULL ,
PRIMARY KEY (passport_number)
);

CREATE TABLE operation_type
(
 id_operation_type numeric(2)  NOT NULL AUTO_INCREMENT PRIMARY KEY,
 operation_name varchar(45) NOT NULL
);


CREATE TABLE bank_operation
(
 id_operation numeric(2) NOT NULL AUTO_INCREMENT PRIMARY KEY,
 operation_timestamp datetime NOT NULL,
 operation_value double(12.2) NOT NULL,
 fk_operation_type numeric(2) NOT NULL,
 fk_id_account_from numeric(14) NOT NULL,
 fk_id_account_to numeric(14),
PRIMARY KEY (id_operation)
);


CREATE TABLE account
(
 id_account numeric(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
 balance double(12.2) NOT NULL,
 fk_client_passport_number numeric(14) NOT NULL,
PRIMARY KEY (id_account)
);

ALTER TABLE bank_operation ADD FOREIGN KEY (fk_operation_type) REFERENCES operation_type(id_operation_type);
ALTER TABLE bank_operation ADD FOREIGN KEY (fk_id_account_from ) REFERENCES account(id_account);
ALTER TABLE bank_operation ADD FOREIGN KEY (fk_id_account_to) REFERENCES account(id_account);
ALTER TABLE account ADD FOREIGN KEY (fk_client_passport_number) REFERENCES client(passport_number);