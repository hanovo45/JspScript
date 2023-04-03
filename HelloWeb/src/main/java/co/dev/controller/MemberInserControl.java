package co.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;
import co.dev.service.MemberService;
import co.dev.service.MemberServiceImpl;
import co.dev.vo.MemberVO;

public class MemberInserControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		MemberService service = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pass");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		
		vo.setId(id);
		vo.setPasswd(pw);
		vo.setName(name);
		vo.setMail(mail);
		System.out.println("입력 : " +vo);
		
		boolean result = service.addMember(vo);
		System.out.println(result);
		
		if(result == true) {
			System.out.println("성공");
			req.setAttribute("message", "성공");
//			req.setAttribute("id", vo);
		}else {
			System.out.println("예외");
			req.setAttribute("message", "예외");
		}
		
		
		RequestDispatcher rd = //
				req.getRequestDispatcher("WEB-INF/member/memberInsertOutput.jsp");
		
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
}
