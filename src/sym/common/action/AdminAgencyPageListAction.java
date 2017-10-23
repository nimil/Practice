package sym.common.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import sym.common.bean.AdminAgencyBean;
import sym.common.bean.AdminUserBean;
import sym.common.service.AdminAgencyPageListService;
import sym.common.service.impl.AdminAgencyPageListServiceimpl;


public class AdminAgencyPageListAction extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private static AdminAgencyPageListService aals=new AdminAgencyPageListServiceimpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if("searchone".equals(request.getParameter("optype"))){
			
			searchone(request,response);
		}else if("agencyadd".equals(request.getParameter("optype"))){
			agencyadd(request,response);
		}else if("update".equals(request.getParameter("optype"))){
			updatea(request,response);
			
		}
		else{
			searchuse(request,response);
			
		}
	}

	private void updatea(HttpServletRequest request, HttpServletResponse response) {
			String acd=request.getParameter("acd");
			String aname=request.getParameter("aname");
			String uname=request.getParameter("uname");
			String status=request.getParameter("status");
			int i=aals.updatea(acd, aname, uname, status);
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

	private void agencyadd(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String aname=request.getParameter("aname");
		String status=request.getParameter("status");
		String agency=request.getParameter("agency");
		String updateid=((AdminUserBean)request.getSession().getAttribute("adminUserBean")).getUser_cd();
		int i=aals.agencyadd(aname, status, agency, updateid);
		if(i>0){
			response.getWriter().write("success");
		}else{
			response.getWriter().write("defeat");
		}
	}

	private void searchuse(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<AdminUserBean> list=aals.searchuse(request.getParameter("aname"));
		String json=JSON.toJSONString(list);
		//System.out.println(json);
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void searchone(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String aname=request.getParameter("aname");
		String sname=request.getParameter("sname");
		String[] status=request.getParameterValues("status[]");
		//System.out.println("AdminAgencyPageListAction.searchone()"+aname+sname+status[0]);
		List<AdminAgencyBean> list111=aals.searchone(aname, sname, status);
		String json=JSON.toJSONString(list111);
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
