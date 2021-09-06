-- 멤버
CREATE TABLE final.member (
   `memberIdx` INTEGER NOT NULL AUTO_INCREMENT,
   `memberId`VARCHAR(50) NOT NULL, 
   `memberPw` VARCHAR(50) NOT NULL ,
   `memberName` VARCHAR(50) NOT NULL ,
   `memberEmail` VARCHAR(40) NOT NULL,
   `memberProfile` VARCHAR(100) NULL,
   `memberNickname` VARCHAR(50) NOT NULL,
   `memberRegdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
   `memberBirth` TIMESTAMP NULL,
    constraint pk_memberIdx PRIMARY KEY (memberIdx),
    constraint member_memberid_uq UNIQUE KEY (memberId),
	constraint member_memberNickname_uq UNIQUE KEY (memberNickname)
);

-- 사진게시판
CREATE TABLE final.photoBoard (
   `boardIdx` INTEGER NOT NULL AUTO_INCREMENT,
   `boardPhoto` VARCHAR(100) NOT NULL,
   `boardDiscription` text NULL,
   `boardDate` TIMESTAMP  NULL DEFAULT CURRENT_TIMESTAMP,
   `hashtag` varchar(200) NULL,
   `memberIdx` INTEGER NOT NULL,
    PRIMARY KEY (`boardIdx`),
    CONSTRAINT `FK_memberIdx_to_board` FOREIGN KEY (`memberIdx`) REFERENCES final.member(`memberIdx`)
);

-- 사진게시판-댓글
CREATE TABLE final.photoBoardComment (
   boardCommnetIdx INTEGER NOT NULL AUTO_INCREMENT ,
   comment text NOT NULL,
   commentDate TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
   boardIdx INTEGER NOT NULL,
   memberIdx INTEGER NOT NULL,
   PRIMARY KEY (`boardCommnetIdx`),
   CONSTRAINT `FK_boardIdx_to_boardComment` FOREIGN KEY (`boardIdx`) REFERENCES final.photoBoard(`boardIdx`),
   CONSTRAINT `FK_memberIdx_to_boardComment` FOREIGN KEY (`memberIdx`) REFERENCES final.member(`memberIdx`)
);

-- 크루
CREATE TABLE final.crew (
	`crewIdx` INTEGER NOT NULL auto_increment,
	`crewName` VARCHAR(50) NOT NULL,
    `crewPhoto` VARCHAR(100) NULL,
	`crewDiscription` TEXT NOT NULL,
	`crewCreatedate` timestamp default current_timestamp,
	`crewTag` varchar(200) NULL,
	`memberIdx` INTEGER NOT NULL,
    `memberNickName` VARCHAR(50),
    constraint pk_crewIdx primary key (crewIdx),
    constraint unique_crewName unique key (crewName),
    constraint fk_memberIdx_to_crewOwner foreign key (memberIdx) references final.member(memberIdx),
    constraint fk_memberName_to_crewCapName foreign key (memberNickName) references final.member(memberNickName)
);

-- 크루가입
CREATE TABLE final.crewreg (
	`crewRegIdx` INTEGER NOT NULL auto_increment,
	`crewRegdate` timestamp default current_timestamp,
	`memberIdx` INTEGER NOT NULL,
	`crewIdx` INTEGER NOT NULL,
    constraint pk_crewIdx primary key (crewRegIdx),
	constraint fk_memberIdx_to_crewReg foreign key (memberIdx) references final.member(memberIdx),
    constraint fk_crewIdx_to_crewReg foreign key (crewIdx) references final.crew(crewIdx)
);

-- 크루댓글
CREATE TABLE final.crewComment (
	`crewCommentIdx` INTEGER NOT NULL auto_increment,
	`crewComment` text NOT NULL,
	`crewCommentDate` timestamp default current_timestamp,
	`memberIdx` INTEGER NOT NULL,
	`crewIdx` INTEGER NOT NULL,
    constraint pk_crewCommentidx primary key (crewCommentIdx),
    constraint fk_memberIdx_to_crewComment foreign key (memberIdx) references final.member(memberIdx),
    constraint fk_crewIdx_to_crewComment foreign key (crewIdx) references final.crew(crewIdx)
);

-- 팔로우
CREATE TABLE final.follow (
	`followIdx` INTEGER NOT NULL auto_increment,
    `followDate` timestamp default current_timestamp,
    `memberIdx` INTEGER NOT NULL,
    `memberIdx2` INTEGER NOT NULL,
    constraint pk_followIdx primary key (followIdx),
    constraint fk_myMemberIdx foreign key (memberIdx) references final.member(memberIdx),
    constraint fk_followMemberIdx foreign key (memberIdx2) references final.member(memberIdx)
);

-- 좋아요
CREATE TABLE final.like (
	`likeIdx` INTEGER NOT NULL auto_increment,
    `likeDate` timestamp default current_timestamp,
	`memberIdx` INTEGER NOT NULL,
    `boardIdx` INTEGER NOT NULL,
    constraint pk_likeIdx primary key (likeIdx),
    constraint fk_myMemberIdx_to_like foreign key (memberIdx) references final.member(memberIdx),
    constraint fk_boardIdx foreign key (boardIdx) references final.photoboard(boardIdx)
);

-- 드랍테이블
drop table final.member;

drop table final.crew;
drop table final.crewreg;
drop table final.crewComment;

DROP TABLE IF EXISTS final.PhotoBoard;
DROP TABLE IF EXISTS final.PhotoBoardComment;

DROP TABLE IF EXISTS final.follow;
DROP TABLE IF EXISTS final.like;