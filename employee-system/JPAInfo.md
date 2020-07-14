#Problems occurred during concurrent transactions - 
 - Dirty Read: It occurs when one transaction reads data that is being modified by another transaction and has
 	not been committed by the first transaction.
 	
 - Non Repeatable Read: When a transaction reads same data more than once and each time it gets a different value.
 
 - Phanthom Read: When two same queries are executed and the number of rows retrieved are different,
 	either new rows are inserted or some rows are deleted. 
 	
#Isolation levels to solve the above problems - 
 - Read Uncommitted: It is lowest level of isolation, using this any transaction can read data even if it is
 	being modified.
 	
 - Read Committed: Using this isolation level a transaction can only read the data if it committed by another
 	transaction. A lock is performed by the transaction that is modifying the data.
 	
 - Repeatable Read: Using this isolation a lock is performed not only on the modified value but also on the data
 	that has been read during the transaction. If a transaction has read 1 row during the transaction then the
	entire row is locked.
	
 - Serializable: This is the highest level of isolation. It locks all the rows that are fetched during a transaction
 	satisfying a certain criteria. e.g - Select * from persons, now the entire table will be locked. No new row can 
 	either be deleted or inserted.