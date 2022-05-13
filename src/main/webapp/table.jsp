<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Home</title>
    <link rel="stylesheet" href="css/bootstrap1.min.css"/>

    <title>计算器</title>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>

    <script>
        $(function () {
            
        });
    </script>
</head>
<body>

<nav aria-label="Page navigation">
    <ul class="pagination">
        <li>
            <a href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li>
            <a href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>
<%--<div class="table-responsive">--%>
    <table class="table">
        <thead>
        <td>序号</td>
        <td>名称</td>
        <td>星级</td>
        <td>武器</td>
        <td>元素</td>
        <td>性别</td>
        <td>地区</td>
        <td>血量</td>
        <td>攻击</td>
        <td>防御</td>
        <td>突破</td>
        <td>描述</td>
        </thead>
        <c:forEach items="${requestScope.roles}" var="role">
            <tr>
                <td>${role.id}</td>
                <td>${role.name}</td>
                <td>${role.rarity}</td>
                <td>${role.weapontype}</td>
                <td>${role.elementtype}</td>
                <td>${role.gender}</td>
                <td>${role.area}</td>
                <td>${role.blood}</td>
                <td>${role.attack}</td>
                <td>${role.defense}</td>
                <td>${role.breakthrough}</td>
                <td>${role.description}</td>
            </tr>
        </c:forEach>
    </table>
<%--</div>--%>
</body>


</html>
