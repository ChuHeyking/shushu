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

        .str1{
            font-size: large !important;
        }

        select{
            color: black;
        }

        input{
            color: black;
            text-align: center;
        }

        body {
            text-align: center;
        }
    </style>

    <script>

    </script>
</head>
<body>

<section id="cal" class="text-white tm-font-big tm-parallax">
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


    <form action="##" onsubmit="return false" method="post" class="col-lg-12" id="form1">
        <div class="container tm-container-gallery">
            <div class="row">
                <div class="text-center col-12">
                    <h2 class="tm-text-primary tm-section-title mb-4">简易伤害计算器</h2>

                </div>
            </div>

            <div class="row align-items-start">
                <div class="col-lg-3 str1">
                    伤害类型：
                    <select name="damageType" id="dt" onchange="s1()">
                        <option>--请选择--</option>
                        <option value="normal">不打反应</option>
                        <option value="amplification1" id="amplificationId1">增幅反应1.5倍</option>
                        <option value="amplification2" id="amplificationId2">增幅反应2倍</option>
                        <option value="upheaval" id="upheavalId">剧变反应</option>
                    </select>
                </div>
                <div class="col-lg-3 str1">
                    增加乘区：
                    <select id="addArea" class="str1">
                        <option>--请选择--</option>
                        <option id="ps">加伤乘区</option>
                        <option id="ms">增伤乘区</option>
                        <option id="rs">减抗</option>
                    </select>
                    <button onclick="add()">+</button>
                </div>
            </div>
            <br/>
            <div class="row col-lg-12">

                <div class="col-lg-2 str1">人物面板攻击力<input type="text" name="attack"></div>
                <div class="col-lg-2 str1">天赋技能倍率（%）<input type="text" name="skill"></div>
                <div class="col-lg-2 str1" id="add1">加伤乘区<input type="text" name="plus"></div>
                <!-- "额外伤害"，"附带伤害"等字眼都属于此乘区，如钟离天赋“普攻/岩脊/大招附带XX%最大生命值的额外伤害”，云堇、申鹤的增伤-->
                <div class="col-lg-2 str1" id="add2">增伤乘区（%）<input type="text" name="multiple"></div>
                <!--               武器效果，圣遗物套装效果，辅助技能等等-->
                <div class="col-lg-2 str1">怪物等级（Lv）<input type="text" name="enemyLv"></div>
                <div class="col-lg-2 str1">人物等级（Lv）<input type="text" name="roleLv"></div>
                <div class="col-lg-2 str1">防御力减免（%）<input type="text" name="defenseCut"></div>
                <div class="col-lg-2 str1">怪物抗性（%）<input type="text" name="enemyResistance"></div>
                <div class="col-lg-2 str1" id="add3">减抗（%）<input type="text" name="resistanceCut"></div>
                <div class="col-lg-2 str1">暴击伤害（%）<input type="text" name="criticalDamageRate"></div>
                <div class="col-lg-2 str1" hidden="true" id="h1">元素精通<input type="text" name="elementProficiency"></div>
            </div>


            <div class="row col-lg-12">
                <div class="col-lg-2" style="text-align: left"><input type="button" value="计算" onclick="cal()"></div>
            </div>

            <div class="row col-lg-12">
                <div class="col-12" style="text-align: left">
                    <div class="col-lg-4">
                        不暴击：
                        <div id="result1"></div>
                    </div>
                </div>
            </div>

            <div class="row col-lg-12">
                <div class="col-12" style="text-align: left">
                    <div class="col-lg-4" >
                        暴击：
                        <div id="result2"></div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</section>


<script src="js/jquery-1.9.1.min.js"></script>
<script src="slick/slick.min.js"></script>
<script src="magnific-popup/jquery.magnific-popup.min.js"></script>
<script src="js/jquery.singlePageNav.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>

    /*        $(function () {
            var conutAdd = 1;
        });*/

    function s1() {
        /*$("#h1").attr("hidden",false);*/
        var optionId = $("#dt")[0].options[$("#dt")[0].selectedIndex].id;
        if (optionId == "amplificationId1" || optionId == "amplificationId2" || optionId == "upheavalId") {
            $("#h1").attr("hidden", false);
        } else {
            $("#h1").attr("hidden", true);
        }
    }

    function cal() {
        /*alert($("#form1").serializeArray());*/
        if ($("input[name='plus']").length > 1) {
            $("input[name='plus']").each(function () {
                $(this).prop("name", "pluss")
            })
        }
        if ($("input[name='multiple']").length > 1) {
            $("input[name='multiple']").each(function () {
                $(this).prop("name", "multiples")
            })
        }
        if ($("input[name='resistanceCut']").length > 1) {
            $("input[name='resistanceCut']").each(function () {
                $(this).prop("name", "resistanceCuts")
            })
        }


        $.ajax({
            url: "calculator/easyCal",
            contentType: "application/json;charset=UTF-8",
            data: JSON.stringify($("#form1").serializeObject()),
            /*data:'{"attack":1900}',*/
            type: "post",
            dataType: "json",
            success: function (data) {
                $("#result1").text(data.normalDamage);
                $("#result2").text(data.criticalDamage);
            }
        });
    }

    $.fn.serializeObject = function () {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name] !== undefined) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value);
            } else {
                o[this.name] = this.value;
            }
        });
        return o;
    };

    function add() {
        var id = $("#addArea")[0].options[$("#addArea")[0].selectedIndex].id;
        var ele = document.createElement("div");
        ele.setAttribute("class", "col-lg-2");
        if (id == "ps") {
            ele.innerHTML = "加伤乘区<input type=\"text\" name=\"plus\">";
            $("#add1").after($(ele));
        } else if (id == "ms") {
            ele.innerHTML = "增伤乘区（%）<input type=\"text\" name=\"multiple\">";
            $("#add2").after($(ele));
        } else if (id == "rs") {
            ele.innerHTML = "减抗（%）<input type=\"text\" name=\"resistanceCut\">";
            $("#add3").after($(ele));
        } else {

        }
    }

    /*function getOffSet() {
        var _offset = 450;
        var windowHeight = window.innerHeight;

        if (windowHeight > 500) {
            _offset = 400;
        }
        if (windowHeight > 680) {
            _offset = 300
        }
        if (windowHeight > 830) {
            _offset = 210;
        }

        return _offset;
    }

    function setParallaxPosition($doc, multiplier, $object) {
        var offset = getOffSet();
        var from_top = $doc.scrollTop(),
            bg_css = 'center ' + (multiplier * from_top - offset) + 'px';
        $object.css({"background-position": bg_css});
    }

    var background_image_parallax = function ($object, multiplier, forceSet) {
        multiplier = typeof multiplier !== 'undefined' ? multiplier : 0.5;
        multiplier = 1 - multiplier;
        var $doc = $(document);
        // $object.css({"background-attatchment" : "fixed"});

        if (forceSet) {
            setParallaxPosition($doc, multiplier, $object);
        } else {
            $(window).scroll(function () {
                setParallaxPosition($doc, multiplier, $object);
            });
        }
    };

    var background_image_parallax_2 = function ($object, multiplier) {
        multiplier = typeof multiplier !== 'undefined' ? multiplier : 0.5;
        multiplier = 1 - multiplier;
        var $doc = $(document);
        $object.css({"background-attachment": "fixed"});
        $(window).scroll(function () {
            var firstTop = $object.offset().top,
                pos = $(window).scrollTop(),
                yPos = Math.round((multiplier * (firstTop - pos)) - 186);

            var bg_css = 'center ' + yPos + 'px';

            $object.css({"background-position": bg_css});
        });
    };

    $(function () {
        // Hero Section - Background Parallax
        background_image_parallax($(".tm-parallax"), 0.30, false);
        background_image_parallax_2($("#contact"), 0.80);

        // Handle window resize
        window.addEventListener('resize', function () {
            background_image_parallax($(".tm-parallax"), 0.30, true);
        }, true);

        // Detect window scroll and update navbar
        $(window).scroll(function (e) {
            if ($(document).scrollTop() > 120) {
                $('.tm-navbar').addClass("scroll");
            } else {
                $('.tm-navbar').removeClass("scroll");
            }
        });

        // Close mobile menu after click
        $('#tmNav a').on('click', function () {
            $('.navbar-collapse').removeClass('show');
        })

        // Scroll to corresponding section with animation
        $('#tmNav').singlePageNav();

        // Add smooth scrolling to all links
        // https://www.w3schools.com/howto/howto_css_smooth_scroll.asp
        $("a").on('click', function (event) {
            if (this.hash !== "") {
                event.preventDefault();
                var hash = this.hash;

                $('html, body').animate({
                    scrollTop: $(hash).offset().top
                }, 400, function () {
                    window.location.hash = hash;
                });
            } // End if
        });

        // Pop up
        $('.tm-gallery').magnificPopup({
            delegate: 'a',
            type: 'image',
            gallery: {enabled: true}
        });

        // Gallery
        $('.tm-gallery').slick({
            dots: true,
            infinite: false,
            slidesToShow: 5,
            slidesToScroll: 2,
            responsive: [
                {
                    breakpoint: 1199,
                    settings: {
                        slidesToShow: 4,
                        slidesToScroll: 2
                    }
                },
                {
                    breakpoint: 991,
                    settings: {
                        slidesToShow: 3,
                        slidesToScroll: 2
                    }
                },
                {
                    breakpoint: 767,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 1
                    }
                },
                {
                    breakpoint: 480,
                    settings: {
                        slidesToShow: 1,
                        slidesToScroll: 1
                    }
                }
            ]
        });
    });*/
</script>
</body>


</html>
