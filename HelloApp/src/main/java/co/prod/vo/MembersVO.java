package co.prod.vo;

import lombok.Data;

@Data
public class MembersVO {
	
	private String memberId;
	private String memberName;
	private String memberTel;
	private String memberAddr;
	private String memberPw;
	
//	member_id varchar2(20) primary key,
//	member_name varchar2(200) not null,
//	member_tel varchar2(20),
//	member_addr varchar2(100),
//	member_pw varchar2(20)
}
