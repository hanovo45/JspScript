package co.prod.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.prod.common.DataSource;
import co.prod.mapper.MemberMapper;
import co.prod.vo.MemberVO;
import co.prod.vo.MembersVO;

public class MemberServiceMybatis implements MemberService {

	// jdbc : MemberDAO dao;
	// mybatis: DataSource: SqlSessionFactory -> SqlSession;
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	// Mapper.xml 파일의 메소드를 호출.
	private MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);

	@Override
	public List<MemberVO> getMembers() {
		return mapper.getMembers();
	}

	@Override
	public boolean addMember(MemberVO vo) {
		return mapper.insertMember(vo) == 1;
	}

	@Override
	public MemberVO getMember(String id) {
		return null;
	}

	@Override
	public boolean modifyMember(MemberVO vo) {
		return false;
	}

	@Override
	public boolean removeMember(String id) {
		return mapper.deleteMember(id) == 1;
	}

	@Override
	public MemberVO login(MemberVO vo) {
		return mapper.login(vo);
	}

	@Override
	public List<MembersVO> getMembersList() {
		return mapper.getMembersList();
	}

	@Override
	public boolean addMembers(MembersVO vo) {
		return mapper.insertMembers(vo) == 1;
	}

	@Override
	public boolean removeMembers(List<MembersVO> list) {
		return mapper.deleteMembers(list) > 0;
	}

}
