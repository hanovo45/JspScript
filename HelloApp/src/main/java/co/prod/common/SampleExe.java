package co.prod.common;

import java.util.ArrayList;
import java.util.List;

import co.prod.service.MemberService;
import co.prod.service.MemberServiceMybatis;
import co.prod.vo.MembersVO;

public class SampleExe {
public static void main(String[] args) {
	
		MemberService service = new MemberServiceMybatis();
		List<MembersVO> list = new ArrayList<>();
		
//		list.add(new MembersVO("user01", "", "", "", ""));
//		list.add(new MembersVO("user02", "", "", "", ""));
//		list.add(new MembersVO("user03", "", "", "", ""));
//		list.add(new MembersVO("user04", "", "", "", ""));
//	
		if (service.removeMembers(list)) {
			System.out.println("Success");
		} else {
			System.out.println("Fail");
		}
	}
}
