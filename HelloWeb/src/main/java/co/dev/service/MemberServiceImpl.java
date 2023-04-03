package co.dev.service;

import java.util.List;

import co.dev.dao.MemberDAO;
import co.dev.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	
	MemberDAO dao = new MemberDAO();
	
	public List<MemberVO> getMembers(){
		return dao.memberList();
	}

	@Override
	public boolean addMember(MemberVO vo) {
		return dao.insertMember(vo) == 1;
	}

	@Override
	public MemberVO getMember(String id) {
		return dao.selectMember(id);
	}

	@Override
	public boolean modifyMember(MemberVO vo) {
		
		return dao.updateMember(vo)>0;
	}

	@Override
	public boolean removeMember(String id) {
		return dao.deleteMember(id) == 1;
	}

	@Override
	public MemberVO login(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}


