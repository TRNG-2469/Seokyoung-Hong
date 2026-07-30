-- SQL Sublanguages practice 

-- Task 1) DDL 
alter table books add column category varchar(30);

-- Task 2) DML 
insert into members(member_id, name, email, signup_date)
values (5003, 'Cool Guy', 'coolguy@gmail.com', now());

-- Task 3) DQL 
select title from books where author = 'George Orwell'; 

-- Task 4) TCL 
begin; 
	insert into books(book_id, title, author)
	values (103, 'Life of PI', 'Yann Martel');
	
	savepoint insert_check;
	
	update books set title = 'Life of e' where book_id = 103;
	
	rollback to savepoint insert_check;  
commit;

-- Task 5) DCL 
create role guest_reader; 
grant select on books to guest_reader; 

