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

SELECT * from phoneInfo_basic;
COMMENT ON COLUMN phoneInfo_basic.fr_name IS '친구이름';
COMMENT ON COLUMN phoneInfo_basic.fr_phoneNumber IS '친구 전화번호';
COMMENT ON COLUMN phoneInfo_basic.fr_email IS '친구 이메일';
COMMENT ON COLUMN phoneInfo_basic.fr_address IS '친구 주소';
COMMENT ON COLUMN phoneInfo_basic.fr_regdate IS '등록 시간';





create table phoneInfo_univ(
        idx number(6) CONSTRAINT phoneInfo_univ_idx_pk PRIMARY KEY,
        fr_u_major varchar2(20) default 'N' not null,
        fr_u_year number(1) default 1 not null, CHECK ( 0 < fr_u_year and fr_u_year < 5),
        fr_ref number(7) CONSTRAINT phoneInfo_univ_FK REFERENCES phoneInfo_basic(idx) NOT NULL
);

COMMENT ON COLUMN phoneInfo_univ.fr_u_major IS '대학친구의 전공 정보';
COMMENT ON COLUMN phoneInfo_univ.fr_u_year IS '대학친구의 학년, CHECK(0 <NUM <5)';
COMMENT ON COLUMN phoneInfo_univ.fr_ref IS '친구의 기본 정보 외래키';

drop table phoneInfo_univ;
desc phoneInfo_univ;





create table phoneInfo_com(
        idx number(6) CONSTRAINT phoneInfo_com_idx_pk PRIMARY KEY,
        fr_c_company varchar2(20) default 'N' not null,
        fr_ref number(6) CONSTRAINT phoneInfo_com_FK REFERENCES phoneInfo_basic(idx) NOT NULL
 );
        
        comment on column phoneInfo_com.fr_c_company is '회사친구의 회사이름';
        comment on column phoneInfo_com.fr_ref is '친구의 기본 정보 외래키';
        
    drop table phoneInfo_com;
    desc phoneInfo_com;
