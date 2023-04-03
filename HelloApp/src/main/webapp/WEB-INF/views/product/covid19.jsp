<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 시도 : <input type="text" id="sido"> -->
	시도 선택: <select id="sidoList">		
	</select>
	<button id="sidoBtn">찾기</button>

	<h3>센터현황</h3>
	<table border="1">
		<thead>
			<tr><th>아이디</th><th>센터명</th><th>주소</th><th>연락처</th><th>시도정보</th></tr>
		</thead>
		<tbody id="centerList"></tbody>
	</table>
	<script>
		
		let showFields = ['id', 'centerName', 'address', 'phoneNumber', 'sido'];

		// row생성(한건 정보)
		function makeTr(center={}){

			// tr 생성 > td * 여러개
			let tr = document.createElement('tr');
			tr.setAttribute('data-lng',center.lng);
			tr.setAttribute('data-lat',center.lat);

			tr.addEventListener('click',openMapFnc);
			
			// td 생성
			// tr.id = center.id;			
			// showFields.forEach(field =>{
			// 	let td = document.createElement('td');
			// 	td.innerText = center[field];
			// 	tr.append(td);
			// })	
			// return tr;
			
			showFields.forEach((prop)=> {
				let txt = center[prop];
				let td = document.createElement('td');
				td.innerText = txt;
				tr.append(td);
			})
			return tr;
			
			// showFields.forEach(field =>{}){
			// 	let td = document.createElement('td');
			// 	td.innerText = center
			// 	console.log(center[data]);
			// 	tr.append(td);
			// })		
			// return tr;

			function openMapFnc(){
				let tr = this;	// event 받는 대상
				let lng = tr.dataset.lng;	// tr.getAttribute('data-lng');
				let lat = tr.dataset.lat;	// tr.getAttribute('data-lat');
				// location.href = 'map.do?lng='+lng+'&lat='+lat;
				window.open('map.do?lng='+lng+'&lat='+lat, '_blank')
			}
		}

		// 전체목록
		let totalList; // 다른 함수에서도 활용

		let url = `https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=pQj2gmU7eJTvFVqs8viFMr1g5Ry%2Ffb3QQljjkGy3mBqKKC6wiAwlW2q%2FSAQbc4GMc8njTd1%2FzOW93EQ8DZUDuA%3D%3D`;
		fetch(url)
		.then(resolve => resolve.json())
		.then(result => {
			// console.log(result);
			
			let aryData = result.data;
			totalList = aryData;	// 처리결과를 활용해서 totalList 대입
			
			aryData.forEach(function (center){
				let tr = makeTr(center);
				document.querySelector('#centerList').append(tr);
			});

			// 시도 배열
			// totalList;	// {id, centerName, adress, phoneNumber, sido}
			// push, pop, unshift, shift
			let sidoAry = [];
			totalList.forEach(function(center){
				if(sidoAry.indexOf(center.sido)<0){
					sidoAry.push(center.sido);
				}
			})
				sidoAry.forEach(function(sido){
					let opt = document.createElement('option');
					opt.value = sido;
					opt.innerText = sido;
					document.querySelector('#sidoList').append(opt);
				});
			})
		.catch(reject => console.error(reject));
		
			

		// 찾기 버튼
		document.querySelector('#sidoBtn').addEventListener('click', findSidofnc);
		
		function findSidofnc(){
			// 전체목록에서 검색조건 filter한 결과를 tbody의 하위 목록으로 출력
			document.querySelector('#centerList').innerHTML = "";

			let searchWord = document.getElementById('sidoList').value;
			let filterAry = totalList.filter(function (center){
				console.log(center);
				return center.sido == searchWord;
			});
			console.log(filterAry);

			filterAry.forEach(center => {
				document.querySelector('#centerList').append(makeTr(center));
			})
		}
		
	</script>
</body>
</html>