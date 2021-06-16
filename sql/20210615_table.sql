CREATE table phoneInfo_basic(
      idx number(6),
      fr_name varchar2(20) not null,
      fr_phoneNumber varchar2(20) not null,
      fr_email varchar2(20),
      fr_address varchar2(20),
      fr_regdate date default sysdate,
      
      CONSTRAINT phoneInfo_basic_dxi_pk PRIMARY KEY (idx)
  
);

drop table phoneInfo_basic;

desc phoneInfo_basic;

insert into phoneInfo_basic(idx,fr_name,fr_phoneNumber,fr_email,fr_address) 
                                 values (1,'이성계','3344','hanmail.com','인천');
                                 
                         
update phoneInfo_basic
set fr_email = 'hanmail.net'
where idx = '1'
;

update phoneInfo_basic
set (fr_name,fr_email) = (select fr_name,fr_email from phoneInfo_basic where idx = 1)
where idx = 2;

update phoneInfo_basic
set fr_phoneNumber = (select fr_phoneNumber from phoneInfo_basic where idx = 1)
where idx = 2;

delete from phoneInfo_basic
where fr_name ='이성계'
;

delete from phoneInfo_basic
where idx = (select idx from phoneInfo_basic where fr_name ='도용성')
;

SELECT * from phoneInfo_basic;




create table phoneInfo_univ(
        idx number(6) CONSTRAINT phoneInfo_univ_idx_pk PRIMARY KEY,
        fr_u_major varchar2(20) default 'N' not null,
        fr_u_year number(1) default 1 not null, CHECK ( 0 < fr_u_year and fr_u_year < 5), --(fr_u_year between 1 and4)
        fr_ref number(7) CONSTRAINT phoneInfo_univ_FK REFERENCES phoneInfo_basic(idx) NOT NULL
       
);


insert into phoneInfo_univ values (2,'math',2,2);

select *
from phoneInfo_basic p,phoneInfo_univ u
where p.idx = u.idx
;

update phoneInfo_univ
set fr_u_major = 'korea'
;

delete from phoneInfo_univ
where idx = '1'
;


drop table phoneInfo_univ;
desc phoneInfo_univ;




select * from phoneInfo_univ;
create table phoneInfo_com(
        idx number(6) CONSTRAINT phoneInfo_com_idx_pk PRIMARY KEY,
        fr_c_company varchar2(20) default 'N' not null,
        fr_ref number(6) CONSTRAINT phoneInfo_com_FK REFERENCES phoneInfo_basic(idx) NOT NULL
 );
        
        
    drop table phoneInfo_com;
    desc phoneInfo_com;
    
    insert into phoneInfo_com VALUES (1,'회사',2);
    
    select * from phoneInfo_com;
    
    select *
    from phoneInfo_basic p , phoneInfo_com c
    where p.idx = c.idx
    ;
    
    update phoneInfo_com
    set fr_c_company ='직장'
    ;
    
    delete from phoneInfo_com
    where fr_c_company = '직장';

COMMENT ON COLUMN phoneInfo_basic.fr_name IS '친구이름';
COMMENT ON COLUMN phoneInfo_basic.fr_phoneNumber IS '친구 전화번호';
COMMENT ON COLUMN phoneInfo_basic.fr_email IS '친구 이메일';
COMMENT ON COLUMN phoneInfo_basic.fr_address IS '친구 주소';
COMMENT ON COLUMN phoneInfo_basic.fr_regdate IS '등록 시간';


COMMENT ON COLUMN phoneInfo_univ.fr_u_major IS '대학친구의 전공 정보';
COMMENT ON COLUMN phoneInfo_univ.fr_u_year IS '대학친구의 학년, CHECK(0 <NUM <5)';
COMMENT ON COLUMN phoneInfo_univ.fr_ref IS '친구의 기본 정보 외래키';


comment on column phoneInfo_com.fr_c_company is '회사친구의 회사이름';
comment on column phoneInfo_com.fr_ref is '친구의 기본 정보 외래키';
        
        
-- INSERT : CREATE
DESC phoneinfo_basic;
insert into phoneinfo_basic
values (1, 'KING', '010-0000-0000', 'king@gmail.com', 'KOREA', sysdate)
;
insert into phoneinfo_basic (idx, fr_name, fr_phonenumber)
values (2, 'SCOTT', '010-9999-9999')
;

-- SELECT : READ
select * from phoneinfo_basic;
select * from phoneinfo_basic where idx=2;

-- UPDATE : UPDATE
-- SCOTT의 이메일을 업데이트, 주소도 업데이트
-- SCOTT 의 idx -> 2
 update phoneinfo_basic
 set fr_email='scott@naver.com', fr_address='서울'
 where idx=2 --fr_name='SCOTT'
;

-- DELETE : DELETE
delete from phoneinfo_basic
where idx=1
;

----------------------------------------------------------------------

-- INSERT : CREATE 데이터 생성
-- 대학친구의 정보를 입력
-- 1 basic 정보 입력
insert into phoneinfo_basic
values (3, 'SON', '010-1111-1111', 'son@gmail.com', 'KOREA', sysdate)
;
-- 2. univ 정보 입력
insert into phoneinfo_univ
values (1, 'COMPUTER', 4, 3)
;

-- SELECT : READ   데이터 검색
select fr_name, pu.fr_u_major, pu.fr_u_year
from phoneinfo_basic pb , phoneinfo_univ pu
where pb.idx=pu.fr_ref
;

-- UPDATE : UPDATE 데이터 수정
-- 전공과 학년을 수정, idx 또는 외래키
update phoneinfo_univ
set fr_u_major='KOR', fr_u_year=1
where idx=1
;

-- DELETE : DELETE 데이터 삭제
delete from phoneinfo_univ
where idx=1
;
delete from phoneinfo_basic
where idx=3
;


----------------------------------------------------------------------

-- INSERT : CREATE
insert into phoneinfo_basic
values (4, 'PARK', '010-7777-7777', 'park@gmail.com', 'LONDON', sysdate)
;
insert into phoneinfo_com
values (1, 'NAVER', 4)
;

-- SELECT : READ
select fr_name, pb.fr_phonenumber, pb.fr_email, pb.fr_address, pc.fr_c_company
from phoneinfo_basic pb , phoneinfo_com pc
where pb.idx=pc.fr_ref
;

-- UPDATE : UPDATE
-- 회사정보를 수정
update phoneinfo_com
set fr_c_company='GOOGLE'
where idx=1
;

-- DELETE : DELETE
delete from phoneinfo_com
where idx=1
;
delete from phoneinfo_basic
where idx=4
;

-- 전체 친구 정보
select *
from phoneinfo_basic pb , phoneinfo_univ pu, phoneinfo_com pc
where pb.idx=pu.fr_ref(+) and pb.idx=pc.fr_ref(+)
;

