--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.

--(5) 박지성이구매한도서의출판사수
select sum(custid)
from orders
where custid=1
;
--(6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이
select bookname,(price - saleprice) as num
from orders o natural join book b
where custid = 1
;
--(7) 박지성이구매하지않은도서의이름
select bookname
from book b
where not exists(select bookname from customer c,orders o
                   where c.custid = o.custid
                   and o.bookid = b.bookid
                   and c.name ='박지성')
                   ;
--2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.

--(8) 주문하지않은고객의이름(부속질의사용)
select name
from customer
where name not in (select name from orders o,customer c where o.custid = c.custid)
;

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
--(11) 고객의이름과고객이구매한도서목록
select name , bookname
from customer c , book b ,orders o
where c.custid = o.custid and o.bookid = b.bookid
order by name
;
--(12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문

--(13) 도서의판매액평균보다자신의구매액평균이더높은고객의이름
​
--3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.

--(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름

--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름

