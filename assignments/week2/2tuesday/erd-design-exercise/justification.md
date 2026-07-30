Since each Book contains an unique, and assumably non-null registratin code, we can use that as the 
primary key of the Book entity. Similarily, each Member has unique and non-null membership card number,
which we will use as the primary key. We model the relationship between the two through a junction table Loans, 
which can take one and only one book with a member. We use a junction table because many books can be associated with 
many members, through taking out additional loans. For the loan entity, we make a composite key, since loans can be 
associated with the same book and member, with different timestamps, in order to uniquely identify a loan. 