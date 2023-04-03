package co.prod.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prod.common.Control;
import co.prod.service.ProductService;
import co.prod.service.ProductServiceImpl;

public class ChartAjax implements Control {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		ProductService service = new ProductServiceImpl();
		List<Map<String, Object>> list = service.chartINfo();
		
		// 배열안에 배열이아니라 배열안에 객체를 가져옴
		
		String json = "[";
		for(Map<String, Object> map : list) {
			System.out.println(map.get("dp") + " , " + map.get("cnt")); 
			// {"Administration":1}
			json += "{\"" + map.get("dp") + "\":" + map.get("cnt") + "},";
		}
		json = json.substring(0, json.length() -1);
		json += "]";
		
		return json + ".ajax";
	}

}
