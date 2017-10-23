package sym.common.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import sym.common.bean.AdminCurrencyBean;
import sym.common.bean.AdminUserBean;
import sym.common.service.impl.AdminCurrencyServiceimpl;

public class AdminCurrencyAction extends HttpServlet {
	AdminCurrencyServiceimpl acsi=new AdminCurrencyServiceimpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			if("madd".equals(request.getParameter("optype"))){
				madd(request,response);
			}else if("updatec".equals(request.getParameter("optype"))){
				updatec(request,response);
				
			}
			else{
				selectall(request,response);
			}
	}

	private void updatec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cname=request.getParameter("cname");
		String ccd=request.getParameter("ccd");
		int i=acsi.updatec(ccd, cname);
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

	private void selectall(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String mname=request.getParameter("mname");
		String[] status=request.getParameterValues("status[]");
		List<AdminCurrencyBean> list=acsi.selectall(mname, status);
		String json=JSON.toJSONString(list);
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void madd(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String mcd=request.getParameter("mcd");
		String mname=request.getParameter("mname");
		String status=request.getParameter("status");
		String updateid=((AdminUserBean)request.getSession().getAttribute("adminUserBean")).getUser_cd();
		AdminCurrencyBean acb=acsi.madd(mcd, mname, status, updateid);
		String json=JSON.toJSONString(acb);
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
