-- Constructing SQL JOIN queries 

-- Sample Data 
INSERT INTO books (book_id, title, author, publishing_year, category)
VALUES
(1, 'Effective Java', 'Joshua Bloch', 2018, 'Programming'),
(2, 'Clean Code', 'Robert C. Martin', 2008, 'Programming'),
(3, 'The Hobbit', 'J.R.R. Tolkien', 1937, 'Fantasy'),
(4, '1984', 'George Orwell', 1949, 'Dystopian'),
(5, 'Atomic Habits', 'James Clear', 2018, 'Self-Help'),
(6, 'The Pragmatic Programmer', 'Andrew Hunt', 1999, 'Programming'),
(7, 'Dune', 'Frank Herbert', 1965, 'Science Fiction'),
(8, 'To Kill a Mockingbird', 'Harper Lee', 1960, 'Classic');

INSERT INTO members (member_id, name, email, signup_date, membership_status)
values
(1, 'Alice Johnson', 'alice@example.com', '2024-01-10', 'SUSPENDED'),
(2, 'Bob Smith', 'bob@example.com', '2024-03-18', 'EXPIRED'),
(3, 'Carol Davis', 'carol@example.com', '2024-05-02', 'ACTIVE'),
(4, 'David Wilson', 'david@example.com', '2024-07-15', 'EXPIRED'),
(5, 'Emma Brown', 'emma@example.com', '2025-01-20', 'ACTIVE');

INSERT INTO loans (book_id, member_id, loan_date, return_date)
VALUES
(1, 1, '2026-07-01', '2026-07-10'),
(2, 1, '2026-07-12', NULL),
(3, 2, '2026-07-05', '2026-07-15'),
(4, 3, '2026-07-18', NULL),
(5, 5, '2026-07-20', '2026-07-28'),
(7, 2, '2026-07-22', NULL);

-- Query 1: All active loans 
select m.name, b.title, l.loan_date 
from loans l
inner join books b 
on b.book_id = l.book_id  
inner join members m 
on m.member_id = l.member_id  
where l.return_date is null 

-- Query 2: Identify inactive members 
select m.name, l.loan_date 
from members m 
left join loans l 
on m.member_id = l.member_id  

-- Query 3: Members with zero borrowings 
select m.name 
from members m 
left join loans l 
on m.member_id = l.member_id  
where l.member_id is null;

-- Query 4: Detailed Book Checkout Catalog 
select m.name, b.title, b.author, l.loan_date 
from members m 
join loans l 
on m.member_id = l.member_id  
join books b on 
b.book_id = l.book_id 

-- Query 5: Overdue Borrowing Log 
select m.name, m.email, b.title, l.loan_date 
from loans l 
join members m 
on m.member_id = l.member_id  
join books b on 
b.book_id = l.book_id  
where l.loan_date < '2026-07-01' and return_date is null; 

-- :D 