create table bank_details(
	bank_account numeric primary key,
	salary numeric
);

create table employee(  
  emp_no    numeric,  
  employee_name    varchar(10),  
  job      varchar(9),  
  manager      numeric, 
  bank_account      numeric,  
  comm     numeric,  
  dept_no   numeric,  
  constraint pk_emp primary key (emp_no),  
  constraint fk_bankAccount foreign key (bank_account) references bank_details (bank_account)
);

insert into bank_details values 
(12345, 10000),
(23456, 20000),
(34567, 30000),
(45678, 40000),
(56789, 50000);

insert into employee values( 7839, 'KING', 'PRESIDENT', null, 12345, null, 10 );
insert into employee values( 7698, 'BLAKE', 'MANAGER', 7839, 23456, null, 30);
insert into employee values( 7782, 'CLARK', 'MANAGER', 7839, 34567, null, 10 );
insert into employee values( 7566, 'JONES', 'MANAGER', 7839, 45678, null, 20);
insert into employee values( 7788, 'SCOTT', 'ANALYST', 7566,  56789, null, 20);