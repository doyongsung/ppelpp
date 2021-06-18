-- 20210618

-- JDBC
select * from dept01;



insert into dept01 values (DEPT01_DEPTNO_SEQ.nextval, 'dev', 'SEOUL');

-- dept01 deptno 에 입력할 일련 번호 -> sequence

create sequence dept01_deptno_seq
start with 10
INCREMENT by 10
;

delete from dept01 where depnto =?;

update dept01 set dname=? , loc=? where deptno = ?
;

select * from dept;

select dept01_deptno_seq.nextval from dual;