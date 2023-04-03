<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load('current', {
            'packages': ['corechart']
        });
        google.charts.setOnLoadCallback(drawChart);

        async function drawChart() {

            console.log("1");

            let outAry = [];
            outAry.push(['dept', 'cnt per dept'])
            let promise1 = await fetch('chartAjax.do') // promise객체
            let promise2 = await promise1.json(); // [{}{}] 배열 데이터
            console.log("1.1");
            promise2.forEach(dept => {
                let ary = [];
                for (let prop in dept) {
                    ary[0] = prop;
                    ary[1] = dept[prop];
                }
                outAry.push(ary);
            })
            console.log("1.2");
            var data = google.visualization.arrayToDataTable(outAry);
            var options = {
                title: 'Person By Department'
            };
            var chart = new google.visualization.PieChart(document.getElementById('piechart'));
            chart.draw(data, options);
            // console.log(outAry);
        }
    </script>
</head>

<body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
</body>


<!-->

<head>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript">
    google.charts.load('current', {
      'packages': ['corechart']
    });
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

    console.log("1");
    let outAry=[];
      fetch('chartAjax.do')
        .then(resolve => resolve.json())
        .then(result => {
        	console.log("1.1");
          // console.log(result);
          let outAry = [];
          outAry.push(['dept','cnt per dept'])
          result.forEach(dept => {
            // console.log(dept)
            let ary = []

            for (prop in dept) {
              ary[0] = prop;
              ary[1] = dept[prop];
            }
            // console.log(ary);
            outAry.push(ary); // 가공
          })
            // [{'Admin':1},{'Accounting':2}....~~]    	  
        })
        .catch(reject => console.error(reject))
            
      console.log("2");
    var data = google.visualization.arrayToDataTable(outAry);
    var options = {
      title: 'Person By Department'
    };
    var chart = new google.visualization.PieChart(document.getElementById('piechart'));
    chart.draw(data, options);            
  // console.log(outAry);
    }
    


  </script>
</head>

</html> -->

</html>