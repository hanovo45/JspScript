package co.prod.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.prod.common.Control;
import co.prod.service.MemberService;
import co.prod.service.MemberServiceMybatis;
import co.prod.vo.MembersVO;

public class MemberAddJquery implements Control {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
	
		MembersVO vo = new MembersVO();
		
		vo.setMemberId(request.getParameter("id"));		
		vo.setMemberName(request.getParameter("name"));
		vo.setMemberTel(request.getParameter("tel"));
		vo.setMemberAddr(request.getParameter("addres"));
		vo.setMemberPw(request.getParameter("passwd"));
		System.out.println(vo);
		MemberService service = new MemberServiceMybatis();
		
		boolean result = service.addMembers(vo);
		Map<String, Object> map = new HashMap<>();
		
		Gson gson = new GsonBuilder().create();
		String json = "";
		
		if (result) {
			map.put("retCode", "Success");
			map.put("members", vo);
		} else {
			map.put("retCode", "Fail");
			map.put("members", null);
		}
		json = gson.toJson(map);

		return json + ".ajax";
	}

}
