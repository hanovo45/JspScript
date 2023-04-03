package co.prod.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.prod.common.Control;
import co.prod.service.ProductService;
import co.prod.service.ProductServiceImpl;
import co.prod.vo.ReplyVO;

public class ReplyModifyAjax implements Control {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
				
		String no = request.getParameter("no");
		String content = request.getParameter("content");
		
		ProductService service = new ProductServiceImpl();
		ReplyVO vo = new ReplyVO();
		
		
		vo.setReplyNo(Integer.parseInt(no));
		vo.setReplyContent(content);
		System.out.println(content);
		System.out.println(no);
		
		boolean result = service.modifyReply(vo);
		
		Map<String, Object> resultMap = new HashMap<>();
		
		if(result) {
			resultMap.put("retCode", "Success");
			resultMap.put("reply", vo);
		}else {
			resultMap.put("retCode", "Fail");
			resultMap.put("reply", null);
		}
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(resultMap);
		
		
		return json + ".ajax";
	}

}
