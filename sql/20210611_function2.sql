-- 2021.06.11

-- 그룹함수
-- 여러행을 묶어 처리하는 함수
-- sum, avg, count, max, min

-- 사원 테이블에서 
-- 1. 사원의 수
-- 2. 사원의 급여 총합
-- 3. 급여 평균
-- 4. 최대 급여
-- 5. 최소 급여
-- count(*) 행전체 , round 반올림
select count(*) as "사원의 수", 
       sum(sal) as "급여의 총합",
       round(avg(sal), 2) as "급여 평균",
       max(sal) as "최대 급여",
       min(sal) as "최소 급여",
       sum(comm) as "커미션의 총합", -- 그룹함수는 nul 값을 제외하고 연산
       avg(comm) as "커미션의 평균",
       count(comm) as "커미션 받는 사원의 수"
from emp
;


select count(distinct job)
from emp
;

--마당서적 book 테이블에 책을납품하는 출판사
select count(distinct publisher)
from book
;

--특정 컬럼을 이용해서 그룹핑하기 -> group by
-- select 그룹핑할 기준의 컬럼, 그룹함수
-- from 테이블
-- where
-- group by 그룹핑할 기준의 컬럼

-- 부서별 급여 평균을 구해보자
select avg(sal) from emp where deptno =10;
select avg(sal) from emp where deptno =20;
select avg(sal) from emp where deptno =30;