create table book (
  book_code varchar2(15) primary key,	-- 도서코드
  book_title varchar2(50) not null,		-- 도서명
  book_author varchar2(50) not null,	-- 저자
  book_press varchar2(50) not null,		-- 출판사
  book_desc varchar2(500),				-- 도서평
  book_price int						-- 도서가격
);