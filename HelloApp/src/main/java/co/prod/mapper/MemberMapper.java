package co.prod.mapper;

import java.util.List;

import co.prod.vo.MemberVO;
import co.prod.vo.MembersVO;

public interface MemberMapper {
	// 매퍼(MemberMapper.xml) 에서 실행할 메소드 정의
	public List<MemberVO> getMembers();
	
	// jquery 리스트
	public List<MembersVO> getMembersList();

	// 로그인 용도.
	public MemberVO login(MemberVO vo);
	
	// 회원삭제.
	public int deleteMember(String id);
	// jquery 삭제
	public int deleteMembers(List<MembersVO> list);
	
	// 회원등록.
	public int insertMember(MemberVO vo);
	
	// jquery 용 등록
	public int insertMembers(MembersVO vo);
	
	
}
