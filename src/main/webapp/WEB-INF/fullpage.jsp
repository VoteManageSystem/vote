<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fullPage.js/2.8.1/jquery.fullPage.css">
 
<script src='http://cdn.bootcss.com/jquery/1.10.1/jquery.min.js'></script>
 
<script src="https://cdnjs.cloudflare.com/ajax/libs/fullPage.js/2.8.1/jquery.fullPage.min.js"></script>

<script src='https://cdnjs.cloudflare.com/ajax/libs/jQuery-slimScroll/1.3.8/jquery.slimscroll.min.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-sale=1,user-scalable=no">
<title>Insert title here</title>
<style>
 body{
 color:#fff;
 }
 .slide{
   font-size:30px;
   text-align:center;
 }
 #header{
   position:fixed;
   top:0;
   right:200px;
   font-size:40px;
   text-align:center;
 }
 #fullpageMenu{
   position:fixed;
   top:0;
   z-index:999;
   font-size:30px;
 }
</style>
</head>
<body>
<div id="header">Header</div>
<ul id="fullpageMenu">
<li data-menuanchor="page1" class="activc"><a href="#page1">1 section</a></li>
<li data-menuanchor="page2" ><a href="#page2">2 section</a></li>
<li data-menuanchor="page3" ><a href="#page3">3 section</a></li>
<li data-menuanchor="page4" ><a href="#page4">4 section</a></li>
</ul>
<div id="fullpage">
    <div class="section "><h1>这是第一屏</h1></div>
    <div class="section "> 
	    <div class="slide">Slide1</div>
	    <div class="slide">Slide2</div>
	    <div class="slide">Slide3</div>
	    <div class="slide">Slide4</div>
    </div>
    <div class="section "><h1>这是第三屏</h1></div>
    <div class="section "><h1>这是第四屏</h1></div>
</div>
<!--  <div id="section">
    <div class="slide">Slide1</div>
    <div class="slide">Slide2</div>
    <div class="slide">Slide3</div>
    <div class="slide">Slide4</div>
</div>-->
<script type="text/javascript">
   $(document).ready(function(){
	   $('#fullpage').fullpage({
		   sectionsColor:['green','red','blue','purple'],
		   //controlArrows:false, //是否显示箭头默认true
		   //verticalCentered:false, //是否居中显示内容，默认true
		   //resize:true //字体是否随着窗口缩放而缩放
		   //scrollingSpeed:2000 //滚动速度，单位为毫秒，默认为700
	       anchors:['page1','page2','page3','page4'],//锚链接
	      // lockAnchors:true //锁定锚链接
	      //loopTop:true,
	      //loopBottom:true,
	      //loopHorizontal:true
	      //autoScrolling:true//是否使用插件的滚动方式，默认为true
	      //scrolBar:true//是否包含滚动条
	      //paddingTop:200px,//section的间距
	      //paddingBottom:0
	      //fixedElements: '#header', //固定元素
	      //continuousVertical:true ,//是否循环滚动，默认为false，于loopTop或者loopBottom那样跳动，且不能同时设置
	      //recordHistory:true, //可以记录页面滚动的历史，通过浏览器的前进后退来导航
	      //menu:'#fullpageMenu',
	     
	      //navigation:true,
	      //navigationPosition:'right',
	      //navigationTooltips:['page1','page2','page3','page4'], // 小圆点导航
	      //showActiveTooltip:true,
	      
	      //slidesNavigation:true,
	      //slidesNavPosition:'top'//幻灯片导航的位置
	      
	      scrollOverflow:true //满屏不够的时候出现滚动条
	   });
	   
   });

</script>
</body>
</html>