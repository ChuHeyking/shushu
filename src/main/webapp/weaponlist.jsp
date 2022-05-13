<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>原神同人社区</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">


    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>



    <style>
        .cls{
            border-style:solid;
            border-color: black;
        }
        td{
            border-style:solid;
            border-color: black;
        }
    </style>
</head>
<body>
<table class="cls">
    <thead class="cls">
    <td>name</td>
    <td>type</td>
    <td>rarity</td>
    <td>access</td>
    <td>initialAttack</td>
    <td>initialAttribute</td>
    <td>fullAttack</td>
    <td>fullAttribute</td>
    <td>skill</td>
    </thead>
    <c:forEach items="${requestScope.weaponList}" var="i">
        <tr class="cls">
            <td>${i.name}</td>
            <td>${i.type}</td>
            <td>${i.rarity}</td>
            <td>${i.access}</td>
            <td>${i.initialAttack}</td>
            <td>${i.initialAttribute}</td>
            <td>${i.fullAttack}</td>
            <td>${i.fullAttribute}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
