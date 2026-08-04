-- Assignment: write stored procedure using single INOUT parameter 

-- Created stored procedure 
create or replace procedure  
make_awesome_name (
inout name varchar
) 
language plpgsql 
as $$
begin 
	SELECT CONCAT(name, ' the GREAT') 
	into name;
end;
$$; 

call make_awesome_name('Seoky');

-- Write a trigger to update changes 
CREATE TABLE inventory_audit_log (
    log_id SERIAL PRIMARY KEY,
    item_id INT NOT NULL,
    action_type VARCHAR(10) NOT NULL,
    old_quantity INT,
    new_quantity INT,
    changed_by VARCHAR(50) DEFAULT CURRENT_USER,
    changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Making the trigger function 
create or replace function fn_update_log()
returns trigger 
language plpgsql 
as $$ 
begin 
	insert into inventory_audit_log(item_id, action_type, old_quantity, new_quantity) 
	values (old.item_id, 'UPDATE', old.quantity, new.quantity);
	return new; 
end;
$$;


-- Attaching to updates 
create trigger trg_log_update 
before update on inventory 
for each row 
	execute function fn_update_log();

-- Testing trigger 
select * from inventory; 
select * from inventory_audit_log;

update inventory set quantity = quantity + 2 where item_id = 1; 

select * from inventory; 
select * from inventory_audit_log; 

-- The trigger updates the log with new quantity on update :) 



