package sym.common.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import sym.common.bean.AdminUserBean;
import sym.common.service.AdminUserService;
import sym.common.service.impl.AdminUserServiceImpl;


public class AdminUserAction extends HttpServlet {
	private static AdminUserService aus=new AdminUserServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			if("updateuser".equals(request.getParameter("optype"))){
				updateuser(request,response);
			}else if("useradd".equals(request.getParameter("optype"))){
				useradd(request,response);
			}else{
				userselect(request,response);
			}
	}

	private void userselect(HttpServletRequest request, HttpServletResponse response) {
		String uname=request.getParameter("uname");
		String[] dept=request.getParameterValues("dept[]");
		String[] status=request.getParameterValues("status[]");
		String tel=request.getParameter("tel");
		 List<AdminUserBean> list=new ArrayList<AdminUserBean>();
		 list=aus.selectall(uname,dept,status,tel);
		 String json=JSON.toJSONString(list);
//		 System.out.println(json);
		 try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void useradd(HttpServletRequest request, HttpServletResponse response) {
		
	
		String uname=request.getParameter("uname");
//		System.out.println(uname);
//		int i=1/0;
		String tel=request.getParameter("tel");
		String dept=request.getParameter("dept");
		String status=request.getParameter("status");
		String updateid=((AdminUserBean)request.getSession().getAttribute("adminUserBean")).getUser_cd();
		 boolean issuccess=aus.UserAdd(uname, tel, dept, status, updateid);
		 response.setCharacterEncoding("UTF-8");
		 if(issuccess){
			 AdminUserBean aub=aus.searchone(uname, dept, tel);
			 if("M".equals(aub.getUser_owner_flg())){
				 aub.setUser_owner_flg("管理");
			 }else if("S".equals(aub.getUser_owner_flg())){
				 aub.setUser_owner_flg("业务");
			 }else{
				 aub.setUser_owner_flg("财务");
			 }
			 if("T".equals(aub.getIs_valid())){
				 aub.setIs_valid("有效");
			 }else{
				 aub.setIs_valid("无效");
			 }
			 String data=JSON.toJSONString(aub);
			 //System.out.println(data);
			 try {
				response.getWriter().write(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }else{
		
		 }
		 
	}

	private void updateuser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String uname=request.getParameter("uname");
		String uid=request.getParameter("uid");
		String tel=request.getParameter("tel");
		String dept=request.getParameter("dept");
		String status=request.getParameter("status");
		int i=aus.updateuser(uid, uname, tel, dept, status);
		if(i>0){
			try {
				response.getWriter().write("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				response.getWriter().write("defeat");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
