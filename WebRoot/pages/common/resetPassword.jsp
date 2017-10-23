<%@ page language="java" pageEncoding="UTF-8" %>

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
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery_plugin/bs/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery_plugin/placeholder/jquery.placeholder.js"></script>
		<link id="icon" href="${pageContext.request.contextPath}/image/s.ico" rel="icon">
		<!--script 〓system-->

		<!--styles common-->
		<link href="${pageContext.request.contextPath}/js/lib/jquery_plugin/bs/css/bootstrap.min.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/js/lib/jquery_plugin/bs/css/bootstrap-responsive.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/common/bootstrap_setup.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/common/common.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/menu/main.css" rel="stylesheet" type="text/css">
	<style type="text/css">
			#span01,#span02,#span03,#span04,#span05{
				color: red;
			}
		</style>
	<script type="text/javascript">
	  //校验旧密码js代码 checkOldPass()
	  function checkOldPass(){
		  var oldpass=document.getElementById("password_old");
		  var oldpwd=oldpass.value.length;
		  var span1=document.getElementById("span01");
		  if(oldpwd==0){
			  span1.innerHTML="密码不能为空(⊙o⊙)…";
			  return false;
		  }else if(oldpwd>=15){
			  span1.innerHTML="您输入的密码长度超过了十五位，短点吧~~~";
			  oldpass.value="";
		     return false;
		  }
		  else{
			  return true;
		  }
		  
	  }
	  
	  //校验新密码 checkPass1()
	   function checkPass1(){
		  var newpass=document.getElementById("password_1");
		  var pwdlen=newpass.value.length;
		  var span2=document.getElementById("span02");
		  if(pwdlen==0){
			  span2.innerHTML="确认密码不能为空(⊙o⊙)…";
			  return false;
		  }else if(pwdlen>=15){
			  span2.innerHTML="您输入的确认密码长度超过了十五位，短点吧~~~";
			  oldpass.value="";
			     return false;
			  }
		  else{
			  return true;
		  }
		  
	  }
	  
	  //校验两次新密码输入是否一致 checkPass2()
	   function checkPass2(){
		  var newpass1=document.getElementById("password_2");
		  var pwdlen=newpass1.value.length;
		  var pw2=newpass1.value;
		  var pw1=document.getElementById("password_1").value;
		  var span3=document.getElementById("span03");
		  if(pwdlen==0){
			  span3.innerHTML="密码不能为空(⊙o⊙)…";
			  return false;
		  }else if(pwdlen>=15){
			  span3.innerHTML="您输入的确认密码长度超过了十五位，短点吧~~~";
			  oldpass.value="";
			     return false;
			  }
		  else{
			  if(pw2!=pw1){
			   span3.innerHTML="您两次输入的密码不一致！！！";
				  return false;
			  }
			  else{
				  return true;
				  }
		  }
		  
	  }
	  
	  function checkAll()
	  {
	    if(checkOldPass() && checkPass1() && checkPass2())
	    {
	      document.forms[0].action="/OMS/ResetPasswordAction?method=update";
	      document.forms[0].submit();
	      return true;
	    }
	  }
	
	
	
	</script>
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
						<img alt="" src="/OMS/images/logo.png"><span style="padding-left: 10px;padding-top:10px;padding-bottom:5px;color:#EEEEEE;font-size: 23px;font-weight: bold;vertical-align:middle;">订单管理系统</span>
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
							<ul class="dropdown-menu" style="z-login:1000000;">
								<li><a href="#">修改密码</a></li>
								<li class="divider"></li>
								<li><a href="/OMS/pages/login.jsp">退出系统</a></li>
							</ul>
						</li>
						<li class="" style="border-left-width: 0px;">
							<a class="" style="border-left-width: 0px;" data-toggle="dropdown" href="#">
								<span class="label label-info" style="background:#4f81bd;padding: 3px 4px;width:30px;height: 14px;text-align:center;border-radius:10px;font-size: 13px;">管理</span>
							</a>
						</li>
					</ul>
					<ul class="nav pull-right navi">
						<li class=""><a href="/OMS/pages/menu/mainMenuG.jsp">返回主菜单</a></li>
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
<form action="" method="post">
<div class="main">
	<div class="banner">
		<span>修改密码</span>
	</div>
	<div class="content" style=" min-height: 300px;border-top:1px solid #0088CC;">
		<div class = "search-result">
			<div id="search_result" style="padding:10px;margin-top:80px;">
				<table class="table-edit table-striped table-bordered">
					<tbody>
						<tr>
							<td style="width:230px" class="right_align">
							<div class="">当前密码:</div>
							</td>
							<td>
							<div>
							<input id="password_old" class="span3 jq-placeholder must" type="password" title="" placeholder="请输入当前密码" value="" name="password_old" onblur="checkOldPass();">
							<span id="span01"></span>
							</div>
							</td>
						</tr>
						<tr>
							<td class="right_align">
								<div class="">新密码:</div>
							</td>
							<td>
								<div>
									<input id="password_1" class="span3 jq-placeholder must" type="password" title="" value="" placeholder="请输入新密码" name="password_1">
								<span id="span02"></span>
								</div>
							</td>
						</tr>
						<tr>
							<td class="right_align">
								<div class="">确认新密码:</div>
							</td>
							<td>
								<div>
									<input id="password_2" class="span3 jq-placeholder must" type="password" title="" value="" placeholder="请输入确认新密码" name="password_2">
								<span id="span03"></span>
								</div>
							</td>
						</tr>
						<tr>
						<td><span id="span04">${message}</span><span id="span05">${result}</span></td>
						</tr>
					</tbody>
				</table>
				
			</div>
	</div>

</div>

<div class="bottom_block">

		<a class="btn btn-primary btn-middle" href="javascript:checkAll()">确定</a>
		<a class="btn btn-info btn-middle-aft" style="" href="/OMS/pages/menu/mainMenuG.jsp">返回主菜单</a>
</div>

</div>
</form>

</body>
</html>
