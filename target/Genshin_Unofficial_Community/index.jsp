<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Home</title>
    <link rel="stylesheet" href="fontawesome-5.5/css/all.min.css"/>
    <link rel="stylesheet" href="slick/slick.css">
    <link rel="stylesheet" href="slick/slick-theme.css">
    <link rel="stylesheet" href="magnific-popup/magnific-popup.css">
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/templatemo-style.css"/>

    <title>原神同人社区</title>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->

    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>

    <script>
        $(function () {
            $.ajax({
                url: "tianFu/getAll",
                contentType: "application/json;charset=UTF-8",
                /*data:'{"src":"hehe"}',*/       /*asdas千万不要在data外加{}号*/
                dataType: "json",
                type: "post",
                success: function (data) {

                    if (data.src == "00") {
                        $("#tianfuimg").prop("src", "img/tainfu/" + data.src + ".jpg");
                        $("#weekday").text(data.day);
                        for (var i = 0; i < 3; i++) {
                            $("#tainfutext" + i).text("所有！！！");
                        }
                    } else {
                        $("#tianfuimg").prop("src", "img/tainfu/" + data.src + ".jpg");
                        $("#weekday").text(data.day);
                        for (var i = 0; i < 3; i++) {
                            $("#bookName" + i).text(data.books[i].name);
                            $("#tainfutext" + i).text(data.books[i].name);
                            var s1 = "";
                            for (var j = 0; j < data.books[i].roles.length; j++) {
                                s1 += data.books[i].roles[j].name;

                                if (j % 2 != 0) {
                                    s1 += "<br/>";
                                } else {
                                    s1 += "&nbsp;&nbsp;&nbsp;&nbsp;";
                                }
                            }
                            $("#book" + i).html(s1);
                        }
                    }

                    /*                    $("#bookName2").text(data.books[1].name);
                                        $("#bookName3").text(data.books[2].name);*/


                }
            });
        });
    </script>
</head>
<body>
<!-- Hero section -->
<section id="hero" class="text-white tm-font-big tm-parallax">
    <!-- Navigation -->
    <nav class="navbar navbar-expand-md tm-navbar" id="tmNav">
        <div class="container">
            <div class="tm-next">
                <a href="#hero" class="navbar-brand">原神社区</a>
            </div>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <i class="fas fa-bars navbar-toggler-icon"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link tm-nav-link" href="#introduction">天赋素材一览</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link tm-nav-link" href="#work">资料库</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link tm-nav-link" href="#contact">伤害计算器</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="text-center tm-hero-text-container">
        <div class="tm-hero-text-container-inner">
            <h2 class="tm-hero-title">Genshin</h2>
            <p class="tm-hero-subtitle">
                Unofficial Community
                <br/>by 薄暮°
            </p>
        </div>
    </div>

    <div class="tm-next tm-intro-next">
        <a href="#introduction" class="text-center tm-down-arrow-link">
            <i class="fas fa-3x fa-caret-down tm-down-arrow"></i>
        </a>
    </div>
</section>

<section id="introduction" class="tm-section-pad-top">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <img src="" alt="Image" class="img-fluid tm-intro-img" id="tianfuimg"/>
            </div>
            <div class="col-lg-6">
                <div class="tm-intro-text-container">
                    <h2 class="tm-text-primary mb-4 tm-section-title">天赋素材一览</h2>
                    <p class="mb-4 tm-intro-text">
                        今天是 <strong id="weekday"></strong> <br/>
                        今日天赋素材是：<br/>
                        <strong id="tainfutext0"></strong><br/>
                        <strong id="tainfutext1"></strong><br/>
                        <strong id="tainfutext2"></strong>
                    </p>
                    <p class="mb-5 tm-intro-text">
                        如果想查看天赋升级所需的材料数量请点击
                        <a rel="nofollow" href="#">计算</a><br/>
                        如果想查看所有天赋材料总览请点击下面按钮
                    </p>
                    <div class="tm-next">
                        <a href="/tianFu/getA" class="tm-intro-text tm-btn-primary" id="readMore">总览</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="row tm-section-pad-top">
            <div class="col-lg-4">
                <i class="fas fa-4x fa-bus text-center tm-icon"></i>
                <h2 class="text-center tm-text-primary mb-4" id="bookName0"></h2>
                <div id="book0" class="text-center">

                </div>
            </div>

            <div class="col-lg-4 mt-5 mt-lg-0">
                <i class="fas fa-4x fa-bicycle text-center tm-icon"></i>
                <h2 class="text-center tm-text-primary mb-4" id="bookName1"></h2>
                <div id="book1" class="text-center">

                </div>
            </div>
            <div class="col-lg-4 mt-5 mt-lg-0">
                <i class="fas fa-4x fa-city text-center tm-icon"></i>
                <h2 class="text-center tm-text-primary mb-4" id="bookName2"></h2>
                <div id="book2" class="text-center">

                </div>
            </div>
        </div>
    </div>
</section>
<section id="work" class="tm-section-pad-top">
    <div class="container tm-container-gallery">
        <div class="row">
            <div class="text-center col-12">
                <h2 class="tm-text-primary tm-section-title mb-4">资料库</h2>
                <p class="mx-auto tm-work-description">
                </p>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <div class="mx-auto tm-gallery-container">
                    <div class="grid tm-gallery">
                        <a href="/findRole/role?page=1">
                            <figure class="effect-honey tm-gallery-item">
                                <img src="img/index/a.jpg" alt="Image" class="img-fluid">
                                <figcaption>
                                    <h2><i>Role <span>角色</span><br/> 资料</i></h2>
                                </figcaption>
                            </figure>
                        </a>
                        <a href="/findWeapon/weapon?page=1">
                            <figure class="effect-honey tm-gallery-item">
                                <img src="img/index/b.jpg" alt="Image" class="img-fluid">
                                <figcaption>
                                    <h2><i>Weapon <span>武器</span><br/> 资料</i></h2>
                                </figcaption>
                            </figure>
                        </a>
                        <a href="/findRelics/relics?page=1">
                            <figure class="effect-honey tm-gallery-item">
                                <img src="img/gallery-tn-03.jpg" alt="Image" class="img-fluid">
                                <figcaption>
                                    <h2><i>Relics <span>圣遗物</span> 资料</i></h2>
                                </figcaption>
                            </figure>
                        </a>
                        <a href="img/gallery-img-04.jpg">
                            <figure class="effect-honey tm-gallery-item">
                                <img src="img/gallery-tn-04.jpg" alt="Image" class="img-fluid">
                                <figcaption>
                                    <h2><i>Dreamy <span>Honey</span> Now</i></h2>
                                </figcaption>
                            </figure>
                        </a>
                        <a href="img/gallery-img-05.jpg">
                            <figure class="effect-honey tm-gallery-item">
                                <img src="img/gallery-tn-05.jpg" alt="Image" class="img-fluid">
                                <figcaption>
                                    <h2><i>Fifth <span>Honey</span> Now</i></h2>
                                </figcaption>
                            </figure>
                        </a>
                        <a href="img/gallery-img-06.jpg">
                            <figure class="effect-honey tm-gallery-item">
                                <img src="img/gallery-tn-06.jpg" alt="Image" class="img-fluid">
                                <figcaption>
                                    <h2><i>Sixth <span>Honey</span> Now</i></h2>
                                </figcaption>
                            </figure>
                        </a>
                        <a href="img/gallery-img-01.jpg">
                            <figure class="effect-honey tm-gallery-item">
                                <img src="img/gallery-tn-01.jpg" alt="Image" class="img-fluid">
                                <figcaption>
                                    <h2><i>Dreamy <span>Honey</span> Now</i></h2>
                                </figcaption>
                            </figure>
                        </a>
                        <a href="img/gallery-img-02.jpg">
                            <figure class="effect-honey tm-gallery-item">
                                <img src="img/gallery-tn-02.jpg" alt="Image" class="img-fluid">
                                <figcaption>
                                    <h2><i>Eighth <span>Honey</span> Now</i></h2>
                                </figcaption>
                            </figure>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Contact -->
<section id="contact" class="tm-section-pad-top tm-parallax-2">
    <div class="container tm-container-contact">
        <div class="row">
            <div class="col-12">
                <h2 class="mb-4 tm-section-title">伤害计算器</h2>
                <p class="mb-5">
                </p>
            </div>

            <div class="col-sm-12 col-md-6 d-flex align-items-center tm-contact-item">
                <a href="calculator.jsp" class="tm-contact-item-link">
                    <i class="fas fa-3x fa-calculator mr-4"></i>
                    <span class="mb-0">简易伤害计算器</span>
                </a>
            </div>
            <div class="col-sm-12 col-md-6 d-flex align-items-center tm-contact-item">
                <a href="mailto:info@company.co" class="tm-contact-item-link">
                    <i class="fas fa-3x fa-envelope mr-4"></i>
                    <span class="mb-0">info@company.co</span>
                </a>
            </div>
            <div class="col-sm-12 col-md-6 d-flex align-items-center tm-contact-item">
                <a href="#" class="tm-contact-item-link">
                    <i class="fas fa-3x fa-map-marker-alt mr-4"></i>
                    <span class="mb-0">回到顶部</span>
                </a>
            </div>
        </div>
    </div>
    <footer class="text-center small tm-footer">
        <p class="mb-0">Copyright &copy; 2019.Company name All rights reserved.<a target="_blank"
                                                                                  href="http://sc.chinaz.com/moban/"></a>
        </p>
    </footer>
</section>
<script src="js/jquery-1.9.1.min.js"></script>
<script src="slick/slick.min.js"></script>
<script src="magnific-popup/jquery.magnific-popup.min.js"></script>
<script src="js/jquery.singlePageNav.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>

    function getOffSet(){
        var _offset = 450;
        var windowHeight = window.innerHeight;

        if(windowHeight > 500) {
            _offset = 400;
        }
        if(windowHeight > 680) {
            _offset = 300
        }
        if(windowHeight > 830) {
            _offset = 210;
        }

        return _offset;
    }

    function setParallaxPosition($doc, multiplier, $object){
        var offset = getOffSet();
        var from_top = $doc.scrollTop(),
            bg_css = 'center ' +(multiplier * from_top - offset) + 'px';
        $object.css({"background-position" : bg_css });
    }

    var background_image_parallax = function($object, multiplier, forceSet){
        multiplier = typeof multiplier !== 'undefined' ? multiplier : 0.5;
        multiplier = 1 - multiplier;
        var $doc = $(document);
        // $object.css({"background-attatchment" : "fixed"});

        if(forceSet) {
            setParallaxPosition($doc, multiplier, $object);
        } else {
            $(window).scroll(function(){
                setParallaxPosition($doc, multiplier, $object);
            });
        }
    };

    var background_image_parallax_2 = function($object, multiplier){
        multiplier = typeof multiplier !== 'undefined' ? multiplier : 0.5;
        multiplier = 1 - multiplier;
        var $doc = $(document);
        $object.css({"background-attachment" : "fixed"});
        $(window).scroll(function(){
            var firstTop = $object.offset().top,
                pos = $(window).scrollTop(),
                yPos = Math.round((multiplier * (firstTop - pos)) - 186);

            var bg_css = 'center ' + yPos + 'px';

            $object.css({"background-position" : bg_css });
        });
    };

    $(function(){
        // Hero Section - Background Parallax
        background_image_parallax($(".tm-parallax"), 0.30, false);
        background_image_parallax_2($("#contact"), 0.80);

        // Handle window resize
        window.addEventListener('resize', function(){
            background_image_parallax($(".tm-parallax"), 0.30, true);
        }, true);

        // Detect window scroll and update navbar
        $(window).scroll(function(e){
            if($(document).scrollTop() > 120) {
                $('.tm-navbar').addClass("scroll");
            } else {
                $('.tm-navbar').removeClass("scroll");
            }
        });

        // Close mobile menu after click
        $('#tmNav a').on('click', function(){
            $('.navbar-collapse').removeClass('show');
        })

        // Scroll to corresponding section with animation
        $('#tmNav').singlePageNav();

        // Add smooth scrolling to all links
        // https://www.w3schools.com/howto/howto_css_smooth_scroll.asp
        $("a").on('click', function(event) {
            if (this.hash !== "") {
                event.preventDefault();
                var hash = this.hash;

                $('html, body').animate({
                    scrollTop: $(hash).offset().top
                }, 400, function(){
                    window.location.hash = hash;
                });
            } // End if
        });

        // Pop up
        /*$('.tm-gallery').magnificPopup({
            delegate: 'a',
            type: 'image',
            gallery: { enabled: false }
        });*/

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
    });
</script>
</body>
</html>