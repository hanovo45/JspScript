package co.dev.controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;

public class MainControl implements Control {
	
	// main.do (url)
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		RequestDispatcher rd =  req.getRequestDispatcher("WEB-INF/main/main.jsp");
		try {
			rd.forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}	// 페이지 재지정
		
	}
	
	
}
