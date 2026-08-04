-- Part A: Setup and Seed Data 
DROP TABLE IF EXISTS bank_accounts CASCADE;

CREATE TABLE bank_accounts (
    account_id INT PRIMARY KEY,
    owner_name VARCHAR(100) NOT NULL,
    balance DECIMAL(12, 2) NOT NULL,
    CONSTRAINT chk_positive_balance CHECK (balance >= 0.00)
);

INSERT INTO bank_accounts (account_id, owner_name, balance) VALUES 
(101, 'David Miller', 500.00),
(102, 'Emily Davis', 150.00);

-- Part B: Tasks 

-- Task 1: Basic Successful Transfer 
select * from bank_accounts; 

--Update statements within transaction, happens as one operation 
begin; 
	update bank_accounts set balance = balance - 100 where account_id = 101; 
	update bank_accounts set balance = balance + 100 where account_id = 102; 
commit;

select * from bank_accounts; 

-- Task 2: Failed Transfer 
begin;  
	update bank_accounts set balance = balance - 600 where account_id = 101; 
	--Transaction aborted here due to constraint failing, so rolled back  
	rollback;
	--update bank_accounts set balance = balance + 600 where account_id = 102; 
--commit;  

select * from bank_accounts; 

-- Task 3: Savepoint Checkpoints 

begin; 

INSERT INTO bank_accounts (account_id, owner_name, balance) VALUES (103, 'David Vault', 0.00);

--create savepoint after inserting new row 
savepoint vault_created; 

update bank_accounts set balance = balance - 300 where account_id = 101; 
update bank_accounts set balance = balance + 300 where account_id = 103;

--undoes the update statements 
rollback to savepoint vault_created;  

commit; 

select * from bank_accounts; 


