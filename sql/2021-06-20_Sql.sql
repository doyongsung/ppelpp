create table Contact (
  pidx number(6) CONSTRAINT Contact_pidx_pk PRIMARY key,
  name varchar(20) CONSTRAINT Contact_name_nn not null,
  phone varchar(20) CONSTRAINT Contact_phone_nn not null,
  address varchar(20) DEFAULT 'Bucheon' CONSTRAINT contact_address_nn not null,
  email varchar(20),
  FriendType VARCHAR(6) CONSTRAINT Contact_FriendType_ck check(FriendType in('univ','com','cafe'))not null,
  
  
  major varchar(20),
  grade number(1),
  company VARCHAR(20),
  dname varchar(20),
  job varchar(10),
  group varchar(20),
  nickname varchar(20)
);

select *from dept;
insert into dept values ('50','marketing','bucheon');
insert into dept(deptno,dname) values('60','marketing');

update dept 
set dname = 'SALES',loc = 'DALLAS'
where deptno = '60'
;

DELETE from dept
where deptno = '50';

select *from emp;
SELECT * FROM DEPT;

desc emp;

select *
from all_constraints
where table_name ='emp';

create index emp_index
on emp(ename);

create or replace view emp_view
as
select *
from emp e, dept d
where e.deptno = d.deptno;

update emp 
set deptno = (select deptno from emp where ename ='SCOTT');
select * from emp;