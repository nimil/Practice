package sym.common.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import sym.common.bean.AdminCustomerBean;
import sym.common.bean.AdminUserBean;
import sym.common.service.impl.AdminCustomerServiceimpl;

public class AdminCustomerAction extends HttpServlet {
	AdminCustomerServiceimpl acsi=new AdminCustomerServiceimpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if("cadd".equals(request.getParameter("optype"))){
		cadd(request,response);
		}else if("updatecustomer".equals(request.getParameter("optype"))){
			updatec(request,response);
		}
		else{
			selectallc(request,response);
		}
	}

	private void updatec(HttpServletRequest request, HttpServletResponse response) {
		String cid=request.getParameter("cid");
		String cname=request.getParameter("cname");
		String tel=request.getParameter("tel");
		String ctype=request.getParameter("ctype");
		String status=request.getParameter("status");
		String addr=request.getParameter("addr");
		int i=acsi.updatec(cid, cname, tel, addr, status, ctype);
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

	private void selectallc(HttpServletRequest request, HttpServletResponse response) {
		String cname=request.getParameter("cname");
		String[] ctype=request.getParameterValues("ctype[]");
		String[] status=request.getParameterValues("status[]");
		String ctel=request.getParameter("ctel");
		List<AdminCustomerBean> list=acsi.selectall(cname, ctel, ctype, status);
		String json=JSON.toJSONString(list);
		//System.out.println(json);
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void cadd(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
	String cname=request.getParameter("cname");
	String ctel=request.getParameter("ctel");
	String ctype=request.getParameter("ctype");
	String status=request.getParameter("status");
	String caddr=request.getParameter("caddr");
	String updateid=((AdminUserBean)request.getSession().getAttribute("adminUserBean")).getUser_cd();
	int i=acsi.insertCustomer(cname, ctel, ctype, status, caddr, updateid);
	if(i>0){
		AdminCustomerBean searchCustomer = acsi.searchCustomer(cname, ctel);
		String customer=JSON.toJSONString(searchCustomer);
		response.getWriter().write(customer);
	}else{
		
	}
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
