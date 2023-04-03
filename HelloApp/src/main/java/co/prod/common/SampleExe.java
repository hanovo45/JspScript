package co.prod.common;

import java.util.ArrayList;
import java.util.List;

import co.prod.service.MemberService;
import co.prod.service.MemberServiceMybatis;
import co.prod.vo.MembersVO;

public class SampleExe {
public static void main(String[] args) {
	
	MemberService servie = new MemberServiceMybatis();
	List<MembersVO> list = new ArrayList<>();
	
	
}
}
