
-- Task 1: Refactor DDL 
alter table books 
add constraint publishing_constraint 
check(publishing_year >= 1450 and publishing_year <= EXTRACT(YEAR FROM NOW())); 

alter table members 
add column membership_status varchar(25) default 'ACTIVE'; 

alter table members 
add constraint membership_valid_constraint  
check(membership_status in ('ACTIVE', 'SUSPENDED', 'EXPIRED'))

alter table loans 
add constraint loans_fkey_books  
foreign key (book_id) references books(book_id)
on delete cascade; 

alter table loans 
add constraint loans_fkey_members 
foreign key (member_id) references members(member_id)
on delete restrict;

-- Task 2: Verify CHECK, DEFAULT constraints 
-- Note: I believe first instruction has an error, it should be a member inserted 
insert into members(member_id, name, email, signup_date) 
values (15, 'New Seoky', 'newseoky@gmail.com', now()); 

select membership_status from members where member_id = 15; 

insert into books(book_id, title, author, publishing_year, category)
values (15, 'hi', 'authorauthor', 1200, 'cool category');

update members set membership_status='BLOCKED' where member_id = 15; 


-- Task 3: Verify CASCADES 
insert into books(book_id, title, author, publishing_year, category)
values (15, 'hi', 'authorauthor', 1900, 'cool category');
insert into loans(book_id, member_id, loan_date) values(15, 15, now());

select * from loans; 

delete from books where book_id = 15; 

insert into books(book_id, title, author, publishing_year, category)
values (15, 'hi', 'authorauthor', 1900, 'cool category');
insert into loans(book_id, member_id, loan_date) values(15, 15, now());

delete from members where member_id = 15; 
