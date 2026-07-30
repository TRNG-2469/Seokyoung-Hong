-- Task 1: Creating tables with key constraints 

create table books (
	book_id int primary key, 
	title varchar(100), 
	author varchar(50),
	publishing_year smallint
);

create table members (
	member_id int primary key, 
	name varchar(50), 
	email varchar(100) unique, 
	signup_date timestamp 
);

create table loans (
	book_id int references books(book_id), 
	member_id int references members(member_id), 
	loan_date timestamp, 
	return_date timestamp, 
	primary key (book_id, member_id, loan_date)
);

-- Task 2: Seed Valid Parental Records 
INSERT INTO books VALUES 
(101, 'The Hobbit', 'J.R.R. Tolkien'), 
(102, '1984', 'George Orwell');

INSERT INTO members VALUES 
(5001, 'John Doe', 'john@email.com'), 
(5002, 'Jane Smith', 'jane@email.com');

-- Task 3: 
-- 1) Orphan check 
INSERT INTO loans (member_id, book_id, loan_date)
VALUES (9999, 101, '2026-07-12'); -- Member 9999 does not exist!

-- 2) Duplicate email check 
INSERT INTO members VALUES (5003, 'Alex Jones', 'john@email.com');

