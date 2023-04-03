package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 자바소스 : http통신방법을 활용해서 request, response 생성처리
// HttpServlet 클래스를 상속받아서 사용
// 서블릿의 실행 : 개발자 X , Tomcat 컨테이너가 제어(Inversion Of Control : 제어의 역전)
// 순서 : 객체 -> init -> service -> destroy

public class FirstServlet extends HttpServlet{

	public FirstServlet() {
		// 생성자 호출은 서블릿이 호출될때 한번만 실행
		System.out.println("생성자 호출해봄 FirstServlet");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// init 호출은 서블릿이 호출될때 한번만 실행
		System.out.println("init 호출해봄 FirstServlet");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// service 호출은 서블릿이 호출될때마다  실행
		System.out.println("service 호출해봄 FirstServlet");
		
		if(req.getMethod().equals("GET")) {
			doGet(req, resp);
		}else if(req.getMethod().equals("POST")) {
			doPost(req, resp);
		}
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy 호출해봄 FirstServlet");
	}
	
	// 클라이언트 -> 서버로 요청방식 : get or post 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get : 주소창: url, a href:"", <from method="get">
		// 특징 : url 사용자가 입력값 노출, 용량제한 
		// 응답정보 - 클라이언트측
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter(); // 출력스트림 생성
		out.print("<h3>Get 방식요청</h3>");
		// 사용자가 입력했던 값을 읽어오는 방법
		String id = req.getParameter("id"); // first?id=guest&pw=1234
		String pw = req.getParameter("pw");
		
		out.print("<p>입력 id : " + id + " , 비번 : " + pw + "</p>");
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter(); // 출력스트림 생성
		out.print("<h3>POST 방식요청</h3>");
		
		
		String id = req.getParameter("id"); // first?id=guest&pw=1234
		String pw = req.getParameter("pw");
		
		out.print("<p>입력 id : " + id + " , 비번 : " + pw + "</p>");
		out.close();
		
	}
	
	
}
