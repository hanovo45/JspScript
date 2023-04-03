package co.dev.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.controller.LoginFormControl;
import co.dev.controller.MainControl;
import co.dev.controller.MemberDeleteControl;
import co.dev.controller.MemberDeleteFormControl;
import co.dev.controller.MemberInserControl;
import co.dev.controller.MemberInsertFormControl;
import co.dev.controller.MemberListControl;
import co.dev.controller.MemberSearchControl;
import co.dev.controller.MemberSearchFormControl;
import co.dev.controller.MemberUpdateControl;
import co.dev.controller.MemberUpdateFormControl;
import co.dev.controller.NoticeAddControl;
import co.dev.controller.NoticeFormControl;
import co.dev.controller.NoticeListControl;
import co.dev.controller.NoticeModifyControl;
import co.dev.controller.NoticeRemovoControl;
import co.dev.controller.NoticeSearchControl;

public class FrontController extends HttpServlet{
	// url패턴과 실행 컨트롤러 등록
	// url - controller : map 등록
	
	Map<String, Control> map = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		
		map.put("/main.do", new MainControl());
		
		map.put("/login.do", new LoginControl());
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/logout.do", new LogoutControl());
		
		// 회원목록
		map.put("/memberList.do", new MemberListControl());
		
		//회원등록
		map.put("/memberInsertForm.do", new MemberInsertFormControl());
		//회원등록처리
		map.put("/memberInsert.do", new MemberInserControl());
		
		//회원조회화면
		map.put("/memberSearchForm.do", new MemberSearchFormControl());
		//회원조회후 화면
		map.put("/memberSearch.do", new MemberSearchControl());
		
		map.put("/memberUpdateForm.do", new MemberUpdateFormControl()); // 수정조회화면
		
		map.put("/memberUpdate.do", new MemberUpdateControl()); // 수정조회후 화면
		
		map.put("/memberDeleteForm.do", new MemberDeleteFormControl());
		
		map.put("/memberDelete.do", new MemberDeleteControl());
		
		// 공지사항 관련
		
		
		map.put("/noticeList.do", new NoticeListControl());	// 목록
		
		map.put("/noticeWriteForm.do", new NoticeFormControl()); // 공지사항 등록화면
		
		map.put("/noticeAdd.do", new NoticeAddControl()); // 공지사항 등록
		//getNotice(nid),selectNotice(nid)
		map.put("/noticeSearch.do", new NoticeSearchControl()); // 공지사항상세조회  
		
		map.put("/noticeModify.do", new NoticeModifyControl());	// 정보수정
		
		map.put("/noticeRemovo.do", new NoticeRemovoControl()); // 삭제
		// 사원목록 만들기 숙제
//		map.put("empList.do", new EmpListControl());    // 결과페이지 : member/empList.jsp
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// url - control 매칭
		String uri = req.getRequestURI();		// http://localhost:8080/HelloWeb/main.do
		String context = req.getContextPath();  // /HelloWeb
		String path = uri.substring(context.length());	// /main.do		uri이후 9글자뒤(?)의 주소읽음?
		System.out.println(path);
		
		Control sub = map.get(path);	// Parent parent = new Child(); 이해x
		sub.execute(req, resp);
		

	}
}
