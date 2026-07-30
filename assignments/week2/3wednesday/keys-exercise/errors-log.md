## Orphan test error message 
Error message received:  
```
SQL Error [23503]: ERROR: insert or update on table "loans" violates foreign key constraint "loans_member_id_fkey"
  Detail: Key (member_id)=(9999) is not present in table "members".

Error position:
``` 

## Duplicate email check 
Error message received:  
```
SQL Error [23505]: ERROR: duplicate key value violates unique constraint "members_email_key"
  Detail: Key (email)=(john@email.com) already exists.

Error position:
```
