package co.dev.service;

import java.util.List;

import co.dev.vo.MemberVO;

public interface MemberService {
	
	// 회원 목록
	public List<MemberVO> getMembers();
	
	// 회원 등록
	public boolean addMember(MemberVO vo);
	
	// 회원 조회
	public MemberVO getMember(String id);
	
	// 회원 수정
	public boolean modifyMember(MemberVO vo);
	
	// 회원삭제
	public boolean removeMember(String id);
	
	// 로그인
	public MemberVO login(MemberVO vo);
	
}