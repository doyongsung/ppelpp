-- 20210616

-- DML


-- 테스트 테이블 생성

CREATE table dept01
as
select * from dept where 1 =0;



-- 데이터 입력 : 행단위 입력
-- insert into 데이블명 (컬럼명,...) values (데이터, 데이터,...)
-- 입력하고자 하는 컬럼과 입력데이터의 개수는 일치
-- 컬럼의 도메인과 입력데이터의 타입이 일치
-- 기본키와 같이 not null 인경우 컬럼을 생략하면 안됌

desc dept01;
select * from dept01;

-- 1번부서 개발팀 서울 위치
--insert into dept01(deptno,dname,loc)
--            values(10, '개발팀','서울');
            

            
-- 데이터 저장할 컬럼기술을 생략 가능!
-- 모든 컴럴믜 데이터를 ㅇ입력할 때
-- vvalues 질의 데이터의 순서 :테이블이 생성될때 저의된 컬럼순의 순서
desc dept01;

--insert into dept01 values (20, '마케팅','부산');                       '

desc emp;

insert into emp (empno, deptno) values (7777,60);
select * from emp;

rollback;

desc orders;

insert into orders (orderid,custid, bookid) values (11, 6, 11);


 -- 서브 쿼리를 이용해서 데이터 입력
 drop table dept02;
 
 create table dept02
 as select * from dept where 1=0;
 select * from dept02;
 
 
 -- 데이터 입력
 insert into dept02
 select*from dept;

insert into dept02
select * from dept02;

-- 데이터를 변경 : 행단위로 선택하고 변경하고자하는 컬럼을 기술
-- update 테이블 명 set 컬럼이름 = 새로운 데이터, 컬럼이름 = 새로운데이터 where 행을 선택하는 조건

create table dept03
as select * from dept
;
select * from dept03;

--모든 부서의 위치를 seoul로 이동
update dept03
set loc = 'SEOUL'
;
--where 
-- 10번 부서의 위치를 PUSAN이동, 부서이름도 DEV 변경
-- 순서상관없음
UPDATE dept03
set loc = 'PUSAN', dname = null
where deptno = 10
;

-- emp01 새롭게 생성하고 update
drop table emp01;
create table emp01
as select *from emp;

select * from emp01;

-- 모든 사원의 부서번호를 30번으로 수정합시다.
update emp01
set deptno = 30;

-- 이번엔 모든 사원의 급여를 10% 인상시키는 update 문.
update emp01
set sal =  sal*1.1
;

-- 모든 사원의 입사일을 오늘로 수정.
update emp01
set hiredate = sysdate
;

rollback;
select * from emp01;
--부서번호가 10번인 사원의 
-- 부서번호를 30번으로 수정합시다.
update emp01
set deptno =30
where deptno = 10
;

-- 급여가 3000 이상인 사원만 급여를 10% 인상합니다.
update emp01
set sal = sal*1.1
where sal >= 3000
;

-- 1983년에 입사한 사원의 
-- 입사일이 오늘로 수정합시다.
update emp01
set hiredate = sysdate
where substr(hiredate, 1,2) = '81'
;

-- SCOTT 사원의 부서번호는 20번으로, 직급은 MANAGER로 한꺼번에 수정하도록 합시다
UPDATE emp01
set deptno =30, job ='MANAGER'
where ename = 'SCOTT'
;

-- SCOTT 사원의 입사일자는 오늘로, 급여를 50으로 커미션을 4000으로 수정합시다
update emp01
set hiredate = sysdate, sal =50, comm =4000
where ename = 'SCOTT';

-- 20번 부서의 지역명을
-- 40번 부서의 지역명으로 변경하기 위해서 서브 쿼리문을 사용해 봅시다
insert into dept01
select * from dept
;
select loc from dept01 where deptno = 40;

update dept01
set loc =(select loc from dept01 where deptno = 40)
where deptno = 20
;

-- 서브 쿼리를 이용해서
-- 부서번호가 20인 부서의 부서명과 지역명을
-- 부서 번호가 10번인 부서와 동일하게 변경하도록 해 봅시다.
select * from dept01 where deptno = 10;
select * from dept01 where deptno = 20;

update dept01
set(dname,loc) = (select dname,loc from dept01 where deptno = 10)
where deptno = 20
;
select*from dept01;

-- 데이터의 삭제 : 행단위 삭제
-- delete from 테이블 이름 where 조건 

-- dept01 테이블의 모든 데이터를 삭제 하자
delete from dept01 ;

-- 이름이 SCOTT인 사원을 삭제
delete from emp01 where ename ='SCOTT';
SELECT * from emp01;

-- 사원 테이블에서 부서명이 SALES인 사원을 모두 삭제해봅시다.
SELECT * from dept where dname = 'SALES';
delete from emp01
where deptno = (SELECT deptno from dept where dname = 'SALES')
;