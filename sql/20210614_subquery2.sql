--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.

--(5) 박지성이구매한
-- 도서의출판사수
select sum(custid)
from orders
where custid=1
;

-- 박지성이 구매한 도서 ID
SELECT DISTINCT O.BOOKID
FROM ORDERS O, CUSTOMER C
WHERE O.CUSTID=C.CUSTID AND C.NAME='박지성'
;

select count(distinct publisher)
from customer c, orders o, book b
where c.custid = o. custid and o.bookid = b.bookid and c.name ='박지성';


--(6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이
select bookname,(price - saleprice) as num
from orders o natural join book b
where custid = 1
;

SELECT b.bookname, b.price, B.PRICE-o.saleprice AS PRICEGAP
FROM ORDERS O, CUSTOMER C, BOOK B
WHERE C.CUSTID=O.CUSTID AND O.BOOKID=B.BOOKID
AND C.NAME='박지성'
;

SELECT b.bookname, B.PRICE, B.PRICE-o.saleprice
FROM ORDERS O, BOOK B
WHERE O.BOOKID=B.BOOKID
AND CUSTID=(SELECT CUSTID FROM CUSTOMER WHERE NAME='박지성')
;
SELECT CUSTID FROM CUSTOMER WHERE NAME='박지성';

--(7) 박지성이구매하지않은 -->서브쿼리
-- 도서의이름 --> 결과 , 메인쿼리에서 찾아야함
select bookname
from book b
where not exists(select bookname from customer c,orders o
                   where c.custid = o.custid
                   and o.bookid = b.bookid
                   and c.name ='박지성')
                   ;
                   
SELECT bookid --*
FROM ORDERS O, CUSTOMER C
WHERE O.CUSTID=C.CUSTID AND C.NAME='박지성'
;


SELECT BOOKNAME, BOOKID
FROM BOOK
WHERE BOOKID NOT IN (
    SELECT O.BOOKID
    FROM ORDERS O, CUSTOMER C
    WHERE O.CUSTID=C.CUSTID AND C.NAME='박지성'
)
;
--2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.

--(8) 주문하지않은고객의이름(부속질의사용)
select name
from customer
where name not in (select name from orders o,customer c where o.custid = c.custid)
;


SELECT C.NAME
FROM ORDERS O, CUSTOMER C
WHERE O.CUSTID(+)=C.CUSTID 
AND O.ORDERID IS NULL
;

SELECT NAME
FROM CUSTOMER
WHERE CUSTID NOT IN (SELECT DISTINCT CUSTID FROM ORDERS)
;

SELECT DISTINCT CUSTID FROM ORDERS ;

--(9) 주문금액의총액과주문의평균금액
select sum(saleprice) as "total", avg(saleprice) as "AVGSALEPRICE"
from orders
;

--(10) 고객의이름과고객별구매액
select name,sum(saleprice)
from customer c , orders o
where c.custid = o.custid
group by name
;

select o.custid ,
(select c.name from customer c where o.custid =c.custid),
sum(saleprice)
from orders o
group by o.custid
;

--(11) 고객의이름과고객이구매한도서목록
select name , bookname
from customer c , book b ,orders o
where c.custid = o.custid and o.bookid = b.bookid
order by name
;
--(12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문
select *
from orders o1, book b1
where o1.bookid = b1.bookid 
                  and (price-saleprice) = (select max(price-saleprice) from orders o2, book b2 
                                           where o2.bookid = b2.bookid);
                                           
                                           
select max(b.price - o.saleprice)
from orders o, book b
where o.bookid = b.bookid
;

--(13) 도서의 판매액 평균보다
--     자신의 구매액 평균이 더높은 고객의 이름
select name
from customer natural join orders
having avg(saleprice) > (select round(avg(saleprice)) from orders o, customer c where o.custid = c.custid)
group by name
;

select avg(saleprice) from orders ;
select name,round(avg(saleprice)) from orders o, customer c where o.custid = c.custid
group by name
;

SELECT AVG(SALEPRICE) FROM ORDERS;


SELECT C.NAME, AVG(SALEPRICE)
FROM ORDERS O, CUSTOMER C
WHERE O.CUSTID=C.CUSTID
GROUP BY C.NAME
HAVING AVG(SALEPRICE)>(
    SELECT AVG(SALEPRICE) FROM ORDERS
)-- 평균 구매액
;

--3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.

--(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
select name
from customer c , book b, orders o
where c.custid = o.custid and b.bookid = o.bookid and name = '박지성'
;

--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름

