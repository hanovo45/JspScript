<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset='utf-8' />
  <script src='full/dist/index.global.js'></script>
  <script>
    document.addEventListener('DOMContentLoaded', async function (addCal) {
      // fetch api를 사용
      let events = [];
      await fetch('fullCalendarAjax.do')
        .then(resolve => resolve.json())
        .then(result => {
          events = result;
        })
        .catch(reject => console.error(reject));



      var calendarEl = document.getElementById('calendar');

      var calendar = new FullCalendar.Calendar(calendarEl, {
        headerToolbar: {
          left: 'prev,next today',
          center: 'title',
          right: 'dayGridMonth,timeGridWeek,timeGridDay'
        },
        initialDate: '2023-03-30',
        navLinks: true, // can click day/week names to navigate views
        selectable: true,
        selectMirror: true,
        select: function (arg) {
          var title = prompt('Event Title:');

          if (title) {
            calendar.addEvent({
              title: title,
              start: arg.start,
              end: arg.end,
              allDay: arg.allDay
            })
            fetch('fullCalendarAddAjax.do', {
                method: 'post',
                headers: {
                  'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: 'title=' + title + '&start=' + arg.startStr + '&end=' + arg.endStr
              })
              .then(resolve => resolve.json())
              .then(result => {
                if (result.retCode != null) {
                  alert(result.retCode);
                }
              })
          }
          calendar.unselect()
        },

        eventClick: function (arg) {
          if (confirm('이벤트를 삭제하시겠습니까?')) {
            arg.event.remove()
          }
        },
        editable: true,
        dayMaxEvents: true, // allow "more" link when too many events
        events: events
      });
      calendar.render();
    });
  </script>
  <style>
    body {
      margin: 40px 10px;
      padding: 0;
      font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
      font-size: 14px;
    }

    #calendar {
      max-width: 1100px;
      margin: 0 auto;
    }
  </style>
</head>

<body>

  <div id='calendar'></div>

</body>

</html>