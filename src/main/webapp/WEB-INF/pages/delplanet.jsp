<% request.setCharacterEncoding("UTF-8");%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>DeletePlanet</title>

    <style language="css" type="text/css">
        <%@include file="/WEB-INF/css/main.css"%>
    </style>

</head>
<body>

<nav class="one" align="center">
    <ul>
        <li><a href="createLord">Создать повелителя</a></li>
        <li><a href="createPlanet">Создать планету</a></li>
        <li><a href="lordplanet">Назначить повелителя планеты</a></li>
        <li><a href="delplanet">Уничтожить планету</a></li>
        <li><a href="badloards">Бездельники</a></li>
        <li><a href="toplords">ТОП 10 молодых повелителей</a></li>
    </ul>
</nav>

<br>

<table border="1" id="out" align="center">


</table>


<script language="JavaScript" type="text/javascript">
    function myFunction(str) {
        var url = "http://localhost:8080/planet/delete=" + str;
        var ajax = new XMLHttpRequest();
        ajax.open("DELETE", url, true);
        ajax.send(null);
        ajax.onreadystatechange = function () {

            if (ajax.readyState == 4 && (ajax.status == 200)) {
                console.log("ready");

                var data = ajax.responseText;
                var myData = data.toString();

                var myData1 = myData.replace("object Object", "");
                var myData2 = myData1.replace("}]", "");
                var planetArr = myData2.split("},{");

                var inPage = '';
                inPage = '<tr><td>Название планеты</td><td>Кнопка</td></tr>';
                for (var i = 0; i < planetArr.length; i++) {
                    try {
                        var namePlanet = "'" + planetArr[i].split("\"name\":")[1].split(",\"")[0].replace("\"", "").replace("\"", "") + "'";
                        inPage += '<tr>' + '<td>' + planetArr[i].split("\"name\":")[1].split(",\"")[0].replace("\"", "").replace("\"", "") + '</td>';
                        inPage += '<td>' + '<button type="button" onclick="myFunction(' + namePlanet + ')">Удалить</button>' + '</td>' + '</tr>';
                    } catch (e) {

                    }
                }
                out.innerHTML = inPage;

            } else {
                console.log("not ready yet")
            }
        }
    };

    window.onload = function () {

        var url = "http://localhost:8080/planet";
        var ajax = new XMLHttpRequest();
        ajax.open("GET", url, true);
        ajax.send(null);
        ajax.onreadystatechange = function () {

            if (ajax.readyState == 4 && (ajax.status == 200)) {
                console.log("ready");

                var data = ajax.responseText;
                var myData = data.toString();

                var myData1 = myData.replace("object Object", "");
                var myData2 = myData1.replace("}]", "");
                var planetArr = myData2.split("},{");

                var inPage = '';
                inPage = '<tr><td>Название планеты</td><td>Кнопка</td></tr>';
                for (var i = 0; i < planetArr.length; i++) {
                    var nameNew = "'" + planetArr[i].split("\"name\":")[1].split(",\"")[0].replace("\"", "").replace("\"", "") + "'";
                    inPage += '<tr>' + '<td>' + planetArr[i].split("\"name\":")[1].split(",\"")[0].replace("\"", "").replace("\"", "") + '</td>';
                    inPage += '<td>' + '<button type="button" onclick="myFunction(' + nameNew + ')">Удалить</button>' + '</td>' + '</tr>';
                }
                out.innerHTML = inPage;

            } else {
                console.log("not ready yet")
            }
        }
    };

</script>

</body>
</html>