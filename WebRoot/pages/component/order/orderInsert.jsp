<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja" class="">
<!--<![endif]-->
<head>
<%
  String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>
	<!--script frontend-->
	<script type="text/javascript" src="<%=basePath%>/js/lib/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/lib/jquery_plugin/bs/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/lib/jquery_plugin/placeholder/jquery.placeholder.js"></script>
	<script src="<%=basePath%>/js/common/datepicker.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/lib/jquery_plugin/ui/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/common/popup.js"></script>
	<script src="<%=basePath%>/js/MonthPicker/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/lib/jquery_alert/jquery.alerts.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/component/orderInsert.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/common/monthPicker.js"></script>
	<link id="icon" href="<%=basePath%>/images/s.ico" rel="icon">
	<!--script 〓system-->
	<!--styles common-->
	<link href="<%=basePath%>/js/lib/jquery_plugin/bs/css/bootstrap.min.css" rel="stylesheet" type="text/css">

	<link href="<%=basePath%>/js/lib/jquery_plugin/bs/css/bootstrap-responsive.css" rel="stylesheet" type="text/css">
	<link href="<%=basePath%>/css/common/bootstrap_setup.css" rel="stylesheet" type="text/css">
	<link href="<%=basePath%>/js/lib/jquery_plugin/ui/jquery-ui.css" rel="stylesheet" type="text/css">
	<link href="<%=basePath%>/css/common/common.css" rel="stylesheet" type="text/css">
	<link href="<%=basePath%>/css/common/popup.css" rel="stylesheet" type="text/css">
	<link href="<%=basePath%>/css/common/datepicker.css" rel="stylesheet">
	<link href="<%=basePath%>/js/lib/jquery_alert/jquery.alerts.css" rel="stylesheet" type="text/css">
	<link href="<%=basePath%>/css/common/monthPicker.css" rel="stylesheet" type="text/css">

	<script type="text/javascript">
	var path = '<%=basePath%>';
$(function(){

    $("#orderUtil").load('<%=basePath%>/pages/component/order/orderUtil.jsp');
 
	$('#agency_search').on('click',function(e){
		$.ajax({  
            type: "POST",  
            url:"<%=basePath%>agentAction?method=findAgent&showCount=10&pageNo=1",  
            async: false,  
            error: function(request) {  
                alert("未知错误！");  
            },  
            success: function(data) {  
               $("#pop_table").load('<%=basePath%>/pages/component/admin/agentUtil.jsp');
            }  
        }); 
    });  
    $('#customer_search').on('click',function(e){
		$.ajax({  
            type: "POST",  
            url:"<%=basePath%>customerAction?method=findCustomer&showCount=10&pageNo=1",  
            async: false,  
            error: function(request) {  
                alert("未知错误！");  
            },  
            success: function(data) {  
               $("#pop_table_customer").load('<%=basePath%>/pages/component/admin/customerUtil.jsp');
            }  
        }); 
    }); 
    $("#account").blur(function(){
	      var total = Number($("#bid_price").val())*Number($("#account").val());
	      $("#total").val(total);
    }); 
     $("#comm_rate").blur(function(){
	     var comm_pay = (Number($("#total").val())/100)*Number($("#comm_rate").val());
     	 $("#comm_pay").val(comm_pay);
    }); 
    
});
		function changeMonth(id) {
			dateSelect($('#'+id).val(), function(year, month){
					$('#'+id).val(year + "/" + month);
			});
		}

	/**
	  * 代理商翻页
	  *@author guojl
	  */
	function queryAgent(pageNo,display_rows)
	{
	    if(pageNo<1){
	    	alert("已经是第一页!");
	    	return false;
	    }
	    if(pageNo > '${pageInforBean.totalPage}'){
	    	alert("已经是最后一页!");
	    	return false;
	    }
		$.ajax({  
		            type: "POST",  
		            url:"<%=basePath%>agentAction?method=findAgent&showCount=10&pageNo=1",  
		            async: false,  
		            error: function(request) {  
		                alert("未知错误！");  
		            },  
		            success: function(data) {  
		               $("#pop_table").load('<%=basePath%>/pages/component/admin/agentUtil.jsp');
		            }  
		        }); 
	}
	/**
	  * 客户翻页
	  *@author guojl
	  */
	function queryCurr(pageNo,display_rows)
	{
	    if(pageNo<1){
	    	alert("已经是第一页!");
	    	return false;
	    }
	    if(pageNo > '${pageInforBean.totalPage}'){
	    	alert("已经是最后一页!");
	    	return false;
	    }
		$('#customer_search').on('click',function(e){
				$.ajax({  
		            type: "POST",  
		            url:"<%=basePath%>customerAction?method=findCustomer&showCount=10&pageNo=1",  
		            async: false,  
		            error: function(request) {  
		                alert("未知错误！");  
		            },  
		            success: function(data) {  
		               $("#pop_table_customer").load('<%=basePath%>/pages/component/admin/customerUtil.jsp');
		            }  
		        }); 
		    });  
	}
	function toAgent(obj){
		$('#agency_id').val($(obj).find("td:eq(1)").text());
		$('#user_name').val($(obj).find("td:eq(2)").text());
		$('#agency_dialog').dialog('close');
	}
	function toCustomer(obj){
		$('#customer_name').val(obj.id);
		$('#customer_dialog').dialog('close');
	}
	function addOrder(){
		$.ajax({  
            type: "POST",  
            url:"<%=basePath%>orderAction?method=addOrder",  
            data:$('#orderForm').serialize(),// 序列化表单值  
            async: false,  
            error: function(request) {  
                alert("未知错误！");  
            },  
            success: function(data) {  
               alert("添加成功！");
               location.href="<%=basePath%>/pages/menu/mainMenuG.jsp";
            }  
        });  
	}
	</script>

	<style type="text/css">
		a {
			cursor: pointer;
			color:#0088CC;
	}
	</style>
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
						<a class="logo" href="../../menu/mainMenuG.html" style="padding: 0px;">
						<img alt="" src="<%=basePath%>/images/logo.png"><span style="padding-left: 10px;padding-top:10px;padding-bottom:5px;color:#EEEEEE;font-size: 23px;font-weight: bold;vertical-align:middle;">订单管理系统</span>
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
								<li><a href="<%=basePath%>/pages/common/resetPassword.jsp">修改密码</a></li>
								<li class="divider"></li>
								<li><a href="<%=basePath%>/loginAction?method=loginOut">退出系统</a></li>
							</ul>
						</li>
						<li class="" style="border-left-width: 0px;">
							<a class="" style="border-left-width: 0px;" data-toggle="dropdown" href="#">
								<span class="label label-info" style="background:#4f81bd;padding: 3px 4px;width:30px;height: 14px;text-align:center;border-radius:10px;font-size: 13px;">管理</span>
							</a>
						</li>
					</ul>
					<ul class="nav pull-right navi">
						<li class=""><a href="<%=basePath%>pages/menu/mainMenuG.jsp">返回主菜单</a></li>
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
<div class="main">
	<div class="banner">
		<span>新订单录入</span>
	</div>
	<div class="content">
		<div style="margin:10px 0;padding:5px 20px;">
			<form id="orderForm">
			<div class="edit-content" style="margin-bottom: 0px;border-top:1px solid #0088CC;padding-top:10px;">
				<table class="edit-table" style="width:95%">
					<tbody>
						<tr>
							<td width="60%">
								<table>
									<tbody>
										<tr>
											<td class="right_align">合同号&nbsp;:&nbsp;</td>
											<td><div style="margin-bottom:8px;"><input class="input-xlarge" type="text" name="num1" 
													style="margin-bottom:3px;width: 120px;ime-mode: disabled"  readonly="readonly" 
													value="${orderIdFirst}">&nbsp;<div style="display:inline">－</div>&nbsp;<input class="input-xlarge" type="text"  readonly="readonly"  name="num2" 
													style="margin-bottom:3px;width: 30px;;ime-mode: disabled"
													value="${orderIdSecond }">
												</div>
											</td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td class="right_align">业务员&nbsp;:&nbsp;</td>
											<td colspan="3">
												<table>
													<tr>
														<td>
															<input type="text" readonly="readonly" style="width: 80px;"  name="salesman" 
																id="user_name" value=""></input>
														</td>
														<td>
															&nbsp;&nbsp;&nbsp;&nbsp;<span>代理商&nbsp;:&nbsp;</span>
														</td>
														<td>
															<i id="agency_search" class="icon icon-search"
															style="background-position: 0 0;padding-top: 0; height: 20px; width: 20px; padding-left: 0;"
															title="查询"></i>
															<i id="agency_clear" class="icon icon-clear"
															style="background-position: 0 0;padding-top: 0; height: 20px; width: 20px; margin-left: 2px; padding-left: 3px;"
															title="清除"></i>
														</td>
														<td>
															<div style="display: inline; margin-left: 3px;width:100px;">
																	<input type="text" readonly="readonly" style="width: 40px;"  name="agent_name" 
																			id="agency_id"></input> <label
																			style="display: inline; margin-left: 3px;"
																			id="agency_name"></label>
															</div>
														</td>
													</tr>
												</table>
											</td>
										</tr>
										<tr>
											<td class="right_align">客户类别&nbsp;:&nbsp;</td>
											<td colspan="3">
												<select  name="client_sort"  style="width:80px;">
													<option></option>
													<option value="A">国网</option>
													<option value="B">南网</option>
													<option value="C">地方</option>
													<option value="D">海外</option>
												</select>
											</td>
										</tr>
										<tr>
											<td class="right_align">客户名称&nbsp;:&nbsp;</td>
											<td colspan="3">
													<!-- <input id="input01" class="" type="text" style="width:300px;"> -->
													<i id="customer_search" class="icon icon-search"
													style="background-position: 0 0; margin-top: -5px; padding-top: 0; height: 20px; width: 20px; padding-left: 0;"
													title="查询"></i>
													<div style="display: inline; margin-left: 3px;">
															<input type="text"  readonly="readonly"  style="width: 300px;" name="client_name" 
																	id="customer_name"></input>
													</div>
											</td>
										</tr>
										<tr>
											<td class="right_align">项目名称&nbsp;:&nbsp;</td>
											<td colspan="3"><input id="input01" class="" name="project_name" 
													type="text" style="margin-bottom:5px;width: 300px;"></td>
										</tr>
										<tr>
											<td class="right_align">预计发货月&nbsp;:&nbsp;</td>
											<td colspan="3"><input id="test01" type="text" name="deliver_month" 
													style="width: 70px; margin-bottom: 3px; ime-mode: disabled"><img src="<%=basePath%>/images/cal.gif" id="imgs" onclick="changeMonth('test01')" />
											</td>
										</tr>
										<tr>
											<td class="right_align">预计送电月&nbsp;:&nbsp;</td>
											<td><input id="test02" type="text" name="send_month" 
													style="width: 70px; margin-bottom: 5px; ime-mode: disabled"><img src="<%=basePath%>/images/cal.gif" id="imgs" onclick="changeMonth('test02')" />
											</td>
											<!-- <td class="right_align">通电后保证月数&nbsp;:&nbsp;</td>
											<td><input type="text" name=""  style="margin-bottom: 0; width: 60px;text-align:right;"></input>
											</td> -->
										</tr>
										<tr>

										</tr>
									</tbody>
								</table>
							</td>
							<td width="40%">
								<table style="margin-left:30px;">
										<tbody>
												<tr>
														<td class="right_align">投标铜价&nbsp;:&nbsp;</td>
														<td><input type="text" name="bid_price"   id="bid_price"
																style="margin-bottom: 5px; width: 150px; text-align: right;"></td>
												</tr>
												<tr>
														<td class="right_align">金额(货币)&nbsp;:&nbsp;</td>
														<td><input type="text" name="account"  id="account"
																style="margin-bottom: 5px; width: 150px; text-align: right; ime-mode: disabled">
																<select name="curr_name"  style="width: 90px;">
																	<c:forEach items="${currList }" var="name">
																		<option value="${name }">${name }</option>
																	</c:forEach>
														</select></td>
												</tr>
												<tr>
													<td colspan="2"><span>&nbsp;</span></td>
												</tr>
												<tr>
													<td class="right_align">合同总价&nbsp;:&nbsp;</td>
													<td><input id="total" class="" readonly="readonly" type="text"  name="total" 
															style="width: 150px; text-align: right; ime-mode: disabled">
													</td>
												</tr>
												<tr>
													<td class="right_align">佣金率&nbsp;:&nbsp;</td>
													<td><input type="text"  name="comm_rate"  id="comm_rate"
															style="margin-bottom: 5px; width: 50px; text-align: right; ime-mode: disabled">&nbsp;<label style="display:inline;"">%</label>
													</td>
												</tr>
												<tr>
													<td class="right_align">佣金金额&nbsp;:&nbsp;</td>
													<td><input type="text"  readonly="readonly"  name="comm_pay" id="comm_pay"
															style="margin-bottom: 5px; width: 150px; text-align: right; ime-mode: disabled"></td>
												</tr>
												<tr>
														<td colspan="2">

														</td>
												</tr>
										</tbody>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div>
				<table style="width:70%">
				<tr>
					<td>
						<div>
							<span style="position: relative; left: 10px; top: 8px; font-size: 14px; background-color: #FFFFFF;">
								回款比例/预计回款月/预计回款金额:&nbsp;
							</span>
							<div style="padding: 20px 10px;height:83px;margin-top: 0px; border: 1px solid #0088CC;">
									<table style=" margin-left:30px;width:90%">
											<tr>
												<td><input id="input01" class="right_align"  name="scale" 
														type="text"
														style="width: 45px; margin-bottom: 0; ime-mode: disabled">
														:&nbsp;&nbsp;
												<td><input id="input01" class="right_align"  name="scale" 
														type="text"
														style="width: 45px; margin-bottom: 0; ime-mode: disabled">
														:&nbsp;
												<td><input id="input01" class="right_align"  name="scale" 
														type="text"
														style="width: 45px; margin-bottom: 0; ime-mode: disabled">
														:&nbsp;&nbsp;
												<td><input id="input01" class="right_align"  name="scale" 
														type="text"
														style="width: 45px; margin-bottom: 0; ime-mode: disabled">
														:&nbsp;&nbsp;
												<td><input id="input01" class="right_align"  name="scale" 
														type="text"
														style="width: 45px; margin-bottom: 0; ime-mode: disabled">
														:&nbsp;&nbsp;
												<td><input id="input01" class="right_align"  name="scale" 
														type="text"
														style="width: 45px; margin-bottom: 0; ime-mode: disabled">
											</tr>
											<tr>
												<td><input id="input07" type="text"  name="month" 
														style="margin-bottom: 0; width: 70px; ime-mode: disabled"><img src="<%=basePath%>/images/cal.gif" id="imgs" onclick="changeMonth('input07')" />
												<td><input id="input02" type="text"  name="month" 
														style="margin-bottom: 0; width: 70px; ime-mode: disabled"><img src="<%=basePath%>/images/cal.gif" id="imgs" onclick="changeMonth('input02')" />
												<td><input id="input03" type="text" name="month" 
														style="margin-bottom: 0; width: 70px; ime-mode: disabled"><img src="<%=basePath%>/images/cal.gif" id="imgs" onclick="changeMonth('input03')" />
												<td><input id="input04" type="text" name="month" 
														style="margin-bottom: 0; width: 70px; ime-mode: disabled"><img src="<%=basePath%>/images/cal.gif" id="imgs" onclick="changeMonth('input04')" />
												<td><input id="input05" type="text" name="month" 
														style="margin-bottom: 0; width: 70px; ime-mode: disabled"><img src="<%=basePath%>/images/cal.gif" id="imgs" onclick="changeMonth('input05')" />
												<td><input id="input06" type="text" name="month" 
															style="margin-bottom: 0; width: 70px; ime-mode: disabled"><img src="<%=basePath%>/images/cal.gif" id="imgs" onclick="changeMonth('input06')" />
											</tr>
											<tr>
												<td><input id="input01" class="right_align" name="amount" 
														type="text" style="width: 90px; ime-mode: disabled">
												<td><input id="input01" class="right_align" name="amount" 
														type="text" style="width: 90px; ime-mode: disabled">
												<td><input id="input01" class="right_align" name="amount" 
														type="text" style="width: 90px; ime-mode: disabled">
												<td><input id="input01" class="right_align" name="amount" 
														type="text" style="width: 90px; ime-mode: disabled">
												<td><input id="input01" class="right_align" name="amount" 
														type="text" style="width: 90px; ime-mode: disabled">
												<td><input id="input01" class="right_align" name="amount" 
														type="text" style="width: 90px; ime-mode: disabled">
											</tr>
									</table>
							</div>
						</div>
					</td>
				</tr>
				</table>
			</div>
				</form>
			<div id="orderUtil">
			
			</div>
			
		</div>
	</div>
	<div class="bottom_block">
		<a class="btn btn-primary btn-middle" style="" href="javascript:void(0);" onclick="addOrder()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;确认&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
		<a class="btn btn-info btn-middle-aft" style="" href="<%=basePath%>pages/menu/mainMenuG.jsp">返回主菜单</a>
	</div>
</div>

<!-- 代理商dialog -->
		<div id="agency_dialog" style="display:none;">
				<div style="width:100%;border-bottom: 1px solid #0088CC;">
						<div style="color:#0060A4;display:inline;font-size:14px;">业务员&nbsp;:&nbsp;<span style="margin-left:3px;">李四</span></div>
						<span style="float:right">
								<input id="keyword" class="" type="text"
										value="" title="" style="width: 180px;">
								<button class="btn search-btn-easy btn-mini" type="button"
										onclick="">
										<i class="icon-search_mini"></i>
								</button>
						</span>
						<div style="clear:both;"></div>
				</div>

					<div class = "search-result">
						<div id="pop_table" style="padding:10px;margin-top:-10px;">
							
						</div>
					</div>
		</div>



<!-- 选择客户pop -->
<div id="customer_dialog" style="display:none;">
		<div style="width:100%;border-bottom: 1px solid #0088CC;">
				<div style="color:#0060A4;display:inline;font-size:14px;">客户类别&nbsp;:&nbsp;<span style="margin-left:3px;">国网</span></div>
				<span style="float:right">
					<input id="keyword" class="" type="text" value="" title="" style="width: 180px;">
					<button class="btn search-btn-easy btn-mini" type="button"
													onclick="">
													<i class="icon-search_mini"></i>
					</button>
				</span>
				<div style="clear:both;"></div>
		</div>

		<div class = "search-result">
			<div id="pop_table_customer" style="padding:10px;margin-top:-10px;">
					
			</div>
		</div>
		</div>


<div id="dateSelectPop" style="display:none">
				<div class="modal-body">
								<table style="background: none repeat scroll 0% 0% rgb(234, 247, 239); width: 100%;">
												<tr>
																<td>
																				<div>
																								<table style="width: 100%;text-align: center;" class="sel_table_year">
																												<tr>
																																<td id="year_back" style="cursor: pointer;"><span>&lt;</span></td>
																																<td id="year_next" style="cursor: pointer;"><span>&gt;</span></td>
																												</tr>
																												<tr>
																																<td><div id="sel_year1" class="p_sel_year"></div></td>
																																<td><div id="sel_year6" class="p_sel_year"></div></td>
																												</tr>
																												<tr>
																																<td><div id="sel_year2" class="p_sel_year"></div></td>
																																<td><div id="sel_year7" class="p_sel_year"></div></td>
																												</tr>
																												<tr>
																																<td><div id="sel_year3" class="p_sel_year"></div></td>
																																<td><div id="sel_year8" class="p_sel_year"></div></td>
																												</tr>
																												<tr>
																																<td><div id="sel_year4" class="p_sel_year"></div></td>
																																<td><div id="sel_year9" class="p_sel_year"></div></td>
																												</tr>
																												<tr>
																																<td><div id="sel_year5" class="p_sel_year"></div></td>
																																<td><div id="sel_year10" class="p_sel_year"></div></td>
																												</tr>
																								</table>
																				</div>
																</td>
																<td style="background-color: rgb(0, 143, 32); margin-right: 5px;">
																</td>
																<td>
																				<div>
																								<table style="width: 100%;text-align: center;" class="sel_table_month">
																												<tr>
																																<td><div id="sel_month1" class="p_sel_month">01<span class="sel_month_unit">月</span></div></td>
																																<td><div id="sel_month7" class="p_sel_month">07<span class="sel_month_unit">月</span></div></td>
																												</tr>
																												<tr>
																																<td><div id="sel_month2" class="p_sel_month">02<span class="sel_month_unit">月</span></div></td>
																																<td><div id="sel_month8" class="p_sel_month">08<span class="sel_month_unit">月</span></div></td>
																												</tr>
																												<tr>
																																<td><div id="sel_month3" class="p_sel_month">03<span class="sel_month_unit">月</span></div></td>
																																<td><div id="sel_month9" class="p_sel_month">09<span class="sel_month_unit">月</span></div></td>
																												</tr>
																												<tr>
																																<td><div id="sel_month4" class="p_sel_month">04<span class="sel_month_unit">月</span></div></td>
																																<td><div id="sel_month10" class="p_sel_month">10<span class="sel_month_unit">月</span></div></td>
																												</tr>
																												<tr>
																																<td><div id="sel_month5" class="p_sel_month">05<span class="sel_month_unit">月</span></div></td>
																																<td><div id="sel_month11" class="p_sel_month">11<span class="sel_month_unit">月</span></div></td>
																												</tr>
																												<tr>
																																<td><div id="sel_month6" class="p_sel_month">06<span class="sel_month_unit">月</span></div></td>
																																<td><div id="sel_month12" class="p_sel_month">12<span class="sel_month_unit">月</span></div></td>
																												</tr>
																								</table>
																				</div>
																</td>
												</tr>
								</table>
				</div>
</div>


</body>
</html>
