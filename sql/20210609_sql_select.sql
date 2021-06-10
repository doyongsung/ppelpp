-- (1) 도서번호가1인도서의이름
select bookname
from book
where bookid = 1
;
-- (2) 가격이20,000원이상인도서의이름
select bookname
from book
where price >= 20000
;
-- (3) 박지성의총구매액(박지성의고객번호는1번으로놓고작성)
select sum(saleprice) 
from orders
where custid = 1
;
-- (4) 박지성이구매한도서의수(박지성의고객번호는1번으로놓고작성)
select count(custid) 
from orders
where custid = 1
;
-- 2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.

-- (1) 마당서점도서의총개수
-- (2) 마당서점에도서를출고하는출판사의총개수
-- (3) 모든고객의이름, 주소s
select name, address
from customer
;
-- (4) 2014년7월4일~7월7일사이에주문받은도서의주문번호
select orderid
from orders
where orderdate >= '14/07/04' and orderdate <= '14/07/07'
;
-- (5) 2014년7월4일~7월7일사이에주문받은도서를제외한도서의주문번호
select orderid
from orders
where not (orderdate >= '14/07/04' and orderdate <= '14/07/07')
;
-- (6) 성이‘김’씨인고객의이름과주소
select name, address
from customer
where name like '김%'
;
-- (7) 성이‘김’씨이고이름이‘아’로끝나는고객의이름과주소
select name, address
from customer
where name like '김%아'
;