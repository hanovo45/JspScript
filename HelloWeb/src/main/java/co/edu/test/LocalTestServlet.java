package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/local")
public class LocalTestServlet extends HttpServlet{
	
	String str;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String str = req.getParameter("msg");  -> 지역변수 = 여러개의 사용ㅇ
		
		str = req.getParameter("msg");		// 필드선언 = 클래스내에서 다사용되지만 한개만됨(마지막꺼)
		int num = 0;
		resp.setContentType("text/html;charset=utf-8");
		
		// 출력스트림 생성
		PrintWriter out = resp.getWriter();
		out.print("<h3>처리결과</h3>");
		
		while(num++ < 10) {
			out.print(str + " : " + num + "<br>");
			out.flush();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		out.print("<h3>Done</h3>");
		out.close();
		
//		서블릿의 지역번수 / 멤버
//		
//		상태유지 기술
//		http: 요청-> 응답 : 요청,응답 처리가되면 메모리 사라짐
//		client A: 요청 -> 응답
//		client B: 요청 -> 응답
//		
//		클라이언트 : 서버
//		쿠키		: 요청, 세션, 컨텍스트(애플리케이션)

//		https://tmxhsk99.tistory.com/135   
		
		
		
		
	}
	
}
