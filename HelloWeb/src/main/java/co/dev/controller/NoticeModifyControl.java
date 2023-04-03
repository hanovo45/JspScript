package co.dev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;
import co.dev.service.NoticeService;
import co.dev.service.NoticeServiceMybatis;
import co.dev.vo.NoticeVO;

public class NoticeModifyControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String nid = req.getParameter("nid");
		String title = req.getParameter("title");
		String subject = req.getParameter("subject");
		
		NoticeVO notice = new NoticeVO();
		notice.setNoticeId(Integer.parseInt(nid));
		notice.setNoticeTitle(title);
		notice.setNoticeSubject(subject);
		
		NoticeService service = new NoticeServiceMybatis();
		
		
		
//		System.out.println(notice);	//id 기준으로 title, subject변경
		// 서비스 : noticeModify(NoticeVO), mapper: updateNotice(NoticeVO)
		// 목록페이지로 이동
		
		
	}

}
