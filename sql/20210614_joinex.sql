--32. EQUI 조인을 사용하여 SCOTT 사원의 부서번호와 부서 이름을 출력하시오.
SELECT E.ENAME, E.empno, m.DNAME
FROM DEPT m, EMP E
WHERE E.ENAME = 'SCOTT' AND m.DEPTNO = E. DEPTNO
;

-- ansi 이용
select emp.ename, emp.empno, dept.dname
from emp join dept
using (deptno)
where emp.ename ='SCOTT'
;

--33. INNER JOIN과 ON 연산자를 사용하여 사원 이름과 함께 그 사원이 소속된 부서이름과 지역 명을 출력하시오.
select e.ename,e.deptno , m.loc
from emp e inner join dept m
on e.deptno = m.deptno
order by e.deptno
;

select e.ename, m.dname, m.loc
from emp e inner join dept m
on e.deptno = m.deptno -- 조인의 조건
where e.ename ='SCOTT' -- 행을 선택하는 조건
;


--36. 조인과 WildCARD를 사용하여 이름에 ‘A’가 포함된 모든 사원의 이름과 부서명을 출력하시오.
select e.ename, m.dname
from emp e natural join dept m
where e.ename like '%A%'
;

SELECT e.ename, m.dname
FROM emp e, dept m
where e.deptno = m.deptno and e.ename like '%A%'
;

SELECT e.ename, m.dname
from emp e join dept m
using (deptno)
where e.ename like '%A%'
;

--37. JOIN을 이용하여 NEW YORK에 근무하는 모든 사원의 이름, 업무, 부서번호 및 부서명을 출력하시오.
select e.ename,e.job,e.deptno ,m.dname
from emp e, dept m
where m.loc = 'NEW YORK' and e.deptno = m.deptno
;

--38. SELF JOIN을 사용하여 사원의 이름 및 사원번호, 관리자 이름을 출력하시오.
select e.ename,e.empno,m.ename
from emp e, emp m
where e.mgr = m.empno
;
--39. OUTER JOIN, SELF JOIN을 사용하여 관리자가 없는 사원을 포함하여 사원번호를 기준으로 내림차순 정렬하여 출력하시오.
select e.ename,e.empno,m.ename
from emp e, emp m 
where e.mgr = m.empno(+)
order by empno desc
;

--40. SELF JOIN을 사용하여 지정한 사원의 이름, 부서번호, 지정한 사원과 동일한 부서에서 근무하는 사원을 출력하시오. ( SCOTT )
select e.ename,m.ename,e.deptno
from emp e, emp m
where e.deptno = m.deptno and e.ename ='SCOTT'
;

select ename from emp where deptno = 20;

select *
from emp e, emp m
where e.ename = 'SCOTT'
and e.deptno = m.deptno and m.ename != 'SCOTT'
;
--41. SELF JOIN을 사용하여 WARD 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하시오.
select e.ename,e.hiredate, m.ename
from emp e, emp m
where e.hiredate < m.hiredate and e.ename = 'WARD'
;

--42. SELF JOIN 을 사용하여 관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을 관리자의 이름 및 입사일과 함께 출력하시오.
select e.ename , e.hiredate , m.ename ,m.hiredate
from emp e, emp m
where e.hiredate < m.hiredate and m.mgr = e.empno
;
