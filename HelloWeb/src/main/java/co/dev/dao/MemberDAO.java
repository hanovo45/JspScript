package co.dev.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

import co.dev.common.DAO;
import co.dev.vo.MemberVO;

public class MemberDAO extends DAO{
	
	// 회원 삭제
	public int deleteMember(String id) {
		
		getConn();
		String sql = "delete from members where id=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			int r=psmt.executeUpdate();
			
			return r;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConn();
		}
		return 0;
	}
	
	// 회원 수정
	public int updateMember(MemberVO vo) {
		
		getConn();
		String sql = "update members set passwd=?,name=?,mail=? where id=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPasswd());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getMail());
			psmt.setString(4, vo.getId());
			
			int r=psmt.executeUpdate();
			
			return r;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConn();
		}
		return 0;//여기는 예외가 생겨서 catch문 지나고 되돌려진 값 없을때 돌려짐<<즉 false값을 보내주면 됨//ex> null보낸 조회문 참고
		//참고해서 이해하면 좀더 쉬울꺼에여
	}
	
	
	// 회원 조회
	public MemberVO selectMember(String id) {
		
		getConn();
		String sql = "select * from members where id =?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();	// id : 키,
			
			if(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setMail(rs.getString("mail"));
				
				return vo;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConn();
		}
		return null;
	}
	
	// 회원 등록
	public int insertMember(MemberVO vo) {
		
		getConn();
		String sql = "insert into members(id,name,passwd,mail) values(?,?,?,?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getPasswd());
			psmt.setString(4, vo.getMail());
			
			int r = psmt.executeUpdate();
			return r;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConn();
		}
		return 0;	//처리가 안됨
	}
	
	
	
	
	
	// 회원목록
		public List<MemberVO> memberList(){
			List<MemberVO> memberList = new ArrayList<>();
			
			getConn();
			String sql = "select * from members order by id";
			
			try {
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				
				while(rs.next()){
					MemberVO vo = new MemberVO();
					vo.setId(rs.getString("id"));
					vo.setName(rs.getString("name"));
					vo.setPasswd(rs.getString("passwd"));
					vo.setMail(rs.getString("mail"));
					
					memberList.add(vo);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				disConn();
			}
			return memberList;
		}


		
}
