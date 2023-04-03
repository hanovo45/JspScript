package co.yedam.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.service.BookService;
import co.yedam.service.BookServiceMybatis;
import co.yedam.vo.BookVO;

public class BoodAddControl implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BookService service = new BookServiceMybatis();
		BookVO book = new BookVO();	
	
		book.setBookCode(request.getParameter("bookCode"));
		book.setBookTitle(request.getParameter("bookTitle"));
		book.setBookAuthor(request.getParameter("bookAuthor"));
		book.setBookPress(request.getParameter("bookPress"));
		book.setBookDesc(request.getParameter("bookDesc"));
		book.setBookPrice(Integer.parseInt(request.getParameter("bookPrice")));
		
		if(service.addBook(book)== true) {
			request.setAttribute("message", "등록됨");
			List<BookVO> book2 = new ArrayList<>();
			book2 = service.bookList();
			request.setAttribute("list", book2);
			
//		}else {
//			System.out.println("예외");
////			request.setAttribute("message", "예외임");
//			request.getRequestDispatcher("WEB-INF/book/bookAddForm.jsp").forward(request, response);
		}
			request.getRequestDispatcher("WEB-INF/book/bookList.jsp").forward(request, response);		

//		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/book/bookList.jsp");
//		rd.forward(request, response);
		
//		private String bookCode;
//		private String bookTitle;
//		private String bookAuthor;
//		private String bookPress;
//		private String bookDesc;
//		private String bookPrice;

	}

}
