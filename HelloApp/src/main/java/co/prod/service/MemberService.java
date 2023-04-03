package co.prod.service;

import java.util.List;

import co.prod.vo.MemberVO;
import co.prod.vo.MembersVO;

public interface MemberService {
	// 회원목록.
	public List<MemberVO> getMembers();
	
	// jquery 회원목록
	public List<MembersVO> getMembersList();

	// 회원등록.
	public boolean addMember(MemberVO vo);
	
	// jquery 추가
	public boolean addMembers(MembersVO vo);

	// 회원조회.
	public MemberVO getMember(String id);

	// 회원수정처리.
	public boolean modifyMember(MemberVO vo);

	// 회원삭제처리.
	public boolean removeMember(String id);
	
	// jquery 삭제
	public boolean removeMembers(List<MembersVO> list);

	// id/pw 로그인 처리.
	public MemberVO login(MemberVO vo);
}
