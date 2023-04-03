package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/queryTest")
public class QueryTestServlet extends HttpServlet{
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8"); // 요청정보의 인코딩 방식지정
		resp.setCharacterEncoding("utf-8"); // 응답정보의 인코딩 방식지정
		resp.setContentType("text/html;charset=utf-8"); // 컨텐트 타입지정
		// 사용자가 여러개의 값을 전송
		// 각 값을 System.out.print("콘솔에 출력");
		resp.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pwd");
		String name = req.getParameter("name");
		String hobby = req.getParameter("hobby");
		String gender = req.getParameter("gender");
		String religion = req.getParameter("religion");
		String intro = req.getParameter("introduction");
		
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		System.out.println("이름 : " + name);
		System.out.println("취미 : " + hobby);
		System.out.println("성별 : " + gender);
		System.out.println("종교 : " + religion);
		System.out.println("자기소개 : " + intro);
		
		PrintWriter out = resp.getWriter();
		
		out.print("결과");
		out.close();
	}
}
