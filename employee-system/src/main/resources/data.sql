insert into company(comp_id, comp_name, location, num_of_employyes)
	values (20001, 'Tata Motors', 'New Jersey', 50);
insert into company(comp_id, comp_name, location, num_of_employyes)
	values (20002, 'Tata Motors', 'New York', 30);
insert into company(comp_id, comp_name, location, num_of_employyes)
	values (20003, 'Nike', 'New Orleans', 20);
insert into company(comp_id, comp_name, location, num_of_employyes)
	values (20004, 'Apple', 'Washington DC', 45);
	

insert into pan(pan_id, pan_number, address)
	values (30001, 'BFNPJ1786F', 'New York');
insert into pan(pan_id, pan_number, address)
	values (30002, 'BKNQJ1796F', 'New Orleans');
insert into pan(pan_id, pan_number, address)
	values (30003, 'AFMPA2796L', 'San Fransisco');
insert into pan(pan_id, pan_number, address)
	values (30004, 'DPNKS1916K', 'New Jersey');
insert into pan(pan_id, pan_number, address)
	values (30005, 'EQNKJ1811J', 'San Diago');

insert into employee(emp_id, emp_name, dept_name, birth_date, pan_id, comp_id)
	values (10001, 'Clint Barton', 'Finance', '1981-04-27 00:00:00', 30001, 20001);
insert into employee(emp_id, emp_name, dept_name, birth_date, pan_id, comp_id)
	values (10002, 'Steve Rogers', 'Research', '1989-01-08 00:00:00', 30002, 20002);	
insert into employee(emp_id, emp_name, dept_name, birth_date, pan_id, comp_id)
	values (10004, 'Tony Stark', 'Finance', '1990-03-28 00:00:00', 30003, 20004);	
insert into employee(emp_id, emp_name, dept_name, birth_date, pan_id, comp_id)
	values (10005, 'Peter Parker', 'Finance', '1992-06-18 00:00:00', 30004, 20004);	
insert into employee(emp_id, emp_name, dept_name, birth_date, pan_id, comp_id)
	values (10006, 'Carol Denvers', 'Engineering', '1989-05-11 00:00:00', 30005, 20004);	

