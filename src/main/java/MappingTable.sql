create table department(  
  dept_no     integer,  
  department_name      varchar(14),  
  location        varchar(13),  
  constraint pk_dept primary key (dept_no)  
);

create table employee(  
  emp_no    integer,  
  employee_name    varchar(10),  
  job      varchar(9),  
  manager      integer, 
  salary      integer,  
  comm     integer,  
  dept_no   integer,  
  constraint pk_emp primary key (emp_no),  
  constraint fk_deptno foreign key (dept_no) references department (dept_no)  
);

insert into department values(10, 'ACCOUNTING', 'NEW YORK');
insert into department values(20, 'RESEARCH', 'DALLAS');
insert into department values(30, 'SALES', 'CHICAGO');
insert into department values(40, 'OPERATIONS', 'BOSTON');

insert into employee values( 7839, 'KING', 'PRESIDENT', null, 5000, null, 10 );
insert into employee values( 7698, 'BLAKE', 'MANAGER', 7839, 2850, null, 30);
insert into employee values( 7782, 'CLARK', 'MANAGER', 7839, 2450, null, 10 );
insert into employee values( 7566, 'JONES', 'MANAGER', 7839, 2975, null, 20);
insert into employee values( 7788, 'SCOTT', 'ANALYST', 7566,  3000, null, 20);
insert into employee values( 7902, 'FORD', 'ANALYST', 7566, 3000, null, 20);
insert into employee values( 7369, 'SMITH', 'CLERK', 7902, 800, null, 20);
insert into employee values( 7499, 'ALLEN', 'SALESMAN', 7698, 1600, 300, 30 );
insert into employee values( 7521, 'WARD', 'SALESMAN', 7698, 1250, 500, 30);
insert into employee values( 7654, 'MARTIN', 'SALESMAN', 7698, 1250, 1400, 30);
insert into employee values( 7844, 'TURNER', 'SALESMAN', 7698, 1500, 0, 30);
insert into employee values( 7876, 'ADAMS', 'CLERK', 7788, 1100, null, 20 );
insert into employee values( 7900, 'JAMES', 'CLERK', 7698, 950, null, 30 );
insert into employee values( 7934, 'MILLER', 'CLERK', 7782, 1300, null, 10 );