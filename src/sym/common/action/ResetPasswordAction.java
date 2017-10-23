package sym.common.action;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import sym.common.bean.AdminUserBean;

import sym.common.service.impl.ResetPasswordServiceimpl;

public class ResetPasswordAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ResetPasswordAction() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	@Override
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		if("update".equals(method))
		{
			setPassword(request,response);
		}

	}

	private void setPassword(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String oldpwd=request.getParameter("password_old");
		String newpasswd=request.getParameter("password_1");
		AdminUserBean aub=new AdminUserBean();
		 HttpSession session=request.getSession();
    	 aub= (AdminUserBean) session.getAttribute("adminUserBean");
    	 String User_cd=aub.getUser_cd();
    	 ResetPasswordServiceimpl rpi=new ResetPasswordServiceimpl();
		boolean oldpwdbl= rpi.findpasswd(oldpwd, User_cd);
		if(oldpwdbl){
			boolean issuss=new ResetPasswordServiceimpl().updatepasswd(User_cd, newpasswd);
			if(!issuss){
				session.setAttribute("result", "服务器内部错误更改失败请谅解！");
			}else{
				try {
					response.sendRedirect("/OMS/pages/login.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}else{
		session.setAttribute("message","原密码输入错误，请重新输入");
		try {
			request.getRequestDispatcher("/pages/common/resetPassword.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	@Override
	public void init() throws ServletException {
		// Put your code here
	}

}
