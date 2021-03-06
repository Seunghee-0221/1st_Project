DROP TABLE RATE;
CREATE TABLE RATE(
    rCODE NUMBER(1) PRIMARY KEY,
    rNAME VARCHAR2(20) NOT NULL
);
DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    mID VARCHAR2(20) PRIMARY KEY,
    mPW VARCHAR2(20) NOT NULL,
    mNAME VARCHAR2(30) NOT NULL,
    mNICKNAME VARCHAR2(30) NOT NULL UNIQUE,
    mBIRTH DATE NOT NULL,
    mEMAIL VARCHAR2(100),
    mADDRESS VARCHAR2(255),
    mJOINDATE DATE DEFAULT SYSDATE,
    rCODE REFERENCES RATE(rCODE)
);
DROP TABLE fBOARD;
DROP SEQUENCE fBOARD_SEQ;
CREATE SEQUENCE fBOARD_SEQ MAXVALUE 999999 NOCYCLE NOCACHE;
CREATE TABLE fBOARD(
    fbNO NUMBER(6) PRIMARY KEY,
    fbTITLE VARCHAR2(255) NOT NULL,
    fbCONTENT CLOB,
    fbFILENAME VARCHAR2(100),
    fbGROUP NUMBER(6),
    fbSTEP NUMBER(3),
    fbINDENT NUMBER(3),
    fbHIT NUMBER(6) DEFAULT 0,
    fbDATE DATE DEFAULT SYSDATE,
    mID REFERENCES MEMBER(mID) ON DELETE CASCADE
);
DROP TABLE fbCOMMENT;
DROP SEQUENCE fbCOMMENT_SEQ;
CREATE SEQUENCE fbCOMMENT_SEQ MAXVALUE 999999 NOCYCLE NOCACHE;
CREATE TABLE fbCOMMENT(
    fbCNO NUMBER(6) PRIMARY KEY,
    fbNO REFERENCES fBOARD(fbNO) ON DELETE CASCADE,
    mID REFERENCES MEMBER(mID) ON DELETE CASCADE,
    fbCOMMENT VARCHAR2(1000) NOT NULL,
    fbCDATE DATE DEFAULT SYSDATE
);
DROP TABLE nBOARD;
DROP SEQUENCE nBOARD_SEQ;
CREATE SEQUENCE nBOARD_SEQ MAXVALUE 999999 NOCYCLE NOCACHE;
CREATE TABLE nBOARD(
    nbNO NUMBER(6) PRIMARY KEY,
    nbTITLE VARCHAR2(255) NOT NULL,
    nbCONTENT CLOB,
    nbHIT NUMBER(6) DEFAULT 0 NOT NULL,
    nbLIKE NUMBER(6) DEFAULT 0 NOT NULL,
    nbDATE DATE DEFAULT SYSDATE,
    mID REFERENCES MEMBER(mID) ON DELETE CASCADE
);
DROP TABLE nbLIKE;
DROP SEQUENCE nbLIKE_SEQ;
CREATE SEQUENCE nbLIKE_SEQ MAXVALUE 99999999 NOCYCLE NOCACHE;
CREATE TABLE nbLIKE(
    nbLNO NUMBER(8) PRIMARY KEY,
    mID REFERENCES MEMBER(mID) ON DELETE CASCADE,
    nbNO REFERENCES nBOARD(nbNO) ON DELETE CASCADE
);
DROP TABLE nbCOMMENT;
DROP SEQUENCE nbCOMMENT_SEQ;
CREATE SEQUENCE nbCOMMENT_SEQ MAXVALUE 999999 NOCYCLE NOCACHE;
CREATE TABLE nbCOMMENT(
    nbCNO NUMBER(6) PRIMARY KEY,
    nbNO REFERENCES nBOARD(nbNO) ON DELETE CASCADE,
    mID REFERENCES MEMBER(mID) ON DELETE CASCADE,
    nbCOMMENT VARCHAR2(1000) NOT NULL,
    nbCDATE DATE DEFAULT SYSDATE
);
DROP TABLE rBOARD;
DROP SEQUENCE rBOARD_SEQ;
CREATE SEQUENCE rBOARD_SEQ MAXVALUE 999999 NOCYCLE NOCACHE;
CREATE TABLE rBOARD(
    rbNO NUMBER(6) PRIMARY KEY,
    rbTITLE VARCHAR2(255) NOT NULL,
    rbCONTENT CLOB,
    rbHIT NUMBER(6) DEFAULT 0,
    rbLIKE NUMBER(6) DEFAULT 0,
    rbDATE DATE DEFAULT SYSDATE,
    mID REFERENCES MEMBER(mID) ON DELETE CASCADE
);
DROP TABLE rbLIKE;
DROP SEQUENCE rbLIKE_SEQ;
CREATE SEQUENCE rbLIKE_SEQ MAXVALUE 99999999 NOCYCLE NOCACHE;
CREATE TABLE rbLIKE(
    rbLNO NUMBER(8) PRIMARY KEY,
    rbNO REFERENCES rBOARD(rbNO) ON DELETE CASCADE,
    mID REFERENCES MEMBER(mID) ON DELETE CASCADE
);
DROP TABLE rbCOMMENT;
DROP SEQUENCE rbCOMMENT_SEQ;
CREATE SEQUENCE rbCOMMENT_SEQ MAXVALUE 999999 NOCYCLE NOCACHE;
CREATE TABLE rbCOMMENT(
    rbCNO NUMBER(6) PRIMARY KEY,
    rbNO REFERENCES rBOARD(rbNO) ON DELETE CASCADE,
    mID REFERENCES MEMBER(mID) ON DELETE CASCADE,
    rbCOMMENT VARCHAR2(1000) NOT NULL,
    rbCDATE DATE DEFAULT SYSDATE
);
DROP TABLE ADMINASTOR;
CREATE TABLE ADMINASTOR(
    aID VARCHAR2(20) PRIMARY KEY,
    aPW VARCHAR2(20) NOT NULL,
    aMASTER NUMBER(1) DEFAULT 0
);
DROP TABLE NOTICE;
DROP SEQUENCE NOTICE_SEQ;
CREATE SEQUENCE NOTICE_SEQ MAXVALUE 999999 NOCYCLE NOCACHE;
CREATE TABLE NOTICE(
    nNO NUMBER(6) PRIMARY KEY,
    aID VARCHAR2(20),
    nTITLE VARCHAR2(255) NOT NULL,
    nCONTENT VARCHAR2(2000),
    nDATE DATE DEFAULT SYSDATE
);
DROP TABLE pCODE;
CREATE TABLE pCODE(
    pCODE VARCHAR2(10) PRIMARY KEY,
    pCODENAME VARCHAR2(50) NOT NULL
);
DROP TABLE PRODUCT;
DROP SEQUENCE PRODUCT_SEQ;
CREATE SEQUENCE PRODUCT_SEQ MAXVALUE 9999 NOCYCLE NOCACHE;
CREATE TABLE PRODUCT(
    pNO NUMBER(4) PRIMARY KEY,
    pCODE VARCHAR2(10) REFERENCES pCODE(pCODE),
    pNAME VARCHAR2(100) NOT NULL,
    pCONTENT CLOB,
    pPRICE NUMBER(8) NOT NULL,
    pImg VARCHAR2(255)
);
DROP TABLE PLIST;
DROP SEQUENCE PLIST_SEQ;
CREATE SEQUENCE PLIST_SEQ MAXVALUE 999999 NOCYCLE NOCACHE;
CREATE TABLE PLIST(
    PLNO NUMBER(6) PRIMARY KEY,
    MID REFERENCES MEMBER(MID) ON DELETE CASCADE,
    CPU NUMBER(4),
    MAINBOARD NUMBER(4),
    RAM NUMBER(4),
    VGA NUMBER(4),
    SSD NUMBER(4),
    HDD NUMBER(4),
    PCASE NUMBER(4),
    POWER NUMBER(4)
);


-- ★ 통합검색 (각 테이블을 따로 검색하여 게시판별로 최근글 최대 5개까지 출력) ★
SELECT * FROM (SELECT ROWNUM RN, R.* FROM (SELECT RB.*, M.MNICKNAME FROM RBOARD RB, MEMBER M WHERE RB.MID=M.MID AND RBTITLE LIKE '%'||'홍'||'%' ORDER BY RBNO DESC) R) WHERE RN BETWEEN 1 AND 5;
SELECT * FROM (SELECT ROWNUM RN, N.* FROM (SELECT NB.*, M.MNICKNAME FROM NBOARD NB, MEMBER M WHERE NB.MID=M.MID AND NBTITLE LIKE '%'||'동'||'%' ORDER BY NBNO DESC) N) WHERE RN BETWEEN 1 AND 5;
SELECT * FROM (SELECT ROWNUM RN, F.* FROM (SELECT FB.*, M.MNICKNAME FROM FBOARD FB, MEMBER M WHERE FB.MID=M.MID AND FBTITLE LIKE '%'||'T'||'%' ORDER BY FBGROUP DESC, FBSTEP) F) WHERE RN BETWEEN 1 AND 5;


-- ★ 회원 ★

-- 등급번호 입력
INSERT INTO RATE VALUES (1, '신규회원');
INSERT INTO RATE VALUES (2, '일반회원');
INSERT INTO RATE VALUES (3, '우수회원');

-- 아이디 중복체크
SELECT * FROM MEMBER WHERE MID='abcd';

-- 닉네임 중복체크
SELECT * FROM MEMBER WHERE MNICKNAME='서에번쩍';

-- 회원가입
INSERT INTO MEMBER (MID, MPW, MNAME, MNICKNAME, MBIRTH, MEMAIL, MADDRESS, RCODE) VALUES ('abcd', '1234', '홍길동', '동에번쩍', '1999-01-20', 'hong@tj.com', '서울시 종로구', 1);
INSERT INTO MEMBER (MID, MPW, MNAME, MNICKNAME, MBIRTH, MEMAIL, MADDRESS, RCODE) VALUES ('bbbb', '2222', '박길동', '서에번쩍', '1999-02-20', 'park@tj.com', '서울시 강북구', 1);
INSERT INTO MEMBER (MID, MPW, MNAME, MNICKNAME, MBIRTH, MEMAIL, MADDRESS, RCODE) VALUES ('cccc', '3333', '김길동', '남에번쩍', '1999-03-20', 'kim@tj.com', '서울시 노원구', 1);
INSERT INTO MEMBER (MID, MPW, MNAME, MNICKNAME, MBIRTH, MEMAIL, MADDRESS, RCODE) VALUES ('dddd', '4444', '최길동', '북에번쩍', '1999-04-20', 'choi@tj.com', '서울시 서초구', 1);

-- 회원 더미데이터 입력
BEGIN
FOR i IN 1..200 LOOP
INSERT INTO MEMBER (MID, MPW, MNAME, MNICKNAME, MBIRTH, MEMAIL, MADDRESS)
VALUES (CONCAT('user', i), '123123', CONCAT('user', i), CONCAT('user', i), '1999-01-20', 'user@tj.com', '서울시 종로구');
END LOOP;
END;
/
-- 로그인
SELECT * FROM MEMBER WHERE MID='abcd' AND MPW='1234';

-- 회원정보가져오기 (mId로 dto보기)
SELECT * FROM MEMBER WHERE MID='abcd';

-- 정보수정
UPDATE MEMBER SET MPW='123456', MNAME='갬길동', MNICKNAME='서남에번쩍', MBIRTH='1990-06-01', MEMAIL='hong2@tj.com', MADDRESS='강남' WHERE MID='abcd';

-- 회원탈퇴
DELETE MEMBER WHERE MID='abcd';

-- 회원등급 조정 (신규회원이면 게시판 글 작성시 일반회원으로)
UPDATE MEMBER SET RCODE=2 WHERE MID='qwer' AND RCODE=1;
select * from notice;

-- ★ 게시판 ★

-- 리뷰/사용기 게시판 글 작성 (더미글)
INSERT INTO RBOARD (RBNO, RBTITLE, RBCONTENT, MID) VALUES (RBOARD_SEQ.NEXTVAL, '홍길동전', '빨간동전이 놓인 길', 'abcd');
BEGIN
FOR i IN 1..200 LOOP
INSERT INTO RBOARD (RBNO, RBTITLE, RBCONTENT, MID)
VALUES (RBOARD_SEQ.NEXTVAL, CONCAT('홍길동전', i), '빨간동전이 놓인 길', 'abcd');
END LOOP;
END;
/
-- 리뷰/사용기 게시판 글 수정
UPDATE RBOARD SET RBTITLE='항길동전', RBCONTENT='길이다' WHERE RBNO=1;

-- 리뷰/사용기 게시판 글 삭제
DELETE FROM RBOARD WHERE RBNO=1;

-- 리뷰/사용기 게시판 글 조회수UP
UPDATE RBOARD SET RBHIT=RBHIT+1 WHERE RBNO=3;

-- 리뷰/사용기 게시판 글 상세보기 (RBNO로 DTO보기)
SELECT R.*, M.MNICKNAME FROM RBOARD R, MEMBER M WHERE R.MID=M.MID AND RBNO=3;

-- 리뷰/사용기 게시판 글 전체갯수
SELECT COUNT(*) FROM RBOARD;

-- 리뷰/사용기 게시판 글 목록(PAGING)
SELECT * FROM (SELECT ROWNUM RN, R.* FROM (SELECT R.*, M.MNICKNAME FROM RBOARD R, MEMBER M WHERE R.MID=M.MID ORDER BY RBNO DESC) R) WHERE RN BETWEEN 3 AND 5;

-- 리뷰/사용기 게시판 좋아요 여부확인
SELECT * FROM RBLIKE WHERE MID='abcd' AND RBNO=3;

-- 리뷰/사용기 게시판 좋아요 하기
UPDATE RBOARD SET RBLIKE=RBLIKE+1 WHERE RBNO=202;
INSERT INTO RBLIKE (RBLNO, MID, RBNO) VALUES (RBLIKE_SEQ.NEXTVAL, 'abcd', 3);

-- 리뷰/사용기 게시판 좋아요 취소
UPDATE NBOARD SET RBLIKE=RBLIKE-1 WHERE RBNO=3;
DELETE FROM RBLIKE WHERE MID='abcd' AND RBNO=3;

-- 리뷰/사용기 게시판 댓글 달기
INSERT INTO RBCOMMENT (RBCNO, RBNO, MID, RBCOMMENT) VALUES (RBCOMMENT_SEQ.NEXTVAL, 3, 'abcd', '안녕하세요');
INSERT INTO RBCOMMENT (RBCNO, RBNO, MID, RBCOMMENT) VALUES (RBCOMMENT_SEQ.NEXTVAL, 3, 'abcd', '안녕하세요2');

-- 리뷰/사용기 게시판 댓글 삭제
DELETE FROM RBCOMMENT WHERE RBCNO=2;

-- 리뷰/사용기 게시판 댓글 보기
SELECT R.*, M.MNICKNAME FROM RBCOMMENT R, MEMBER M WHERE R.MID=M.MID AND RBNO=201 ORDER BY RBCNO;

-- 뉴스/정보 게시판 글 작성
INSERT INTO NBOARD (NBNO, NBTITLE, NBCONTENT, MID) VALUES (NBOARD_SEQ.NEXTVAL, '홍길동전', '빨간동전이 놓인 길', 'abcd');

-- 뉴스/정보 게시판 더미글
BEGIN
FOR i IN 1..200 LOOP
INSERT INTO NBOARD (NBNO, NBTITLE, NBCONTENT, MID)
VALUES (NBOARD_SEQ.NEXTVAL, '녹길동전', '초록동전이 놓인 길', 'abcd');
END LOOP;
END;
/

-- 뉴스/정보 게시판 글 수정
UPDATE NBOARD SET NBTITLE='항길동전', NBCONTENT='길이다' WHERE NBNO=1;

-- 뉴스/정보 게시판 글 삭제
DELETE FROM NBOARD WHERE NBNO=1;

-- 뉴스/정보 게시판 글 조회수UP
UPDATE NBOARD SET NBHIT=NBHIT+1 WHERE NBNO=2;

-- 뉴스/정보 게시판 글 상세보기 (NBNO로 DTO보기)
SELECT N.*, M.MNICKNAME FROM NBOARD N, MEMBER M WHERE N.MID=M.MID AND NBNO=2;

-- 뉴스/정보 게시판 글 전체갯수
SELECT COUNT(*) FROM NBOARD;

-- 뉴스/정보 게시판 글 목록(PAGING)
SELECT * FROM (SELECT ROWNUM RN, N.* FROM (SELECT N.*, M.MNICKNAME FROM NBOARD N, MEMBER M WHERE N.MID=M.MID ORDER BY NBNO DESC) N) WHERE RN BETWEEN 1 AND 2;

-- 뉴스/정보 게시판 좋아요 여부확인
SELECT * FROM NBLIKE WHERE MID='abcd' AND NBNO=3;

-- 뉴스/정보 게시판 좋아요 하기
UPDATE NBOARD SET NBLIKE=NBLIKE+1 WHERE NBNO=209;
INSERT INTO NBLIKE (NBLNO, MID, NBNO) VALUES (NBLIKE_SEQ.NEXTVAL, 'abcd', 209);

-- 뉴스/정보 게시판 좋아요 취소
UPDATE NBOARD SET NBLIKE=NBLIKE-1 WHERE NBNO=209;
DELETE FROM NBLIKE WHERE MID='abcd' AND NBNO=209;

-- 뉴스/정보 게시판 댓글 달기
INSERT INTO NBCOMMENT (NBCNO, NBNO, MID, NBCOMMENT) VALUES (NBCOMMENT_SEQ.NEXTVAL, 209, 'abcd', '안녕하세요2');
INSERT INTO NBCOMMENT (NBCNO, NBNO, MID, NBCOMMENT) VALUES (NBCOMMENT_SEQ.NEXTVAL, 3, 'abcd', '안녕하세요2');

-- 뉴스/정보 게시판 댓글 삭제
DELETE FROM NBCOMMENT WHERE NBCNO=1;

-- 뉴스/정보 게시판 댓글 보기
SELECT N.*, M.MNICKNAME FROM NBCOMMENT N, MEMBER M WHERE N.MID=M.MID AND NBNO=3 ORDER BY NBCNO DESC;

-- 자유게시판 글 작성 (원글)
INSERT INTO FBOARD (FBNO, FBTITLE, FBCONTENT, FBFILENAME, FBGROUP, FBSTEP, FBINDENT, MID) VALUES (FBOARD_SEQ.NEXTVAL, 'TITLE1', 'CONTENT1', NULL, FBOARD_SEQ.CURRVAL, 0, 0, 'abcd');
INSERT INTO FBOARD (FBNO, FBTITLE, FBCONTENT, FBFILENAME, FBGROUP, FBSTEP, FBINDENT, MID) VALUES (FBOARD_SEQ.NEXTVAL, 'TITLE2', 'CONTENT2', NULL, FBOARD_SEQ.CURRVAL, 0, 0, 'abcd');
INSERT INTO FBOARD (FBNO, FBTITLE, FBCONTENT, FBFILENAME, FBGROUP, FBSTEP, FBINDENT, MID) VALUES (FBOARD_SEQ.NEXTVAL, 'TITLE3', 'CONTENT3', NULL, FBOARD_SEQ.CURRVAL, 0, 0, 'abcd');

-- 자유게시판 글 수정
UPDATE FBOARD SET FBTITLE='UPDATE1', FBCONTENT='uCONTENT1', FBFILENAME='NOTHING.jpg' WHERE FBNO=1;

-- 자유게시판 글 삭제
DELETE FROM FBOARD WHERE FBNO=2;

-- 자유게시판 글 조회수UP
UPDATE FBOARD SET FBHIT=FBHIT+1 WHERE FBNO=1;

-- 자유게시판 글 상세보기 (FBNO로 DTO보기)
SELECT F.*, M.MNICKNAME FROM FBOARD F, MEMBER M WHERE F.MID=M.MID AND FBNO=1;

-- 자유게시판 글 전체갯수
SELECT COUNT(*) FROM FBOARD;

-- 자유게시판 글 목록(PAGING)
SELECT * FROM (SELECT ROWNUM RN, F.* FROM (SELECT F.*, M.MNICKNAME FROM FBOARD F, MEMBER M WHERE F.MID=M.MID ORDER BY FBGROUP DESC, FBSTEP) F) WHERE RN BETWEEN 1 AND 10;

-- 자유게시판 댓글 달기
INSERT INTO FBCOMMENT (FBCNO, FBNO, MID, FBCOMMENT) VALUES (FBCOMMENT_SEQ.NEXTVAL, 3, 'abcd', '안녕하세요');

-- 자유게시판 댓글 삭제
DELETE FROM FBCOMMENT WHERE FBCNO=1;

-- 자유게시판 댓글 보기
SELECT F.*, M.MNICKNAME FROM FBCOMMENT F, MEMBER M WHERE F.MID=M.MID AND FBNO=3 ORDER BY FBCNO DESC;

-- 자유게시판 답변글 추가전 STEP A 수행 (원글과 FBGROUP이 같고 FBSTEP이 원글보다 큰 경우)
UPDATE FBOARD SET FBSTEP=FBSTEP+1 WHERE FBGROUP=1 AND FBSTEP>0;

-- 자유게시판 답변글 작성 (원글의 FBGROUP을 따른다)
INSERT INTO FBOARD (FBNO, FBTITLE, FBCONTENT, FBFILENAME, FBGROUP, FBSTEP, FBINDENT, MID) VALUES (FBOARD_SEQ.NEXTVAL, '답글', '답글내용', NULL, 1, 1, 1, 'bbbb');


-- ★ 관리자 ★

-- 최고관리자 등록하기 (기본데이터)
INSERT INTO ADMINASTOR VALUES ('Adminastor', 'admin123', 1);

-- 관리자 로그인
SELECT * FROM ADMINASTOR WHERE AID='Adminastor' AND APW='admin123';

-- 관리자 전체 리스트(최고관리자 제외)
SELECT * FROM ADMINASTOR WHERE AMASTER=0;

-- 관리자 아이디 중복체크
SELECT * FROM ADMINASTOR WHERE AID='Adminastor';

-- 부 관리자 등록
INSERT INTO ADMINASTOR (AID, APW) VALUES ('subadmin', '123456');
INSERT INTO ADMINASTOR (AID, APW) VALUES ('admin', '123456');

-- 부 관리자 삭제
DELETE FROM ADMINASTOR WHERE AID = 'subadmin' AND AMASTER=0;

-- 우수회원으로 등급조정
UPDATE MEMBER SET RCODE=3 WHERE MID='abcd';

-- 전체 회원수
SELECT COUNT(*) FROM MEMBER;

-- 전체 회원리스트 출력(PAGING)
SELECT * FROM (SELECT ROWNUM RN, M.* FROM (SELECT * FROM MEMBER ORDER BY MID) M) WHERE RN BETWEEN 1 AND 10;

-- 등급별 회원리스트(PAGING)
SELECT * FROM (SELECT ROWNUM RN, M.* FROM (SELECT * FROM MEMBER WHERE RCODE=1 ORDER BY MID) M) WHERE RN BETWEEN 1 AND 10;

-- 회원 탈퇴시키기
DELETE FROM MEMBER WHERE MID='dddd';

-- 게시판 글 삭제하기 (모든 글 삭제가능)
DELETE FROM RBOARD WHERE RBNO=1;
DELETE FROM NBOARD WHERE NBNO=1;
DELETE FROM FBOARD WHERE FBNO=2;


-- ★ 공지사항 ★

-- 공지사항 글 작성
INSERT INTO NOTICE (NNO, AID, NTITLE, NCONTENT) VALUES (NOTICE_SEQ.NEXTVAL, 'admin', '안녕하세요 회원', '반갑다');
INSERT INTO NOTICE (NNO, AID, NTITLE, NCONTENT) VALUES (NOTICE_SEQ.NEXTVAL, 'admin', '공지입니다1', '공지1');
INSERT INTO NOTICE (NNO, AID, NTITLE, NCONTENT) VALUES (NOTICE_SEQ.NEXTVAL, 'admin', '공지입니다2', '공지2');

-- 공지사항 글 삭제
DELETE FROM NOTICE WHERE NNO=1;

-- 공지사항 글 수정
UPDATE NOTICE SET NTITLE='공지변경', NCONTENT='변경입니다' WHERE NNO=3;

-- 공지사항 글 상세보기 (NNO로 DTO보기)
SELECT * FROM NOTICE WHERE NNO=3;

-- 공지사항 글 갯수
SELECT COUNT(*) FROM NOTICE;

-- 공지사항 리스트 (PAGING)
SELECT * FROM (SELECT ROWNUM RN, N.* FROM (SELECT * FROM NOTICE ORDER BY NNO DESC) N) WHERE RN BETWEEN 1 AND 5;


-- ★ PC견적 ★

-- PC견적 상품분류 입력
INSERT INTO PCODE VALUES ('CPU', 'CPU');
INSERT INTO PCODE VALUES ('MAINBOARD', '메인보드');
INSERT INTO PCODE VALUES ('RAM', '메모리');
INSERT INTO PCODE VALUES ('VGA', '그래픽카드');
INSERT INTO PCODE VALUES ('SSD', 'SSD');
INSERT INTO PCODE VALUES ('HDD', '하드디스크');
INSERT INTO PCODE VALUES ('PCASE', '케이스');
INSERT INTO PCODE VALUES ('POWER', '파워');

-- PC견적 더미상품입력
INSERT INTO PRODUCT (PNO, PCODE, PNAME, PCONTENT, PPRICE, PIMG) VALUES (PRODUCT_SEQ.NEXTVAL, 'CPU', '인텔 i-5', NULL, 200000, NULL);
INSERT INTO PRODUCT (PNO, PCODE, PNAME, PCONTENT, PPRICE, PIMG) VALUES (PRODUCT_SEQ.NEXTVAL, 'CPU', '라이젠 2600', NULL, 180000, NULL);
INSERT INTO PRODUCT (PNO, PCODE, PNAME, PCONTENT, PPRICE, PIMG) VALUES (PRODUCT_SEQ.NEXTVAL, 'MAINBOARD', 'ASUS', NULL, 200000, NULL);
INSERT INTO PRODUCT (PNO, PCODE, PNAME, PCONTENT, PPRICE, PIMG) VALUES (PRODUCT_SEQ.NEXTVAL, 'RAM', 'G.SKILL', NULL, 200000, NULL);
INSERT INTO PRODUCT (PNO, PCODE, PNAME, PCONTENT, PPRICE, PIMG) VALUES (PRODUCT_SEQ.NEXTVAL, 'VGA', '지포스', NULL, 200000, NULL);
INSERT INTO PRODUCT (PNO, PCODE, PNAME, PCONTENT, PPRICE, PIMG) VALUES (PRODUCT_SEQ.NEXTVAL, 'VGA', '라데온', NULL, 200000, NULL);
INSERT INTO PRODUCT (PNO, PCODE, PNAME, PCONTENT, PPRICE, PIMG) VALUES (PRODUCT_SEQ.NEXTVAL, 'SSD', 'SAMSUNG EVO', NULL, 200000, NULL);
INSERT INTO PRODUCT (PNO, PCODE, PNAME, PCONTENT, PPRICE, PIMG) VALUES (PRODUCT_SEQ.NEXTVAL, 'HDD', 'WD', NULL, 200000, NULL);
INSERT INTO PRODUCT (PNO, PCODE, PNAME, PCONTENT, PPRICE, PIMG) VALUES (PRODUCT_SEQ.NEXTVAL, 'PCASE', 'ABKO', NULL, 200000, NULL);
INSERT INTO PRODUCT (PNO, PCODE, PNAME, PCONTENT, PPRICE, PIMG) VALUES (PRODUCT_SEQ.NEXTVAL, 'POWER', 'FSP', NULL, 200000, NULL);

-- PC견적 제품정보 (PNO로 DTO보기)
SELECT P.*, C.PCODENAME FROM PRODUCT P, PCODE C WHERE P.PCODE=C.PCODE AND PNO=1;

-- PC견적 저장하기
INSERT INTO PLIST (PLNO, MID, CPU, MAINBOARD, RAM, VGA, SSD, HDD, PCASE, POWER) VALUES (PLIST_SEQ.NEXTVAL, 'abcd', 1, 3, 10, 4, 6, 7, 8, 9);

-- PC견적 삭제하기
DELETE FROM PLIST WHERE PLNO=6;

-- PC견적 불러오기 (mId별)
SELECT * FROM PLIST WHERE MID='qwer' ORDER BY PLNO DESC;

-- PLNO로 DTO보기
SELECT * FROM PLIST WHERE PLNO=1;

-- 제품 리스트 출력 (분류별 상품명순)
SELECT P.*, C.PCODENAME FROM PRODUCT P, PCODE C WHERE P.PCODE = C.PCODE AND P.PCODE='CPU' ORDER BY PNAME;

-- 제품 등록
INSERT INTO PRODUCT (PNO, PCODE, PNAME, PCONTENT, PPRICE, PIMG) VALUES (PRODUCT_SEQ.NEXTVAL, 'CPU', '인텔 i-7', NULL, 300000, NULL);

-- 제품 수정
UPDATE PRODUCT SET PCODE='CPU', PNAME='인텔 i-9', PCONTENT='PCON', PPRICE=500000, PIMG=NULL WHERE PNO=11;

-- 제품 삭제
DELETE FROM PRODUCT WHERE PNO=11;

-- 메인화면 신규상품 4가지
SELECT * FROM (SELECT ROWNUM RN, PS.* FROM (SELECT P.*, PCODENAME FROM PRODUCT P, PCODE C WHERE P.PCODE = C.PCODE ORDER BY PNO DESC) PS) WHERE RN BETWEEN 1 AND 4;

