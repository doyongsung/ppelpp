-- 20210615

-- DDL :데이터 정의어

-- 테이블 생성 : create table
-- 테이블 수정 : alter table
-- 테이블 삭제 : drop table

-- create table (
--  컬럼이름 타입 (사이즈) 제약조건 정의,
--   .....,
-- ) 

-- create table (
--  컬럼이름 타입 (사이즈) ,
--   .....,
--  제약조건 정의,
--   .....
-- ) 

-- 사원 테이블과 유사한 구조의
-- 사원번호, 사원이름, 급여 3개의 칼럼으로 구성된
-- EMP01 테이블을 생성해 봅시다.

create table EMP01 (
   empno number(4), -- 사원번호
   ename VARCHAR2(20), -- 사원이름
   sal number(6,2)
);

-- 서브 쿼리를 이용해서 기존 테이블의 구조를 복사하고 해당 튜플도 복사
-- 내용은 다 가져오지만 제약조건은 가져오지 않는다.
-- alter table 을 주고 추가적으로 제약조건을 걸어줘야함
------------------------------------------
create table emp02
as
select * from emp
;

select * from emp02;
------------------------------------------
create table emp03
as
select empno, ename,sal from emp
;

select * from emp03;
------------------------------------------
create table emp04
as
select * from emp where deptno= 30
;

select * from emp04;
------------------------------------------
create table emp05
as
select * from emp where 1 =2
;

select * from emp05;
------------------------------------------

-- 컬럼 추가 : ADD COLUMN 새로운 칼럼추가 맨 마지막에 추가, 자신이원하는 위치에 x
-- 컬럼 수정 : MODIFY COLUMN 기존칼럼 수정
-- 컬럼 삭제 : DROP COLUMN 기존칼럼 삭제

-- 테이블의 변경 : alter table
-- alter table { 테이블 이름} add
-- alter table { 테이블 이름} modify
-- alter table { 테이블 이름} drop

-- emp01 테이블에 job 컬럼을 추가해보자
alter table emp01
add(job varchar2(9) ) --베어링캐릭터 9자리
;
desc emp01;

-- emp01 테이블의 job 컬럼의 사이즈를 수정 9 -> 30
alter table emp01
modify(job varchar2(30) )
;

alter table emp01
modify(job varchar2(130) not null )
;

-- emp01 테이블의 job 컬럼을 삭제
alter table emp01
drop column job
;

-- 테이블 삭제
drop table emp06;
drop table emp02;

-- 새로운 테이블 생성
create table emp02
as
select * from emp;

select * from emp02;

-- 모든 행을 삭제 trucate : 롤백이 안된다

truncate table emp02;

-- 테이블의 이름 변경 -> rename 현재 이름 새 새로운 이름
rename emp02 to test;
desc emp02

-- 무결성 제약조건  필수조건인경우 not null
-- 제약 조건을 설정하는 방법은 컬럼 레벨과 테이블 레벨 두가지 방식 , not null 제약조건은 컬럼 레벨로만 정의 즉,컬럼바로옆에만
-- unique : 중복x항상유일한값 
-- ex(userid varchar(10) not null unique)
-- 기본키 : primary key : not null 조건과 unique 조건을 결합한 형태
-- 외래키 : foreign key : 참조되는 테이블의 칼럼의 값이 존재하면 허용한다.
-- check : 저장가능한 데이터의 값의 범위나 조건을 지정하여 설정한 값만 허용
-- default : sysdate 기본값 정의



drop table emp02;

create table emp02
as
select empno, ename,sal,job from emp where 1=0
;

--컬럼 레벨에서 제약 사항 정의
create table emp02 (
        empno number(4) constraint emp02_empno_pk primary key,--not null unique,
        ename varchar2(20) constraint emp02_ename_nn not null,
        sal number(6,2) constraint emp02_sal_ck check (sal > 500 and sal < 5000), --6자리 소수점2자리
        job varchar(20) default '미지정',
        deptno number constraint emp02_deptno_fk REFERENCES dept(deptno) --외래키 정의 foreign key
);

desc dept;

desc emp02;
-- values(); 안에 값을 집어넣을때는 컬럼 순서대로 입력        -- sal 1000.00 (6)       --deptno 50부터 없어서 오류
insert into emp02 (empno,ename,sal,job,deptno)
       values(1000, 'SON', 4000, 'MANAGER',40); --not null 컬럼이면 null값을 집어넣을수없다고 오류
       
-- 모든 컬럼에 데이터를 넣을 수도 있다. 다만 모든컬럼에 입력할때 생략가능 
insert into emp02 values(null, null, 10000, 'MANAGER');

SELECT * from emp02 ;

--테이블 레벨에서 제약 사항 정의
create table emp03 (
        empno number(4),-- constraint emp02_empno_pk primary key,--not null unique,
        ename varchar2(20), constraint emp03_ename_nn not null, -- not null 제약은 컬럼 레벨에서만 정의 가능
        sal number(6,2), constraint emp03_sal_ck check (sal > 500 and sal < 5000), --6자리 소수점2자리
        job varchar(20),-- default '미지정',
        deptno number,-- constraint emp02_deptno_fk REFERENCES dept(deptno), --외래키 정의 foreign key
        ----------------------------------------------------------------------------------
        --제약 정의
        constraint emp03_empno_pk primary key(empno), -- pk 제약
        constraint emp03_deptno foreign key(deptno) REFERENCES dept(deptno)

);