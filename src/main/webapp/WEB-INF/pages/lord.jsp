<% request.setCharacterEncoding("UTF-8");%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>CreateLord</title>

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

<table border="1" align="center">
    <tr>
        <td>Возраст повелителя</td>
        <td>Имя повелителя</td>
        <td>Кнопка</td>
    </tr>

    <tr>
        <td><input name="enterData1" type="text" id="ageLord" class="input" placeholder="Введите возраст повелителя">
        </td>
        <td><input name="enterData2" type="text" id="nameLord" class="input" placeholder="Введите имя повелителя"></td>
        <td>
            <button type="button" id="button" onclick="myFunction()">Создать повелителя</button>
        </td>

    </tr>
</table>
<br>
<table border="1" id="out" align="center">


</table>


<script language="JavaScript" type="text/javascript">
    function myFunction() {

        var ageLord = document.getElementById("ageLord").value;
        var nameLord = document.getElementById("nameLord").value;

        document.getElementById("ageLord").value = "";
        document.getElementById("nameLord").value = "";

        var url = "http://localhost:8080/lord/agelord=" + ageLord + "&namelord=" + nameLord;
        var ajax = new XMLHttpRequest();
        ajax.open("PUT", url, true);
        ajax.send(null);
        ajax.onreadystatechange = function () {

            if (ajax.readyState == 4 && (ajax.status == 200)) {
                console.log("ready");

                var data = ajax.responseText;
                var myData = data.toString();

                var myData1 = myData.replace("object Object", "");
                var myData2 = myData1.replace("}]", "");
                var lordArr = myData2.split("},{");

                var inPage = '';
                inPage = '<tr><td>Возраст повелителя</td><td>Имя повелителя</td></tr>';
                for (var i = 0; i < lordArr.length; i++) {
                    try {
                        inPage += '<tr>' + '<td>' + lordArr[i].split("\"age\":")[1].split(",\"")[0] + '</td>';
                        inPage += '<td>' + lordArr[i].split("\"name\":")[1].split(",\"")[0].replace("\"", "").replace("\"", "") + '</td>' + '</tr>';
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

        var ageLord = document.getElementById("ageLord").value;
        var nameLord = document.getElementById("nameLord").value;

        document.getElementById("ageLord").value = "";
        document.getElementById("nameLord").value = "";

        var url = "http://localhost:8080/lord";
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
                var lordArr = myData2.split("},{");

                var inPage = '';
                inPage = '<tr><td>Возраст повелителя</td><td>Имя повелителя</td></tr>';
                for (var i = 0; i < lordArr.length; i++) {
                    try {
                        inPage += '<tr>' + '<td>' + lordArr[i].split("\"age\":")[1].split(",\"")[0] + '</td>';
                        inPage += '<td>' + lordArr[i].split("\"name\":")[1].split(",\"")[0].replace("\"", "").replace("\"", "") + '</td>' + '</tr>';
                    } catch (e) {

                    }
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
