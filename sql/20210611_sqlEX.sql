--16. SUBSTR 함수를 사용하여 사원들의 입사한 년도와 입사한 달만 출력하시오.
select substr(hiredate,1,5)
from emp
;

--17. SUBSTR 함수를 사용하여 4월에 입사한 사원을 출력하시오.
select ename
from emp
where substr(hiredate, 4, 2) = 4
;

--18. MOD 함수를 사용하여 사원번호가 짝수인 사람만 출력하시오.
select *
from emp
where mod(empno,2) =0
;
--19. 입사일을 년도는 2자리(YY), 월은 숫자(MM)로 표시하고 요일은 약어 (DY)로 지정하여 출력하시오.
select to_char(HIREDATE,'YY.MM.DY')
from emp
;
--20. 올해 몇 칠이 지났는지 출력하시오. 현재날짜에서 올해 1월 1일을 뺀 결과를 출력하고 TO_DATE 함수를 사용하여 데이터 형을 일치 시키시오.
select to_date('2021.01.01', 'YYYY.MM.DD'), trunc(sysdate - to_date('2021.01.01', 'YYYY.MM.DD'))
from emp
;
--21. 사원들의 상관 사번을 출력하되 상관이 없는 사원에 대해서는 NULL 값 대신 0으로 출력하시오.
select ename, nvl(MGR, 0)
from emp
order by MGR
;
--22. DECODE 함수로 직급에 따라 급여를 인상하도록 하시오. 직급이 ‘ANALIST”인 사원은 200, ‘SALESMAN’인 사원은 180, ‘MANAGER’인 사원은 150, ‘CLERK”인 사원은 100을 인상하시오.
select ename,job,sal,
        decode(job,'ANALIST', sal + 200,
                   'SALESMAN', sal + 180,
                   'MANAGER', sal + 150,
                   'CLERK', sal + 100
        ) as upsal
from emp
;
--23. 모든 사원의 급여 최고액, 최저액, 총액 및 평균 급여를 출력하시오. 평균에 대해서는 정수로 반올림하시오.
select max(sal), min(sal), sum(sal), round(avg(sal))
from emp
;

--24. 각 담당 업무 유형별로 급여 최고액, 최저액, 총액 및 평균 액을 출력하시오. 평균에 대해서는 정수로 반올림 하시오.
select job,max(sal),min(sal),sum(sal),round(avg(sal))
from emp
group by job
order by job
;
--25. COUNT(*) 함수를 이용하여 담당업무가 동일한 사원 수를 출력하시오.
select job,count(job)
from emp
group by job
;
--26. 관리자 수를 출력하시오.
select count(DISTINCT MGR)
from emp
;
--27. 급여 최고액, 급여 최저액의 차액을 출력하시오.
select max(sal)-min(sal)
from emp
;
--28. 직급별 사원의 최저 급여를 출력하시오. 관리자를 알 수 없는 사원과 최저 급여가 2000 미만인 그룹은 제외시키고 결과를 급여에 대한 내림차순으로 정렬하여 출력하시오.
select min(sal)
from emp
where mgr is not null
group by job
having not min(sal) <2000
order by min(sal) desc
;
--29. 각 부서에 대해 부서번호, 사원 수, 부서 내의 모든 사원의 평균 급여를 출력하시오. 평균 급여는 소수점 둘째 자리로 반올림 하시오.
select deptno,count(*), round(avg(sal),2)
from emp
group by deptno
order by deptno
;
--30. 각 부서에 대해 부서번호 이름, 지역 명, 사원 수, 부서내의 모든 사원의 평균 급여를 출력하시오. 평균 급여는 정수로 반올림 하시오. DECODE 사용.
-- 10 ACCOUNTING  NEW YORK
-- 20 RESEARCH  DALLAS
-- 30 SALES  CHICAGO
-- 40 OPERATIONS  BOSTON
select deptno,
       decode(deptno, 10 ,'ACCOUNTING',
                     20 ,'RESEARCH',
                     30 ,'SALES',
                     40 ,'OPERATIONS'),
        decode(deptno, 10 ,'NEW YORK',
                       20 ,'DALLAS',
                       30 ,'CHICAGO',
                       40 ,'BOSTON'),
                       count(*),round(avg(sal))
from emp
group by deptno
;
-- 31. 업무를 표시한 다음 해당 업무에 대해 부서 번호별 급여 및 부서 10, 20, 30의 급여 총액을 각각 출력하시오. 별칭은 각 job, dno, 부서 10, 부서 20, 부서 30, 총액으로 지정하시오. 
 select deptno as dno, job,
      decode (deptno, 10, sum(sal)) as "부서 10",
         decode (deptno, 20, sum(sal)) as "부서 20",
          decode (deptno, 30, sum(sal)) as "부서 30",              
         sum(sal) as "총액"
 from emp
 group by job,deptno
 order by deptno
 ;
--select deptno as dno, job,
--       nvl(sum(decode (deptno, 10, sal)),0) as "부서 10",
--        nvl(sum(decode (deptno, 20, sal)),0) as "부서 20",
--          nvl(sum(decode (deptno, 30, sal)),0) as "부서 30",              
--         sum(sal) as "총액"
--from emp
--group by job,deptno
--order by deptno
--;
--( hint. Decode, group by )