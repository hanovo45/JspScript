package co.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.membership.MemberImpl;

import co.dev.common.Control;
import co.dev.service.MemberService;
import co.dev.service.MemberServiceImpl;

public class MemberDeleteControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		MemberService service = new MemberServiceImpl();
		String id = req.getParameter("id");
		
		boolean r = service.removeMember(id);
		
		if(r) {
			req.setAttribute("result", "정상처리완료");
		}else {
			req.setAttribute("result", "예외 발생");
		}
		
		try {
			req.getRequestDispatcher("WEB-INF/member/memberDeleteOutput.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		// MemberService, MemberDAO
	}

}
