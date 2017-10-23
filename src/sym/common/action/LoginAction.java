package sym.common.action;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sym.common.bean.AdminUserBean;
import sym.common.service.impl.LoginServiceImpl;

/**
 * �û���¼�Ŀ��Ʋ㴦��
 * @author guojl
 * @version 2014-08-07
 */
public class LoginAction extends HttpServlet {

	/**
	 * doPost����
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		if("login".equals(method))
		{
			doLogin(request,response);
		}
	}
	
	/**
	 * doGet����
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	
	/**
	 * �û���¼ʱ��֤�û���������
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doLogin(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
     //��ȡ���ύ���û���������
     String user_cd=request.getParameter("user[cd]");
     String user_pswd=request.getParameter("user[password]");
     
     boolean bool=new LoginServiceImpl().findUser(user_cd, user_pswd);
     
     if(bool)
     {
    	 //boolΪtrue����ʾ�û���������ȷ�������LoginService��findUserDefualt������ȡ�û���Ϣ����ŵ�session�б���
    	 AdminUserBean adminUserBean=new LoginServiceImpl().findUserDefault(user_cd);
    	 
    	 //��adminUserBean���󱣴浽session��
    	 HttpSession session=request.getSession();
    	 session.setAttribute("adminUserBean", adminUserBean);
    	 
    	 //�ж��û�Ȩ�ޣ�ת����Ӧ�����˵�ҳ��
    	 if("M".equals(adminUserBean.getUser_owner_flg()))
    	 {
    		 response.sendRedirect("pages/menu/mainMenuG.jsp");
    	 }
    	 else if("S".equals(adminUserBean.getUser_owner_flg()))
    	 {
    		 response.sendRedirect("pages/menu/mainMenuY.jsp");
    	 }
    	 else if("F".equals(adminUserBean.getUser_owner_flg()))
    	 {
    		 response.sendRedirect("pages/menu/mainMenuC.jsp");
    	 }
     }else
     {
    	 request.setAttribute("errMsg","�û������������");
    	 request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
     }
     
       
}

}
