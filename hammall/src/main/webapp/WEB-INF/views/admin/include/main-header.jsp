<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<header class="main-header">
<!-- Logo -->
<a href="/admin/admin_process" class="logo" style="background-color:#fd7e14"> <!-- mini logo for sidebar mini 50x50 pixels -->
	<span class="logo-mini"> <b>A</b>LT
</span> <!-- logo for regular state and mobile devices -->
 <span class="logo-lg"> 
 	<b >HamMall</b>
</span>
</a>

<!-- Header Navbar -->
<nav class="navbar navbar-static-top" role="navigation" style="background-color:#ffc107">
	<!-- Sidebar toggle button-->
	<a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button"> <span class="sr-only">Toggle navigation</span>
	</a>
	<!-- Navbar Right Menu -->
	<div class="navbar-custom-menu">
		<ul class="nav navbar-nav">
			<li>
			<span>최근 로그인시간: 
				<fmt:formatDate value="${sessionScope.adLoginStatus.admin_date_late}" pattern="yyyy-MM-dd HH:mm:ss"/> 
			</span>
			</li>
			<li>
			<span>&nbsp|&nbsp</span>
			<span>
				${sessionScope.adLoginStatus.admin_name}님 로그인중
			</span>
			</li>
			<br>
			<li style="float: right;">
				<form action="/admin/admin_logout" method="post" >
					<input type="submit" value="로그아웃">
				</form>
			</li>
			<li style="float: right;">
				<form action="/admin/adFormModify" method="get" >
					<input type="submit" value="정보수정">
				</form>
			</li>
			
		</ul>
	</div>
</nav>
</header>