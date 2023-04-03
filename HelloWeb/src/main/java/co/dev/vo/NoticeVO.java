package co.dev.vo;

import java.util.Date;

import lombok.Data;

@Data
public class NoticeVO {
	
	// notice 테이블의 테이터 담아놓기 위한 객체 
	private int noticeId;	// oracle : notice_id -> noticeId 
	private String noticeWriter;   // notice_writer -> noticeWriter
	private String noticeTitle;
	private String noticeSubject;
	private Date createDate;
	private int hitCount;
	private String attach;
	
	
	
//	create table notice(
//			notice_id number primary key,
//			notice_writer varchar2(100) not null, -- 
//			notice_title varchar2(300) not null,
//			notice_subject varchar2(1000) not null, --내용
//			create_date date default sysdate, -- 등록일자
//			hit_count number default 0, -- 조회수
//			attach varchar2(100)  -- 첨부파일
//			);
}
