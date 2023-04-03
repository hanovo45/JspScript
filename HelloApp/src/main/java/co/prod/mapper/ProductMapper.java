package co.prod.mapper;

import java.util.List;
import java.util.Map;

import co.prod.vo.CalendarVO;
import co.prod.vo.ProductVO;
import co.prod.vo.ReplyVO;

public interface ProductMapper {
	//목록
	public List<ProductVO> productList();
	public ProductVO selectProduct(String code);
	
	// 댓글목록.
	public List<ReplyVO> replyList(String code);
	// 댓글삭제.
	public int deleteReply(int replyId);
	// 댓글등록.
	public int insertReply(ReplyVO vo);
	// 댓글조회
	public ReplyVO selectReply(int replyId);
	// 댓글 수정
	public int modifyReply(ReplyVO vo);
	// 차트
	public List<Map<String, Object>> chartINfo();
	// 캘린더
	public List<CalendarVO> calendarList();
	// 캘린더 추가
	public int insertCalendar(CalendarVO vo);
}
