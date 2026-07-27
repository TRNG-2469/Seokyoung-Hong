--Perform DML 

-- Create table 
create table customers(
	customer_id int primary key,
	name varchar(50) not null,
	membership_tier varchar(20) default 'BRONZE'
)

-- Add some data to the table --- INSERT 
-- single row 
insert into customers (customer_id, name, membership_tier)
values (1, 'Alice', 'GOLD')

-- insert multiple rows 
insert into customers (customer_id, name, membership_tier)
values 
(2, 'John Doe', 'GOLD'),
(3, 'Mark', 'SILVER');

insert into customers (customer_id, name)
values 
(4, 'Jane Doe');

update customers 
set membership_tier = 'GOLD'
where customer_id = 4;

delete from customers
where customer_id = 1; 

-- IN CLASS ASSIGNMENT: Update statement to modify two column values 
update customers 
set membership_tier = 'BRONZE', name = 'Seokyoung Hong'
where customer_id = 2;















