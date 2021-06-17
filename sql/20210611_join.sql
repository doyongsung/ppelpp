-- 2021.06.11

-- JOIN : 스키마의 합

-- CROSS JOIN
-- 스키마의 합 : 집합의 곱 연산과 같다

select *
from emp, dept
;

-- ansi cross join
select * 
from emp cross join dept
;


-- EQUI JOIN

select *
from emp, dept
where emp.deptno=dept.deptno
;

select * from orders;
select * from customer;
select * from book;

select o.orderid, c.name, b.bookname
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid
order by o.orderid
;

-- ansi -> inner join
-- 오라클 EQUI JOIN

select *
from emp, dept
where emp.deptno=dept.deptno
;

select *
from emp e inner join dept d
on e.deptno=d.deptno
;







-- 이름이 SCOTT인 사람의 where e.ename='SCOTT'
--  부서명을 출력해봅시다. 
-- 출력해야하는 컬럼을 가지는 테이블을 확인해보자
-- 이름 : emp, 부서명 : dept
select e.ename, d.dname , d.deptno
from emp e, dept d
where e.deptno = d.deptno --and ename='SCOTT'
      and e.ename='SCOTT'
order by d.dname, e.ename
;

select *
from emp e inner join dept d
on e.deptno=d.deptno
where e.ename='SCOTT'
;

-- 비교하는 컬럼의 이름이 같을 때
-- on 절을 생략하고 -> using 을 이용하면 조건식을 간략하게 처리
select *
from emp e inner join dept d
--on e.deptno=d.deptno
using (deptno)
where e.ename='SCOTT'
;

-- NATURAL JOIN
select *
from emp NATURAL JOIN dept
;

select *
from emp ,dept
where emp.deptno = dept.deptno
;




-- self JOIN : 자기 자신을 조인 ( 참조 )
-- emp -> mgr 컬럼이 emp.empno 참조
select e.empno, e.ename, e.mgr , m.ename
from emp e, emp m
where  e.mgr=m.empno(+)
;

-- outer JOIN
select e.empno, e.ename, e.mgr , m.ename
from emp e, emp m
where  e.mgr=m.empno(+)  --> 표현하고자 하는 컬럼이 테이블의 반대쪽, null 값을 가지는 위치에 (+) 
;

-- [left | right | full] outer join
select e.ename, e.mgr, m.ename as "관리자"
--from emp e left outer join emp m
from emp m right outer join emp e
on e.mgr=m.empno
;





-- NON EQUI JOIN
-- 동등 비교가 아닌 크다 작다와 같은 비교로 조인의 조건을 작성

select * from salgrade;

select e.ename, e.sal, s.grade, s.losal, s.hisal
from emp e, salgrade s
--where e.sal>=s.losal and e.sal<=s.hisal
where sal between s.losal and s.hisal
order by e.ename
;

-- 회원별 구매 내역출력
select c.name--, count(o.orderid) as "구매횟수", avg(saleprice)
from orders o , customer c
where o.custid(+)=c.custid
group by c.name
order by c.name
;

select name
from orders NATURAL join customer 
group by name
;

select * from customer;
