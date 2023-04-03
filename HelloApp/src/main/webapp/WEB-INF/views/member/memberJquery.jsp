<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="jquery/jquery-3.6.4.min.js"></script>
    <script>
        // document 로딩 후 처리
        $(document).ready(function () {
            // fetch('url', {option})
            // 목록 출력 ajax
            $.ajax({
                url: "memberListJquery.do", // 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소
                data: {
                    // name: "홍길동", // request.getParameter('name');
                    // id: 'user01' // request.getParameter('id');
                }, // HTTP 요청과 함께 서버로 보낼 데이터
                method: "GET", // HTTP 요청 방식(GET, POST)
                dataType: "json", // 서버에서 보내줄 데이터의 타입 : JSON.parse()실행
                success: function (result) { // 서버요청의 성공시 실행할 함수
                    //JSON.parse(result);
                    $(result).each(function (idx, member) {
                        console.log(idx, member);
                        $('#list').append(
                            // tr>td*4 생성
                            $('<tr />').append($('<td />').text(member.memberId),
                                $('<td />').text(member.memberName),
                                $('<td />').text(member.memberAddr),
                                $('<td />').text(member.memberTel),
                                $('<td />').text(member.memberPw),
                                $('<td />').append('<button />')
                                .text('삭제')
                                .on('click', rowDeletFnc),
                                $('<td />').append($('<input type="checkbox" />'))
                            )
                        );
                    });
                },
                error: function (err) { // 서버요청의 실패시 실행할 함수
                    console.log(err);
                }
            }) // $.ajax()끝부분

            // 삭제버튼 이벤트 핸들러
            function rowDeletFnc() { // until = tbody 아래의 하위요소(tr)
                $(this).parentsUntil('tbody').remove();
            }

            // 추가버튼 이벤트
            $('#addBtn').on('click', function (e) {
                e.preventDefault(); // 전송기능 차단
                // 사용자가 필수입력값을 입력했는지 validation 하고
                if (!$('#id').val() || !$('#name').val() || !$('#passwd').val()) {
                    alert('입력값을 확인해주세요');
                    return;
                }
                // ajax 호출
                $.ajax({

                    url: "memberaddJquery.do", // 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소
                    data: {
                        id: $('#id').val(),
                        name: $('#name').val(),
                        addr: $('#addres').val(),
                        tel: $('#tel').val(),
                        pw: $('#passwd').val()
                    },
                    method: "post", // HTTP 요청 방식(GET, POST)
                    dataType: "json", // 서버에서 보내줄 데이터의 타입
                    success: function (result) {
                        if (result.retCode == 'Success') {
                            alert('성공');
                            $('#list').append(
                                // tr>td*4 생성
                                $('<tr />').append($('<td />').text($('#id').val()),
                                    $('<td />').text($('#name').val()),
                                    $('<td />').text($('#passwd').val()),
                                    $('<td />').text($('#addres').val()),
                                    $('<td />').text($('#tel').val()),
                                    $('<td />').append($('<button />')
                                        .text('삭제')
                                        .on('click', rowDeletFnc)),
                                    $('<td />').append($('<input type="checkbox" />'))
                                )
                            )
                        } else if (result.retCode == 'Fail') {
                            alert('실패');
                            // 처리중 에러
                        } else {
                            // 반환코드 확인
                        }
                    },
                    error: function(reject){
                        console.log(reject);
                    }
                })
            })

            //선택삭제버튼 이벤트
            $('#delSelected').on('click', function (e) {
                e.preventDefault();
				let memberIdAray = {}
                // $('input:checked').parentsUntil('tbody').remove();

                $('#list input:checked').each(function(idx,item){
                	console.log($(item).parent().parent().attr('id'))
                	//memberIdAray.push({'memberId': $(item).parent().parent().attr('id')})
                //     $(item).closest('tr').remove();
                 	memberIdAry.memberId = $(item).parent().parent().attr('id');
                 })
                 console.log(memberIdAray);
                
                // ajax 호출
                $.ajax({
                	url:"memberRemoveJquery.do",	// 호출 컨트롤
                	method:'post',
                	data:{memberId:'user01', memberId:'user02'}
                	success: function(result){
                		
                	},
                	error: function(reject){
                		
                	}
                })
            })

            // 전부체크
            $('th>input[type="checkbox"]').on('change', function () {
                $('td>input').prop({
                    checked: this.checked
                })
            })

            // th>input 과 td>input을 비교해서 전체선택이 되도록
            // 선택된 갯수를 비교?
            // ajax호출의 결과로 만들어지는 부분. 이벤트 위임
            $('#list').on('change', 'td>input[type="checkbox"]', function () {
                // $('td>')
                console.log(this);
                let checkCnt = $('td>input[type="checkbox"]:checked').length;
                let allCnt = $('td>input[type="checkbox"]').length;

                if (checkCnt == allCnt) {
                    $('#allCheck').prop('checked', ture)
                } else {
                    $('#allCheck').prop('checked', false)
                }
                td > input[type = "checkbox"]
            })
        });
    </script>
</head>

<body>
    <div>
        <form>
            <table class="table" border="1">
                <tr>
                    <td>Id:</td>
                    <td><input type="text" id="id"></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" id="name"></td>
                </tr>
                <tr>
                    <td>Pass:</td>
                    <td><input type="text" id="passwd"></td>
                </tr>
                <tr>
                    <td>주소:</td>
                    <td><input type="text" id="addres"></td>
                </tr>
                <tr>
                    <td>연락처:</td>
                    <td><input type="text" id="tel"></td>
                </tr>
                <tr>
                    <td colspan='2' align="center">
                        <button id="addBtn">등록</button>
                        <button id="delSelected">선택삭제</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <!-- 123 -->
    <div>
        <table class="table" border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Pass</th>
                    <th>주소</th>
                    <th>연락처</th>
                    <th>삭제</th>
                    <th><input type="checkbox" id="allCheck"></th>
                </tr>
            </thead>
            <tbody id="list">
            </tbody>
        </table>
    </div>
</body>

</html>