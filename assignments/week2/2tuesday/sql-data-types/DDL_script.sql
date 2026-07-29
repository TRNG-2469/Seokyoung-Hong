-- 1) Analyze the column specifications 
/* 
 * customer_id: int 
 * full_name: varchar 
 * email_address: varchar 
 * age: smallint 
 * credit_balance: decimal 
 * registered_at: timestamptz 
 *  
 */


-- 2) Write and Run the DDL script 
create table customers(
	customer_id int primary key, 
	full_name varchar(100) not null, 
	email_address varchar(100) unique, 
	age smallint check (age > 0), 
	credit_balance decimal(10, 2), 
	registered_at timestamptz
);

-- 3) Test, Verify Column Types 
select column_name, data_type, character_maximum_length 
from information_schema.columns 
where table_name = 'customers';

