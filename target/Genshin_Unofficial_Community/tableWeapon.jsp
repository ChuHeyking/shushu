<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>

    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Home</title>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap1.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/fontawesome-5.5/css/all.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/slick/slick.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/slick/slick-theme.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/magnific-popup/magnific-popup.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/templatemo-style.css"/>

    <title>计算器</title>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>


    <style>
        td {
            text-align: center;
            vertical-align: middle !important;
        }

        .controlColor {
            color: #8f8f8f;
        }

        .controlColor:hover {
            color: #3496d8;
        }

        body {
            text-align: center;
        }
    </style>

    <script>
        function f1(me) {

            if ($(me).attr("class") == "btn btn-default") {

                var val1 = $(me).text();
                $(me).html(val1 + "<input type=\"text\" hidden=\"true\" name=\"" + $(me).attr("abc") + "\" value=\"" + val1 + "\">");
                $(me).removeClass("btn-default");
                $(me).addClass("btn-primary");
                /*alert($(me.childNodes[0]).attr("name"));
                $(me.childNodes[0]).val($(me).text());*/
            } else {

                var val1 = $(me).text();
                $(me).html(val1);
                $(me).removeClass("btn-primary");
                $(me).addClass("btn-default");
                /*$(me.childNodes[0]).val("");*/
            }
            $("#form1").submit();
        }
        
        function formSubmit(me) {
            $("#form1").prop("action",$(me).attr("jump"));
            $("#form1").submit();
        }
    </script>
</head>

<body>

<section id="dio" class="text-white tm-font-big tm-parallax">
    <!-- Navigation -->
    <nav class="navbar navbar-expand-md tm-navbar" id="tmNav"
         style="background: white;border-bottom: 1px solid #e9ecef">
        <div class="container">
            <div class="tm-next">
                <a href="index.jsp#hero" class="navbar-brand controlColor">原神社区</a>
            </div>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <i class="fas fa-bars navbar-toggler-icon"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link tm-nav-link controlColor" href="index.jsp#introduction">天赋素材一览</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link tm-nav-link controlColor" href="index.jsp#work">资料库</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link tm-nav-link controlColor" href="index.jsp#contact">伤害计算器</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</section>

<section>

<form id="form1" action="${sessionScope.kv.URI}?page=1" method="post">
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
            <table id="tableHead" class="col-lg-10 table table-bordered">
                <tbody>
                <tr>
                    <th class="col-lg-2 text-center">全部</th>
                    <td class="col-lg-8 text-left">
                        <a class="btn btn-default" href="${sessionScope.kv.URI}?page=1" role="button">全部</a>
                    </td>
                </tr>
                <tr>
                    <th class="col-lg-2 text-center">星级</th>
                    <td class="col-lg-8 text-left">
                        <c:forEach items="${sessionScope.kv.typeMap.weaponRarity}" var="i">
                            <button type="button" class="${sessionScope.kv.selectMap.weaponRarity.contains(i)?"btn btn-primary":"btn btn-default"}"
                                    onclick="f1(this)" abc="weaponRarity">${i}<c:if test="${sessionScope.kv.selectMap.weaponRarity.contains(i)}">
                                <input type="text" hidden="true" name="weaponRarity" value="${i}"></c:if></button>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <th class="col-lg-2 text-center">种类</th>
                    <td class="col-lg-8 text-left">
                        <c:forEach items="${sessionScope.kv.typeMap.type}" var="i">
                            <button type="button" class="${sessionScope.kv.selectMap.type.contains(i)?"btn btn-primary":"btn btn-default"}"
                                    onclick="f1(this)" abc="type">${i}<c:if test="${sessionScope.kv.selectMap.type.contains(i)}">
                                <input type="text" hidden="true" name="type" value="${i}"></c:if></button>
                        </c:forEach>
                    </td>
                </tr>
                <%--<tr>--%>
                    <%--<th class="col-lg-2 text-center">获取途径</th>--%>
                    <%--<td class="col-lg-8 text-left">--%>
                        <%--<c:forEach items="${sessionScope.kv.typeMap.access}" var="i">--%>
                            <%--<button type="button" class="${sessionScope.kv.selectMap.access.contains(i)?"btn btn-primary":"btn btn-default"}"--%>
                                    <%--onclick="f1(this)" abc="access">${i}<c:if test="${sessionScope.kv.selectMap.access.contains(i)}">--%>
                                <%--<input type="text" hidden="true" name="access" value="${i}"></c:if></button>--%>
                        <%--</c:forEach>--%>
                    <%--</td>--%>
                <%--</tr>--%>

                </tbody>
            </table>
        </div>
    </div>
</form>

<div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-10">
        <table id="table1" class="table table-striped table-hover">
            <thead>
            <tr>
                <td>图片</td>
                <td>序号</td>
                <td>名称</td>
                <td>星级</td>
                <td>种类</td>
                <td class="col-lg-2">获取途径</td>
                <td>初始攻击力</td>
                <td>初始属性</td>
                <td>满级攻击力</td>
                <td>满级属性</td>
                <td class="col-lg-3">武器技能</td>
            </tr>
            </thead>

            <tbody id="tbody1">
            <c:forEach var="list" items="${sessionScope.kv.list}">
                <tr>
                    <td><img height="100px" src="img/weapon/${list.name}.png"></td>
                    <td>${list.id }</td>
                    <td>${list.name }</td>
                    <%--<td>${list.weaponRarity }</td>--%>
                    <td><img src="img/rarity/${list.weaponRarity}.png"></td>
                    <td>${list.type }</td>
                    <td class="col-lg-2">${list.access }</td>
                    <td>${list.initialAttack }</td>
                    <td>${list.initialAttribute }</td>
                    <td>${list.fullAttack }</td>
                    <td>${list.fullAttribute }</td>
                    <td class="col-lg-3">${list.skill }</td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<nav aria-label="Page navigation">
    <ul class="pagination justify-content-center">
        <li id="numHead">
            <a href="#" jump="${sessionScope.kv.URI}?page=${sessionScope.kv.page-1<1?1:sessionScope.kv.page-1}" onclick="formSubmit(this)" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <c:forEach var="i" step="1" begin="1" end="${sessionScope.kv.totalPage}">
            <c:if test="${i == sessionScope.kv.page}">
                <li class="active"><a href="#" jump="${sessionScope.kv.URI}?page=${i}" onclick="formSubmit(this)">${i}<span class="sr-only">(current)</span></a></li>
            </c:if>
            <c:if test="${i != sessionScope.kv.page}">
                <li><a href="#" jump="${sessionScope.kv.URI}?page=${i}" onclick="formSubmit(this)">${i}</a></li>
            </c:if>
        </c:forEach>
        <li id="numEnd">
            <a href="#" jump="${sessionScope.kv.URI}?page=${sessionScope.kv.page+1>sessionScope.kv.totalPage?sessionScope.kv.page:sessionScope.kv.page+1}" onclick="formSubmit(this)" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>
<h3 style="color: #2e6da4">共 ${sessionScope.kv.totalCount} 条</h3>

<div id="information" totalPage="0" page="0" totalCount="0"></div>

</section>
</body>


</html>
