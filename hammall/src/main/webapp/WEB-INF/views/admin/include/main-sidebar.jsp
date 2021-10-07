<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<aside class="main-sidebar" style="background-color:#ffc107">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">

				<!-- Sidebar user panel (optional) -->
				<div class="user-panel">
					<div class="pull-left image">
						<img src="/img_all/admin1.png" class="img-circle" alt="User Image">
					</div>
					<div class="pull-left info">
						<p>${sessionScope.adLoginStatus.admin_name}</p>
						<!-- Status -->
						<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
					</div>
				</div>

				<!-- search form (Optional) 
				<form action="#" method="get" class="sidebar-form">
					<div class="input-group">
						<input type="text" name="q" class="form-control" placeholder="Search...">
						<span class="input-group-btn">
							<button type="submit" name="search" id="search-btn" class="btn btn-flat">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
				-->
				
				<!-- /.search form -->

				<!-- Sidebar Menu -->
				<ul class="sidebar-menu" data-widget="tree">
					
					<li class="treeview">
						<a href="#" style="background-color:#fd7e14"><i class="fa fa-link"></i> <span style="color: #343a40">상품관리</span> <span class="pull-right-container">
								<i class="fa fa-angle-left pull-right"></i>
							</span> </a>
						<ul class="treeview-menu" style="background-color:#fd7e14">
							<li>
								<a href="${pageContext.request.contextPath}/admin/product/product_insert" style="color: #343a40">상품등록</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/admin/product/pro_list" style="color: #343a40">상품목록</a>
							</li>
						</ul>
					</li>
					<li class="treeview" >
						<a href="#" style="background-color:#ffc107"><i class="fa fa-link"></i> <span style="color: #343a40">주문관리</span> <span class="pull-right-container">
								<i class="fa fa-angle-left pull-right"></i>
							</span> </a>
						<ul class="treeview-menu" style="background-color:#ffc107">
							<li>
								<a href="${pageContext.request.contextPath}/admin/order/order_list" style="color: #343a40">주문목록</a>
							</li>
						</ul>
					</li>
					<li class="treeview" >
						<a href="#" style="background-color:#fd7e14"><i class="fa fa-link"></i> <span style="color: #343a40">회원관리</span> <span class="pull-right-container">
								<i class="fa fa-angle-left pull-right"></i>
							</span> </a>
						<ul class="treeview-menu" style="background-color:#fd7e14">
							<li>
								<a href="${pageContext.request.contextPath}/admin/member/userInfo_list" style="color: #343a40">회원목록</a>
							</li>
						</ul>
					</li>
					<!-- 
					<li class="treeview" >
						<a href="#" style="background-color:#ffc107"><i class="fa fa-link"></i> <span style="color: #343a40">통계/매출현황관리</span> <span class="pull-right-container">
								<i class="fa fa-angle-left pull-right"></i>
							</span> </a>
						<ul class="treeview-menu" style="background-color:#ffc107">
							<li>
								<a href="/admin/order/order_sale" style="color: #343a40">매출통계</a>
							</li>
						</ul>
					</li>
					 -->
				</ul>
				<!-- /.sidebar-menu -->
			</section>
			<!-- /.sidebar -->
</aside>
