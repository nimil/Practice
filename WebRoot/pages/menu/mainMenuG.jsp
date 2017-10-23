<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<!--[if lt IE 7]><html class="ie6 ie"><![endif]-->
<!--[if IE 7]><html class="ie7 ie"><![endif]-->
<!--[if IE 8]><html class="ie8 ie"><![endif]-->
<!--[if gt IE 8]><!-->
<html lang="ja" class="">
<!--<![endif]-->
	<head>
		<meta charset="UTF-8">
		<!--script frontend-->
		<script type="text/javascript" src="../../js/lib/jquery/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/lib/jquery_plugin/bs/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../../js/lib/jquery_plugin/placeholder/jquery.placeholder.js"></script>
		<link id="icon" href="../../image/s.ico" rel="icon">
		<!--script 〓system-->

		<!--styles common-->
		<link href="../../js/lib/jquery_plugin/bs/css/bootstrap.min.css" rel="stylesheet" type="text/css">
		<link href="../../js/lib/jquery_plugin/bs/css/bootstrap-responsive.css" rel="stylesheet" type="text/css">
		<link href="../../css/common/bootstrap_setup.css" rel="stylesheet" type="text/css">
		<link href="../../css/common/common.css" rel="stylesheet" type="text/css">
		<link href="../../css/menu/main.css" rel="stylesheet" type="text/css">
	</head>
<body>
<!--▼▼▼header▼▼▼-->
<header>
	<div class="navbar navbar-inverse">
		<div class="navbar-inner">
			<div class="container">
				<button data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar" type="button">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<!--logo-->
				<ul class="nav nav-pills logo">
					<li>
						<a class="logo" href="/OMS/pages/menu/mainMenuG.jsp" style="padding: 0px;">
						<img alt="" src="../../images/logo.png"><span style="padding-left: 10px;padding-top:10px;padding-bottom:5px;color:#EEEEEE;font-size: 23px;font-weight: bold;vertical-align:middle;">订单管理系统</span>
						</a>
					</li>
				</ul>
				<!--navi-->
				<div class="nav-collapse collapse">
					<ul class="nav pull-right user">
						<li class="dropdown">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-user icon-white unit"></i>${adminUserBean.user_nm }<b class="caret"></b>
							</a>
							<ul class="dropdown-menu" style="z-index:1000000;">
								<li><a href="../common/resetPassword.jsp">修改密码</a></li>
								<li class="divider"></li>
								<li><a href="../login.jsp">退出系统</a></li>
							</ul>
						</li>
						<li class="" style="border-left-width: 0px;">
							<a class="" style="border-left-width: 0px;" data-toggle="dropdown" href="#">
								<span class="label label-info" style="background:#4f81bd;padding: 3px 4px;width:30px;height: 14px;text-align:center;border-radius:10px;font-size: 13px;">管理</span>
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</header>
<!--▼▼▼search▼▼▼-->
<div class="container-fluid search disabled">
	<div class="row-fluid">
	</div>
</div>
<!--▼▼▼contents(field type)▼▼▼-->
<div class="container-fluid contents">
	<div class="row-fluid">
		<div class="span">
			<div class="row-fluid entrance" style="padding-top: 50px;">
				<div class="" align="center">
					<!--〓ボタンエリア-->
					<div class="row-fluid search-button" >
						<table>
								<tbody>
									<tr>
										<td>
											<div class="btn btn-success btn-panel" onclick="window.location='../component/order/orderInsert.html?login=g'">
												<img src="../../images/newOrderform.png"><p class="font-title">新订单录入</p>
											</div>
										</td>
										<td>
											<div class="btn btn-success btn-panel" onclick="window.location='../component/order/orderSearch.html?login=g'">
												<img src="../../images/editOrderform.png"><p class="font-title">订单查询/变更</p>
											</div>
										</td>
										<td>
											<div class="btn btn-success btn-panel" onclick="window.location='../component/invoice/invoiceSearch.html?login=g'">
												<img src="../../images/invoice.png"><p class="font-title">发票录入</p>
											</div>
										</td>
									</tr>
									<tr>
										<td>
											<div class="btn btn-success btn-panel"   onclick="window.location='../component/payment/paymentSearch.html?login=g'">
												<img src="../../images/collections.png"><p class="font-title">实际回款查询/录入</p>
											</div>
										</td>
										<td>
											<div class="btn btn-success btn-panel" onclick="window.location='../component/download/fileDownload.html?login=g'">
												<img src="../../images/Download.png"><p class="font-title">数据下载</p>
											</div>
										</td>
										<td>
											<div class="btn btn-success btn-panel" onclick="window.location='../component/admin/userMaster.html?login=g'">
												<img src="../../images/User.png"><p class="font-title">用户管理 </p>
											</div>
										</td>
									</tr>
									<tr>
										<td>
											<div class="btn btn-success btn-panel" onclick="window.location='../component/admin/customerMaster.html?login=g'" >
												<img src="../../images/Contacts_1.png"><p class="font-title">客户管理</p>
											</div>
										</td>
										<td>
											<div class="btn btn-success btn-panel" onclick="window.location='../component/admin/agencyMaster.html?login=g'">
												<img src="../../images/Library.png"><p class="font-title">代理商管理</p>
											</div>
										</td>
										<td>
											<div class="btn btn-success btn-panel" onclick="window.location='../component/admin/currencyMaster.html?login=g'">
												<img src="../../images/Currency- Dollar.png"><p class="font-title">货币管理</p>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>